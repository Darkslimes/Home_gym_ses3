package com.example.home_gym;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class hello2 extends AppCompatActivity {
    SharedPreferences pref;
    SharedPreferences.Editor edit;
    ImageButton femaleButton;
    ImageButton maleButton;
    Button next;
    Boolean pushed = false;
    private final String gender = "gender";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello2);
        Init();

        maleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChangeColor(1);
                edit.putString(gender, "male");
            }
        });
        femaleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChangeColor(2);
                edit.putString(gender, "female");
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(pushed==false){
                    edit.apply();
                    next.setBackgroundResource(R.drawable.golden_element);
                    Intent intent = new Intent(getApplicationContext(), hello2_female.class);
                    startActivity(intent);
                    finish();
                } else if (pushed==true){
                    edit.apply();
                    next.setBackgroundResource(R.drawable.golden_element);
                    Intent intent = new Intent(getApplicationContext(), hello2_male.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    private void ChangeColor (int gender_id) {
        if(gender_id == 1){
            maleButton.setBackgroundResource(R.drawable.golden_element);
            femaleButton.setBackgroundResource(R.drawable.custom_element);
            pushed = true;
        } else {
            femaleButton.setBackgroundResource(R.drawable.golden_element);
            maleButton.setBackgroundResource(R.drawable.custom_element);
            pushed = false;
        }
    }
    private void Init(){
        pref = getSharedPreferences("Values", MODE_PRIVATE);
        edit =pref.edit();
        maleButton = findViewById(R.id.imageButton2);
        femaleButton = findViewById(R.id.imageButton);
        next = findViewById(R.id.nextbutton1);
    }

}