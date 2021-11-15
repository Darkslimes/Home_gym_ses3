package com.example.home_gym;

import android.content.Intent;
import android.graphics.ImageDecoder;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.Button;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import java.text.SimpleDateFormat;

public class stopwatch extends AppCompatActivity {
    TextView clock;
    Button start;

    int mCurrectPeriod = 0;
    private Timer myTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stopwatch);
        clock = (TextView) findViewById(R.id.digital_clock);
        start = (Button) findViewById(R.id.start);
    }

    public void Start (View view)
    {
        myTimer = new Timer();
        myTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                TimerMethod();
            }
        },0,1000);

    }
    private void TimerMethod(){
        this.runOnUiThread(Timer_Tick);
    }
    private Runnable Timer_Tick = new Runnable() {
        @Override
        public void run() {
            mCurrectPeriod++;
            String temp = (new SimpleDateFormat("mm:ss")).format(new
                    Date(mCurrectPeriod*1000));
            clock.setText(temp);
            start.setClickable(false);
        }
    };

    public void Stop (View view)
    {

        if(myTimer != null) myTimer.cancel();
        start.setClickable(true);

    }
    public void Reset (View view)
    {
        mCurrectPeriod = 0;
        clock.setText("00:00");
    }
    public void Next (View view)
    {
        Intent i = new Intent(stopwatch.this, ManyBody.class);
        startActivity(i);
        finish();
    }

}