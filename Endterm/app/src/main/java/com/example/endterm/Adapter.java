package com.example.endterm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import com.example.endterm.models.Model;

public class Adapter extends RecyclerView.Adapter<Adapter.NewsViewHolder> {

    private ArrayList<Model> dataset;
    private Context context;
    private InterfaceJ onNewsClickListener;

    Adapter(
            ArrayList<Model> dataset,
            Context context,
            InterfaceJ onNewsClickListener
    ){
        this.dataset = dataset;
        this.context = context;
        this.onNewsClickListener = onNewsClickListener;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NewsViewHolder(LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_list,parent,false
        ));
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        holder.bind(dataset.get(position));
    }


    @Override
    public int getItemCount() {
        return dataset.size();
    }

    class NewsViewHolder extends RecyclerView.ViewHolder{

        NewsViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        void bind(final Model p){
            TextView titleTextView = itemView.findViewById(R.id.titleTextView);
            TextView descriptionTextView = itemView.findViewById(R.id.descriptionTextView);
            ImageView mainImage = itemView.findViewById(R.id.mainImage);
            ImageButton shareBtn = itemView.findViewById(R.id.listShareBtn);
            TextView created_at = itemView.findViewById(R.id.created_at);

            titleTextView.setText(p.getTitle());
            descriptionTextView.setText(p.getShortDescription());

            Glide.with(context)
                    .load(p.getImage_url())
                    .placeholder(R.drawable.ic_ball_load)
                    .into(mainImage);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onNewsClickListener.startDetailsActivity(p.getId());
                }
            });

            created_at.setText(DateJ.getFormattedStringFromDate(p.getCratetion_date()));


            shareBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onNewsClickListener.showToast("Не получилось сделать");
                }
            });
        }
    }
}

