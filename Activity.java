package com.example.crops;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Map;

public class Activity extends android.app.Activity {
    int[]xiingxi={R.mipmap.dgjs,R.mipmap.ymwz};

    private int[]icon={R.mipmap.timg,R.mipmap.yimg1};
    private String[]iconName={"蚕豆","马铃薯"};
    private TextView textView;
    private ImageView imageView;

    private ImageView imageView15;
    private TextView textView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        Bundle bundle=this.getIntent().getExtras();
        int value=bundle.getInt("position");



        setContentView(R.layout.ol);
        imageView= (ImageView) findViewById(R.id.imageView);
        imageView15= (ImageView) findViewById(R.id.imageView15);
        //textView1= (TextView) findViewById(R.id.textView);
        imageView15.setImageResource(xiingxi[value]);
        imageView.setImageResource(icon[value]);
        //textView1.setText(iconName[value]);

    }
}
