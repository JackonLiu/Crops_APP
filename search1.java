package com.example.crops;

import android.app.Activity;
import android.os.Bundle;

import android.content.Intent;

import android.util.Log;
import android.view.View;
import android.widget.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class search1 extends Activity  implements AdapterView.OnItemClickListener{
    private int[]icon={R.mipmap.timg,R.mipmap.yimg1};
    private String[]iconName={"蚕豆","马铃薯"};
    private ListView listView;
    private AutoCompleteTextView ac;
    private String[] res={"蚕豆","马铃薯"};
    private ImageButton button;
    private AutoCompleteTextView autoCompleteTextView;

    private SimpleAdapter simpleAdapter;
    List<Map<String,Object>> dataList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);
        listView= (ListView) findViewById(R.id.listView);
        button= (ImageButton) findViewById(R.id.button);
        dataList=new ArrayList<Map<String,Object>>();

        autoCompleteTextView= (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
        simpleAdapter=new SimpleAdapter(this,getData(),R.layout.item,new String[]{"imageView","textView"},new int[]{R.id.imageView,R.id.textView});
        //listView.setAdapter(simpleAdapter);
        listView.setOnItemClickListener(this);
        ac= (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
        ArrayAdapter<String>adapter=new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,res);
        ac.setAdapter(adapter);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                dataList.clear();
                simpleAdapter=new SimpleAdapter(search1.this,dataList,R.layout.item,new String[]{"imageView","textView"},new int[]{R.id.imageView,R.id.textView});
                listView.setAdapter(simpleAdapter);
                int j,l=0;
                for (j=0;j<icon.length;j++) {
                    String abc=autoCompleteTextView.getText()+"";
                    if (abc.equals(iconName[j])){
                        Map<String, Object>map=new HashMap<String, Object>();
                        map.put("imageView",icon[j]);
                        map.put("textView",iconName[j]);
                        dataList.add(map);
                        simpleAdapter=new SimpleAdapter(search1.this,dataList,R.layout.item,new String[]{"imageView","textView"},new int[]{R.id.imageView,R.id.textView});
                        listView.setAdapter(simpleAdapter);
                        l=l+1;

                    }

                }
                if (l==0){
                    Map<String, Object>map=new HashMap<String, Object>();
                    map.put("imageView",R.mipmap.ic_launcher);
                    map.put("textView","没找到");
                    dataList.add(map);
                    simpleAdapter=new SimpleAdapter(search1.this,dataList,R.layout.item,new String[]{"imageView","textView"},new int[]{R.id.imageView,R.id.textView});
                    listView.setAdapter(simpleAdapter);

                }


            }
        });
    }
    public List<Map<String,Object>> getData() {
        for(int i=0;i<icon.length;i++){
            Map<String, Object>map=new HashMap<String, Object>();
            map.put("imageView",icon[i]);
            map.put("textView",iconName[i]);
            dataList.add(map);
        }

        return dataList;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


        Intent intent=new Intent(this,donghua.class);


        Bundle bundle=new Bundle();
        bundle.putInt("position",position);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
