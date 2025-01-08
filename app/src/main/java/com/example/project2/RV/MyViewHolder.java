package com.example.project2.RV;

import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.project2.R;

import java.util.List;

public class MyViewHolder extends RecyclerView.ViewHolder{
    TextView tv_name,tv_price,tv_qu;



    public MyViewHolder(View itemView) {
        super(itemView);
        tv_name = itemView.findViewById(R.id.coffee_name);
        tv_price = itemView.findViewById(R.id.sum_price);
        tv_qu = itemView.findViewById(R.id.coffee_amount);


    }



}
