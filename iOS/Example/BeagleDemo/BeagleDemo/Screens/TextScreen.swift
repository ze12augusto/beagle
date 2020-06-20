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

struct TextScreen: DeeplinkScreen {
    
    init(path: String, data: [String : String]?) {
    }
    
    func screenController() -> UIViewController {
        return Beagle.screen(.declarative(screen))
    }
    
    var screen: Screen {
        return Screen(
            navigationBar: navigationBar,
            child: Container(
                children: [
                    beagleText(text: "hello world without style"),
                    beagleText(text: "hello world with style", styleId: "DesignSystem.Text.helloWord"),
                    beagleText(text: "hello world with Appearance", backgroundColor: "#4682b4"),
                    beagleText(
                        text: "hello world with style and Appearance",
                        styleId: "DesignSystem.Text.helloWord",
                        backgroundColor: "#4682b4"
                    )
            ])
        )
    }
    
    var navigationBar: NavigationBar {
        return NavigationBar(
            title: "Beagle Text",
            showBackButton: true,
            navigationBarItems: [
                NavigationBarItem(
                    image: "informationImage",
                    text: "",
                    action: Alert(
                        title: "Text",
                        message: "This widget will define a text view natively using the server driven information received through Beagle.",
                        labelOk: "OK"
                    )
                )]
        )
    }
    
    func beagleText(text: Expression<String>, styleId: String? = nil, backgroundColor: String? = nil) -> Text {
        return Text(
            text,
            styleId: styleId,
            widgetProperties: WidgetProperties(
                style: Style(backgroundColor: backgroundColor),
                flex: Flex().margin(EdgeValue().top(16).left(16).right(16))
        ))
    }
}
