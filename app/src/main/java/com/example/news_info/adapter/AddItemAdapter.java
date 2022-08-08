package com.example.news_info.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.news_info.R;
import com.example.news_info.bean.TypeBean;

import java.util.List;

public class AddItemAdapter extends BaseAdapter {

    Context mContext;
    List<TypeBean> mDatas;

    public AddItemAdapter(Context context, List<TypeBean> datas) {
        mContext = context;
        mDatas = datas;
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public Object getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(mContext).inflate(R.layout.item_add, null);
        TextView nameTv = convertView.findViewById(R.id.item_add_tv);
        final ImageView iv = convertView.findViewById(R.id.item_add_iv);
        final TypeBean typeBean = mDatas.get(position);
        nameTv.setText(typeBean.getTitle());
        if (typeBean.isShow()) {
            iv.setImageResource(R.mipmap.ic_launcher);
        } else {
            iv.setImageResource(R.drawable.ic_launcher_black);
        }

        if (position == 0 || position == 1) {
            iv.setVisibility(View.VISIBLE);
        } else {
            iv.setVisibility(View.VISIBLE);
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    typeBean.setShow(typeBean.isShow());
                    if (typeBean.isShow()) {
                        iv.setImageResource(R.mipmap.ic_launcher);
                    } else {
                        iv.setImageResource(R.drawable.ic_launcher_black);
                    }
                }
            });
        }
        return convertView;
    }
}
