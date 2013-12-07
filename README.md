Android UI Testing with Espresso
===
This is a demo app to use during the workshop called 'Android UI Testing with Espresso'.

Requirements
---
In order to build the app you need:

 - Of course, git – [official downloads](http://git-scm.com/downloads)
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

 - Hurray! You've finished with this! This branch is intended to use 'extra' stuff.
 - Check out the app's `build.gradle` and see how cool it is to use your own device provider to only run instrument tests on some devices (specially good for CIs)
 - Take a look at `WorldDestructionCountdown.java`, `IdlingResourceActivity.java` and `IdlingResourceActivityTest.java` to see how to implement an IdlingResource in order to make Espresso wait for a specific source that you use before executing tests. The example makes use of plain Threads, which is made intentionally just for demo purposes (since Espresso doesn't monitor Threads), that means, don't use plain Threads in Android.
 - To see how to write Espresso in a project with maven, see my fork of the Github Android client (`git clone git@github.com:xrigau/android.git` & `git checkout 99_setup_with_maven`)
