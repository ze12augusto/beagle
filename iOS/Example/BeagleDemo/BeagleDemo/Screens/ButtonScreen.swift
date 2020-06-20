//
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

import UIKit
import BeagleUI
import BeagleSchema

struct ButtonScreen: DeeplinkScreen {
    
    init(path: String, data: [String : String]?) {
    }
    
    func screenController() -> UIViewController {
        return Beagle.screen(.declarative(screen))
    }
    
    var flexTop: Flex {
        return Flex().margin(EdgeValue().top(15))
    }
    
    var screen: Screen {
        return Screen(
            navigationBar: navigationBar,
            child: Container(
                children: [
                    createButton(text: "Button",flex: flexTop),
                    createButton(
                        text: "Button with style",
                        styleId: "DesignSystem.Stylish.Button",
                        flex: flexTop
                    ),
                    buttonWithAppearanceAndStyle(text: "Button with Appearance"),
                    buttonWithAppearanceAndStyle(
                        text: "Button with Appearance and style",
                        styleId: "DesignSystem.Stylish.ButtonAndAppearance"
                    )
                    
            ])
        )
    }
    
    var navigationBar: NavigationBar {
        return NavigationBar(
            title: "Beagle Button",
            showBackButton: true,
            navigationBarItems: [
                NavigationBarItem(
                    image: "informationImage",
                    text: "",
                    action: Alert(
                        title: "Button",
                        message: "This is a widget that will define a button natively using the server driven information received through Beagle.",
                        labelOk: "luokis"
                    )
                )]
        )
    }
    
    func createButton(text: String, styleId: String? = nil, flex: Flex? = nil) -> Button {
        return Button(text: text,
                      styleId: styleId,
                      action: Navigate.openNativeRoute(.DEEPLINK_ENDPOINT),
                      widgetProperties: WidgetProperties(
                        flex: flex
                    )
        )
    }
    
    func buttonWithAppearanceAndStyle(text: String, styleId: String? = nil) -> Button {
        return Button(text: text,
                      styleId: styleId,
                      action: Navigate.openNativeRoute(.DEEPLINK_ENDPOINT),
                      widgetProperties: WidgetProperties(
                        style: Style(backgroundColor: "#0f4c81", cornerRadius: CornerRadius(radius: 16)),
                        flex: Flex().margin(EdgeValue().top(15).left(25).right(25))
                    )
        )
    }
}
