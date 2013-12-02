package com.xrigau.droidcon.espresso.loader;

import android.app.LoaderManager;
import android.content.Context;
import android.content.Loader;
import android.os.Bundle;

import com.xrigau.droidcon.core.model.PostList;

public class PostsTaskLoaderCallbacks implements LoaderManager.LoaderCallbacks<PostList> {

    private final Context context;
    private final LoaderListener<PostList> listener;

    public PostsTaskLoaderCallbacks(Context context, LoaderListener<PostList> listener) {
        this.context = context;
        this.listener = listener;
    }

    @Override
    public Loader onCreateLoader(int id, Bundle args) {
        listener.onLoadStarted();
        return new PostsTaskLoader(context);
    }

    @Override
    public void onLoadFinished(Loader<PostList> loader, PostList posts) {
        listener.onLoadFinished(posts);
    }

    @Override
    public void onLoaderReset(Loader<PostList> loader) {
        listener.onLoadStarted();
    }
}
