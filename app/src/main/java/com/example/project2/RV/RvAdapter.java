package com.example.project2.RV;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.project2.Class.CoffeeSelectedData;
import com.example.project2.MainActivity;
import com.example.project2.R;

import java.util.List;


public class RvAdapter extends RecyclerView.Adapter<MyViewHolder> {
    List<CoffeeSelectedData> coffeeSelectedList;
    View Kview;
    TextView TP,TQ;
    TextView testTP,testTA;
    ImageButton plus,minus;
    int tPrice,tAmount;
    int testN,testP;

    public RvAdapter(List<CoffeeSelectedData> coffeeSelectedList, View Kview ) {
        this.Kview=Kview;
        this.coffeeSelectedList = coffeeSelectedList;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.rv_item_baseket,parent,false);

        testTP = Kview.findViewById(R.id.textPrice);
        testTA = Kview.findViewById(R.id.textAmount);          //오른쪽 하단의 총 갯수와 가격을 표시하는 textView

        TextView TP = view.findViewById(R.id.sum_price);
        TextView TQ = view.findViewById(R.id.coffee_amount);   //왼쪽 하단의 커피 가격과 갯수

        TextView NAME = view.findViewById(R.id.coffee_name);

        ImageButton plus = view.findViewById(R.id.plusButton);
        minus = view.findViewById(R.id.minusButton);

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                minus.setEnabled(true);
                for (int i = 0; i < coffeeSelectedList.size(); i++) {
                    if(coffeeSelectedList.get(i).getCoffeeN().equals(NAME.getText().toString())){
                        if(coffeeSelectedList.get(i).getCoffeeN().contains("(COLD)")){
                            Log.v("TEST!@#$",""+coffeeSelectedList.get(i).getCoffeeN());
                            testN=coffeeSelectedList.get(i).getCoffeeQ();
                            testN++;
                            testP=testN*4000;

                            coffeeSelectedList.get(i).setCoffeeQ(testN);
                            coffeeSelectedList.get(i).setCoffeeP(testP);
                            TQ.setText(""+coffeeSelectedList.get(i).getCoffeeQ());
                            TP.setText(""+coffeeSelectedList.get(i).getCoffeeP());

                        }
                        else if(coffeeSelectedList.get(i).getCoffeeN().contains("(HOT)")) {
                            Log.v("TEST!@#$",""+coffeeSelectedList.get(i).getCoffeeN());
                            testN=coffeeSelectedList.get(i).getCoffeeQ();
                            testN++;
                            testP=testN*3000;
                            coffeeSelectedList.get(i).setCoffeeQ(testN);
                            coffeeSelectedList.get(i).setCoffeeP(testP);
                            TQ.setText(""+coffeeSelectedList.get(i).getCoffeeQ());
                            TP.setText(""+coffeeSelectedList.get(i).getCoffeeP());

                        }
                    }
                    for (int j = 0; j <coffeeSelectedList.size() ; j++) {
                        int test = coffeeSelectedList.get(j).getCoffeeP();
                        int test2 = coffeeSelectedList.get(j).getCoffeeQ();
                        Log.v("MYTAGS",String.valueOf(coffeeSelectedList.get(j).getCoffeeP()));
                        tPrice+=test;
                        tAmount+=test2;
                    }
                    testTP.setText(""+tPrice+"원");
                    testTA.setText("총 "+tAmount+"개 선택");
                    tPrice=0;
                    tAmount=0;
                }

                Log.v("TESTTEXT",""+testTP.getText().toString());
            }});
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < coffeeSelectedList.size(); i++) {
                    if(coffeeSelectedList.get(i).getCoffeeN().equals(NAME.getText().toString())){
                        if(coffeeSelectedList.get(i).getCoffeeN().contains("(COLD)")){
                            Log.v("TEST!@#$",""+coffeeSelectedList.get(i).getCoffeeN());
                            testN=coffeeSelectedList.get(i).getCoffeeQ();
                            testN--;
                            testP=testN*4000;
                            coffeeSelectedList.get(i).setCoffeeQ(testN);
                            coffeeSelectedList.get(i).setCoffeeP(testP);
                            TQ.setText(""+coffeeSelectedList.get(i).getCoffeeQ());
                            TP.setText(""+coffeeSelectedList.get(i).getCoffeeP());
                        }
                        else {
                            Log.v("TEST!@#$",""+coffeeSelectedList.get(i).getCoffeeN());
                            testN=coffeeSelectedList.get(i).getCoffeeQ();
                            testN--;
                            testP=testN*3000;
                            coffeeSelectedList.get(i).setCoffeeQ(testN);
                            coffeeSelectedList.get(i).setCoffeeP(testP);
                            TQ.setText(""+coffeeSelectedList.get(i).getCoffeeQ());
                            TP.setText(""+coffeeSelectedList.get(i).getCoffeeP());
                        }

                    }
                    for (int j = 0; j <coffeeSelectedList.size() ; j++) {
                        int test = coffeeSelectedList.get(j).getCoffeeP();
                        int test2 = coffeeSelectedList.get(j).getCoffeeQ();
                        Log.v("MYTAGS",String.valueOf(coffeeSelectedList.get(j).getCoffeeP()));
                        tPrice+=test;
                        tAmount+=test2;
                    }
                    testTP.setText(""+tPrice+"원");
                    testTA.setText("총 "+tAmount+"개 선택");
                    tPrice=0;
                    tAmount=0;

                }
                if (testP==0){
                    minus.setEnabled(false);
                }}
        });


        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        CoffeeSelectedData coffee = coffeeSelectedList.get(position);
        holder.tv_name.setText(coffee.getCoffeeN());
        holder.tv_price.setText(""+coffee.getCoffeeP());
        holder.tv_qu.setText(""+coffee.getCoffeeQ());
    }

    @Override
    public int getItemCount() {
        return coffeeSelectedList.size();
    }


    public void clear(){
        coffeeSelectedList.clear();
//        Log.v("TESTTAG11",""+coffeeSelectedList);
        notifyDataSetChanged();
    }

}







