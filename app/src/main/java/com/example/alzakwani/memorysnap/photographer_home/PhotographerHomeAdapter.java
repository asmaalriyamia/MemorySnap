package com.example.alzakwani.memorysnap.photographer_home;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alzakwani.memorysnap.R;

import java.util.ArrayList;

/**
 * Created by alzakwani on 11/29/17.
 */

public class PhotographerHomeAdapter extends RecyclerView.Adapter<PhotographerHomeAdapter.ViewHolder>{
    Context mContext;
    ArrayList<HomeItems> homeItems;
public  OnAdapterItemClick onItemClick;
public  interface OnAdapterItemClick{
    public void onItemClick(int position);
}
    public PhotographerHomeAdapter(Context mContext, ArrayList<HomeItems> homeItems) {
        this.mContext = mContext;
        this.homeItems = homeItems;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater =(LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.home_list_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        HomeItems items =homeItems.get(position);
        holder.home_name.setText(items.getHomeItems());
        holder.home_image.setImageResource(items.getHomeImages());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClick.onItemClick(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return homeItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView home_image;
        TextView home_name;
        public ViewHolder(View itemView) {
            super(itemView);
            home_name =(TextView)itemView.findViewById(R.id.name);
            home_image =(ImageView)itemView.findViewById(R.id.image);
        }
    }

    public void setOnItemClick(OnAdapterItemClick onItemClick){
    this.onItemClick=onItemClick;

    }
}
