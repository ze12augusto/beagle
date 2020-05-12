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

import Foundation
import XCTest

enum BeagleScreen: String {
    
    case beagleHeader = "Beagle Demo"
    case navigatorComponent = "Navigator"
    
    case formAndLazyComponent = "Form & Lazy Component"
    case formAndLazyText1 = "Text above input hidden"
    case formAndLazyText2 = "Text bellow input hiden"
    case formAndLazyText3 = "FormSubmit"
    
    case pageViewComponent = "Page View"
    case pageViewText1 = "Text with alignment atribute set to center"
    case pageViewText2 = "Text with alignment atribute set to right"
    case pageViewText3 = "Text with alignment atribute set to left"
    
    case tabViewComponent = "Tab View"
    case tabViewText1 = "Blaaslkdjfaskldjfalskdjfasldjfasldfj"
    case tabViewText2 = "Text1 Tab 2"
    case tabViewText3 = "Text1 Tab 3"
    case tabViewText4 = "Text1 Tab 4"
    
    case listViewComponent = "List View"
    case formComponent = "Form"
    case customComponent = "Custom Component"
    case webViewComponent = "Web View"
    //    case returnButton = "Beagle Demo"
    
    
    
    var element: XCUIElement {
        
        switch self {
            
        case .beagleHeader, .navigatorComponent, .formAndLazyComponent, .pageViewComponent, .tabViewComponent, .listViewComponent, .formComponent, .customComponent, .webViewComponent, .formAndLazyText1, .formAndLazyText2, .formAndLazyText3, .pageViewText1, .pageViewText2, .pageViewText3, .tabViewText1, .tabViewText2, .tabViewText3, .tabViewText4:
            return XCUIApplication().staticTexts[self.rawValue]
            //        case .returnButton:
            //            return XCUIApplication().buttons[self.rawValue]
        }
    }
}
