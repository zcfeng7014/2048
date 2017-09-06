package com.zcfeng.a2048;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/8/30/030.
 */

public class MyAdapter extends BaseAdapter {
    int[] a;
    MyAdapter(int[] nums){
        this.a=nums;

    }
    @Override
    public int getCount() {
        return a.length;
    }
    @Override
    public Object getItem(int i) {
        return null;
    }
    @Override
    public long getItemId(int i) {
        return 0;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view ==null){
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item,viewGroup,false);
        }
        LinearLayout ll=view.findViewById(R.id.item_layout);
        TextView tv=view.findViewById(R.id.value);
        tv.setText("");
        if(a[i]!=0)
            tv.setText(a[i]+"");
        return ll;
    }
}