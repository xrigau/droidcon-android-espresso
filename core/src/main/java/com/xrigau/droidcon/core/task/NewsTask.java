package com.xrigau.droidcon.core.task;

import com.xrigau.droidcon.core.model.PostList;
import com.xrigau.droidcon.core.service.Services;

public class NewsTask implements Task<PostList> {

    @Override
    public PostList execute(Services services) {
        return services.news();
    }
}
