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

import io.cucumber.java.Before
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When


class AlertScreenSteps : AbstractStep() {

    override var bffRelativeUrlPath = "/alert"

    @Before("@alert")
    fun setup() {
        loadBffScreen()
    }

    @Given("^the Beagle application did launch with the alert screen url$")
    fun checkBaseScreen() {
        waitForElementWithTextToBeClickable("Alert Screen", false, false)
    }

    @When("^I press an alert button with the (.*) title$")
    fun clickOnButton(string: String) {
        waitForElementWithTextToBeClickable(string, false, false).click()
    }

    @Then("^an alert with the (.*) message should appear on the screen$")
    fun checkAlertMessage(string: String) {
        waitForElementWithTextToBeClickable(string, false, false)
    }

    @Then("^an alert with the (.*) and (.*) should appear on the screen$")
    fun checkAlertMessageAndTitle(string: String, string2: String) {
        waitForElementWithTextToBeClickable(string, false, false)
        waitForElementWithTextToBeClickable(string2, false, false)
    }

    @Then("^I press the confirmation (.*) button on the alert$")
    fun clickOnTheConfirmationActionButtonWithText(string: String) {
        waitForElementWithTextToBeClickable(string, false, true).click()
    }

    @Then("^an alert with a confirmation button with (.*) label should appear$")
    fun checkAlertConfirmationButtonLabelIsSetWithText(string: String) {
        waitForElementWithTextToBeClickable(string, false, true)
    }
}