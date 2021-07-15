package com.example.cardtest;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Holder extends RecyclerView.ViewHolder {

    TextView tvName, tvNum, tvIdNumber, tvIdBirthday, tvIdNum;

    public Holder(@NonNull View itemView) {
        super(itemView);
        tvName = itemView.findViewById(R.id.tvIdName);
        tvNum = itemView.findViewById(R.id.tvNumber);
        tvIdNumber = itemView.findViewById(R.id.tvIdNumber);
        tvIdBirthday = itemView.findViewById(R.id.tvIdBirth);
        tvIdNum = itemView.findViewById(R.id.tvIdNum);

    }
}
