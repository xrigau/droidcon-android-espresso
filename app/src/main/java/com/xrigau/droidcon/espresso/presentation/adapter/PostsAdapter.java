package com.xrigau.droidcon.espresso.presentation.adapter;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.xrigau.droidcon.core.model.Post;
import com.xrigau.droidcon.core.model.PostList;
import com.xrigau.droidcon.espresso.R;

public class PostsAdapter extends BaseAdapter {

    private final PostList posts;
    private final LayoutInflater inflater;
    private final Resources resources;

    public PostsAdapter(PostList posts, LayoutInflater inflater, Resources resources) {
        this.posts = posts;
        this.inflater = inflater;
        this.resources = resources;
    }

    @Override
    public int getCount() {
        return posts.size();
    }

    @Override
    public Post getItem(int position) {
        return posts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return getItem(position).hashCode();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.posts_list_item, parent, false);
            convertView.setTag(new ViewHolder(convertView));
        }

        ViewHolder holder = ViewHolder.from(convertView.getTag());
        Post post = getItem(position);
        populateView(holder, post);

        return convertView;
    }

    private void populateView(ViewHolder holder, Post post) {
        holder.title.setText(post.getTitle());
        holder.domain.setText(post.getDomain());
        updateCommentsVuew(holder, post.getCommentCount());
        holder.time.setText(post.getTime());
    }

    private void updateCommentsVuew(ViewHolder holder, int comments) {
        if (comments == 0) {
            holder.comments.setVisibility(View.GONE);
            return;
        }
        int stringResId = comments == 1 ? R.string.one_comment : R.string.many_comments;
        holder.comments.setText(resources.getString(stringResId, comments));

        holder.comments.setVisibility(View.VISIBLE);
    }

    private static class ViewHolder {

        private final TextView title;
        private final TextView domain;
        private final TextView comments;
        private final TextView time;

        public ViewHolder(View view) {
            title = (TextView) view.findViewById(R.id.title);
            domain = (TextView) view.findViewById(R.id.domain);
            comments = (TextView) view.findViewById(R.id.comments);
            time = (TextView) view.findViewById(R.id.time);
        }

        public static ViewHolder from(Object tag) {
            return (ViewHolder) tag;
        }
    }
}
