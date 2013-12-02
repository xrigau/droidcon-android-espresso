package com.xrigau.droidcon.core.task;

import com.xrigau.droidcon.core.service.Services;

import retrofit.RestAdapter;
import retrofit.client.Client;

public class TaskExecutor {

    private static final String API_URL = "http://node-hnapi.herokuapp.com";

    private final Client client;

    public TaskExecutor(Client client) {
        this.client = client;
    }

    public <T> T execute(Task<T> task) {
        RestAdapter restAdapter = new RestAdapter.Builder().setClient(client).setServer(API_URL).build();
        return task.execute(restAdapter.create(Services.class));
    }

}
