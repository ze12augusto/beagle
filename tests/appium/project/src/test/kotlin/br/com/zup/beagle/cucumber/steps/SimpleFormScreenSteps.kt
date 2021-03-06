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

package br.com.zup.beagle.cucumber.steps

import io.appium.java_client.MobileElement
import io.cucumber.java.Before
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When

class SimpleFormScreenSteps : AbstractStep() {
    override var bffRelativeUrlPath = "/simpleform"

    @Before("@simpleForm")
    fun setup() {
        loadBffScreen()
    }

    @Given("^that I'm on the simple form screen$")
    fun checkBaseScreen() {
        waitForElementWithValueToBeClickable("SimpleForm", false, false)
    }

    @When("^I click on textInput with place holder (.*) and insert the value (.*)$")
    fun insertEmailInTextInput(placeHolderText: String, value: String) {
        var element: MobileElement = waitForElementWithValueToBeClickable(placeHolderText, false, false)
        element.click()
        element.sendKeys(value)

    }

    @When("^I click to (.*)$")
    fun sendDataFromTextInputs(submit: String) {
        waitForElementWithValueToBeClickable(submit, false, false).click()
    }

}