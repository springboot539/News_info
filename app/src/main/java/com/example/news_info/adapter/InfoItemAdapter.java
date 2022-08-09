package com.example.news_info.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.news_info.R;
import com.example.news_info.bean.InfoBean;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Fragment中的ListView的适配器
 */
public class InfoItemAdapter extends BaseAdapter {
    Context mContext;
    List<InfoBean.ResultBean.DataBean> mDatas;
    ImageLoader mImageLoader;
    DisplayImageOptions mOptions;//图片加载配置信息


    public InfoItemAdapter(Context context, List<InfoBean.ResultBean.DataBean> datas) {
        mContext = context;
        mDatas = datas;
        mImageLoader = ImageLoader.getInstance();
        mOptions = new DisplayImageOptions.Builder()
                .showImageOnLoading(null)//正在加载过程显示图片
                .showImageForEmptyUri(null)//如果是一个空字符串
                .showImageOnFail(null)
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .considerExifParams(true)
                .bitmapConfig(Bitmap.Config.RGB_565)
                .build();
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
        ViewHolder holder = null;
        if (convertView == null) {
            View view = convertView = LayoutInflater.from(mContext).inflate(R.layout.item_newsfrag, null);
            holder = new ViewHolder(view);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        InfoBean.ResultBean.DataBean dataBean = mDatas.get(position);
        holder.titleTv.setText(dataBean.getTitle());
        holder.sourceTv.setText(dataBean.getAuthor_name());
        holder.timeTv.setText(dataBean.getDate());
//        获取三张图片的地址
        String pic1 = dataBean.getThumbnail_pic_s();
        String pic2 = dataBean.getThumbnail_pic_s02();
        String pic3 = dataBean.getThumbnail_pic_s03();
        if (TextUtils.isEmpty(pic1)) {
//            不显示也不占用地方
            holder.iv1.setVisibility(View.GONE);
        } else {
            holder.iv1.setVisibility(View.VISIBLE);
            mImageLoader.displayImage(pic1, holder.iv1, mOptions);
        }
        if (TextUtils.isEmpty(pic2)) {
//            不显示也不占用地方
            holder.iv2.setVisibility(View.GONE);
        } else {
            holder.iv2.setVisibility(View.VISIBLE);
            mImageLoader.displayImage(pic1, holder.iv2, mOptions);
        }
        if (TextUtils.isEmpty(pic3)) {
//            不显示也不占用地方
            holder.iv3.setVisibility(View.GONE);
        } else {
            holder.iv3.setVisibility(View.VISIBLE);
            mImageLoader.displayImage(pic1, holder.iv3, mOptions);
        }
        return convertView;
    }

    class ViewHolder {
        TextView titleTv, sourceTv, timeTv;
        ImageView iv1, iv2, iv3;

        public ViewHolder(View view) {
            titleTv = view.findViewById(R.id.item_newsfrag_tv_title);
            sourceTv = view.findViewById(R.id.item_tv_source);
            timeTv = view.findViewById(R.id.item_tv_time);
            iv1 = view.findViewById(R.id.item_news_iv);
            iv2 = view.findViewById(R.id.item_news_iv2);
            iv3 = view.findViewById(R.id.item_news_iv3);
        }
    }
}
