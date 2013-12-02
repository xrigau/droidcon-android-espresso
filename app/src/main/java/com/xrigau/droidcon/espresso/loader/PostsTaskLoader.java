package com.xrigau.droidcon.espresso.loader;

import android.content.AsyncTaskLoader;
import android.content.Context;

import com.xrigau.droidcon.core.model.PostList;
import com.xrigau.droidcon.core.task.NewsTask;
import com.xrigau.droidcon.core.task.TaskExecutor;
import com.xrigau.droidcon.espresso.BuildConfig;

public class PostsTaskLoader extends AsyncTaskLoader<PostList> {

    public PostsTaskLoader(Context context) {
        super(context);
    }

    @Override
    public PostList loadInBackground() {
        return new TaskExecutor(BuildConfig.HTTP_CLIENT).execute(new NewsTask());
    }
}
