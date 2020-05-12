////
///*
// * Copyright 2020 ZUP IT SERVICOS EM TECNOLOGIA E INOVACAO SA
// *
// * Licensed under the Apache License, Version 2.0 (the "License");
// * you may not use this file except in compliance with the License.
// * You may obtain a copy of the License at
// *
// *     http://www.apache.org/licenses/LICENSE-2.0
// *
// * Unless required by applicable law or agreed to in writing, software
// * distributed under the License is distributed on an "AS IS" BASIS,
// * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// * See the License for the specific language governing permissions and
// * limitations under the License.
// */
//
//import XCTest
//
//class BeagleDemoUITests: XCTestCase {
//
//    override func setUpWithError() throws {
//        // Put setup code here. This method is called before the invocation of each test method in the class.
//
//        // In UI tests it is usually best to stop immediately when a failure occurs.
//        continueAfterFailure = false
//
//        // In UI tests it’s important to set the initial state - such as interface orientation - required for your tests before they run. The setUp method is a good place to do this.
//    }
//
//    override func tearDownWithError() throws {
//        // Put teardown code here. This method is called after the invocation of each test method in the class.
//    }
//
//    func testExample() throws {
//        // UI tests must launch the application that they test.
//        let app = XCUIApplication()
//        app.launch()
//
//        let scrollViewsQuery = app.scrollViews
//        let elementsQuery = scrollViewsQuery.otherElements
//        elementsQuery.staticTexts["Navigator"].tap()
//        app.navigationBars["Step 1"].buttons["Beagle Demo"].tap()
//        elementsQuery/*@START_MENU_TOKEN@*/.staticTexts["Form & Lazy Component"]/*[[".buttons[\"Form & Lazy Component\"].staticTexts[\"Form & Lazy Component\"]",".staticTexts[\"Form & Lazy Component\"]"],[[[-1,1],[-1,0]]],[0]]@END_MENU_TOKEN@*/.tap()
//        app.navigationBars["Form & LazyComponent"].buttons["Beagle Demo"].tap()
//        elementsQuery/*@START_MENU_TOKEN@*/.staticTexts["Page View"]/*[[".buttons[\"Page View\"].staticTexts[\"Page View\"]",".staticTexts[\"Page View\"]"],[[[-1,1],[-1,0]]],[0]]@END_MENU_TOKEN@*/.tap()
//
//        let element = scrollViewsQuery.children(matching: .other).element.children(matching: .other).element.children(matching: .other).element.children(matching: .other).element.children(matching: .other).element.children(matching: .other).element.children(matching: .other).element.children(matching: .other).element
//        element.swipeRight()
//        element.swipeRight()
//        elementsQuery/*@START_MENU_TOKEN@*/.staticTexts["Tab View"]/*[[".buttons[\"Tab View\"].staticTexts[\"Tab View\"]",".staticTexts[\"Tab View\"]"],[[[-1,1],[-1,0]]],[0]]@END_MENU_TOKEN@*/.tap()
//
//        let collectionViewsQuery = app.collectionViews
//        collectionViewsQuery/*@START_MENU_TOKEN@*/.staticTexts["Tab 2 com titulo"]/*[[".cells.staticTexts[\"Tab 2 com titulo\"]",".staticTexts[\"Tab 2 com titulo\"]"],[[[-1,1],[-1,0]]],[0]]@END_MENU_TOKEN@*/.tap()
//        collectionViewsQuery/*@START_MENU_TOKEN@*/.staticTexts["Tab 3"]/*[[".cells.staticTexts[\"Tab 3\"]",".staticTexts[\"Tab 3\"]"],[[[-1,1],[-1,0]]],[0]]@END_MENU_TOKEN@*/.tap()
//        app.navigationBars["TabView"].buttons["Beagle Demo"].tap()
//        elementsQuery/*@START_MENU_TOKEN@*/.staticTexts["List View"]/*[[".buttons[\"List View\"].staticTexts[\"List View\"]",".staticTexts[\"List View\"]"],[[[-1,1],[-1,0]]],[0]]@END_MENU_TOKEN@*/.tap()
//        collectionViewsQuery/*@START_MENU_TOKEN@*/.textViews.containing(.staticText, identifier:"0003").element/*[[".cells.textViews.containing(.staticText, identifier:\"0003\").element",".textViews.containing(.staticText, identifier:\"0003\").element"],[[[-1,1],[-1,0]]],[0]]@END_MENU_TOKEN@*/.swipeLeft()
//        collectionViewsQuery/*@START_MENU_TOKEN@*/.textViews.containing(.staticText, identifier:"0005").element/*[[".cells.textViews.containing(.staticText, identifier:\"0005\").element",".textViews.containing(.staticText, identifier:\"0005\").element"],[[[-1,1],[-1,0]]],[0]]@END_MENU_TOKEN@*/.swipeLeft()
//        app.navigationBars["ListView"].buttons["Beagle Demo"].tap()
//        elementsQuery/*@START_MENU_TOKEN@*/.staticTexts["Form"]/*[[".buttons[\"Form\"].staticTexts[\"Form\"]",".staticTexts[\"Form\"]"],[[[-1,1],[-1,0]]],[0]]@END_MENU_TOKEN@*/.tap()
//        app.textFields["Optional field"].tap()
//        app.textFields["Required field"].tap()
//
//
//        // Use recording to get started writing UI tests.
//        // Use XCTAssert and related functions to verify your tests produce the correct results.
//    }
//
//    func testLaunchPerformance() throws {
//        if #available(macOS 10.15, iOS 13.0, tvOS 13.0, *) {
//            // This measures how long it takes to launch your application.
//            measure(metrics: [XCTOSSignpostMetric.applicationLaunch]) {
//                XCUIApplication().launch()
//            }
//        }
//    }
//}
