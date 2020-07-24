/*
 * Copyright 2020 ZUP IT SERVICOS EM TECNOLOGIA E INOVACAO SA
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package br.com.zup.beagle.android.context

import br.com.zup.beagle.android.data.serializer.BeagleMoshi
import br.com.zup.beagle.android.jsonpath.JsonPathFinder
import br.com.zup.beagle.android.logger.BeagleMessageLogs
import br.com.zup.beagle.android.utils.getContextId
import br.com.zup.beagle.android.utils.getExpressions
import com.squareup.moshi.Moshi
import org.json.JSONArray
import org.json.JSONObject
import java.lang.IllegalStateException
import java.lang.reflect.Type
import java.util.regex.Matcher
import java.util.regex.Pattern

internal class ContextDataEvaluation(
    private val jsonPathFinder: JsonPathFinder = JsonPathFinder(),
    private val contextPathResolver: ContextPathResolver = ContextPathResolver(),
    private val moshi: Moshi = BeagleMoshi.moshi
) {

    fun evaluateBindExpression(
        contextData: ContextData,
        bind: Bind.Expression<*>
    ): Any? {
        return evaluateBindExpression(listOf(contextData), bind)
    }

    fun evaluateBindExpression(
        contextsData: List<ContextData>,
        bind: Bind.Expression<*>
    ): Any? {
        val expressions = bind.value.getExpressions()

        return when {
            bind.type == String::class.java -> {
                contextsData.forEach { contextData ->
                    expressions.filter { it.getContextId() == contextData.id }.forEach { expression ->
                        evaluateExpressionsForContext(contextData, expression, bind)
                    }
                }

                evaluateMultipleExpressions(bind)
            }
            expressions.size == 1 -> evaluateExpression(contextsData[0], bind, expressions[0])
            else -> {
                BeagleMessageLogs.multipleExpressionsInValueThatIsNotString()
                null
            }
        }
    }

    private fun evaluateExpressionsForContext(
        contextData: ContextData,
        expression: String,
        bind: Bind.Expression<*>
    ) {
        val value = evaluateExpression(contextData, bind, expression) ?: ""
        bind.evaluatedExpressions[expression] = value
    }

    private fun evaluateMultipleExpressions(bind: Bind.Expression<*>): Any? {
        val regex = "(.*?)(\\\\*)@\\{(([^'\\}]|('([^'\\\\]|\\\\.)*'))*)\\}"
        var text = ""
        lateinit var slashes: String
        lateinit var key: String
        lateinit var preExpression: String
        lateinit var posExpression: String
        lateinit var fullGroup: String

        val pattern = Pattern.compile(regex)
        val matcher: Matcher = pattern.matcher(bind.value)

        while (matcher.find()) {
            fullGroup = matcher.group(0) ?: ""
            preExpression = matcher.group(1) ?: ""
            key = matcher.group(3) ?: ""
            slashes = matcher.group(2) ?: ""
            text += if (slashes.length % 2 == 0) {
                fullGroup.replace(
                    oldValue = "${matcher.group(2)}@{$key}",
                    newValue = normalizeSlashes(slashes) + bind.evaluatedExpressions[key].toString())
            } else {
                preExpression + normalizeSlashes(slashes) + "@{$key}"
            }
            posExpression = bind.value.substring(matcher.end())
        }
        return if (text.isEmpty()) null else text + posExpression
    }

    private fun normalizeSlashes(slashes: String): String {
        var slashesCount = slashes.length / 2
        var newSlashes = ""
        while (slashesCount != 0) {
            newSlashes += "\\"
            slashesCount--
        }
        return newSlashes
    }

    private fun evaluateExpression(contextData: ContextData, bind: Bind.Expression<*>, expression: String): Any? {
        val value = getValue(contextData, expression)

        return try {
            if (bind.type == String::class.java) {
                value?.toString() ?: showLogErrorAndReturn(bind)
            } else if (value is JSONArray || value is JSONObject) {
                moshi.adapter<Any>(bind.type).fromJson(value.toString()) ?: showLogErrorAndReturn(bind)
            } else {
                value ?: showLogErrorAndReturn(bind)
            }
        } catch (ex: Exception) {
            BeagleMessageLogs.errorWhileTryingToNotifyContextChanges(ex)
            null
        }
    }

    private fun showLogErrorAndReturn(bind: Bind.Expression<*>) = run {
        BeagleMessageLogs.errorWhenExpressionEvaluateNullValue("${bind.value} : ${bind.type}")
        null
    }

    private fun getValue(contextData: ContextData, path: String): Any? {
        return if (path != contextData.id) {
            findValue(contextData, path)
        } else {
            contextData.value
        }
    }

    private fun findValue(contextData: ContextData, path: String): Any? {
        return try {
            val keys = contextPathResolver.getKeysFromPath(contextData.id, path)
            jsonPathFinder.find(keys, contextData.value)
        } catch (ex: Exception) {
            BeagleMessageLogs.errorWhileTryingToAccessContext(ex)
            null
        }
    }
}
