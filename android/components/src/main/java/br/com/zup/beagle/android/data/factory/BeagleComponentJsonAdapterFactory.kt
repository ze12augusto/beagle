package br.com.zup.beagle.android.data.factory

import br.com.zup.beagle.android.components.Touchable
import br.com.zup.beagle.android.components.form.FormInput
import br.com.zup.beagle.android.components.form.FormSubmit
import br.com.zup.beagle.android.components.form.InputWidget
import br.com.zup.beagle.android.components.page.PageIndicatorComponent
import br.com.zup.beagle.android.data.serializer.PolymorphicJsonAdapterFactory
import br.com.zup.beagle.android.setup.InternalWidgetFactory
import br.com.zup.beagle.android.widget.WidgetView
import br.com.zup.beagle.core.ServerDrivenComponent
import java.util.*

private const val BEAGLE_NAMESPACE = "beagle"

internal object BeagleComponentJsonAdapterFactory {

    fun make(factory: PolymorphicJsonAdapterFactory<ServerDrivenComponent>):
        PolymorphicJsonAdapterFactory<ServerDrivenComponent> {
        var newFactory = registerBaseSubTypes(factory)
        newFactory = registerUIClass(newFactory)
        newFactory = registerWidgets(newFactory, BEAGLE_NAMESPACE, InternalWidgetFactory.registeredWidgets())
        return newFactory
    }

    private fun registerBaseSubTypes(
        factory: PolymorphicJsonAdapterFactory<ServerDrivenComponent>
    ): PolymorphicJsonAdapterFactory<ServerDrivenComponent> {
        return factory
            .withBaseSubType(PageIndicatorComponent::class.java)
            .withBaseSubType(InputWidget::class.java)
    }

    private fun registerUIClass(
        factory: PolymorphicJsonAdapterFactory<ServerDrivenComponent>
    ): PolymorphicJsonAdapterFactory<ServerDrivenComponent> {
        return factory
            .withSubtype(Touchable::class.java, createNamespaceFor<Touchable>())
            .withSubtype(FormInput::class.java, createNamespaceFor<FormInput>())
            .withSubtype(FormSubmit::class.java, createNamespaceFor<FormSubmit>())
    }

    private fun registerWidgets(
        factory: PolymorphicJsonAdapterFactory<ServerDrivenComponent>,
        appName: String,
        widgets: List<Class<WidgetView>>
    ): PolymorphicJsonAdapterFactory<ServerDrivenComponent> {
        var newFactory = factory

        widgets.forEach {
            newFactory = newFactory.withSubtype(it, createNamespace(appName, it))
        }

        return newFactory
    }

    private inline fun <reified T : ServerDrivenComponent> createNamespaceFor(): String {
        return createNamespace(BEAGLE_NAMESPACE, T::class.java)
    }

    private fun createNamespace(appNamespace: String, clazz: Class<*>): String {
        val typeName = clazz.simpleName.toLowerCase(Locale.getDefault())
        return "$appNamespace:$typeName"
    }
}