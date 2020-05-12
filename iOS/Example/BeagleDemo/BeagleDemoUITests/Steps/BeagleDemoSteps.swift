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

extension BeagleDemoTestBase {
    
    func givenAppisReady(){
        XCTContext.runActivity(named: "Given App is Ready") { _ in
            XCTAssertTrue(BeagleScreen.beagleHeader.element.exists)
        }
    }
    
    func checkScreenContainsNavigatorComponent(){
        XCTContext.runActivity(named: "When I see the component Navigator") { _ in
            XCTAssertTrue(BeagleScreen.navigatorComponent.element.exists)
        }
    }
    
    func clickOnTextNavigator(){
        XCTContext.runActivity(named: "Then I click on text Navigator") { _ in
            BeagleScreen.navigatorComponent.element.tap()
        }
    }
    
    func checkScreenContainsFormAndLazyComponent(){
        XCTContext.runActivity(named: "When I see the component Form & Lazy") { _ in
            XCTAssertTrue(BeagleScreen.formAndLazyComponent.element.exists)
        }
    }
    
    func clickOnTextFormAndLazy(){
        XCTContext.runActivity(named: "Then I click on text Form & Lazy") { _ in
            BeagleScreen.formAndLazyComponent.element.tap()
        }
    }
    
    func validateFormAndLazyComponent(){
        XCTContext.runActivity(named: "Then I validate the component Form & Lazy") { _ in
            XCTAssertTrue(BeagleScreen.formAndLazyText1.element.exists)
            XCTAssertTrue(BeagleScreen.formAndLazyText2.element.exists)
            XCTAssertTrue(BeagleScreen.formAndLazyText3.element.exists)
        }
    }
    
    func checkScreenContainsPageViewComponent(){
        XCTContext.runActivity(named: "When I see the component Page View") { _ in
            XCTAssertTrue(BeagleScreen.pageViewComponent.element.exists)
        }
    }
    
    func clickOnTextPageView(){
        XCTContext.runActivity(named: "Then I click on text Page View") { _ in
            BeagleScreen.pageViewComponent.element.tap()
        }
    }
    
    func validatePageViewComponent(){
        XCTContext.runActivity(named: "Then I validate the component Page View") { _ in
            XCTAssertTrue(BeagleScreen.pageViewText1.element.exists)
            XCTAssertTrue(BeagleScreen.pageViewText2.element.exists)
            XCTAssertTrue(BeagleScreen.pageViewText3.element.exists)
            
            XCUIApplication().swipeLeft()
            
            XCTAssertTrue(BeagleScreen.pageViewText1.element.exists)
            XCTAssertTrue(BeagleScreen.pageViewText2.element.exists)
            XCTAssertTrue(BeagleScreen.pageViewText3.element.exists)
            
            XCUIApplication().swipeLeft()
            
            XCTAssertTrue(BeagleScreen.pageViewText1.element.exists)
            XCTAssertTrue(BeagleScreen.pageViewText2.element.exists)
            XCTAssertTrue(BeagleScreen.pageViewText3.element.exists)
        }
    }
    
    func checkScreenContainsTabViewComponent(){
        XCTContext.runActivity(named: "When I see the component Tab View") { _ in
            XCTAssertTrue(BeagleScreen.tabViewComponent.element.exists)
        }
    }
    
    func clickOnTextTabView(){
        XCTContext.runActivity(named: "Then I click on text Tab View") { _ in
            BeagleScreen.tabViewComponent.element.tap()
        }
    }
    
    func validateTabViewComponent(){
        XCTContext.runActivity(named: "Then I validate the component Tab View") { _ in
            XCTAssertTrue(BeagleScreen.tabViewText1.element.exists)
            
            XCUIApplication().swipeLeft()
            XCTAssertTrue(BeagleScreen.tabViewText2.element.exists)
            
            XCUIApplication().swipeLeft()
            XCTAssertTrue(BeagleScreen.tabViewText3.element.exists)
            
            XCUIApplication().swipeLeft()
            XCTAssertTrue(BeagleScreen.tabViewText4.element.exists)
        }
    }
    
    func checkScreenContainsListViewComponent(){
        XCTContext.runActivity(named: "When I see the component List View") { _ in
            XCTAssertTrue(BeagleScreen.listViewComponent.element.exists)
        }
    }
    
    func clickOnTextListView(){
        XCTContext.runActivity(named: "Then I click on text List View") { _ in
            BeagleScreen.listViewComponent.element.tap()
        }
    }
    
    func checkScreenContainsFormComponent(){
        XCTContext.runActivity(named: "When I see the component Form") { _ in
            XCTAssertTrue(BeagleScreen.formComponent.element.exists)
        }
    }
    
    func clickOnTextForm(){
        XCTContext.runActivity(named: "Then I click on text Form") { _ in
            BeagleScreen.formComponent.element.tap()
        }
    }
    
    func checkScreenContainsCustomComponent(){
        XCTContext.runActivity(named: "When I see the component Custom Component") { _ in
            XCTAssertTrue(BeagleScreen.customComponent.element.exists)
        }
    }
    
    func clickOnTextCustomComponent(){
        XCTContext.runActivity(named: "Then I click on text Custom Component") { _ in
            BeagleScreen.customComponent.element.tap()
        }
    }
}


