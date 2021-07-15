package com.example.cardtest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Holder> {

    Context context;
    ArrayList<Model> models;

    public Adapter(Context context, ArrayList<Model> models){
        this.context = context;
        this.models = models;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item, null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.tvName.setText(models.get(position).getmName());
        holder.tvNum.setText(models.get(position).getmNum());
        holder.tvIdNumber.setText(models.get(position).getmIdNumber());
        holder.tvIdBirthday.setText(models.get(position).getmIdBirthday());
        holder.tvIdNum.setText(models.get(position).getmIdNum());
    }

    @Override
    public int getItemCount() {
        return models.size();
    }
}
