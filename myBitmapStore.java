package com.example.crops;

import android.graphics.Bitmap;

public class myBitmapStore {
    static private Bitmap bmpp=null;//一定要是static的才行..
    static void setBitmap(Bitmap bmp){
        bmpp = bmp;
    }
    static Bitmap getBitmap(){
        return bmpp;
    }
}