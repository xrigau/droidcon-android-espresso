package com.xrigau.droidcon.espresso.presentation;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.xrigau.droidcon.espresso.R;
import com.xrigau.droidcon.espresso.util.DeveloperError;

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = new MenuInflater(this);
        inflater.inflate(R.menu.activity_visitor, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.toast:
                Toast.makeText(this, getString(R.string.toasted_message), Toast.LENGTH_SHORT).show();
                break;
            case R.id.exit:
                finish();
                break;
            default:
                throw new DeveloperError("Menu option not handled properly!");
        }
        return true;
    }
}
