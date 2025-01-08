package com.example.project2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project2.Class.CoffeeSelectedData;
import com.example.project2.RV.RvAdapter2;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SecondActivity extends AppCompatActivity {
    List<CoffeeSelectedData> coffeeSelectedData;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity);
        Intent intent = getIntent();

        coffeeSelectedData = intent.getParcelableArrayListExtra("itemList");
        RecyclerView recyclerView3 = findViewById(R.id.rv4);
        recyclerView3.setLayoutManager(new LinearLayoutManager(this));
        RvAdapter2 adapter2 = new RvAdapter2(coffeeSelectedData);
        recyclerView3.setAdapter(adapter2);
        Log.v("MYTESTTAG",""+coffeeSelectedData.get(0).getCoffeeQ());


    }
}
