# RijsMuseumApp

## How to run?

Add the **MUSEUM_API_KEY=YOUR_API_KEY** in the [local.properties](local.properties) files

## Run Automation test 

Use `./gradlew app:runAllTests` in the gradle task manager. This will run UI and Unit test.

## Android Project Libraries

This Android project utilizes the following libraries:

- androidx.core:core-ktx:1.10.1: AndroidX Core library with Kotlin extensions, providing helpful functions and utilities for Android development.

- org.jetbrains.kotlin:kotlin-bom:1.8.0: Kotlin BOM (Bill of Materials) for managing Kotlin dependencies, ensuring compatibility and consistency.

- androidx.lifecycle:lifecycle-runtime-ktx:2.6.1: AndroidX Lifecycle library for managing lifecycle-aware components in Android applications, with Kotlin extensions.
- 
- androidx.activity:activity-compose:1.7.2: AndroidX Activity Compose library, enabling the use of Jetpack Compose in Activities.

- androidx.compose:compose-bom:2022.10.00: Jetpack Compose BOM (Bill of Materials) for managing Compose dependencies, ensuring compatibility across Compose libraries.
 
- androidx.compose.ui:ui: Jetpack Compose UI library, providing core UI components and functions for building modern Android UIs declaratively.
 
- androidx.compose.ui:ui-graphics: Jetpack Compose UI Graphics library, offering additional graphics utilities and functions for Compose-based UIs.
 
- androidx.compose.ui:ui-tooling-preview: Jetpack Compose UI Tooling Preview library, enabling previewing Compose UI components in Android Studio.
 
- androidx.compose.material3:material3: Jetpack Compose Material3 library, offering Material Design components and styles for Compose-based UIs.
 
- androidx.paging:paging-compose:3.2.0-rc01: AndroidX Paging library with Compose support, providing tools for efficient data loading and pagination in UIs.
 
- androidx.navigation:navigation-fragment-ktx:$nav_version: AndroidX Navigation library with Kotlin extensions, facilitating navigation between destinations in Android applications.
 
- com.squareup.retrofit2:retrofit:$retrofit_version: Retrofit HTTP client library for Android, simplifying network requests and API integration.
 
- com.squareup.retrofit2:converter-gson:$retrofit_version: Retrofit Gson Converter library, enabling JSON serialization/deserialization using Gson with Retrofit.
 
- io.coil-kt:coil-compose:2.4.0: Coil image loading library for Compose, providing efficient image loading and caching capabilities.
 
- io.insert-koin:koin-core:$koin_version: Koin dependency injection framework for Kotlin, offering a lightweight and pragmatic solution for managing dependencies.
 
- io.insert-koin:koin-androidx-compose:$koin_android_compose_version: Koin integration with Jetpack Compose, allowing easy dependency injection in Compose-based applications.
 
- junit:junit:4.13.2: JUnit testing framework for unit tests, enabling the creation and execution of automated tests.
 
- org.robolectric:robolectric:4.9.2: Robolectric library for unit testing Android applications, providing a simulated Android environment for tests.
 
- org.jetbrains.kotlinx:kotlinx-coroutines-test:1.7.1: Kotlin Coroutines Test library, offering testing utilities and helpers for Kotlin Coroutines.
 
- com.google.truth:truth:1.1.4: Truth assertion library for testing, providing a fluent and expressive syntax for making test assertions.
 
- org.mockito:mockito-core:4.8.0: Mockito mocking framework for unit testing, allowing the creation of mock objects and behavior verification.
 
- io.insert-koin:koin-test:3.4.0: Koin testing utilities, facilitating testing of Koin dependencies in Android applications.