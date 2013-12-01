package com.xrigau.droidcon.espresso;

import android.app.Activity;
import android.widget.TextView;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.util.ActivityController;

import static org.junit.Assert.assertEquals;

@RunWith(RobolectricTestRunner.class)
public class AndroidUnitTest {

    @Test
    public void testInstantiation() {
        String expected = "Robolectric is running with Gradle";

        ActivityController<Activity> activity = Robolectric.buildActivity(Activity.class);
        TextView textView = new TextView(activity.get().getApplicationContext());
        textView.setText(expected);

        assertEquals(expected, textView.getText());
    }
}
