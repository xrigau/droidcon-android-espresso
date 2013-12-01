package com.xrigau.droidcon.espresso.helper;

import android.view.View;

import org.hamcrest.Matcher;

public class EspressoTestsMatchers {

    public static Matcher<View> overflowMenu() {
        return null; // Pro tip: Look at Espresso.java
    }

    public static Matcher<String> isEmpty() {
        return null;
    }

    public static Matcher<View> withDrawable(final int resourceId) {
        return new DrawableMatcher(resourceId);
    }

}
