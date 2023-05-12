package com.furkancolak.kronometre;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Runnable runnable;
    Handler handler;
    int number;
    Button start;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        number = 0 ;
    }
    public void start(View view){
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                textView.setText("Counter : "+number);
                number++;
                handler.postDelayed(runnable,1000);
            }
        };
        handler.post(runnable);
        start.setEnabled(false);
    }
    public void stop(View view){
        start.setEnabled(true);
        handler.removeCallbacks(runnable);
        number= 0;
        textView.setText("Counter : "+number);
    }
}