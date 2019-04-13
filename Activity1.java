package com.example.crops;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Activity1 extends Activity {
    String[]xiingxi={"玉米（拉丁学名：Zea mays L.）是禾本科玉蜀黍属一年生草本植物。别名：玉蜀黍、棒子、包谷、包米、包粟、玉茭、苞米、珍珠米、苞芦、大芦粟，东北辽宁话称珍珠粒，潮州话称薏米仁，粤语称为粟米，闽南语称作番麦。\n" +
            "玉米是一年生雌雄同株异花授粉植物， 植株高大， 茎强壮， 是重要的粮食作物和饲料作物， 也是全世界总产量最高的农作物， 其种植面积和总产量仅次于水稻和小麦。玉米一直都被誉为长寿食品， 含有丰富的蛋 白质、 脂肪、 维生素、 微量元素、 纤维素等， 具有开发高营养、 高生物学功能食品的巨大潜力。但由于其遗传性较为复杂， 变异种类丰富， 在常规的育种过程中存在着周期过长、 变异系数过大、 影响子代生长发育的缺点， 而现代生物育种技术不但克服了上述缺点和不足， 同时也提高了育种速度和质量。 \n" +
            "玉米味道香甜，可做各式菜肴，如玉米烙、玉米汁等，它也是工业酒精和烧酒的主要原料。","广义水稻区别于旱稻；狭义水稻指淡水稻，区别于海水稻等。\n" +
            "按稻谷类型，水稻可以分为籼稻和粳稻、早稻和中晚稻，糯稻和非糯稻。还有其它分类，水稻一般栽培于水田，无土栽培的是水上稻。水稻一般没有一米高，2米左右的为新培育的巨型稻。\n" +
            "我国科学家袁隆平对杂交水稻的研究作出了巨大贡献，被誉为“杂交水稻之父”。水稻所结子实即稻谷，稻谷脱去颖壳后称糙米，糙米碾去米糠层即可得到大米。世界上近一半人口，都以大米为食。水稻除可食用外，还可以酿酒、制糖作工业原料，稻壳、稻秆，可以作为饲料。我国水稻主产区主要是东北地区、长江流域、珠江流域。属于直接经济作物。还是世界上三分之一人类的主食。也是北方人民的主要有机食品。2017年9月，袁隆平宣布一项剔除水稻中重金属镉的新成果。"};

    private int[]icon={R.mipmap.a,R.mipmap.b};
    private String[]iconName={"玉米","水稻"};
    private TextView textView;
    private ImageView imageView;
    private TextView textView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        Bundle bundle=this.getIntent().getExtras();
        int value=bundle.getInt("position");



        setContentView(R.layout.ol);
        imageView= (ImageView) findViewById(R.id.imageView);
        textView1= (TextView) findViewById(R.id.textView);
        textView= (TextView) findViewById(R.id.text);
        imageView.setImageResource(icon[value]);
        textView1.setText(iconName[value]);
        textView.setText(xiingxi[value]);
    }
}
