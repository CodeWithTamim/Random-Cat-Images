package com.cwtstudio.randomcatimages.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cwtstudio.randomcatimages.Models.CatsModel;
import com.cwtstudio.randomcatimages.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ViewHolder> {
    List<CatsModel>catsList;
    Context context;

    public RVAdapter(List<CatsModel> catsList, Context context) {
        this.catsList = catsList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.cat_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String imgUrl = catsList.get(position).getUrl();
        if (imgUrl != null) {

            Picasso.get().load(imgUrl).into(holder.imgCat);
        }

    }

    @Override
    public int getItemCount() {
        return catsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imgCat;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgCat = itemView.findViewById(R.id.imgCat);


        }
    }




}
