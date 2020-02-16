package com.example.multithreadingdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {
    Handler handler = new Handler();
    Button button;
    TextView textView;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String glide;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView =findViewById(R.id.timer);
        button =findViewById(R.id.b1);
        handler.postDelayed(run, 1000);
        imageView = findViewById(R.id.image);
        Glide.with(this).load(R.drawable.android).into(imageView);
    }

    Runnable run = new Runnable() {
        @Override
        public void run() {
            updateTime();
            if ((Integer.parseInt(textView.getText().toString())== 0)){
               imageView.setVisibility(View.VISIBLE);
            }

        }
    };

    public void updateTime(){
        textView.setText(""+(Integer.parseInt(textView.getText().toString())-1));

        if ((Integer.parseInt(textView.getText().toString())== 0)){
            button.setVisibility(View.INVISIBLE);

        }else if((Integer.parseInt(textView.getText().toString())== 0)){
            //imageView.setVisibility(View.INVISIBLE);
        }else {
            handler.postDelayed(run,1000);
        }


    }


}
