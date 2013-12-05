package com.xrigau.droidcon.espresso.presentation;

import android.os.Handler;
import android.os.Message;

import static android.os.SystemClock.sleep;

public class WorldDestructionCountdown {

    public static final int COUNTDOWN_STARTED = 0;
    public static final int COUNTDOWN_UPDATED = 1;
    public static final int COUNTDOWN_FINISHED = 2;

    private static final long WORLD_DESTRUCTION_COUNTDOWN_TIME_MS = 5000L;
    private static final long UPDATE_INTERVAL_MS = 1000L;
    private static final int IGNORED = -1;

    private final Handler handler;
    private CancellableRunnable runnable;

    public WorldDestructionCountdown(Handler handler) {
        this.handler = handler;
    }

    public void startCounting() {
        runnable = makeRunnable();
        new Thread(runnable).start();
    }

    private CancellableRunnable makeRunnable() {
        return new CancellableRunnable() {
            @Override
            public void run() {
                onCountdownStarted();
                notifyUpdate(COUNTDOWN_STARTED, IGNORED);

                long iterations = WORLD_DESTRUCTION_COUNTDOWN_TIME_MS / UPDATE_INTERVAL_MS;
                for (int i = 0; i < iterations; i++) {
                    notifyUpdate(COUNTDOWN_UPDATED, (int) (WORLD_DESTRUCTION_COUNTDOWN_TIME_MS - i * UPDATE_INTERVAL_MS));
                    sleep(UPDATE_INTERVAL_MS);
                    if (isCancelled) {
                        return;
                    }
                }

                notifyUpdate(COUNTDOWN_FINISHED, IGNORED);
                onCountdownFinished();
            }

            private void notifyUpdate(int what, int data) {
                Message message = handler.obtainMessage();
                message.what = what;
                message.arg1 = data;
                handler.sendMessage(message);
            }
        };
    }

    protected void onCountdownStarted() {
    }

    protected void onCountdownFinished() {
    }

    public void stop() {
        runnable.cancel();
    }

    private static abstract class CancellableRunnable implements Runnable {
        boolean isCancelled = false;

        void cancel() {
            isCancelled = true;
        }
    }
}
