package com.example.crops;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static android.view.animation.Animation.RELATIVE_TO_SELF;

public class donghua extends Activity {
    private RelativeLayout relativeLayout;
    private ImageView imageView;
    private AnimationDrawable animationDrawable;
    private AnimationDrawable animationDrawable1;
    private AnimationDrawable animationDrawable2;
    private AnimationDrawable animationDrawable3;
    private AnimationDrawable animationDrawable4;
    private AnimationDrawable animationDrawable5;
    private AnimationDrawable animationDrawable6;
    private AnimationDrawable animationDrawable7;
    private AnimationDrawable animationDrawable8;
    private ImageButton button3;//放大镜
    private ImageButton button4;//铲子
    private ImageButton button5;//水壶
    private ImageButton button6;//农药
    private ImageButton button7;//肥料
    private ImageButton image1;
    private ImageButton image2;
    private ImageButton image3;
    private TextView textView8;
    private  TextView textView13;

    private  ImageView imageView1;
    private String[]iconName={"100ml","200ml","300ml","400ml","500ml","600ml"};
    int screenWidth;
    int screenHeight;
    int lastX;
    int lastY;
    private SimpleAdapter simpleAdapter;
    List<Map<String,Object>> dataList;
    private ListView listView;
    private ImageView imageView7;
    private ListView listView1;
    private SimpleAdapter simpleAdapter1;
    List<Map<String,Object>> dataList1;
    private String[]iconName3={"第一农药","第二农药","第三农药","第四农药","第五农药","第六农药" };
    private ListView listView2;
    private SimpleAdapter simpleAdapter2;
    List<Map<String,Object>> dataList2;
    private String[]iconName2={"第一化肥","第二化肥","第三化肥","第四化肥","第五化肥","第六化肥" };
    private ListView listView3;
    private SimpleAdapter simpleAdapter3;
    List<Map<String,Object>> dataList3;
    private String[]iconName1={"一铲","两铲","三铲","四铲","五铲","六铲" };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle=this.getIntent().getExtras();
        int value=bundle.getInt("position");
        setContentView(R.layout.ee);
        // imageView = (ImageView) findViewById(R.id.imageView1);
        relativeLayout= (RelativeLayout) findViewById(R.id.asd);
        button3= (ImageButton) findViewById(R.id.button3);
        button4= (ImageButton) findViewById(R.id.button4);
        button5= (ImageButton) findViewById(R.id.button5);
        button6= (ImageButton) findViewById(R.id.button6);
        button7= (ImageButton) findViewById(R.id.button7);
        image1= (ImageButton) findViewById(R.id.image1);

textView8= (TextView) findViewById(R.id.textView8);
textView13= (TextView) findViewById(R.id.textView13);
        DisplayMetrics dm = getResources().getDisplayMetrics();
        screenWidth = dm.widthPixels-838;
        screenHeight = dm.heightPixels - 780;
        // final ImageButton imgg= (ImageButton) findViewById(R.id.imageButton4);
        // imgg.setVisibility(View.INVISIBLE);
        /*imgg.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // TODO Auto-generated method stub
                int action=event.getAction();
                Log.i("@@@@@@", "Touch:"+action);
                //Toast.makeText(DraftTest.this, "λ�ã�"+x+","+y, Toast.LENGTH_SHORT).show();
                switch(action){
                    case MotionEvent.ACTION_DOWN:
                        lastX = (int) event.getRawX();
                        lastY = (int) event.getRawY();
                        break;
                    /**
                     * layout(l,t,r,b)
                     * l  Left position, relative to parent
                     t  Top position, relative to parent
                     r  Right position, relative to parent
                     b  Bottom position, relative to parent
                     * */
                  /* case MotionEvent.ACTION_MOVE:
                        int dx =(int)event.getRawX() - lastX;
                        int dy =(int)event.getRawY() - lastY;

                        int left = v.getLeft() + dx;
                        int top = v.getTop() + dy;
                        int right = v.getRight() + dx;
                        int bottom = v.getBottom() + dy;
                        if(left < 0){
                            left = 0;
                            right = left + v.getWidth();
                        }
                        if(right > screenWidth){
                            right = screenWidth;
                            left = right - v.getWidth();
                        }
                        if(top < 0){
                            top = 0;
                            bottom = top + v.getHeight();
                        }
                        if(bottom > screenHeight){
                            bottom = screenHeight;
                            top = bottom - v.getHeight();
                        }
                        v.layout(left, top, right, bottom);

                        Log.i("@@@@@@", "position��" + left +", " + top + ", " + right + ", " + bottom);
                        lastX = (int) event.getRawX();
                        lastY = (int) event.getRawY();
                        break;
                    case MotionEvent.ACTION_UP:
                        break;
                }
                return false;
            }
        });*/
        final RelativeLayout lin= (RelativeLayout) findViewById(R.id.lin1);
        listView= (ListView) findViewById(R.id.listView2);
        listView1= (ListView) findViewById(R.id.listView2);
        listView2= (ListView) findViewById(R.id.listView2);
        listView3= (ListView) findViewById(R.id.listView2);
        dataList=new ArrayList<Map<String,Object>>();
        dataList1=new ArrayList<Map<String,Object>>();
        dataList2=new ArrayList<Map<String,Object>>();
        dataList3=new ArrayList<Map<String,Object>>();
        simpleAdapter=new SimpleAdapter(this,getData(),R.layout.jiaoshui,new String[]{"imageView"},new int[]{R.id.imageView6});
        simpleAdapter1=new SimpleAdapter(this,getData1(),R.layout.nongyao,new String[]{"textView1"},new int[]{R.id.textView9});
        simpleAdapter2=new SimpleAdapter(this,getData2(),R.layout.huafei,new String[]{"textView2"},new int[]{R.id.textView10});
        simpleAdapter3=new SimpleAdapter(this,getData3(),R.layout.chan,new String[]{"textView3"},new int[]{R.id.textView11});
        //button1= (Button) findViewById(R.id.button2);
        imageView1= (ImageView) findViewById(R.id.imageView4);
        imageView7= (ImageView) findViewById(R.id.imageView7);
        switch (value) {
            case 0:
                //animationDrawable.start();
                /*button1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                       imgg.setVisibility(View.VISIBLE);

                        listView.setAdapter(simpleAdapter);
                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                final int a=imgg.getTop();
                                Toast.makeText(donghua.this,"请拖动按钮"+a,Toast.LENGTH_LONG).show();

                                if ((a>500)&&(a<700)){
                                    relativeLayout.setBackgroundResource(R.drawable.animation0);
                                    //animationDrawable = (AnimationDrawable) imageView.getDrawable();
                                    animationDrawable = (AnimationDrawable) relativeLayout.getBackground();
                                    imageView1.setImageResource(R.drawable.animation1);
                                    animationDrawable2 = (AnimationDrawable) imageView1.getDrawable();
                                    Toast.makeText(donghua.this, "nice", Toast.LENGTH_SHORT).show();
                                    animationDrawable2.start();
                                    animationDrawable.stop();
                                    animationDrawable.start();








                                }else{
                                    //Toast.makeText(donghua.this, "选错啦", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

                    }
                });*/
                //铲子
                button3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {




                        imageView7.setBackgroundResource(0);

                        //listView1.setAdapter(simpleAdapter1);




                        //imageView1.setImageResource(R.drawable.animation3);
                        //animationDrawable3 = (AnimationDrawable) imageView1.getDrawable();
                        imageView7.setImageResource(R.drawable.animation);
                        //imageView1.setImageResource();
                        animationDrawable8= (AnimationDrawable) imageView7.getDrawable();
                        // relativeLayout.setBackgroundResource(R.drawable.animation2);
                        //animationDrawable1 = (AnimationDrawable) relativeLayout.getBackground();
                        Toast.makeText(donghua.this, "nice", Toast.LENGTH_SHORT).show();
                        animationDrawable8.start();

                        // animationDrawable8.start();
                        // animationDrawable1.stop();
                        //animationDrawable1.start();




                        button4.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                imageView7.setBackgroundResource(0);




                                imageView7.setImageResource(R.drawable.animation0);
                                imageView1.setImageResource(R.drawable.animation1);//啥水壶
                                animationDrawable7= (AnimationDrawable) imageView1.getDrawable();
                                animationDrawable7.start();
                                animationDrawable8= (AnimationDrawable) imageView7.getDrawable();
                                animationDrawable8.start();





                                Toast.makeText(donghua.this,"请点击肥料",Toast.LENGTH_SHORT).show();
                                button7.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        animationDrawable7.stop();
                                        animationDrawable8.stop();
                                        lin.setVisibility(View.VISIBLE);
                                        lin.setBackgroundResource(R.mipmap.xiaka);

                                        textView8.setText("基肥");
                                        textView13.setText("每株施猪牛粪或厩肥5千克、石灰0.3千克、过磷酸钙0.3千克、腐熟土杂肥20千克与晒白的表土充分混合，待10天左右再种苗。基肥的作用是改良土壤理化结构和酸碱度。为香蕉高产打下了良好基础。");
                                        button3.setVisibility(View.INVISIBLE);
                                        button4.setVisibility(View.INVISIBLE);
                                        button5.setVisibility(View.INVISIBLE);
                                        button6.setVisibility(View.INVISIBLE);
                                        button7.setVisibility(View.INVISIBLE);
                                        imageView7.setBackgroundResource(0);
                                        DisplayMetrics dm = getResources().getDisplayMetrics();
                                        int width = dm.widthPixels;
                                        int height = dm.heightPixels;
                                        // RelativeLayout.LayoutParams params= (RelativeLayout.LayoutParams) imageView7.getLayoutParams();
//获取当前控件的布局对象
                                        //params.height=height/2+500;//设置当前控件布局的高度
                                        // params.width=width/2;//设置当前控件布局的高度


                                        //imageView7.setTranslationY(300);

                                        //imageView7.setLayoutParams(params);//将设置好的布局参数应用到控件中
                /*BitmapDrawable bitmapDrawable = (BitmapDrawable)imageView1.getBackground();
                if(bitmapDrawable!=null){
                    Bitmap hisBitmap = bitmapDrawable.getBitmap();
                    if(hisBitmap.isRecycled()==false)
                    {
                        hisBitmap.recycle();
                    }
                }
                BitmapDrawable bitmapDrawable1 = (BitmapDrawable)imageView7.getBackground();
                if(bitmapDrawable1!=null){
                    Bitmap hisBitmap1 = bitmapDrawable1.getBitmap();
                    if(hisBitmap1.isRecycled()==false)
                    {
                        hisBitmap1.recycle();
                    }
                }*/




                                        imageView1.setImageResource(R.drawable.animation3);
                                        animationDrawable7= (AnimationDrawable) imageView1.getDrawable();
                                        animationDrawable7.start();
                                        //imageView1.setVisibility(View.INVISIBLE);
                                        imageView7.setImageResource(R.drawable.animation4);
                                        animationDrawable8= (AnimationDrawable) imageView7.getDrawable();
                                        animationDrawable8.start();
                                        image1.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                lin.setVisibility(View.INVISIBLE);
                                                button3.setVisibility(View.VISIBLE);
                                                button4.setVisibility(View.VISIBLE);
                                                button5.setVisibility(View.VISIBLE);
                                                button6.setVisibility(View.VISIBLE);
                                                button7.setVisibility(View.VISIBLE);
                                            }
                                        });
                                        Toast.makeText(donghua.this,"请点击放大镜",Toast.LENGTH_SHORT).show();
                                        button6.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                animationDrawable7.stop();
                                                animationDrawable8.stop();
                                                imageView1.setVisibility(View.INVISIBLE);
                                                imageView7.setBackgroundResource(R.mipmap.ef6);
                                                imageView7.setImageResource(R.drawable.animation8);
                                                animationDrawable8= (AnimationDrawable) imageView7.getDrawable();
                                                animationDrawable8.start();
                                                button5.setOnClickListener(new View.OnClickListener() {
                                                    @Override
                                                    public void onClick(View v) {
                                                        animationDrawable8.stop();
                                                        lin.setVisibility(View.VISIBLE);
                                                        lin.setBackgroundResource(R.mipmap.xiaka1);
                                                        textView8.setText("鱼藤精");
                                                        textView13.setText("鱼藤精是从鱼藤根部提取的植物性杀虫剂，具有触杀和胃毒作用，对蚜虫及鳞翅目幼虫效果较好。对人畜、作物极为安全，特别适合在果、蔬、茶、桑使用，常用2.5%鱼胶精乳油500~800倍液喷雾。");
                                                        imageView7.setBackgroundResource(R.mipmap.ef6);
                                                        button3.setVisibility(View.INVISIBLE);
                                                        button4.setVisibility(View.INVISIBLE);
                                                        button5.setVisibility(View.INVISIBLE);
                                                        button6.setVisibility(View.INVISIBLE);
                                                        button7.setVisibility(View.INVISIBLE);
                                                        image1.setOnClickListener(new View.OnClickListener() {
                                                            @Override
                                                            public void onClick(View v) {
                                                                lin.setVisibility(View.INVISIBLE);
                                                                button3.setVisibility(View.VISIBLE);
                                                                button4.setVisibility(View.VISIBLE);
                                                                button5.setVisibility(View.VISIBLE);
                                                                button6.setVisibility(View.VISIBLE);
                                                                button7.setVisibility(View.VISIBLE);
                                                            }
                                                        });
                                                        //imageView7.setBackgroundResource(0);
                                                        imageView7.setImageResource(R.drawable.animation9);
                                                        animationDrawable8= (AnimationDrawable) imageView7.getDrawable();
                                                        animationDrawable8.start();
                                                    }
                                                });


                                            }
                                        });
                                    }
                                });
                            }
                        });




                    }
                });
                button4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        imageView7.setBackgroundResource(0);
                        Toast.makeText(donghua.this,"操作错误",Toast.LENGTH_SHORT).show();
                    }
                });
                button7.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        imageView7.setBackgroundResource(0);
                        Toast.makeText(donghua.this,"操作错误",Toast.LENGTH_SHORT).show();
                    }
                });
                button5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        imageView7.setBackgroundResource(0);
                        Toast.makeText(donghua.this,"操作错误",Toast.LENGTH_SHORT).show();
                       /*listView2.setAdapter(simpleAdapter2);
                        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                if(position!=3){
                                    Toast.makeText(donghua.this, "选错啦", Toast.LENGTH_SHORT).show();
                                }
                                else{
                                    imageView1.setImageResource(R.drawable.animation4);
                                    animationDrawable4 = (AnimationDrawable) imageView1.getDrawable();
                                    //relativeLayout.setBackgroundResource(R.drawable.animation6);
                                   // animationDrawable6 = (AnimationDrawable) relativeLayout.getBackground();

                                    animationDrawable4.start();
                                  // animationDrawable6.stop();
                                    //animationDrawable6.start();
                                }
                            }
                        });*/
                    }
                });
                button6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        imageView7.setBackgroundResource(0);
                        Toast.makeText(donghua.this,"操作错误",Toast.LENGTH_SHORT).show();
                        /*listView3.setAdapter(simpleAdapter3);
                        listView3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                if(position!=4){
                                    Toast.makeText(donghua.this, "选错啦", Toast.LENGTH_SHORT).show();
                                }
                                else{
                                    Toast.makeText(donghua.this, "nice56978", Toast.LENGTH_SHORT).show();
                                    imageView1.setImageResource(R.drawable.animation5);
                                    animationDrawable5 = (AnimationDrawable) imageView1.getDrawable();
                                    relativeLayout.setBackgroundResource(R.drawable.animation7);
                                    animationDrawable7 = (AnimationDrawable) relativeLayout.getBackground();
                                    animationDrawable5.start();
                                    animationDrawable7.stop();
                                    animationDrawable7.start();
                                }
                            }
                        });*/
                    }
                });
                break;
            case 1:
                /*imageView.setImageResource(R.drawable.animation1);
                animationDrawable = (AnimationDrawable) imageView.getDrawable();
                animationDrawable.start();*/
                //animationDrawable.start();
                /*button1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                       imgg.setVisibility(View.VISIBLE);

                        listView.setAdapter(simpleAdapter);
                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                final int a=imgg.getTop();
                                Toast.makeText(donghua.this,"请拖动按钮"+a,Toast.LENGTH_LONG).show();

                                if ((a>500)&&(a<700)){
                                    relativeLayout.setBackgroundResource(R.drawable.animation0);
                                    //animationDrawable = (AnimationDrawable) imageView.getDrawable();
                                    animationDrawable = (AnimationDrawable) relativeLayout.getBackground();
                                    imageView1.setImageResource(R.drawable.animation1);
                                    animationDrawable2 = (AnimationDrawable) imageView1.getDrawable();
                                    Toast.makeText(donghua.this, "nice", Toast.LENGTH_SHORT).show();
                                    animationDrawable2.start();
                                    animationDrawable.stop();
                                    animationDrawable.start();








                                }else{
                                    //Toast.makeText(donghua.this, "选错啦", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

                    }
                });*/
                //铲子
                button3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        imageView7.setBackgroundResource(0);




                        //listView1.setAdapter(simpleAdapter1);




                        //imageView1.setImageResource(R.drawable.animation3);
                        //animationDrawable3 = (AnimationDrawable) imageView1.getDrawable();
                        imageView7.setImageResource(R.drawable.animation5);
                        //imageView1.setImageResource();
                        animationDrawable8= (AnimationDrawable) imageView7.getDrawable();
                        // relativeLayout.setBackgroundResource(R.drawable.animation2);
                        //animationDrawable1 = (AnimationDrawable) relativeLayout.getBackground();
                        Toast.makeText(donghua.this, "nice", Toast.LENGTH_SHORT).show();
                        animationDrawable8.start();

                        // animationDrawable8.start();
                        // animationDrawable1.stop();
                        //animationDrawable1.start();

                        image1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                lin.setVisibility(View.INVISIBLE);
                                button3.setVisibility(View.VISIBLE);
                                button4.setVisibility(View.VISIBLE);
                                button5.setVisibility(View.VISIBLE);
                                button6.setVisibility(View.VISIBLE);
                                button7.setVisibility(View.VISIBLE);
                                Toast.makeText(donghua.this,"请点击洒水壶",Toast.LENGTH_SHORT).show();
                            }
                        });


                        button4.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                imageView7.setBackgroundResource(0);

                                animationDrawable8.stop();

                                imageView7.setImageResource(R.drawable.animation6);
                                imageView1.setImageResource(R.drawable.animation1);//啥水壶
                                animationDrawable7= (AnimationDrawable) imageView1.getDrawable();
                                animationDrawable7.start();
                                animationDrawable8= (AnimationDrawable) imageView7.getDrawable();
                                animationDrawable8.start();
                                image1.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        lin.setVisibility(View.INVISIBLE);
                                        button3.setVisibility(View.VISIBLE);
                                        button4.setVisibility(View.VISIBLE);
                                        button5.setVisibility(View.VISIBLE);
                                        button6.setVisibility(View.VISIBLE);
                                        button7.setVisibility(View.VISIBLE);
                                    }
                                });





                                Toast.makeText(donghua.this,"请点击肥料",Toast.LENGTH_SHORT).show();
                                button7.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        animationDrawable7.stop();
                                        animationDrawable8.stop();
                                        imageView7.setBackgroundResource(0);
                                        lin.setVisibility(View.VISIBLE);
                                        lin.setBackgroundResource(R.mipmap.xiaka);
                                        textView8.setText("复合肥");
                                        textView13.setText("市场上常见的化肥，磷肥，氮肥，最好是复合肥，但要对症施肥。玉米是高产作物，需肥量较大，必须合理施肥才能满足玉米在整个生育期对养分的需要。");






                                        button3.setVisibility(View.INVISIBLE);
                                        button4.setVisibility(View.INVISIBLE);
                                        button5.setVisibility(View.INVISIBLE);
                                        button6.setVisibility(View.INVISIBLE);
                                        button7.setVisibility(View.INVISIBLE);
                /*BitmapDrawable bitmapDrawable = (BitmapDrawable)imageView1.getBackground();
                if(bitmapDrawable!=null){
                    Bitmap hisBitmap = bitmapDrawable.getBitmap();
                    if(hisBitmap.isRecycled()==false)
                    {
                        hisBitmap.recycle();
                    }
                }
                BitmapDrawable bitmapDrawable1 = (BitmapDrawable)imageView7.getBackground();
                if(bitmapDrawable1!=null){
                    Bitmap hisBitmap1 = bitmapDrawable1.getBitmap();
                    if(hisBitmap1.isRecycled()==false)
                    {
                        hisBitmap1.recycle();
                    }
                }*/



                                        DisplayMetrics dm = getResources().getDisplayMetrics();
                                        int width = dm.widthPixels;
                                        int height = dm.heightPixels;
                                        // RelativeLayout.LayoutParams params= (RelativeLayout.LayoutParams) imageView7.getLayoutParams();
