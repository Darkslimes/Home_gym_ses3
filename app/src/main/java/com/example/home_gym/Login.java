package com.example.home_gym;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity {
    EditText username, password;
    Button signin, signup, back;
    DBhelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.username1);
        password = findViewById(R.id.password1);
        signin = findViewById(R.id.SignIn1);
        signup = findViewById(R.id.SignUp);
        DB = new DBhelper(this);
        AlertDialog.Builder alert = new AlertDialog.Builder(this);

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user = username.getText().toString();
                String pass = password.getText().toString();

                if(TextUtils.isEmpty(user) || TextUtils.isEmpty(pass))
                    alert.setMessage("Заполните все поля").show();
                else{
                    Boolean checkuserpass = DB.checkusernamepassword(user,pass);
                    if(checkuserpass==true){
                        alert.setMessage("Авторизация прошла успешно").show();
                        Intent i = new Intent(getApplicationContext(), Hello1.class);
                        startActivity(i);
                        finish();
                    }else{
                        alert.setMessage("Ошибка авторизации").show();
                    }
                }
            }
        });
    }

    public void SignUp(View view)
    {
        Intent i = new Intent(Login.this, Registration.class);
        startActivity(i);
        finish();
    }

    public void Perehod (View view)
    {
        Intent i = new Intent(Login.this, ManyBody.class);
        startActivity(i);
        finish();
    }
}