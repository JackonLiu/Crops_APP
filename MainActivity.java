package com.example.crops;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.*;
import org.tensorflow.demo.CameraActivity;

public class MainActivity extends AppCompatActivity {
    private ImageButton button1;
    private ImageButton button2;
    private ImageButton button3;
    private  ImageView view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);



        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.sjdi);

        view= (ImageView) findViewById(R.id.imageView8);
        button1 = (ImageButton) findViewById(R.id.imageButton);
        button2= (ImageButton) findViewById(R.id.first);
        button3= (ImageButton) findViewById(R.id.second);
        Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.gijh);
        view.setAnimation(animation );
        button2.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    v.getBackground().setAlpha(100);
                    //更改为按下时的背景图片

                }else if(event.getAction() == MotionEvent.ACTION_UP){

                    //改为抬起时的图片
                    v.getBackground().setAlpha(255);

                }
                return false;
            }
        });
        button3.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    v.getBackground().setAlpha(100);
                    //更改为按下时的背景图片

                }else if(event.getAction() == MotionEvent.ACTION_UP){

                    //改为抬起时的图片
                    v.getBackground().setAlpha(255);

                }
                return false;
            }
        });
        button1.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    v.getBackground().setAlpha(100);
                    //更改为按下时的背景图片

                }else if(event.getAction() == MotionEvent.ACTION_UP){

                    //改为抬起时的图片
                    v.getBackground().setAlpha(255);

                }
                return false;
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               Intent intent = new Intent(MainActivity.this, CameraActivity.class);

                startActivity(intent);

            }
        });
button2.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this, zhongjian.class);
        startActivity(intent);
    }
});

button3.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this, xinxi .class);
        startActivity(intent);
    }
});



    }


}


