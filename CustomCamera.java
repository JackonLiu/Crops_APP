package com.example.crops;

import java.io.*;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.*;
import android.hardware.Camera;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Base64;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import com.example.crops.R;

@SuppressWarnings("unused")
public class CustomCamera extends Activity implements SurfaceHolder.Callback, OnClickListener,Camera.PictureCallback {

    private Camera myCamera;
    Bitmap bitmap;



    private SurfaceView preview;
    private Button button;
    private SurfaceHolder myHolder;
    private static final int PHOTO_REQUEST_GALLERY = 2;// 从相册中选择
    private static final int PHOTO_REQUEST_CUT = 3;//myHolder勇于展现surfaceView的图像
    private File tempFile;

    private Camera.PictureCallback myPictureCallBack=new Camera.PictureCallback() {

        @Override
        public void onPictureTaken(byte[] data, Camera arg1) {
            //将拍照得到的数据信息存储到本地
            String myFilePath=Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getPath();
            Log.i("dsadsad",myFilePath);
            File tempFile=new File("/storage/emulated/0/Pictures/abc.png");
            try {
                FileOutputStream fos=new FileOutputStream(tempFile);
                fos.write(data);
                fos.close();
                //然后将这个照片的数据信息传送给要进行展示的Activity即可
                Intent intent=new Intent(CustomCamera.this,ResultActivity.class);
                intent.putExtra("PicturePath", tempFile.getAbsolutePath());
                startActivity(intent);
                //拍照结束之后销毁当前的Activity，进入到图片展示界面
                CustomCamera.this.finish();
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }


        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customcarema);
        preview=(SurfaceView) findViewById(R.id.preview);
        preview.setFocusable(true);
        preview.setFocusableInTouchMode(true);
        preview.setClickable(true);
        preview.setOnClickListener(this);
        myHolder=preview.getHolder();
        myHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
        myHolder.addCallback(this);
button= (Button) findViewById(R.id.button);
        //从SharedPreferences获取图片
        getBitmapFromSharedPreferences();
button.setOnClickListener(new OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent1 = new Intent(Intent.ACTION_PICK);
        intent1.setType("image/*");
        // 开启一个带有返回值的Activity，请求码为PHOTO_REQUEST_GALLERY
        startActivityForResult(intent1, PHOTO_REQUEST_GALLERY);
    }
});
        //实现点击屏幕自动聚焦的功能，此处并不需要拍照，故只是聚焦
        preview.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                myCamera.autoFocus(null);
            }
        });
    }


    @Override
    protected void onResume() {
        super.onResume();
        if(myCamera==null){
            myCamera=getCamera();
            if(myHolder != null ){
                setStartPreview(myCamera, myHolder);
            }
        }
    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        releaseCamera();
    }

    /**
     * 释放相机的资源
     */
    private void releaseCamera(){
        if(myCamera !=null ){
            myCamera.setPreviewCallback(null);
            myCamera.stopPreview();
            myCamera.release();
            myCamera=null;
        }
    }


    /**
     * 拍照的一些参数设置,点击此按钮之后会触发拍照的会掉，进而实现拍照的效果
     * @param view
     */
    public void onCapture(View view){
        Camera.Parameters parameters=myCamera.getParameters();
        //设置照片的类型
        parameters.setPictureFormat(ImageFormat.JPEG);
        parameters.setPictureSize(800, 600);
        //设置为自动聚焦
        parameters.setFocusMode(Camera.Parameters.FOCUS_MODE_AUTO);
        //设置为自动聚焦是不够的，因为我们先得到的是最为清晰的图片，所以要在聚焦成功的时候才进行拍照
        myCamera.autoFocus(new Camera.AutoFocusCallback() {

            @Override
            public void onAutoFocus(boolean success, Camera camera) {
                // TODO Auto-generated method stub
                if(success){
                    myCamera.takePicture(null, null, myPictureCallBack);
                }
            }
        });
    }

    /**
     * 获取系统的一个Camera对象
     */
    private Camera getCamera(){
        Camera camera=null;
        try{
            camera=Camera.open();
        }catch(Exception e){
            e.printStackTrace();
        }

        return camera;
    }

    /**
     * 开始预览相机的内容，其实就是讲surfaceHolder与之绑定
     */
    private void setStartPreview(Camera camera,SurfaceHolder holder){
        //直接调用系统方式绑定预览
        try {
            camera.setPreviewDisplay(holder);
            //由于系统默认使用横屏预览，，所以要进行设置
            camera.setDisplayOrientation(90);
            camera.startPreview();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }




    @Override
    public void surfaceChanged(SurfaceHolder holder, int arg1, int arg2, int arg3) {
        // TODO Auto-generated method stub
        myCamera.startPreview();
    }


    @Override
    public void surfaceCreated(SurfaceHolder holder) {
       /* // TODO Auto-generated method stub
        myCamera = Camera.open(1);
        Camera.Parameters parameters = myCamera.getParameters();
        try {
            // 将摄像头的预览显示设置为mSurfaceHolder
            myCamera.setPreviewDisplay(myHolder);
            myCamera.setDisplayOrientation(90);
        } catch (IOException e) {
            myCamera.release();
        }
        // 设置输出格式
        parameters.setPictureFormat(PixelFormat.JPEG);
        // 设置摄像头的参数.否则前面的设置无效
        myCamera.setParameters(parameters);*/
        setStartPreview(myCamera, myHolder);
    }


    @Override
    public void surfaceDestroyed(SurfaceHolder arg0) {
        // TODO Auto-generated method stub
        //myCamera.stopPreview();
        //myCamera.release();
    }
    private void crop(Uri uri) {
        // 裁剪图片意图
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        intent.putExtra("crop", "true");
        // 裁剪框的比例，1：1
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        // 裁剪后输出图片的尺寸大小
        intent.putExtra("outputX", 250);
        intent.putExtra("outputY", 250);

        intent.putExtra("outputFormat", "JPEG");// 图片格式
        intent.putExtra("noFaceDetection", true);// 取消人脸识别
        intent.putExtra("return-data", true);
        // 开启一个带有返回值的Activity，请求码为PHOTO_REQUEST_CUT
        startActivityForResult(intent, PHOTO_REQUEST_CUT);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PHOTO_REQUEST_GALLERY) {
            // 从相册返回的数据
            if (data != null) {
                // 得到图片的全路径
                Uri uri = data.getData();
                crop(uri);
            }

        } else if (requestCode == PHOTO_REQUEST_CUT) {
            // 从剪切图片返回的数据
            if (data != null) {
                Bitmap bitmap = data.getParcelableExtra("data");
                /**
                 * 获得图片
                 *
                 */
               // iv_img.setImageBitmap(bitmap);
                Intent intent=new Intent(CustomCamera.this,TackPicture.class);
                myBitmapStore.setBitmap(bitmap);
                startActivity(intent);
                //保存到SharedPreferences
                // saveBitmapToSharedPreferences(bitmap);
            }
            try {
                // 将临时文件删除
                tempFile.delete();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
    //从SharedPreferences获取图片
    public Bitmap getBitmapFromSharedPreferences() {

        SharedPreferences sharedPreferences = getSharedPreferences("testSP", Context.MODE_PRIVATE);
        //第一步:取出字符串形式的Bitmap
        String imageString = sharedPreferences.getString("image", "");
        //第二步:利用Base64将字符串转换为ByteArrayInputStream
        byte[] byteArray = Base64.decode(imageString, Base64.DEFAULT);
        if (byteArray.length == 0) {

            //iv_img.setImageResource(R.mipmap.ic_launcher);
        } else {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArray);

            //第三步:利用ByteArrayInputStream生成Bitmap
            bitmap = BitmapFactory.decodeStream(byteArrayInputStream);
            Intent intent=new Intent(CustomCamera.this,TackPicture.class);
            intent.putExtra("BITMAP",bitmap);
            startActivity(intent);
            //iv_img.setImageBitmap(bitmap);
        }

        return bitmap;
    }


    @Override
    public void onClick(View v) {

    }

    @Override
    public void onPictureTaken(byte[] data, Camera camera) {
        ImageView img = (ImageView) findViewById(R.id.img_pic1);
        // 将图片保存至相册
//      ContentResolver resolver = getContentResolver();
        Bitmap bitmap = BitmapFactory.decodeByteArray(data, 0, data.length);
        Matrix m = new Matrix();
        m.setRotate(-90);
        Bitmap bitA = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), m, true);
        bitA = Bitmap.createScaledBitmap(bitA, bitA.getWidth()/5, bitA.getHeight()/5, true);
        img.setImageBitmap(bitA);
        new CompareTask().execute(bitA);
//      MediaStore.Images.Media.insertImage(resolver, bitmap, "t", "des");
        // 拍照后重新开始预览
        camera.startPreview();
        bitmap.recycle();
    }
}