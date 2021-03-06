#
# Copyright 2020 ZUP IT SERVICOS EM TECNOLOGIA E INOVACAO SA
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#     http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#

@lazyComponent @android @ios
Feature: Lazy component Validation

    As a Beagle developer/user
    I'd like to make sure my lazyComponent work as expected
    In order to guarantee that my application never fails

    Background:
        Given the Beagle application did launch with the LazyComponent Screen

    Scenario: LazyComponent 01 - Create LazyComponent component and check if it shows the initial
    component and after making the request it shows the new component.

        When I click on button Call lazy successful component screen
        Then an screen with an element WebView screen should be visible

#
#    Scenario 2 is being removed until we have a proper definition on what will happen with error cases.
#
#    Scenario: LazyComponent 02 - Create LazyComponent component and check if it shows the initial component
#    and after making the request with error and check if it only shows the initial component
#
#        When I click on button Call lazy failure component screen
#        Then an screen with an element LazyComponent Failure Screen should be visible
#        Then an screen with an element Loading to failure should be visible
