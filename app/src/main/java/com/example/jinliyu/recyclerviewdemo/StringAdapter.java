package com.example.jinliyu.recyclerviewdemo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class StringAdapter extends RecyclerView.Adapter<StringAdapter.MyViewHolder>  {
    Context context;
    List<String> slist;


    public StringAdapter(Context context, List<String> slist) {
        this.context = context;
        this.slist = slist;
    }

    @NonNull
    @Override
    public StringAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MyViewHolder myViewHolder;
        View view = LayoutInflater.from(context).inflate(R.layout.item_layout,parent,false);

        myViewHolder = new StringAdapter.MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull StringAdapter.MyViewHolder holder, int position) {

        holder.tv.setText(slist.get(position));

    }

    @Override
    public int getItemCount() {
        return slist.size();
    }



    class MyViewHolder extends RecyclerView.ViewHolder{
       TextView tv;

        public MyViewHolder(View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.item_name);
        }
    }

}
