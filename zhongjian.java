package com.example.crops;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class  zhongjian extends Activity implements AdapterView.OnItemClickListener ,View.OnClickListener {
    private Button button;
    private SimpleAdapter simpleAdapter;
    List<Map<String,Object>> dataList;
    private ListView listView;
    private int[]icon={R.mipmap.liangshi,R.mipmap.jingji,R.mipmap.gongye};
    private String[]iconName={"粮食作物","经济作物","蔬菜作物"};
    private String[]iconName1={"粮食作物是指以收获成熟果实为目的的，经去壳，碾磨等加工程序而成为人类基本食粮的一类作物","经济作物又称技术作物，指具有某种特定经济用途的农作物","蔬菜作物"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.ff);
           abc();
        listView= (ListView) findViewById(R.id.list);
        dataList=new ArrayList<Map<String,Object>>();
        simpleAdapter=new SimpleAdapter(this,getData(),R.layout.itemm,new String[]{"imageView","textView","textView1"},new int[]{R.id.imageView,R.id.textView,R.id.textView1});
        listView.setAdapter(simpleAdapter);
        listView.setOnItemClickListener(this);

    }



    private void abc() {
        setContentView(R.layout.ff);

        ImageButton but= (ImageButton) findViewById(R.id.back);
        ImageButton butt= (ImageButton) findViewById(R.id.next);

        but.setOnClickListener(this);
        butt.setOnClickListener(this);
    }

    public List<Map<String,Object>> getData() {
        for (int i = 0; i < icon.length; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("imageView", icon[i]);
            map.put("textView", iconName[i]);
            map.put("textView1", iconName1[i]);
            dataList.add(map);
        }
        return dataList;
     }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position){
            case 0:
                Intent intent=new Intent(zhongjian.this,baike.class);
                startActivity(intent);
                break;
            case 1:
                intent = new Intent(zhongjian.this, baike1.class);
                startActivity(intent);
                break;
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back:
                Intent intent=new Intent(zhongjian.this,MainActivity.class);

                startActivity(intent);
                overridePendingTransition(0, R.anim.out_to_left);

                break;
            case R.id.next:
                Intent intent88=new Intent(zhongjian.this,searchh.class);
                intent88.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent88);
              //  overridePendingTransition(R.anim.open_in, R.anim.open_out);

        }

    }
}
