package com.xrigau.droidcon.espresso.presentation.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class EmptyAdapter extends BaseAdapter {

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
