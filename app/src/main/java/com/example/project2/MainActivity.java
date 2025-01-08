package com.example.project2;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.project2.Class.CoffeeSelectedData;
import com.example.project2.RV.RvAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    View viewMain,viewKoreaMenu,  ///main화면
         F_bestFood,F_coffee,F_nonCoffee,F_smoothie,F_juice,F_dessert,   //프래그먼트
         RvItem;
    Button buttonBestMenu,buttonCoffee,buttonNonCoffee,buttonJuice,buttonSmoothie,buttonDessert,  ///상단의 버튼
           buttonDelete;  ///장바구니에 담은 내용을 지울때
    TextView tv_amount,tv_price;  ///다른 함수에서도 사용되기 때문에 맴버 변수로 지정함(viewID)
    RecyclerView recyclerView;

    List<CoffeeSelectedData> coffeeSelected = new ArrayList<>();  ///장바구니와 비슷함

    CoffeeSelectedData coffee1,coffee2,coffee3,coffee4,coffee5,coffee6,coffee7,coffee8;
    RvAdapter adapter;


    int coffeeHPrice,coffeeHQ,coffeeCPrice,coffeeCQ;
    int totalQ,totalP;






    View XMLView(int idLayout){
        return getLayoutInflater().inflate(idLayout,null,false);
    }  ///xml파일을 view객체로 바꿔주는 함수

    void getLayout_ID(){
        viewMain = XMLView(R.layout.activity_main_project);
        viewKoreaMenu = XMLView(R.layout.activity_main_foodmenu_korean);
        F_bestFood = XMLView(R.layout.f_bestfood);
        F_coffee = XMLView(R.layout.f_coffee);
        F_nonCoffee= XMLView(R.layout.f_non_coffee);
        F_smoothie= XMLView(R.layout.f_smoothie);
        F_juice= XMLView(R.layout.f_juice);
        F_dessert= XMLView(R.layout.f_dessert);
        RvItem = XMLView(R.layout.rv_item_baseket);
    }  ///view 객체의 id를 얻는 함수

    void getViewId(){
        if (viewKoreaMenu != null) {
            buttonBestMenu = viewKoreaMenu.findViewById(R.id.Button_Best_K);
            buttonCoffee = viewKoreaMenu.findViewById(R.id.Button_Coffee_K);
            buttonNonCoffee = viewKoreaMenu.findViewById(R.id.Button_NonCoffee_K);
            buttonJuice = viewKoreaMenu.findViewById(R.id.Button_Jucie_K);
            buttonSmoothie = viewKoreaMenu.findViewById(R.id.Button_Smodi_K);
            buttonDessert = viewKoreaMenu.findViewById(R.id.Button_Disert_K);
            buttonDelete = viewKoreaMenu.findViewById(R.id.buttonDelete);

            tv_amount = viewKoreaMenu.findViewById(R.id.textAmount);
            tv_price = viewKoreaMenu.findViewById(R.id.textPrice);

            recyclerView = viewKoreaMenu.findViewById(R.id.rv);

        } else {
            // viewKoreaMenu가 null일 경우, 로그를 찍거나 처리
            Log.e("Error", "viewKoreaMenu is null");
        }
    }  ///버튼의 아이디를 얻는 함수

    void Remove_AND_AddView(View A1){
        ((FrameLayout) viewKoreaMenu.findViewById(R.id.Frame_Layout)).removeAllViews();
        ((FrameLayout) viewKoreaMenu.findViewById(R.id.Frame_Layout)).addView(A1);
    }  ///ex)베스트를 눌렀을때 f_best만 나오고 나머지 프레그먼트는 없애는 함수

    void setCategoryColor(Button G1,Button G2,Button G3,Button G4,Button G5,Button B1){
        G1.setTextColor(Color.parseColor("#878282"));
        G2.setTextColor(Color.parseColor("#878282"));
        G3.setTextColor(Color.parseColor("#878282"));
        G4.setTextColor(Color.parseColor("#878282"));
        G5.setTextColor(Color.parseColor("#878282"));
        B1.setTextColor(Color.parseColor("#000000"));
    }  ///상단의 버튼(베스트,커피,..)을 눌렀을때 색깔을 바꿔주는 함수



    ///다이얼로그 만들어주는 함수



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLayout_ID();
        getViewId();
        setContentView(viewMain);

        viewMain.findViewById(R.id.ForHereButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(viewKoreaMenu);
            }
        });
        viewMain.findViewById(R.id.ToGoButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(viewKoreaMenu);
            }
        });

        ///상단 버튼을 눌렀을때 색깔이 바뀌는거 구현한 코드
        buttonBestMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Remove_AND_AddView(F_bestFood);
                setCategoryColor(buttonCoffee,buttonNonCoffee,buttonSmoothie,buttonJuice,buttonDessert,buttonBestMenu);
            }
        });
        buttonCoffee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Remove_AND_AddView(F_coffee);
                setCategoryColor(buttonBestMenu,buttonNonCoffee,buttonSmoothie,buttonJuice,buttonDessert,buttonCoffee);
            }
        });
        buttonNonCoffee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Remove_AND_AddView(F_nonCoffee);
                setCategoryColor(buttonBestMenu,buttonCoffee,buttonSmoothie,buttonJuice,buttonDessert,buttonNonCoffee);
            }
        });
        buttonSmoothie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Remove_AND_AddView(F_smoothie);
                setCategoryColor(buttonBestMenu,buttonCoffee,buttonNonCoffee,buttonJuice,buttonDessert,buttonSmoothie);
            }
        });
        buttonJuice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Remove_AND_AddView(F_juice);
                setCategoryColor(buttonCoffee,buttonNonCoffee,buttonSmoothie,buttonBestMenu,buttonDessert,buttonJuice);
            }
        });
        buttonDessert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Remove_AND_AddView(F_dessert);
                setCategoryColor(buttonCoffee,buttonNonCoffee,buttonSmoothie,buttonBestMenu,buttonJuice,buttonDessert);
            }
        });
        viewKoreaMenu.findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    intent.putParcelableArrayListExtra("itemList", (ArrayList<? extends Parcelable>) coffeeSelected);  // Serializable 객체로 전달
                    startActivity(intent);


            }
        });

        recyclerView = viewKoreaMenu.findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        coffee1 = new CoffeeSelectedData("콜드 브루 플로트(HOT)",0,0);
        coffee2 = new CoffeeSelectedData("콜드 브루 플로트(COLD)",0,0);

        coffee3 = new CoffeeSelectedData("라벤더 카페 브레베(HOT)",0,0);
        coffee4 = new CoffeeSelectedData("라벤더 카페 브레베(COLD)",0,0);

        coffee5 = new CoffeeSelectedData("클래식 아포가토(HOT)",0,0);
        coffee6 = new CoffeeSelectedData("클래식 아포가토(COLD)",0,0);

        coffee7 = new CoffeeSelectedData("프랜티 애플 타르트 나이트로(HOT)",0,0);
        coffee8 = new CoffeeSelectedData("프랜티 애플 타르트 나이트로(COLD)",0,0);

        ///객체의 속성 : 1.coffeeN : 해당 커피의 이름(h/c)
        ///            2.coffeeQ : 사용자가 해당 메뉴를 선택한 갯수
        ///            3.coffeeP : 그만큼의 가격
    }



