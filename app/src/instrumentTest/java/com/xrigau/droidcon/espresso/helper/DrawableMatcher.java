package com.xrigau.droidcon.espresso.helper;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

public class DrawableMatcher extends TypeSafeMatcher<View> {

    private final int resourceId;

    public DrawableMatcher(int resourceId) {
        super(View.class);
        this.resourceId = resourceId;
    }

    private String resourceName = null;
    private Drawable expectedDrawable = null;

    @Override
    public boolean matchesSafely(View target) {
        if (expectedDrawable == null) {
            loadDrawableFromResources(target.getResources());
        }
        if (invalidExpectedDrawable()) {
            return false;
        }

        // TODO: Finish! Pro tip: 2 Drawable objects are different, but there's something they share, something is constant...

        return false;
    }

    private void loadDrawableFromResources(Resources resources) {
        try {
            expectedDrawable = resources.getDrawable(resourceId);
            resourceName = resources.getResourceEntryName(resourceId);
        } catch (Resources.NotFoundException ignored) {
            // view could be from a context unaware of the resource id.
        }
    }

    private boolean invalidExpectedDrawable() {
        return expectedDrawable == null;
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("with drawable from resource id: ");
        description.appendValue(resourceId);
        if (resourceName != null) {
            description.appendText("[");
            description.appendText(resourceName);
            description.appendText("]");
        }
    }
}
