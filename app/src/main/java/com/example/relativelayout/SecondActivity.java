package com.example.relativelayout;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {
    ListView LV;

    @Override  ////////   onCreate method or function is used to start an Activity;  ////////
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // super keyword is used to call the parent constructor;
        setContentView(R.layout.activity_second);
        ArrayList<String> displayList = getIntent().getStringArrayListExtra("list");
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("SecondActivity");
        LV = findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, displayList);
        LV.setAdapter(adapter);
    }
}