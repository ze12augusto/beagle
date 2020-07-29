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

package br.com.zup.beagle.android.components.layout

import android.view.View
import br.com.zup.beagle.android.action.Action
import br.com.zup.beagle.android.context.ContextComponent
import br.com.zup.beagle.android.context.ContextData
import br.com.zup.beagle.android.utils.handleEvent
import br.com.zup.beagle.android.view.ComponentsViewFactory
import br.com.zup.beagle.core.Style
import br.com.zup.beagle.android.view.custom.BeagleFlexView
import br.com.zup.beagle.android.widget.RootView
import br.com.zup.beagle.android.widget.WidgetView
import br.com.zup.beagle.annotation.RegisterWidget
import br.com.zup.beagle.core.ServerDrivenComponent

@RegisterWidget
data class Container(
    val children: List<ServerDrivenComponent>,
    override val context: ContextData? = null,
    val onInit: List<Action>? = null
) : WidgetView(), ContextComponent {

    @Transient
    private val componentsViewFactory = ComponentsViewFactory()

    override fun buildView(rootView: RootView): View {
        val view = componentsViewFactory.makeBeagleFlexView(rootView.getContext(), style ?: Style())
        onInit?.let {
            this@Container.handleEvent(rootView, view, it)
        }

        return view
            .apply {
                addChildren(this, rootView)
            }
    }

    private fun addChildren(beagleFlexView: BeagleFlexView, rootView: RootView) {
        children.forEach { child ->
            beagleFlexView.addServerDrivenComponent(child, rootView)
        }
    }
}
