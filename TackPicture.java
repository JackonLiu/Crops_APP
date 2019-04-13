package com.example.crops;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.PropertyResourceBundle;

public class TackPicture extends Activity{
    private ImageView imageView;
    private ImageButton imageButton2;
    private ImageButton imageButton3;
    public static String APP_ID="10112138";
    public static String SECRET_ID="AKIDShgQu7Sj8JEtHPmsDH5csra2FBqFJFqB";
    public static String SECRET_KEY="C8rKYYnoa8QTGo7B0av0pOkrjMjGbhZC";
    public static String USER_ID="876899938";
    private Handler handler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            TextView tv = (TextView) findViewById(R.id.textView7);
            tv.setText(msg.obj.toString());
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.picture);
        Intent intent=getIntent();
        imageView= (ImageView) findViewById(R.id.iv_img);
        imageButton2= (ImageButton) findViewById(R.id.imageButton2);
        imageButton3= (ImageButton) findViewById(R.id.imageButton3);
        if (intent!=null&&intent.getParcelableExtra("BITMAP")!=null){
            Bitmap bitmap = myBitmapStore.getBitmap();
            imageView.setImageBitmap(bitmap);
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
                TackPicture.this.startActivity(intent);
            }
        });
        imageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position=0;
                Intent intent=new Intent(TackPicture.this,donghua.class);


                Bundle bundle=new Bundle();
                bundle.putInt("position",position);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

}