//获取当前控件的布局对象
                                        //params.height=800;//设置当前控件布局的高度
                                        //params.width=500;//设置当前控件布局的高度
                                        //imageView7.setLayoutParams(params);//将设置好的布局参数应用到控件中
                                        imageView1.setImageResource(R.drawable.animation3);
                                        animationDrawable7= (AnimationDrawable) imageView1.getDrawable();
                                        animationDrawable7.start();
                                        //imageView1.setVisibility(View.INVISIBLE);
                                        imageView7.setImageResource(R.drawable.animation7);
                                        animationDrawable7= (AnimationDrawable) imageView7.getDrawable();
                                        animationDrawable7.start();
                                        image1.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                lin.setVisibility(View.INVISIBLE);
                                                button3.setVisibility(View.VISIBLE);
                                                button4.setVisibility(View.VISIBLE);
                                                button5.setVisibility(View.VISIBLE);
                                                button6.setVisibility(View.VISIBLE);
                                                button7.setVisibility(View.VISIBLE);
                                            }
                                        });
                                        Toast.makeText(donghua.this,"请点击农药",Toast.LENGTH_SHORT).show();
                                        button6.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                animationDrawable7.stop();
                                                imageView1.setVisibility(View.INVISIBLE);
                                                imageView7.setBackgroundResource(R.drawable.hi6);
                                                imageView7.setImageResource(R.drawable.animation8);
                                                animationDrawable8= (AnimationDrawable) imageView7.getDrawable();
                                                animationDrawable8.start();
                                                button5.setOnClickListener(new View.OnClickListener() {
                                                    @Override
                                                    public void onClick(View v) {
                                                        animationDrawable8.stop();
                                                        lin.setVisibility(View.VISIBLE);
                                                        lin.setBackgroundResource(R.mipmap.xiaka1);
                                                      textView8.setText("玉米钻心虫(玉米螟)");
                                                      textView13.setText("玉米钻心虫(玉米螟)是危害玉米的主要害虫；其幼虫蛀入玉米主茎或果穗内，能使玉米主茎折断，造成玉米营养供应不足，授粉不良，致使玉米减产降质。");




                                                        button3.setVisibility(View.INVISIBLE);
                                                        button4.setVisibility(View.INVISIBLE);
                                                        button5.setVisibility(View.INVISIBLE);
                                                        button6.setVisibility(View.INVISIBLE);
                                                        button7.setVisibility(View.INVISIBLE);
                                                        imageView7.setBackgroundResource(R.drawable.hi6);
                                                        imageView7.setImageResource(R.drawable.animation9);
                                                        animationDrawable8= (AnimationDrawable) imageView7.getDrawable();
                                                        animationDrawable8.start();

                                                        image1.setOnClickListener(new View.OnClickListener() {
                                                            @Override
                                                            public void onClick(View v) {
                                                                lin.setVisibility(View.INVISIBLE);
                                                                button3.setVisibility(View.VISIBLE);
                                                                button4.setVisibility(View.VISIBLE);
                                                                button5.setVisibility(View.VISIBLE);
                                                                button6.setVisibility(View.VISIBLE);
                                                                button7.setVisibility(View.VISIBLE);
                                                            }
                                                        });
                                                    }
                                                });
                                            }
                                        });
                                    }
                                });
                            }
                        });




                    }
                });
                button4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        imageView7.setBackgroundResource(0);
                        Toast.makeText(donghua.this,"操作错误",Toast.LENGTH_SHORT).show();
                    }
                });
                button7.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        imageView7.setBackgroundResource(0);
                        Toast.makeText(donghua.this,"操作错误",Toast.LENGTH_SHORT).show();
                    }
                });
                button5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        imageView7.setBackgroundResource(0);
                        Toast.makeText(donghua.this,"操作错误",Toast.LENGTH_SHORT).show();
                       /*listView2.setAdapter(simpleAdapter2);
                        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                if(position!=3){
                                    Toast.makeText(donghua.this, "选错啦", Toast.LENGTH_SHORT).show();
                                }
                                else{
                                    imageView1.setImageResource(R.drawable.animation4);
                                    animationDrawable4 = (AnimationDrawable) imageView1.getDrawable();
                                    //relativeLayout.setBackgroundResource(R.drawable.animation6);
                                   // animationDrawable6 = (AnimationDrawable) relativeLayout.getBackground();

                                    animationDrawable4.start();
                                  // animationDrawable6.stop();
                                    //animationDrawable6.start();
                                }
                            }
                        });*/
                    }
                });
                button6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        imageView7.setBackgroundResource(0);
                        Toast.makeText(donghua.this,"操作错误",Toast.LENGTH_SHORT).show();
                        /*listView3.setAdapter(simpleAdapter3);
                        listView3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                if(position!=4){
                                    Toast.makeText(donghua.this, "选错啦", Toast.LENGTH_SHORT).show();
                                }
                                else{
                                    Toast.makeText(donghua.this, "nice56978", Toast.LENGTH_SHORT).show();
                                    imageView1.setImageResource(R.drawable.animation5);
                                    animationDrawable5 = (AnimationDrawable) imageView1.getDrawable();
                                    relativeLayout.setBackgroundResource(R.drawable.animation7);
                                    animationDrawable7 = (AnimationDrawable) relativeLayout.getBackground();
                                    animationDrawable5.start();
                                    animationDrawable7.stop();
                                    animationDrawable7.start();
                                }
                            }
                        });*/
                    }
                });
                break;
        }
    }
    public List<Map<String,Object>> getData() {
        for (int i = 0; i <1; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("imageView", R.mipmap.a);
            dataList.add(map);
        }
        return dataList;
    }
    public List<Map<String,Object>> getData1() {
        for (int i = 0; i < iconName1.length; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("textView1", iconName1[i]);
            dataList1.add(map);
        }
        return dataList1;
    }
    public List<Map<String,Object>> getData2() {
        for (int i = 0; i < iconName2.length; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("textView2", iconName2[i]);
            dataList2.add(map);
        }
        return dataList2;
    }
    public List<Map<String,Object>> getData3() {
        for (int i = 0; i < iconName3.length; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("textView3", iconName3[i]);
            dataList3.add(map);
        }
        return dataList3;
    }


}
