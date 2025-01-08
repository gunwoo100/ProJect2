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
⁕ 매뉴 선택 화면에서 구현해야되는게 생각한것보다 너무 많아서 설명해야될 부분이 많다.
  
  그래서 "위, 중간, 아래"로 나누어서 하나씩 설명할 예정이다.



# • 최종 메뉴 선택화면
![화면 캡처 2025-01-08 180715](https://github.com/user-attachments/assets/ebe010f8-b1db-46e0-8337-d49fe7dcb101)

# 1. 윗 부분

![화면 캡처 2025-01-08 194712](https://github.com/user-attachments/assets/40c4e4fa-75d9-4bda-895e-7a555abbace1)

• 상단의 버튼은 imageButton,Button를 사용하고, 

  LinearLayout(가,세)과/와 margin값을 조정하면서 버튼들을 배치했다.

▲ 하나하나 배치하다 보니 시간이 너무 오래 걸린 문제점이 있었다(거의 1시간 소요됨). 


• 상단의 버튼을 누르면 색깔이 바뀐다.

ex)커피를 누르면 커피글씨 색깔이 검정색으로 변하고 나머지는 회색으로 변한다.)

아래의 코드는 색깔을 바뀌게 해주는 함수이다.

--- void setCategoryColor(Button G1,Button G2,Button G3,Button G4,Button G5,Button B1){ ---
         G1.setTextColor(Color.parseColor("#878282"));
         G2.setTextColor(Color.parseColor("#878282"));
         G3.setTextColor(Color.parseColor("#878282"));
         G4.setTextColor(Color.parseColor("#878282"));
         G5.setTextColor(Color.parseColor("#878282"));
         B1.setTextColor(Color.parseColor("#000000"));
     }  ///상단의 버튼(베스트,커피,..)을 눌렀을때 색깔을 바꿔주는 함수













