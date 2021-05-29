package com.example.xeviet.ui.person;

import androidx.appcompat.app.AppCompatActivity;

import com.example.xeviet.R;

public class Info{
    String InfoName;
    Double InfoPhoneNumber;
    String InfoAdrdress;

    public Info(){}

    public Info( String infoName,Double infoPhoneNumber ,String infoAdrdress) {

        InfoName = infoName;
        InfoAdrdress = infoAdrdress;
        InfoPhoneNumber = infoPhoneNumber;
    }


    public String getInfoName() {
        return InfoName;
    }

    public void setInfoName(String infoName) {
        InfoName = infoName;
    }

    public String getInfoAdrdress() {
        return InfoAdrdress;
    }

    public void setInfoAdrdress(String infoAdrdress) {
        InfoAdrdress = infoAdrdress;
    }

    public Double getInfoPhoneNumber() {
        return InfoPhoneNumber;
    }

    public void setInfoPhoneNumber(Double infoPhoneNumber) {
        InfoPhoneNumber = infoPhoneNumber;
    }
}
