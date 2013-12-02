package com.xrigau.droidcon.core.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PostShould {

    @Test
    public void createPostUsingBuilder() {
        String expectedId = "someId";

        Post post = new Post.Builder().id(expectedId).build();

        assertNotNull(post);
        assertEquals(expectedId, post.getId());
    }
}
