package com.example.crops;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

public class ResultActivity extends Activity {

    private ImageButton imageButton2;
    private ImageButton imageButton3;
    public static String APP_ID="10112138";
    public static String SECRET_ID="AKIDShgQu7Sj8JEtHPmsDH5csra2FBqFJFqB";
    public static String SECRET_KEY="C8rKYYnoa8QTGo7B0av0pOkrjMjGbhZC";
    public static String USER_ID="876899938";
    private Handler handler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            TextView tv = (TextView) findViewById(R.id.textView4);
            tv.setText(msg.obj.toString());
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultactivity);
        imageButton2= (ImageButton) findViewById(R.id.imageButton2);
        imageButton3= (ImageButton) findViewById(R.id.imageButton3);
        String path=getIntent().getStringExtra("PicturePath");
        ImageView imageview=(ImageView) findViewById(R.id.picture);
        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position=0;
                Intent intent=new Intent();
                intent.setAction("huang");
                intent.addCategory("android.intent.category.DEFAULT");
                Bundle bundle=new Bundle();
                bundle.putInt("position",position);
                intent.putExtras(bundle);
                ResultActivity.this.startActivity(intent);
            }
        });
        imageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position=0;
                Intent intent=new Intent(ResultActivity.this,donghua.class);


                Bundle bundle=new Bundle();
                bundle.putInt("position",position);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        //由于这样稚嫩获得横屏，所以我们要使用流的形式来转换
//      Bitmap bitmap=BitmapFactory.decodeFile(path);
//      imageview.setImageBitmap(bitmap);
        final FileInputStream fis;
        try {
            fis = new FileInputStream("/storage/emulated/0/Pictures/abc.png");
            Bitmap bitmap=BitmapFactory.decodeStream(fis);
            /*Matrix matrix=new Matrix();
            matrix.setRotate(90);
            bitmap=Bitmap.createBitmap(bitmap, 0,0, bitmap.getWidth()
                    ,bitmap.getHeight(),matrix,true);*/
            imageview.setImageBitmap(bitmap);
            new Thread(){
                public void run(){
                    Bitmap bitmap=BitmapFactory.decodeStream(fis);
                    Youtu faceYoutu = new Youtu(APP_ID, SECRET_ID, SECRET_KEY, Youtu.API_YOUTU_END_POINT);
                    JSONObject respose;
                    try {
                        respose = faceYoutu.DetectFace(bitmap,0);
                        Message msg = new Message();
                        msg.obj = respose;
                        handler.sendMessage(msg);
                    } catch (KeyManagementException e) {
                        e.printStackTrace();
                    } catch (NoSuchAlgorithmException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
            /*Youtu faceYoutu = new Youtu(APP_ID, SECRET_ID, SECRET_KEY, Youtu.API_YOUTU_END_POINT);
            JSONObject respose;
            try {
                respose = faceYoutu.DetectFace(bitmap,0);
                Message msg = new Message();
                msg.obj = respose;
                handler.sendMessage(msg);
            } catch (KeyManagementException e) {
                e.printStackTrace();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }*/
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }
}