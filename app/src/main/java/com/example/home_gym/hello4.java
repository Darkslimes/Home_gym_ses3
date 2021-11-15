package com.example.home_gym;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class hello4 extends AppCompatActivity {

    Button save;
    Intent intent;
    EditText Height, Weight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello4);
        Init();
        AlertDialog.Builder alert = new AlertDialog.Builder(this);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Hei = Height.getText().toString();
                String Wei = Weight.getText().toString();

                if(TextUtils.isEmpty(Hei) || TextUtils.isEmpty(Wei))
                    alert.setMessage("Заполните все поля").show();
                else{
                    startActivity(intent);
                }
            }
        });

    }
    private void Init(){
        save = findViewById(R.id.button16);
        Height = findViewById(R.id.editTextTextPersonName);
        Weight = findViewById(R.id.editTextTextPersonName2);
        intent = new Intent(getApplicationContext(), ManyBody.class);
    }
}