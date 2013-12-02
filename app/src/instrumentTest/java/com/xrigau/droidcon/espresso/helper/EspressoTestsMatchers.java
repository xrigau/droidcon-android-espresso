package com.xrigau.droidcon.espresso.helper;

import android.view.View;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.*;
import static org.hamcrest.Matchers.*;

public class EspressoTestsMatchers {

    // From Espresso.java
    private static final Matcher<View> OVERFLOW_BUTTON_MATCHER = anyOf(
            allOf(isDisplayed(), withContentDescription("More options")),
            allOf(isDisplayed(), withClassName(endsWith("OverflowMenuButton")))
    );

    public static Matcher<View> overflowMenu() {
        return OVERFLOW_BUTTON_MATCHER;
    }

    public static Matcher<String> isEmpty() {
        return new TypeSafeMatcher<String>() {
            @Override
            public boolean matchesSafely(String target) {
                return target.length() == 0;
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("is empty");
            }
        };
    }

    public static Matcher<View> withDrawable(final int resourceId) {
        return new DrawableMatcher(resourceId);
    }

    public static Matcher<View> withChildCount(final Matcher<Integer> numberMatcher) {
        return null;
    }
}
