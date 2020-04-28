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

package br.com.zup.beagle.sample.automation.robots;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.Espresso;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import java.util.Map;

import br.com.zup.beagle.sample.R;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.core.Is.is;

public class BeagleRobot {


    public BeagleRobot checkViewContainsText(String text) {
        onView(allOf(withText(text))).check(matches(isDisplayed()));
        return this;
    }

    public BeagleRobot selectMenuOption() {
        onView(allOf(withContentDescription("More options"), childAtPosition(childAtPosition(withId(R.id.action_bar), 1), 0))).perform(click());
        return this;
    }

    public BeagleRobot clickOnText(final String text) {
        onView(allOf(withText(text), isDisplayed())).perform(click());
        return this;
    }

    public BeagleRobot typeIntoTextField(int position1, int position2, String text) {
        onView(allOf(childAtPosition(childAtPosition(withId(R.id.fragment_content), position1), position2))).perform(typeText(text));
        Espresso.closeSoftKeyboard();
        return this;
    }

    public BeagleRobot sleep(int seconds) throws InterruptedException {
        Thread.sleep(seconds * 1000L);
        return this;
    }







    public BeagleRobot teste() {
        onData(allOf(is(instanceOf(Map.class)), hasEntry(equalTo("STR"), is("Stack")))).perform(click());
        return this;
    }






    private static Matcher<View> childAtPosition(
        final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                    && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }

}