package com.xrigau.droidcon.espresso.presentation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.xrigau.droidcon.espresso.R;

import java.util.Random;

public class MainActivity extends Activity {

    private static final int VISITOR_NUMBER = new Random().nextInt(Integer.MAX_VALUE);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpViews();
    }

    private void setUpViews() {
        Button button = (Button) findViewById(R.id.hello_visitor);
        button.setText(getString(R.string.hello_visitor, VISITOR_NUMBER));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, VisitorActivity.class)
                        .putExtra(VisitorActivity.VISITOR_ID, VISITOR_NUMBER);
                startActivity(intent);
            }
        });
    }

}
