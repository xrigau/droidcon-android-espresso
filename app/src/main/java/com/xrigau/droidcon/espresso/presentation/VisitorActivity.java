package com.xrigau.droidcon.espresso.presentation;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.xrigau.droidcon.espresso.R;

public class VisitorActivity extends Activity {

    static final String VISITOR_ID = "com.xrigau.droidcon.espresso.VISITOR_ID";
    private static final int DEFAULT_VISITOR_ID = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visitor);
        setUpViews();
    }

    private void setUpViews() {
        int visitorId = getIntent().getIntExtra(VISITOR_ID, DEFAULT_VISITOR_ID);
        ((TextView) findViewById(R.id.visitor_text)).setText(getString(R.string.awesome_visitor, visitorId));
    }
}
