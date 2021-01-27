package com.example.pamaproject;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Home_BaseAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private int layoutID;
    private String[] timelist;
    private String[] syousailist;
    private Bitmap[] iclist;

    static class ViewHolder {
        TextView time;
        TextView syousai;
        ImageView img;
    }
    Home_BaseAdapter(Context context, int itemlayoutID, String[] times, int[] ics, String[] syousais){
        inflater = LayoutInflater.from(context);
        layoutID = itemlayoutID;
        timelist = times;
        syousailist = syousais;
        // bitmapの配列
        iclist = new Bitmap[ics.length];
        // drawableのIDからbitmapに変換
        for( int i = 0; i< ics.length; i++){
            iclist[i] = BitmapFactory.decodeResource(context.getResources(), ics[i]);
        }
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if(convertView == null){
            convertView = inflater.inflate(layoutID,null);
            holder = new ViewHolder();
            holder.img = convertView.findViewById(R.id.img);
            holder.time = convertView.findViewById(R.id.time);
            holder.syousai = convertView.findViewById(R.id.syousai);
            convertView.setTag(holder);

        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.img.setImageBitmap(iclist[position]);
        holder.syousai.setText(syousailist[position]);
        holder.time.setText(timelist[position]);



        return convertView;
    }
    @Override
    public int getCount() {
        return timelist.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

}