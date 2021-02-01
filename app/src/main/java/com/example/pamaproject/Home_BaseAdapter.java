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
    private String[] IntNowdataslist;
    private String[] Codeslist;
    private String[] syousailist;
    private String[] Jihunlist;
    private Bitmap[] iclist;
    private String[] cidlist;

    static class ViewHolder {
        TextView timev;
        TextView syousaiv;
        ImageView imgv;
        TextView jihunv;
        TextView codev;
        TextView cidv;
    }
    Home_BaseAdapter(Context context, int itemlayoutID, String[] IntNowdatas,String[] Codes, int[] Imgs, String[] Jihuns,String[] syousais,String[] cids){
        inflater = LayoutInflater.from(context);
        layoutID = itemlayoutID;
        IntNowdataslist = IntNowdatas;
        Codeslist = Codes;

        // bitmapの配列
        iclist = new Bitmap[Imgs.length];
        // drawableのIDからbitmapに変換
        for( int i = 0; i< Imgs.length; i++){
            iclist[i] = BitmapFactory.decodeResource(context.getResources(), Imgs[i]);
        }
        Jihunlist = Jihuns;
        syousailist = syousais;
        cidlist = cids;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if(convertView == null){
            convertView = inflater.inflate(layoutID,null);
            holder = new ViewHolder();
            holder.timev = convertView.findViewById(R.id.intnowdata);
            holder.syousaiv = convertView.findViewById(R.id.syousai);
            holder.imgv = convertView.findViewById(R.id.img);
            holder.jihunv = convertView.findViewById(R.id.time);
            holder.codev = convertView.findViewById(R.id.code);
            holder.cidv = convertView.findViewById(R.id.cid);
            convertView.setTag(holder);

        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.imgv.setImageBitmap(iclist[position]);
        holder.syousaiv.setText(syousailist[position]);
        holder.timev.setText(IntNowdataslist[position]);
        holder.codev.setText(Codeslist[position]);
        holder.jihunv.setText(Jihunlist[position]);
        holder.cidv.setText(cidlist[position]);




        return convertView;
    }
    @Override
    public int getCount() {
        return IntNowdataslist.length;
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