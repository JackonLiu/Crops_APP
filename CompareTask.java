package com.example.crops;

import android.graphics.Bitmap;
import android.os.Message;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

public class CompareTask {
    public static String APP_ID="10112138";
    public static String SECRET_ID="AKIDShgQu7Sj8JEtHPmsDH5csra2FBqFJFqB";
    public static String SECRET_KEY="C8rKYYnoa8QTGo7B0av0pOkrjMjGbhZC";
    public static String USER_ID="876899938";
    public String execute(Bitmap bitmapA){

    Youtu faceYoutu = new Youtu(APP_ID, SECRET_ID, SECRET_KEY, Youtu.API_YOUTU_END_POINT);
    JSONObject respose = null;
        Message msg;
                try {
        respose = faceYoutu.DetectFace(bitmapA,0);
        msg = new Message();
        msg.obj = respose;
        //handler.sendMessage(msg);
    } catch (KeyManagementException e) {
        e.printStackTrace();
    } catch (NoSuchAlgorithmException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    } catch (JSONException e) {
        e.printStackTrace();
    }

return  respose.toString();
        }

        }


