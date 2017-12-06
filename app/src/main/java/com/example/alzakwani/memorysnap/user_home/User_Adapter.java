package com.example.alzakwani.memorysnap.user_home;

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
 * Created by alzakwani on 12/4/17.
 */

public class User_Adapter extends RecyclerView.Adapter<User_Adapter.MyViewHolder>{
    Context mContext;
    ArrayList<User_Info> infoArrayList;
    public User_Adapter(Context mContext, ArrayList<User_Info> infoArrayList) {
        this.mContext=mContext;
        this.infoArrayList=infoArrayList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater =(LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=inflater.inflate(R.layout.home_list_item,parent,false);

        return new User_Adapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        User_Info student=infoArrayList.get(position);
        holder.Uname.setText(student.getName());
        holder.Uimage.setImageResource(student.getImage());

    }

    @Override
    public int getItemCount() {
        return infoArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView Uname;
        ImageView Uimage;
        public MyViewHolder(View itemView) {
            super(itemView);
            Uname=(TextView) itemView.findViewById(R.id.name);
            Uimage=(ImageView) itemView.findViewById(R.id.image);
        }
    }
}
