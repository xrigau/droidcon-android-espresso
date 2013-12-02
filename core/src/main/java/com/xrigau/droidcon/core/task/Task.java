package com.xrigau.droidcon.core.task;

import com.xrigau.droidcon.core.service.Services;

interface Task<T> {

    T execute(Services services);
}
