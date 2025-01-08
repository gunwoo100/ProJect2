package com.example.project2.Class;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import androidx.annotation.NonNull;

public class CoffeeSelectedData implements Parcelable {
    //Parcelable :  물건을 상자에 담아 다른 곳으로 보내는 것과 비슷해요.
    String coffeeN;
    int coffeeQ,coffeeP;

    public CoffeeSelectedData(String coffeeN, int coffeeQ, int coffeeP) {
        this.coffeeN = coffeeN;
        this.coffeeQ = coffeeQ;
        this.coffeeP = coffeeP;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(coffeeN);  //coffeeN, coffeeQ, coffeeP 값을 Parcel 상자에 넣어서 다른 화면으로 보낼 수 있다.
        dest.writeInt(coffeeQ);
        dest.writeInt(coffeeP);
    }   ///SETTER


    public static final Creator<CoffeeSelectedData> CREATOR = new Creator<CoffeeSelectedData>() {
                @Override
                public CoffeeSelectedData createFromParcel(Parcel in) {
                    return new CoffeeSelectedData(in);
                }

                @Override
                public CoffeeSelectedData[] newArray(int size) {
                    return new CoffeeSelectedData[size];
                }
            };


    protected CoffeeSelectedData(Parcel in) {
        Log.v("TESTTAG12","");
        coffeeN = in.readString();  ///상자에서 값을 꺼내기
        coffeeQ = in.readInt();
        coffeeP = in.readInt();
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

    @Override
    public int describeContents() {
        return 0;
    }


}
