package com.example.home_gym;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class hello2_male extends AppCompatActivity {

    SharedPreferences pref;
    SharedPreferences.Editor edit;
    Button button1,button2,button3,button4;
    private final String save_key ="Purpose";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello2_male);
        Init();

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ColorChange(button1, button2, button3, button4);
                edit.putString(save_key,"Hands");
                edit.apply();
                GoNext();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ColorChange(button2, button1, button3, button4);
                edit.putString(save_key,"Spine");
                edit.apply();
                GoNext();
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ColorChange(button3, button1, button2, button4);
                edit.putString(save_key,"Torso");
                edit.apply();
                GoNext();
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ColorChange(button4, button1, button2, button3);
                edit.putString(save_key,"Legs");
                edit.apply();
                GoNext();
            }
        });
    }

    private void ColorChange(Button button_g, Button button_w_1, Button button_w_2, Button button_w_3) {
        button_g.setBackgroundResource(R.drawable.golden_element);
        button_w_1.setBackgroundResource(R.drawable.custom_element);
        button_w_2.setBackgroundResource(R.drawable.custom_element);
        button_w_3.setBackgroundResource(R.drawable.custom_element);
    }

    private void GoNext() {
        Intent intent = new Intent(getApplicationContext(), hello3.class);
        startActivity(intent);
    }


    private void Init(){
        button1 = findViewById(R.id.button15);
        button2 = findViewById(R.id.button14);
        button3 = findViewById(R.id.button10);
        button4 = findViewById(R.id.button9);
        pref =getSharedPreferences("Values", MODE_PRIVATE);
        edit = pref.edit();
    }
}