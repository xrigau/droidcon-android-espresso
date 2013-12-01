Android UI Testing with Espresso
===
This is a demo app to use during the workshop called 'Android UI Testing with Espresso'.

Requirements
---
In order to build the app you need:

 - Of course, git [official downloads](http://git-scm.com/downloads)
 - The Android SDK with API 19 and build tools v19.0.0 – [Click in 'Use an existing IDE' to download](https://developer.android.com/sdk/index.html#ExistingIDE)
 - Gradle 1.8 (or you can use the Gradle wrapper instead) – [direct download from gradle.org](http://services.gradle.org/distributions/gradle-1.8-bin.zip)
 - Android Studio 0.3.6 (not required but recommended) – [download from developer.android.com](http://developer.android.com/sdk/installing/studio.html)
 - Espresso source code (Highly recommended) – [direct download from Google Code](https://android-test-kit.googlecode.com/archive/b49a13f06e5e832fa456900345ba47cb739637f7.zip)
 
Get started
---
To start you should:

 - Clone this repo in your machine
 - Switch branches after each exercise (the master branch, contains the final result after the session, but you should go through the middle steps and try to solve them, branches are numbered and each branch starts with the necessary things to go on, so it's easy!)
 - You can find the instructions to continue working in the 'Next steps' section below.
  
Next steps
---

 - Fulfill the `isEmpty()` method in `EspressoTestsMatchers` to verify the ImageButton has no text.
 - Write some more complex assertions to verify that a specific View uses a specific Drawable (if it's an ImageView check image, if it's a TextView check compound drawables, if any other View just check background). You can use class `DrawableMatcher` as base to start with.
 - Also you can assert that the ActionBar menu is displayed in some screens and does not exist in others.
 - Checkout the next branch: `git checkout 03_on_view`
