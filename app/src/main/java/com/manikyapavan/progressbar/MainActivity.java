package com.manikyapavan.progressbar;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    ProgressBar p4;
    Handler handler;
    Runnable runnable;
    int i;
    Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        p4=(ProgressBar)findViewById(R.id.p1);
        p4.setVisibility(View.VISIBLE);
        p4.setProgress(0);
        p4.setMax(100);
        handler=new Handler();
        runnable=new Runnable() {
            @Override
            public void run() {
                if(++i<=100){
                    p4.setProgress(i);


                }else{
                    timer.cancel();

                }

               // timer.cancel();
             //   p4.setVisibility(View.VISIBLE);

            }
        };
        timer=new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(runnable);

            }
        },8000,1000);
    }
}
