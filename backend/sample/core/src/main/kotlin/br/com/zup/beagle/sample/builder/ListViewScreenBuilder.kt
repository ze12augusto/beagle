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

package br.com.zup.beagle.sample.builder

import br.com.zup.beagle.core.Style
import br.com.zup.beagle.widget.action.Alert
import br.com.zup.beagle.ext.applyFlex
import br.com.zup.beagle.ext.applyStyle
import br.com.zup.beagle.ext.unitReal
import br.com.zup.beagle.widget.action.RequestActionMethod
import br.com.zup.beagle.widget.action.SendRequest
import br.com.zup.beagle.widget.action.SetContext
import br.com.zup.beagle.widget.context.ContextData
import br.com.zup.beagle.widget.context.expressionOf
import br.com.zup.beagle.widget.core.EdgeValue
import br.com.zup.beagle.widget.core.Flex
import br.com.zup.beagle.widget.core.ListDirection
import br.com.zup.beagle.widget.core.ScrollAxis
import br.com.zup.beagle.widget.layout.Container
import br.com.zup.beagle.widget.layout.NavigationBar
import br.com.zup.beagle.widget.layout.NavigationBarItem
import br.com.zup.beagle.widget.layout.Screen
import br.com.zup.beagle.widget.layout.ScreenBuilder
import br.com.zup.beagle.widget.layout.ScrollView
import br.com.zup.beagle.widget.layout.extensions.dynamic
import br.com.zup.beagle.widget.ui.Button
import br.com.zup.beagle.widget.ui.ImagePath.Local
import br.com.zup.beagle.widget.ui.ListView
import br.com.zup.beagle.widget.ui.Text

object ListViewScreenBuilder : ScreenBuilder {
    override fun build() = Screen(
        navigationBar = NavigationBar(
            title = "Beagle ListView",
            showBackButton = true,
            navigationBarItems = listOf(
                NavigationBarItem(
                    text = "",
                    image = Local.justMobile("informationImage"),
                    action = Alert(
                        title = "ListView",
                        message = "Is a Layout component that will define a list of views natively. " +
                            "These views could be any Server Driven Component.",
                        labelOk = "OK"
                    )
                )
            )
        ),
        child = Container(
            children = listOf(ListView(
                dataSource = expressionOf("@{initialContext}"),
                direction = ListDirection.VERTICAL,
                template = Text(expressionOf("@{item}"))
            ),
                Button(text = "opa", onPress = listOf(SendRequest(
                    url = "https://api.themoviedb.org/3/genre/movie/list?api_key=d272326e467344029e68e3c4ff0b4059",
                    method = RequestActionMethod.GET,
                    onSuccess = listOf(
                        SetContext(
                            contextId = "initialContext",
                            value = "@{onSuccess.data.genres}"
                        )
                    )
                ))),
                Text("@{initialContext}")

            )
        ).applyFlex(flex = Flex(
            grow = 1.0
        )),
        context = ContextData("initialContext", listOf("a", "b", "c", "d"))
    )


    private fun getStaticListView(listDirection: ListDirection) = Container(
        children = listOf(
            Text("Static $listDirection ListView")
                .applyStyle(Style(
                    margin = EdgeValue(bottom = 10.unitReal())
                )),
            ListView(children = (1..10).map(this::createText), direction = listDirection)
        )
    ).applyStyle(Style(
        margin = EdgeValue(bottom = 20.unitReal())
    ))

    private fun getDynamicListView(listDirection: ListDirection) = Container(
        children = listOf(
            Text("Dynamic $listDirection ListView")
                .applyStyle(Style(
                    margin = EdgeValue(bottom = 10.unitReal())
                )),
            ListView.dynamic(size = 20, direction = listDirection, rowBuilder = this::createText)
        )
    )

    private fun createText(index: Int) = Text("Hello $index")
}
