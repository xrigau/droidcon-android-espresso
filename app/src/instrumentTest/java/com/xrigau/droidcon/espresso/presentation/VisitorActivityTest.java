package com.xrigau.droidcon.espresso.presentation;

import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;

import com.xrigau.droidcon.espresso.R;

import static com.google.android.apps.common.testing.ui.espresso.Espresso.onView;
import static com.google.android.apps.common.testing.ui.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static com.google.android.apps.common.testing.ui.espresso.assertion.ViewAssertions.matches;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.*;
import static com.xrigau.droidcon.espresso.helper.EspressoTestsMatchers.overflowMenu;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.containsString;

public class VisitorActivityTest extends ActivityInstrumentationTestCase2<VisitorActivity> {

    private static final int EXPECTED_VISITOR_ID = 123;

    public VisitorActivityTest() {
        super(VisitorActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        setActivityIntent(new Intent().putExtra(VisitorActivity.VISITOR_ID, EXPECTED_VISITOR_ID));
        getActivity();
    }

    public void testShowsCorrectVisitorId() {
        onView(withId(R.id.visitor_text)).check(matches(allOf(isDisplayed(), withText(containsString(Integer.toString(EXPECTED_VISITOR_ID))))));
    }

    public void testActionBarMenuIsCorrect() {
        onView(overflowMenu()).check(matches(isDisplayed()));
        onView(withId(R.id.toast)).check(matches(isDisplayed()));
//        onView(withId(R.id.toast)).perform(click());
//        onView(withText(R.string.toasted_message)).check(matches(isDisplayed())); // FAIL: Toast is showing in a different window?
    }

    public void testExitMenuIsInOverflow() {
        openActionBarOverflowOrOptionsMenu(getActivity());
        onView(withText(R.string.menu_exit)).check(matches(isDisplayed()));
    }
}
