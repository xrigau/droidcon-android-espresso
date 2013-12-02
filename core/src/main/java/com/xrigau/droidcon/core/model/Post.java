package com.xrigau.droidcon.core.model;

import static com.xrigau.droidcon.core.model.Post.Builder.Type;

public class Post {

    private final String id;
    private final String title;
    private final String url;
    private final String domain;
    private final int points;
    private final String user;
    private final String time_ago;
    private final int comments_count;
    private final String type;

    public Post(String id, String title, String url, String domain, int points, String user, String time_ago, int comments_count, String type) {
        this.id = id;
        this.title = title;
        this.url = url;
        this.domain = domain;
        this.points = points;
        this.user = user;
        this.time_ago = time_ago;
        this.comments_count = comments_count;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public String getDomain() {
        return domain;
    }

    public int getPoints() {
        return points;
    }

    public String getUser() {
        return user;
    }

    public String getTime() {
        return time_ago;
    }

    public int getCommentCount() {
        return comments_count;
    }

    public Type getType() {
        return Type.valueOf(type);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Post post = (Post) o;

        if (!id.equals(post.id)) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    public static class Builder {

        public static enum Type {
            UNDEFINED("undefined"),
            LINK("link"),
            COMMENT("comment"),
            JOB("job"),
            ASK("ask");

            private final String type;

            Type(String type) {
                this.type = type;
            }
        }

        private String id;
        private String title;
        private String url;
        private String domain;
        private int points;
        private String user;
        private String time_ago;
        private int commentCount;
        private Type type = Type.UNDEFINED;
        
        public Builder id(String id) {
            this.id = id;
            return this;    
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder url(String url) {
            this.url = url;
            return this;
        }

        public Builder domain(String domain) {
            this.domain = domain;
            return this;
        }

        public Builder points(int points) {
            this.points = points;
            return this;
        }

        public Builder user(String user) {
            this.user = user;
            return this;
        }

        public Builder postedTime(String postedTime) {
            this.time_ago = postedTime;
            return this;
        }

        public Builder commentCount(int commentCount) {
            this.commentCount = commentCount;
            return this;
        }

        public Builder type(Type type) {
            this.type = type;
            return this;
        }

        public Post build() {
            if (id == null) {
                id = "";
            }
            return new Post(id, title, url, domain, points, user, time_ago, commentCount, type.type);
        }
    }
    
}
