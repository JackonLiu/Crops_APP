package com.example.crops;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;
import android.widget.AdapterView.OnItemClickListener;
import org.tensorflow.demo.CameraActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class baike extends Activity implements OnItemClickListener,View.OnClickListener {
    private int[]icon={R.mipmap.xiangjiao,R.mipmap.yumi,R.mipmap.chengzi,R.mipmap.mogu};
    private int[]iconName={R.mipmap.xiangjiao1,R.mipmap.yumi1,R.mipmap.chengzi1,R.mipmap.mogu1};

    private int[]icon1={R.mipmap.xiangjiao2,R.mipmap.yumi2,R.mipmap.chengzi2,R.mipmap.mogu2};
    private ListView listView;
    private TextView textt;
    private AutoCompleteTextView ac;
    private String[] res={"香蕉","玉米","橙子","蘑菇"};
    private Button button;
    private AutoCompleteTextView autoCompleteTextView;

    private SimpleAdapter simpleAdapter;
    List<Map<String,Object>> dataList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bb);
        abc();
        //textt= (TextView) findViewById(R.id.textt);
        //textt.setText("模拟动画");
        listView= (ListView) findViewById(R.id.listView);
        button= (Button) findViewById(R.id.button);
        dataList=new ArrayList<Map<String,Object>>();

        autoCompleteTextView= (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
        simpleAdapter=new SimpleAdapter(this,getData(),R.layout.item,new String[]{"imageView","textView","imageView1"},new int[]{R.id.imageView,R.id.imageView11,R.id.imageView12});
        listView.setAdapter(simpleAdapter);
        listView.setOnItemClickListener(this);
        ac= (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
        ArrayAdapter<String>adapter=new ArrayAdapter<String>(baike.this,android.R.layout.simple_list_item_1,res);
        ac.setAdapter(adapter);
        /*button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                dataList.clear();
                simpleAdapter=new SimpleAdapter(xinxi.this,dataList,R.layout.item,new String[]{"imageView","textView"},new int[]{R.id.imageView,R.id.textView});
                listView.setAdapter(simpleAdapter);

                for (int j=0;j<icon.length;j++) {
                    String abc=autoCompleteTextView.getText()+"";
                    if (abc.equals(iconName[j])){
                        Map<String, Object>map=new HashMap<String, Object>();
                        map.put("imageView",icon[j]);
                        map.put("textView",iconName[j]);
                        dataList.add(map);
                        simpleAdapter=new SimpleAdapter(xinxi.this,dataList,R.layout.item,new String[]{"imageView","textView"},new int[]{R.id.imageView,R.id.textView});
                        listView.setAdapter(simpleAdapter);

                    }
                }


            }
        });*/
    }

    public List<Map<String,Object>> getData() {
        for(int i=0;i<icon.length;i++){
            Map<String, Object>map=new HashMap<String, Object>();
            map.put("imageView",icon[i]);
            map.put("textView",iconName[i]);
            map.put("imageView1",icon1[i]);
            dataList.add(map);
        }

        return dataList;
    }
    private void abc() {


        ImageButton but= (ImageButton) findViewById(R.id.imageButton4);
        ImageButton butt= (ImageButton) findViewById(R.id.imageButton5);

        but.setOnClickListener(this);
        butt.setOnClickListener(this);
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {



        Intent intent=new Intent();
        intent.setAction("huang");
        intent.addCategory("android.intent.category.DEFAULT");
        Bundle bundle=new Bundle();
        bundle.putInt("position",position);
        intent.putExtras(bundle);
        baike.this.startActivity(intent);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imageButton4:
                dataList.clear();
                simpleAdapter=new SimpleAdapter(baike.this,dataList,R.layout.item,new String[]{"imageView","textView","imageView1"},new int[]{R.id.imageView,R.id.imageView11,R.id.imageView12});
                listView.setAdapter(simpleAdapter);

                for (int j=0;j<icon.length;j++) {
                    String abc=autoCompleteTextView.getText()+"";
                    if (abc.equals(res[j])){
                        Map<String, Object>map=new HashMap<String, Object>();
                        map.put("imageView",icon[j]);
                        map.put("textView",iconName[j]);
                        map.put("imageView1",icon1[j]);
                        dataList.add(map);
                        simpleAdapter=new SimpleAdapter(baike.this,dataList,R.layout.item,new String[]{"imageView","textView","imageView1"},new int[]{R.id.imageView,R.id.imageView11,R.id.imageView12});
                        listView.setAdapter(simpleAdapter);

                    }
                }


                break;
            case R.id.imageButton5:
                Intent intent88=new Intent(baike.this,CameraActivity.class);
                intent88.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent88);
                //  overridePendingTransition(R.anim.open_in, R.anim.open_out);

        }
    }
}
