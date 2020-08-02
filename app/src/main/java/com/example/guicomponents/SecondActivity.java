package com.example.guicomponents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView t1,t2,t3,t4,t5;
    String name,age,gender,clgname,department;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        t1 = (TextView)findViewById(R.id.t_name);
        t2 = (TextView)findViewById(R.id.t_age);
        t3 = (TextView)findViewById(R.id.t_gender);
        t4 = (TextView)findViewById(R.id.t_clgname);
        t5 = (TextView)findViewById(R.id.t_department);


        Intent intent = getIntent();

        name = intent.getStringExtra("name");
        age = intent.getStringExtra("age");
        gender = intent.getStringExtra("gender");
        clgname = intent.getStringExtra("clgname");
        department = intent.getStringExtra("department");

        t1.setText(name);
        t2.setText(age);
        t3.setText(gender);
        t4.setText(clgname);
        t5.setText(department);


    }
}
