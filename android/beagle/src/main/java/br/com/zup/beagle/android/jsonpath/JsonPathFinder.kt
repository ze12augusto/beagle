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

package br.com.zup.beagle.android.jsonpath

import br.com.zup.beagle.core.DynamicObject
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.util.*

internal class JsonPathFinder {

    @Suppress("ReturnCount")
    tailrec fun find(nextKeys: LinkedList<String>, value: DynamicObject<*>?): Any? {
        if (nextKeys.isEmpty()) return value?.value

        val currentKey = nextKeys.poll()

        if (currentKey != null) {
            if (currentKey.endsWith("]")) {
                if (value is DynamicObject.Array) {
                    val arrayIndex = JsonPathUtils.getIndexOnArrayBrackets(currentKey)
                    val getValue = value.value[arrayIndex]
                    return find(nextKeys, getValue)
                } else {
                    throw IllegalStateException("Expected Array but received Object")
                }
            } else {
                return when (value) {
                    is DynamicObject.Empty -> null
                    is DynamicObject.String -> find(nextKeys, value)
                    is DynamicObject.Int -> find(nextKeys, value)
                    is DynamicObject.Double -> find(nextKeys, value)
                    is DynamicObject.Boolean -> find(nextKeys, value)
                    is DynamicObject.Dictionary -> find(nextKeys, value.value[currentKey])
                    else -> {
                        return find(nextKeys, DynamicObject.String(value.toString()))
                    }
                }
            }
        } else {
            return null
        }
    }
}
