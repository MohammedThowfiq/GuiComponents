package com.example.guicomponents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    EditText name,age,clgname;
    RadioGroup rg;
    RadioButton r_male,r_female;
    Spinner s;
    Button submit;
    String Name,Age,Gender,ClgName,Department;
    String dept[] = {"IT","CSE","EEE","ECE","MECH"};
    ArrayAdapter<String>ad;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText)findViewById(R.id.et_name);
        age = (EditText)findViewById(R.id.et_age);
        clgname = (EditText)findViewById(R.id.et_clgname);
        rg = (RadioGroup)findViewById(R.id.radioGroup);
        r_male = (RadioButton)findViewById(R.id.radio_male);
        r_female = (RadioButton)findViewById(R.id.radio_female);
        s = (Spinner)findViewById(R.id.spinner);
        submit = (Button)findViewById(R.id.btn_submit);


        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if(r_male.isChecked() == true){

                    Gender = r_male.getText().toString();

                }
                else{

                    Gender = r_female.getText().toString();

                }


            }
        });


        ad = new ArrayAdapter<String>(getBaseContext(),android.R.layout.simple_spinner_item,dept);

        s.setAdapter(ad);

        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                Department = dept[position];

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Name = name.getText().toString();
                Age = age.getText().toString();
                ClgName = clgname.getText().toString();


                Intent intent = new Intent(getApplicationContext(),SecondActivity.class);

                intent.putExtra("name",Name);
                intent.putExtra("age",Age);
                intent.putExtra("gender",Gender);
                intent.putExtra("clgname",ClgName);
                intent.putExtra("department",Department);

                startActivity(intent);


            }
        });





    }
}
