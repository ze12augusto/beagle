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
import io.cucumber.java.en.And
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When

private const val TOUCHABLE_SCREEN_HEADER = "Beagle Touchable"
private const val TOUCHABLE_TEXT_1 = "Text with Touchable"
private const val TOUCHABLE_TEXT_2 = "Click here!"
private const val TOUCHABLE_TEXT_3 = "Image with Touchable"
private const val TOUCHABLE_TEXT_4 = "NetworkImage with Touchable"

class TouchScreenSteps : AbstractStep() {
    override var bffRelativeUrlPath = "/touchable"

    @Before("@touchable")
    fun setup() {
        loadBffScreen()
    }

    @Given("^that I'm on the touchable screen$")
    fun checkImageScreen() {
        waitForElementWithTextToBeClickable(TOUCHABLE_SCREEN_HEADER, false, false)
    }

    @And("^I have a text with touchable configured$")
    fun checkTextWithTouchable() {
        waitForElementWithTextToBeClickable(TOUCHABLE_TEXT_1, false, false)
        waitForElementWithTextToBeClickable(TOUCHABLE_TEXT_2, false, false)
    }

    @And("^I have an image with touchable configured$")
    fun checkImageWithTouchable() {
        waitForElementWithTextToBeClickable(TOUCHABLE_TEXT_3, false, false)
    }

    @When("^I click on touchable text (.*)$")
    fun clickOnTouchableText(string1: String) {
        waitForElementWithTextToBeClickable(string1, false, false).click()
    }

    @When("^I click on touchable image$")
    fun clickOnTouchableImage() {
        waitForImageElementToBeVisible(0).click()

    }

    @Then("^touchable screen should render all text attributes correctly$")
    fun checkTouchableScreenTexts() {
        waitForElementWithTextToBeClickable(TOUCHABLE_TEXT_1, false, false)
        waitForElementWithTextToBeClickable(TOUCHABLE_TEXT_2, false, false)
        waitForElementWithTextToBeClickable(TOUCHABLE_TEXT_3, false, false)
        waitForElementWithTextToBeClickable(TOUCHABLE_TEXT_4, false, false)
    }
}