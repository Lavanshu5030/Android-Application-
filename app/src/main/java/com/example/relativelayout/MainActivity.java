package com.example.relativelayout;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;


import java.util.ArrayList;

public class MainActivity<createToast> extends AppCompatActivity {
    EditText mNameEt;
    EditText mEmailEt;
    EditText mPasswordEt;
    RadioGroup genders;
    Spinner spinner;
    Button button;
    CheckBox checkBox;



    @Override
    protected void onCreate(Bundle savedInstanceState) {      // onCreate() is used to start an activity;
        super.onCreate(savedInstanceState);                   // super keyword is used to call the parent class constructor;
        setContentView(R.layout.activity_main);              // setContentView is used to set the xml



        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("FirstActivity");
        ArrayList<Person> people = new ArrayList<Person>();   // Declared an arraylist
        ArrayList<String> peopleString = new ArrayList<String>();

        mNameEt = findViewById(R.id.Et1_enterName);           //Taking access using the function "findViewById()"
        mEmailEt = findViewById(R.id.Et2_enterEmail);
        mPasswordEt = findViewById(R.id.Et3_enterPassword);
        genders = findViewById(R.id.radioGroup);
        spinner = findViewById(R.id.spMonth);
        checkBox = findViewById(R.id.checkBox);
        button = findViewById(R.id.btn_AddData);
        Button btn_Submit = findViewById(R.id.btn_Submit);

        btn_Submit.setOnClickListener(new View.OnClickListener() {
                                                                                // listener
            @Override
            public void onClick(View v) {                                // click event handler
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);

                intent.putStringArrayListExtra("list", peopleString);       // this method is used to send the data of arraylist

                startActivity(intent);
            }
        });
        Button btn_Login = findViewById(R.id.btn_AddData);
        btn_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = mNameEt.getText().toString();
                String email = mEmailEt.getText().toString();
                String password = mPasswordEt.getText().toString();
                int selectedId = genders.getCheckedRadioButtonId();
                RadioButton r = findViewById(selectedId);
                String gender =  r.getText().toString();
                Boolean check = checkBox.isChecked();
                String month = spinner.getSelectedItem().toString();
                Person person = new Person(name,email,password,gender,check,month);
                people.add(person);
                peopleString.add(person.show());
            }


        });

    }
    public void Toast(View view) {
        Toast.makeText(getApplicationContext(), "Button is clicked", Toast.LENGTH_SHORT).show();
    }
    public void implicitIntent(View view) {                                                               //   DOUBT
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("Mail to:"));
        intent.putExtra(intent.EXTRA_EMAIL, "lavanshu5030@gmail.com");
        intent.putExtra(intent.EXTRA_SUBJECT, "MSI IS BEST");
        intent.putExtra(intent.EXTRA_TEXT, "EVERYTHING WILL BE ALRIGHT");
        if(intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }
    }



}

