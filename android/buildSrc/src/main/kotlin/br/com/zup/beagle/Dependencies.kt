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

package br.com.zup.beagle

import org.gradle.api.Plugin
import org.gradle.api.Project

class Dependencies : Plugin<Project> {
    override fun apply(project: Project) {}

    object ApplicationId {
        const val id = "br.com.zup.beagle.sample"
    }

    object Modules {
        const val androidSample = ":sample"
        const val core = ":beagle"
        const val processor = ":processor"
        const val internalProcessor = ":internal-processor"
        const val androidAnnotation = ":android-annotation"
        const val preview = ":preview"
        const val commonAnnotation = ":common:annotation"
        const val commonProcessorUtils = ":common:processor-utils"
        const val schemaKotlinCore = ":schema:kotlin-core"
        const val extendedSchema = ":common:extended-schema"
        const val networking = ":networking"
        const val logger = ":logger"
        const val store = ":store"
        const val context = ":context"
        const val coreWidgets = ":core-widgets"
        const val coreActions = ":core-actions"
        const val coreDesignSystem = ":core-design-system"
        const val coreRenderEngine = ":render-engine"
        const val coreBeagle = ":core-beagle"
        const val components = ":components"
        const val cache = ":cache"
        const val sharedTest = ":shared-test"
    }

    object Releases {
        const val versionCode = 1
        const val versionName = "1.0"
        const val beagleVersionName = "0.0.1"
    }

    object Versions {
        const val compileSdk = 29
        const val minSdk = 19
        const val targetSdk = 29
        const val buildTools = "29.0.2"
        const val gradle = "3.6.3"
        const val kotlin = "1.3.72"

        const val kotlinCoroutines = "1.3.1"

        const val kotlinPoet = "1.5.0"

        const val appcompat = "1.1.0"
        const val viewModel = "2.2.0"
        const val recyclerView = "1.0.0"

        const val moshi = "1.9.3"

        const val soLoader = "0.8.2"

        const val glide = "4.11.0"

        const val junit = "4.13"
        const val junit5 = "5.6.1"

        const val yoga = "1.16.0"

        const val jni = "0.0.2"

        const val webSocket = "1.5.1"
        const val simpleLogger = "1.7.25"

        const val kotlinTest = "1.3.50"
        const val kotlinCoroutinesTest = "1.3.1"

        const val materialDesign = "1.0.0"
        const val googleCompileTesting = "0.18"
        const val googleAutoService = "1.0-rc6"

        const val jsonObject = "20190722"

        const val mockk = "1.9.3"

        const val testRunner = "1.2.0"
        const val testExt = "1.1.1"
        const val archCoreTesting = "2.1.0"
        const val espressoCore = "3.2.0"

        const val incap = "0.2"
    }

    object GeneralNames {
        const val testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        const val sampleTestInstrumentationRunner = "br.com.zup.beagle.sample.SampleTestRunner"
        const val consumerProguard = "consumer-rules.pro"
    }

    object GlideLibraries {
        const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
        const val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glide}"
    }

    object ProcessorLibraries {
        const val autoService = "com.google.auto.service:auto-service:${Versions.googleAutoService}"
        const val incap = "net.ltgt.gradle.incap:incap:${Versions.incap}"
        const val incapPrcessor = "net.ltgt.gradle.incap:incap-processor:${Versions.incap}"
    }

    object GeneralLibraries {
        const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}"
        const val kotlinCoroutines =
            "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.kotlinCoroutines}"

        const val kotlinPoet = "com.squareup:kotlinpoet:${Versions.kotlinPoet}"

        const val soLoader = "com.facebook.soloader:soloader:${Versions.soLoader}"

        const val yoga = "com.facebook.yoga.android:yoga-layout:${Versions.yoga}"

        const val jni = "com.facebook.fbjni:fbjni:${Versions.jni}"

        const val webSocket = "org.java-websocket:Java-WebSocket:${Versions.webSocket}"
        const val simpleLogger = "org.slf4j:slf4j-simple:${Versions.simpleLogger}"

        const val jsonObject = "org.json:json:${Versions.jsonObject}"
    }

    object GoogleLibraries {
        const val materialDesign = "com.google.android.material:material:${Versions.materialDesign}"
    }

    object AndroidxLibraries {
        const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
        const val coreKtx = "androidx.core:core-ktx:${Versions.appcompat}"
        const val recyclerView = "androidx.recyclerview:recyclerview:${Versions.recyclerView}"
        const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.viewModel}"
        const val viewModelExtensions = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.viewModel}"
    }

    object MoshiLibraries {
        const val moshi = "com.squareup.moshi:moshi:${Versions.moshi}"
        const val kotlin = "com.squareup.moshi:moshi-kotlin:${Versions.moshi}"
        const val adapters = "com.squareup.moshi:moshi-adapters:${Versions.moshi}"
    }

    object TestLibraries {
        const val junit = "junit:junit:${Versions.junit}"
        const val junit5Api = "org.junit.jupiter:junit-jupiter-api:${Versions.junit5}"
        const val junit5Engine = "org.junit.jupiter:junit-jupiter-engine:${Versions.junit5}"
        const val mockk = "io.mockk:mockk:${Versions.mockk}"
        const val kotlinTest = "org.jetbrains.kotlin:kotlin-test:${Versions.kotlinTest}"
        const val kotlinCoroutinesTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.kotlinCoroutinesTest}"
        const val googleCompileTesting = "com.google.testing.compile:compile-testing:${Versions.googleCompileTesting}"
        const val testRunner = "androidx.test:runner:${Versions.testRunner}"
        const val testExt = "androidx.test.ext:junit:${Versions.testExt}"
        const val archCoreTesting = "androidx.arch.core:core-testing:${Versions.archCoreTesting}"
        const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoCore}"
        const val testRules = "androidx.test:rules:${Versions.testExt}"
    }

}