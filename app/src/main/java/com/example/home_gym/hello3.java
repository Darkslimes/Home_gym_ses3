package com.example.home_gym;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class hello3 extends AppCompatActivity {
    SharedPreferences pref;
    SharedPreferences.Editor edit;
    Button next;
    Boolean pushed = false;
    Intent intent;
    LinearLayout button1, button2, button3;
    final String key = "level";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello3);
        Init();
        LinearLayout[] buttons = {button1, button2, button3};

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChangeColor(button1, buttons, "Newbie");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChangeColor(button2, buttons, "Keep On");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChangeColor(button3, buttons, "Advanced");
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pushed == true) {
                    next.setBackgroundResource(R.drawable.golden_element);
                    edit.apply();
                    startActivity(intent);
                }
            }
        });
    }

    private void ChangeColor(LinearLayout pushedLayout, LinearLayout[] layouts, String value) {
        for (LinearLayout layout : layouts) {
            if (layout.equals(pushedLayout)) {
                layout.setBackgroundResource(R.drawable.golden_element);
                edit.putString(key, value);
            } else
                layout.setBackgroundResource(R.drawable.custom_element);
        }   pushed = true;
    }
    private void Init(){
        button1 = findViewById(R.id.layout1);
        button2 = findViewById(R.id.layout2);
        button3 = findViewById(R.id.layout3);
        next = findViewById(R.id.button18);
        pref =getSharedPreferences("Values", MODE_PRIVATE);
        edit = pref.edit();
        intent = new Intent(hello3.this, hello4.class);
    }
}