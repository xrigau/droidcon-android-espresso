package com.xrigau.droidcon.espresso.presentation;

import android.os.Handler;
import android.test.ActivityInstrumentationTestCase2;

import com.google.android.apps.common.testing.ui.espresso.contrib.CountingIdlingResource;
import com.xrigau.droidcon.espresso.R;

import static com.google.android.apps.common.testing.ui.espresso.Espresso.onView;
import static com.google.android.apps.common.testing.ui.espresso.Espresso.registerIdlingResources;
import static com.google.android.apps.common.testing.ui.espresso.assertion.ViewAssertions.matches;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.withId;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.withText;

public class IdlingResourceActivityTest extends ActivityInstrumentationTestCase2<IdlingResourceActivity> {

    public IdlingResourceActivityTest() {
        super(IdlingResourceActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        IdlingResourceActivity activity = getActivity();

        CountingIdlingResource idlingResource = new CountingIdlingResource("WorldDestructionCountdown");
        activity.setCountdown(new CountdownWrapper(activity.makeHandler(), idlingResource));
        registerIdlingResources(idlingResource); // Comment this line to see the test failing
    }

    public void testWorldIsSuccessfullyDestroyed() {
        onView(withId(R.id.timer)).check(matches(withText(R.string.countdown_finished)));
    }

    private class CountdownWrapper extends WorldDestructionCountdown {

        private final CountingIdlingResource idlingResource;

        public CountdownWrapper(Handler handler, CountingIdlingResource idlingResource) {
            super(handler);
            this.idlingResource = idlingResource;
        }

        @Override
        protected void onCountdownStarted() {
            idlingResource.increment();
        }

        @Override
        public void onCountdownFinished() {
            super.onCountdownFinished();
            idlingResource.decrement();
        }

        @Override
        public void stop() {
            super.stop();
            idlingResource.decrement();
        }
    }
}
