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

package br.com.zup.beagle.sample.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.zup.beagle.android.components.GridView
import br.com.zup.beagle.android.components.Image
import br.com.zup.beagle.android.components.ImagePath
import br.com.zup.beagle.android.components.layout.Container
import br.com.zup.beagle.android.components.layout.NavigationBar
import br.com.zup.beagle.android.components.layout.Screen
import br.com.zup.beagle.android.components.utils.Template
import br.com.zup.beagle.android.context.ContextData
import br.com.zup.beagle.android.context.expressionOf
import br.com.zup.beagle.android.utils.toView
import br.com.zup.beagle.core.Style
import br.com.zup.beagle.ext.applyStyle
import br.com.zup.beagle.ext.unitReal
import br.com.zup.beagle.widget.core.EdgeValue
import br.com.zup.beagle.widget.core.ImageContentMode
import br.com.zup.beagle.widget.core.Size

class GridViewFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val declarative = Screen(
            navigationBar = NavigationBar(title = "Grid"),
            child = buildGridView()
        )
        return declarative.toView(this)
    }

    private fun buildGridView() = GridView(
        numColumns = 4,
        context = ContextData(
            id = "outsideContext",
            value = listOf("0", "1", "2", "3", "4", "5",
                "6", "7", "8", "9", "10",
                "11", "12", "13", "14", "15",
                "16", "17", "18", "19", "20")
        ),
        dataSource = expressionOf("@{outsideContext}"),
        templates = listOf(
            Template(
                view = Container(
                    children = listOf(
                        Image(
                            ImagePath.Local("imageBeagle"),
                            mode = ImageContentMode.FIT_CENTER
                        ).applyStyle(
                            Style(
                                margin = EdgeValue(all = 5.unitReal())
                            )
                        )
                    )
                ).applyStyle(
                    Style(
                        size = Size(width = 100.unitReal(), height = 100.unitReal())
                    )
                )
            )
        )
    )


    companion object {
        fun newInstance() = GridViewFragment()
    }
}