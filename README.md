## 자바 안드로이드 키오스크 프로젝트
# 2조
-- 프로젝트 이름 : 키오스크

-- 기간 : 12/23 ~ 1/07 

-- 팀원 : 🙍‍♂️나(백건우), 🙍‍♂️김지욱, 🙍‍♂️엄정현, 🙍‍♀️이새로미

-- ☕ 담당역활 : 앱의 맨 앞부분, 메뉴 선택화면(장바구니)

-- ⏱ 제작기간 : 3~4주


# • 앱의 맨 앞부분
![화면 캡처 2025-01-08 175715](https://github.com/user-attachments/assets/530d5d6d-59ae-48e1-9656-ec58e3fed7b6)      
• 매장,포장버튼 : ImageButton

• 레이아웃 : ConstraintLayout

• 버튼을 눌렀을때 메뉴 선택 화면으로 이동한다(activity_main_foodMenu_Korean)


# • 메뉴 선택 화면(⏱)
**매뉴 선택 화면에서 구현해야되는게 생각한것보다 너무 많아서 설명해야될 부분이 많다.**
  
  **그래서 "위, 중간, 아래"로 나누어서 하나씩 설명할 예정이다.**

**참고 🔽**


    View XMLView(int idLayout){
        return getLayoutInflater().inflate(idLayout,null,false);<br>
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
    
  **inflater를 이용해서 xml을 뷰로 바꾸는 작업**



# • 최종 메뉴 선택화면
![화면 캡처 2025-01-08 180715](https://github.com/user-attachments/assets/ebe010f8-b1db-46e0-8337-d49fe7dcb101) ![화면 캡처 2025-01-08 181043](https://github.com/user-attachments/assets/ff5cb2f5-47d7-4e92-807f-a4aa6a13d137)


# 1. 윗 부분

![화면 캡처 2025-01-08 194712](https://github.com/user-attachments/assets/40c4e4fa-75d9-4bda-895e-7a555abbace1)

• 상단의 버튼은 imageButton,Button를 사용하고, 

  LinearLayout(가,세)과/와 margin값을 조정하면서 버튼들을 배치했다. (▲ 하나하나 배치하다 보니 시간이 너무 오래 걸린 문제점이 있었다(거의 1시간 소요됨).)

  
• 상단의 버튼을 누르면 색깔이 바뀐다.   

ex)커피를 누르면 커피글씨 색깔이 검정색으로 변하고 나머지는 회색으로 변한다.)  --> 사용자가 버튼을 눌렸을때 버튼이 눌렸는지 쉽게 알 수 있다.

아래의 코드는 색깔을 바뀌게 해주는 함수이다.🔽

    void setCategoryColor(Button G1,Button G2,Button G3,Button G4,Button G5,Button B1){ 
             G1.setTextColor(Color.parseColor("#878282"));
             G2.setTextColor(Color.parseColor("#878282"));
             G3.setTextColor(Color.parseColor("#878282"));
             G4.setTextColor(Color.parseColor("#878282"));
             G5.setTextColor(Color.parseColor("#878282"));
             B1.setTextColor(Color.parseColor("#000000"));
         } ---  ///상단의 버튼(베스트,커피,..)을 눌렀을때 색깔을 바꿔주는 함수

          buttonBestMenu.setOnClickListener(new View.OnClickListener() {...}
           
          buttonCoffee.setOnClickListener(new View.OnClickListener() {...}
            
          buttonNonCoffee.setOnClickListener(new View.OnClickListener() {...}
            
          buttonSmoothie.setOnClickListener(new View.OnClickListener() {...}
            
          buttonJuice.setOnClickListener(new View.OnClickListener() {...}
            
          buttonDessert.setOnClickListener(new View.OnClickListener() {...}

      ▲ 상단에 있는 모든버튼에다가 setOnCLickListener를 붙이니까 코드량이 길어지고 중복된다.
            


# 2. 중간부분

![2](https://github.com/user-attachments/assets/f4258631-6a05-4232-b1d1-8415903e3157)

•상단의 버튼을 눌렀을때 해당되는 화면이 뜬다(ex)커피버튼 클릭-->커피만 표시되는 화면이 나옴)

 --먼저 커피,논커피,...에 대한 화면을 프래그먼트로 각각 만든 다음에
   커피버튼을 누르면 커피 프래그먼트만 뜨고 나머지는 보이지 않게 코드를 작성했다.

아래코드는 위에서 언급한 내용을 구현한 것이다.🔽

    void Remove_AND_AddView(View A1){
        ((FrameLayout) viewKoreaMenu.findViewById(R.id.Frame_Layout)).removeAllViews();
        ((FrameLayout) viewKoreaMenu.findViewById(R.id.Frame_Layout)).addView(A1);
    }  ///ex)베스트를 눌렀을때 f_best만 나오고 나머지 프레그먼트는 없애는 함수
    
    buttonBestMenu.setOnClickListener(new View.OnClickListener() {Remove_AND_AddView(화면에 보일 프래그먼트);}     
    
    buttonCoffee.setOnClickListener(new View.OnClickListener() {Remove_AND_AddView(화면에 보일 프래그먼트);}       
    
    buttonNonCoffee.setOnClickListener(new View.OnClickListener() {Remove_AND_AddView(화면에 보일 프래그먼트);}      
    
    buttonSmoothie.setOnClickListener(new View.OnClickListener() {Remove_AND_AddView(화면에 보일 프래그먼트);}     
    
    buttonJuice.setOnClickListener(new View.OnClickListener() {Remove_AND_AddView(화면에 보일 프래그먼트);}      
    
    buttonDessert.setOnClickListener(new View.OnClickListener() {Remove_AND_AddView(화면에 보일 프래그먼트);}

• 화면(프래그먼트)에 표시되는 커피(imageButton)을/를 눌렀을때 다이얼로그창이 뜨고
  사용자에게 hot과 cold둘 중 하나 선택할 수 있도록 라디오 버튼으로 두었다.(추가적인 옵션은 생략함)

  --다이얼로그화면은 하나씩 만듦 
    --> ▲하나씩 만들경우 나중에 커피개수가 많아지면 만들어야 될 다이얼로그화면이 많아져서 작업량이 많아질 수 있다는 문제점이 있다.
    --> 리사이클러 뷰를 활용해서 화면 틀만 만든 다음에 
        어뎁터에 데이터를 넘겨주면 작업량도 줄고 메뉴가 추가될때 리스트에다가 추가만 해주면 문제점을 해결할 수 있을거 같다.

아래코드는 위에서 언급한 내용을 구현한 코드이다.🔽

    void MakeDialog(int layout,CoffeeSelectedData coffeeH,CoffeeSelectedData coffeeC,int rb_id){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            LayoutInflater inflater = getLayoutInflater();
            View dialogView = inflater.inflate(layout, null); // xml명 변경
            builder.setView(dialogView)
                    .setTitle("")
                    .setPositiveButton("장바구니에 담기", (dialog, which) -> {
                        RadioButton rb = dialogView.findViewById(rb_id);

                          •••뒤에서 설명할 예정•••
                    })
                    .setNegativeButton("취소", (dialog, which) -> {
                        dialog.dismiss();
                        // Handle Cancel button click
                    });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        }
        만든이유 : 다이얼로그생성코드가 중복되어서
        인자 :  1.다이얼로그 레이아웃,
                2.HOT,COLD커피 (라디오 버튼에서 hot을 누르면 리스트에 coffee1(hot),cold를 누르면 리스트에 coffee2(cold)를 담기 위해)
                3.해당 다이얼로그의 라디오 버튼(사용자가 hot을 눌렀는지 cold를 눌렀는지 ischecked()로 확인하기 위해서)

        public void coffee1_selected(View view){
            MakeDialog(R.layout.coffee1_selected,coffee1,coffee2,R.id.rb_hot);
        }
        public void coffee2_selected(View view) {
            MakeDialog(R.layout.coffee2_selected,coffee3,coffee4,R.id.rb_hot2);
        }
        public void coffee3_selected(View view){
            MakeDialog(R.layout.coffee3_selected,coffee5,coffee6,R.id.rb_hot3);
        }
        public void coffee5_selected(View view){
            MakeDialog(R.layout.coffee5_selected,coffee7,coffee8,R.id.rb_hot5);
        }  ///해당 메뉴를 눌렀을때 MakeDialog함수를 실행함

# 3. 하단 부분(🎇)

![화면 캡처 2025-01-09 085936](https://github.com/user-attachments/assets/72edb573-fc64-48ac-89c5-62db9cbc6e37)

이번 프로젝트 설명글의 메인이자 제일 어려웠던 부분이었다. 

![1](https://github.com/user-attachments/assets/cbec86be-952b-42a6-9ee6-df4707a911ff)

• 제일먼저 사용자가 음식을 장바구니에 담을때마다 위와같은 틀이 **동적**으로 추가되기 때문에 
  틀을 재활용하는(?) 리사이클러뷰를 사용했다.

우선 사용자가 고른 커피를 담는 장바구니의 역활인 ArrayList를 먼저 만들었다.
그리고 그 장바구니에는 CoffeeDataSelected타임의 객체를 담는다.

아래는 위에서 설명한 내용의 코드이다.🔽

    public class MainActivity extends AppCompatActivity {

                                   •••
    List<CoffeeSelectedData> coffeeSelected = new ArrayList<>();  ///장바구니와 비슷함

    CoffeeSelectedData coffee1,coffee2,coffee3,coffee4,coffee5,coffee6,coffee7,coffee8;
                                   •••
    

    coffee1 = new CoffeeSelectedData("콜드 브루 플로트(HOT)",0,0);
    coffee2 = new CoffeeSelectedData("콜드 브루 플로트(COLD)",0,0);

    coffee3 = new CoffeeSelectedData("라벤더 카페 브레베(HOT)",0,0);
    coffee4 = new CoffeeSelectedData("라벤더 카페 브레베(COLD)",0,0);

    coffee5 = new CoffeeSelectedData("클래식 아포가토(HOT)",0,0);
    coffee6 = new CoffeeSelectedData("클래식 아포가토(COLD)",0,0);

    coffee7 = new CoffeeSelectedData("프랜티 애플 타르트 나이트로(HOT)",0,0);
    coffee8 = new CoffeeSelectedData("프랜티 애플 타르트 나이트로(COLD)",0,0);

    ///객체의 속성 : 1.coffeeN : 해당 커피의 이름(h/c)
    ///             2.coffeeQ : 사용자가 해당 메뉴를 선택한 갯수
    ///             3.coffeeP : 그만큼의 가격
    }

//----------------------------------------------------------------------------------------

    public class CoffeeSelectedData implements Parcelable {
    //Parcelable :  *뒤에서 설명예정*
    String coffeeN;
    int coffeeQ,coffeeP;

    public CoffeeSelectedData(String coffeeN, int coffeeQ, int coffeeP) {
        this.coffeeN = coffeeN;
        this.coffeeQ = coffeeQ;
        this.coffeeP = coffeeP;
    }

    public String getCoffeeN() {
        return coffeeN;
    }

    public int getCoffeeQ() {
        return coffeeQ;
    }

    public int getCoffeeP() {
        return coffeeP;
    }   ///GETTER

    public void setCoffeeQ(int coffeeQ) {
        this.coffeeQ = coffeeQ;
    }

    public void setCoffeeP(int coffeeP) {
        this.coffeeP = coffeeP;
    }
  }


    





  













