package com.xrigau.droidcon.espresso.loader;

public interface LoaderListener<T> {
    void onLoadStarted();

    void onLoadFinished(T result);
}