//-------------------------------------------------------------------------------------------------------------

    void MakeDialog(int layout,CoffeeSelectedData coffeeH,CoffeeSelectedData coffeeC,int rb_id){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(layout, null); // xml명 변경
        builder.setView(dialogView)
                .setTitle("")
                .setPositiveButton("장바구니에 담기", (dialog, which) -> {
                    RadioButton rb = dialogView.findViewById(rb_id);

                    if (rb.isChecked()){
                        if(coffeeSelected.contains(coffeeH)){
                            coffeeHQ = coffeeH.getCoffeeQ();

                            coffeeHQ++;             //갯수 추가
                            coffeeHPrice=coffeeHQ*3000;     //3000원 추가

                            coffeeH.setCoffeeQ(coffeeHQ);
                            coffeeH.setCoffeeP(coffeeHPrice);

                            adapter = new RvAdapter(coffeeSelected,viewKoreaMenu);
                            recyclerView.setAdapter(adapter);
                        }
                        else{
                            coffeeHQ = coffeeH.getCoffeeQ();

                            coffeeHQ++;          //갯수 추가
                            coffeeHPrice=coffeeHQ*3000;  //3000원 추가

                            coffeeH.setCoffeeQ(coffeeHQ);
                            coffeeH.setCoffeeP(coffeeHPrice);

                            coffeeSelected.add(coffeeH);  //Selected리스트에 추가하기
                            adapter = new RvAdapter(coffeeSelected,viewKoreaMenu);
                            recyclerView.setAdapter(adapter);}
                    }
                    else{
                        if(coffeeSelected.contains(coffeeC)){
                            coffeeCQ = coffeeC.getCoffeeQ();

                            coffeeCQ++;
                            coffeeCPrice=coffeeCQ*4000;

                            coffeeC.setCoffeeQ(coffeeCQ);
                            coffeeC.setCoffeeP(coffeeCPrice);

                            adapter = new RvAdapter(coffeeSelected,viewKoreaMenu);
                            recyclerView.setAdapter(adapter);
                        }
                        else{
                            coffeeCQ = coffeeC.getCoffeeQ();

                            coffeeCQ++;
                            coffeeCPrice=coffeeCQ*4000;

                            coffeeC.setCoffeeQ(coffeeCQ);
                            coffeeC.setCoffeeP(coffeeCPrice);

                            coffeeSelected.add(coffeeC);  //Selected리스트에 추가하기
                            adapter = new RvAdapter(coffeeSelected,viewKoreaMenu);
                            recyclerView.setAdapter(adapter);
                        }
                    }  //if문 끝나는 지점
                    Log.v("COFFEE1",""+coffee1.getCoffeeQ());
                    Log.v("COFFEE1",""+coffee1.getCoffeeP());


                    totalP = coffee1.getCoffeeP()
                            +coffee2.getCoffeeP()
                            +coffee3.getCoffeeP()
                            +coffee4.getCoffeeP()
                            +coffee5.getCoffeeP()
                            +coffee6.getCoffeeP()
                            +coffee7.getCoffeeP()
                            +coffee8.getCoffeeP();  //총 가격 합치기

                    totalQ = coffee1.getCoffeeQ()
                            +coffee2.getCoffeeQ()
                            +coffee3.getCoffeeQ()
                            +coffee4.getCoffeeQ()
                            +coffee5.getCoffeeQ()
                            +coffee6.getCoffeeQ()
                            +coffee7.getCoffeeQ()
                            +coffee8.getCoffeeQ();  //총 갯수 합치기

                    tv_amount.setText("총 "+""+totalQ+"개 선택");
                    tv_price.setText(""+totalP+"원");    //총 가격과 갯수를 표시해주는 부분
//                    Log.v("test",""+coffeeSelected.get(0).getCoffeeP());
//                    Log.v("test",""+coffeeSelected.get(0).getCoffeeQ());
                })
                .setNegativeButton("취소", (dialog, which) -> {
                    dialog.dismiss();
                    // Handle Cancel button click
                });
        tv_amount.setText("총 "+""+totalQ+"개 선택");
        tv_price.setText(""+totalP+"원");    //총 가격과 갯수를 표시해주는 부분
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
    ///만든이유 : 다이얼로그생성코드가 중복되어서
    ///인자 : 1.다이얼로그 레이아웃,
    ///      2.HOT,COLD커피 (라디오 버튼에서 hot을 누르면 리스트에 coffee1(hot),cold를 누르면 리스트에 coffee2(cold)를 담기 위해)
    ///      3.해당 다이얼로그의 라디오 버튼(사용자가 hot을 눌렀는지 cold를 눌렀는지 ischecked()로 확인하기 위해서)

    public void coffee1_selected(View view){
        MakeDialog(R.layout.coffee1_selected,coffee1,coffee2,R.id.rb_hot);
    }
    public void coffee2_selected(View view) {
        MakeDialog(R.layout.coffee2_selected,coffee3,coffee4,R.id.rb_hot2);
    }
    public void coffee3_selected(View view){
        MakeDialog(R.layout.coffee3_selected,coffee5,coffee6,R.id.rb_hot3);
    }
    public void coffee4_selected(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.coffee4_selected, null); // xml명 변경

        builder.setView(dialogView)
                .setTitle("")
                .setPositiveButton("확인", (dialog, which) -> {

                });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
    public void coffee5_selected(View view){
        MakeDialog(R.layout.coffee5_selected,coffee7,coffee8,R.id.rb_hot5);
    }  ///해당 메뉴를 눌렀을때 MakeDialog함수를 실행함

    public void clearItem(View view){
        coffee1.setCoffeeP(0);
        coffee1.setCoffeeQ(0);
        coffee2.setCoffeeP(0);
        coffee2.setCoffeeQ(0);
        coffee3.setCoffeeP(0);
        coffee3.setCoffeeQ(0);
        coffee4.setCoffeeP(0);
        coffee4.setCoffeeQ(0);
        coffee5.setCoffeeP(0);
        coffee5.setCoffeeQ(0);
        coffee6.setCoffeeP(0);
        coffee6.setCoffeeQ(0);
        coffee7.setCoffeeP(0);
        coffee7.setCoffeeQ(0);
        coffee8.setCoffeeP(0);
        coffee8.setCoffeeQ(0);
        tv_amount.setText("총 0개 선택");
        tv_price.setText("0원");
        adapter.clear();
    }  ///리스트의 데이터와 속성을 초기화하는 역활

    public void homeClicked(View view){
        setContentView(viewMain);
    } ///집 모양의 아이콘을 눌렀을때 처음 화면으로 돌아가는 역활




}