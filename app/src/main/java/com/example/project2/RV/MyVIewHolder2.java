package com.example.project2.RV;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project2.R;

public class MyVIewHolder2 extends RecyclerView.ViewHolder {
    TextView tv_Name,tv_Price,tv_Amount;

    public MyVIewHolder2(@NonNull View itemView) {
        super(itemView);
        tv_Name = itemView.findViewById(R.id.testN);
        tv_Price = itemView.findViewById(R.id.testQ);
        tv_Amount = itemView.findViewById(R.id.testP);
    }
}
