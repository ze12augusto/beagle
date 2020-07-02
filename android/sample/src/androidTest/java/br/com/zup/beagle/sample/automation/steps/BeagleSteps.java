/*
 * Copyright 2020 ZUP IT SERVICOS EM TECNOLOGIA E INOVACAO SA
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package br.com.zup.beagle.sample.automation.steps;

import android.content.Intent;
import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import br.com.zup.beagle.sample.MainActivity;
import br.com.zup.beagle.sample.automation.elements.BeagleElements;
import br.com.zup.beagle.sample.automation.robots.BeagleRobot;
import br.com.zup.beagle.sample.util.ActivityFinisher2;


public class BeagleSteps {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Before()
    public void setup() {
        activityTestRule.launchActivity(new Intent());
    }

    @After()
    public void tearDown() {
        ActivityFinisher2.finishOpenActivities();
    }


    @Test
    public void TestSelectComponent() throws InterruptedException {
        new BeagleRobot()
            .checkViewContainsText("Beagle Sample")
            .selectMenuOption()
            .clickOnText("TextField")
            .selectMenuOption()
            .clickOnText("LazyComponent")
            .selectMenuOption()
            .clickOnText("ScrollView")
            .selectMenuOption()
            .clickOnText("ImageView")
            .selectMenuOption()
            .clickOnText("PageView Declarative")
            .selectMenuOption()
            .clickOnText("Tab Bar")
            .selectMenuOption()
            .clickOnText("Form")
            .selectMenuOption()
            .clickOnText("Disabled Form Submit")
            .sleep(2)
            .selectMenuOption()
            .sleep(2)
        ;
    }

    @Test
    public void TestSelectTextField() {
        new BeagleRobot()
            .checkViewContainsText("Beagle Sample")
            .selectMenuOption()
            .clickOnText("TextField")
            .typeIntoTextField(0,0,"beagle")
            ;
    }

    @Test
    public void TestSelectLazyComponent() throws InterruptedException {
        new BeagleRobot()
            .checkViewContainsText("Beagle Sample")
            .selectMenuOption()
            .clickOnText("LazyComponent")
            .sleep(2)
            .checkViewContainsText(BeagleElements.LAZY_COMPONENT_TEXT)
        ;
    }

    @Test
    public void TestSelectImageView() {
        new BeagleRobot()
            .checkViewContainsText("Beagle Sample")
            .selectMenuOption()
            .clickOnText("ImageView")
            .checkViewContainsText("Opa!!!")
        ;
    }

    @Test
    public void TestSelectTabBar() {
        new BeagleRobot()
            .checkViewContainsText("Beagle Sample")
            .selectMenuOption()
            .clickOnText("Tab Bar")
            .clickOnText("TITLE 1")
            .checkViewContainsText("Content")
            .clickOnText("TITLE 2")
            .checkViewContainsText("BUTTON")
            .clickOnText("TITLE 3")
            .checkViewContainsText("text tab 3")
            .clickOnText("TITLE 4")
//            .checkViewContainsText("text")
            .clickOnText("TITLE 5")
//            .checkViewContainsText("text")
        ;
    }

    @Test
    public void TestSelectForm() {
        new BeagleRobot()
            .checkViewContainsText("Beagle Sample")
            .selectMenuOption()
            .clickOnText("Form")
            .typeIntoTextField(0, 6, "beagle")
            .typeIntoTextField(0, 7, "beagle@email.com")
            .typeIntoTextField(0, 8, "12345")
            .clickOnText("submit")
        ;
    }
}