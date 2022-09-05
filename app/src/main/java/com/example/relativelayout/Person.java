package com.example.relativelayout;

import android.os.Parcelable;

public class Person{
    String name;
    String email;
    String password;
    String gender;
    boolean remember_me;
    String month;

    public Person(String name, String email, String password, String gender, boolean remember_me, String month){
        this.name = name;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.remember_me = remember_me;
        this.month = month;
    }
    String show(){
        String rm = this.remember_me ? "true" : "false";
        return "name: " + this.name + "\nemail: " + this.email + "\npassword: " + this.password + "\ngender: " + this.gender + "\nremember me: " + rm + "\nmonth: " + this.month;
    }
}
