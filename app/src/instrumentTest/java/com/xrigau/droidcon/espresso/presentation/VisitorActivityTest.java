package com.xrigau.droidcon.espresso.presentation;

import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;

import com.xrigau.droidcon.espresso.R;

import static com.google.android.apps.common.testing.ui.espresso.Espresso.onView;
import static com.google.android.apps.common.testing.ui.espresso.assertion.ViewAssertions.matches;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.*;
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
}
