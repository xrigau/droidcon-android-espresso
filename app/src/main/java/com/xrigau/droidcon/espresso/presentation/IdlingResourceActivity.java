package com.xrigau.droidcon.espresso.presentation;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.TextView;

import com.xrigau.droidcon.espresso.R;

import static com.xrigau.droidcon.espresso.presentation.WorldDestructionCountdown.COUNTDOWN_FINISHED;
import static com.xrigau.droidcon.espresso.presentation.WorldDestructionCountdown.COUNTDOWN_STARTED;
import static com.xrigau.droidcon.espresso.presentation.WorldDestructionCountdown.COUNTDOWN_UPDATED;
import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.SECONDS;

public class IdlingResourceActivity extends Activity {

    private TextView timer;
    private WorldDestructionCountdown countdown = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_idling_resource);
        findViews();

        Handler handler = makeHandler();
        setCountdown(new WorldDestructionCountdown(handler));
    }

    private void findViews() {
        timer = (TextView) findViewById(R.id.timer);
    }

    Handler makeHandler() {
        return new Handler(Looper.getMainLooper()) {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                switch (msg.what) {
                    case COUNTDOWN_STARTED:
                        onStartCountdown();
                        break;
                    case COUNTDOWN_UPDATED:
                        onUpdate(msg.arg1);
                        break;
                    case COUNTDOWN_FINISHED:
                        onEndCountdown();
                        break;
                }
            }
        };
    }

    private void onStartCountdown() {
        timer.setText(getString(R.string.countdown_started));
    }

    private void onUpdate(long remainingMs) {
        timer.setText(getString(R.string.countdown_update, (int) SECONDS.convert(remainingMs, MILLISECONDS)));
    }

    private void onEndCountdown() {
        timer.setText(getString(R.string.countdown_finished));
    }

    public void setCountdown(WorldDestructionCountdown countdown) {
        cancelPreviousCountdownIfExists();
        this.countdown = countdown;
        startCountdown();
    }

    private void cancelPreviousCountdownIfExists() {
        if (this.countdown != null) {
            this.countdown.stop();
        }
    }

    private void startCountdown() {
        countdown.startCounting();
    }
}
