package yushuangming.test01.u2.activity;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.litepal.crud.DataSupport;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import yushuangming.test01.u2.R;
import yushuangming.test01.u2.bean.XingZuo;
import yushuangming.test01.u2.fragment.DangAnFragment;
import yushuangming.test01.u2.fragment.XingZuoYunShiFragment;


public class XingZuoActivity extends AppCompatActivity {

    private SharedPreferences sp;
    private TextView xinxi,xingzuo,riqi,yunshi,dangan;
    private LinearLayout ll;
    private ImageView xingZuoHead;
    private XingZuoYunShiFragment xingZuoYunShiFragment;
    private FragmentManager manager;
    private DangAnFragment dangAnFragment;
    private int a = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xing_zuo);
        ll = (LinearLayout) findViewById(R.id.ll);
        xingzuo = (TextView) findViewById(R.id.xingzuo);
        yunshi = (TextView) findViewById(R.id.yunshi);
        dangan = (TextView) findViewById(R.id.dangan);
        riqi = (TextView) findViewById(R.id.riqi);
        xingZuoHead = (ImageView) findViewById(R.id.xingzuohead);
        xingZuoYunShiFragment = new XingZuoYunShiFragment();
        manager = getSupportFragmentManager();
        FragmentTransaction fm = manager.beginTransaction();
        fm.replace(R.id.ll1, xingZuoYunShiFragment).commit();
        sp = getSharedPreferences("xingzuo", MODE_PRIVATE);
        yunshi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(a!=0){

                yunshi.setBackgroundColor(getResources().getColor(R.color.XingZuo));
                yunshi.setTextColor(Color.WHITE);
                dangan.setBackgroundColor(Color.WHITE);
                dangan.setTextColor(Color.BLACK);
                a = 0;
                xingZuoYunShiFragment = new XingZuoYunShiFragment();
                manager = getSupportFragmentManager();
                FragmentTransaction fm = manager.beginTransaction();
                fm.replace(R.id.ll1, xingZuoYunShiFragment).commit();
                }
            }
        });
        dangan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (a != 1) {

                dangan.setBackgroundColor(getResources().getColor(R.color.XingZuo));
                dangan.setTextColor(Color.WHITE);
                yunshi.setBackgroundColor(Color.WHITE);
                yunshi.setTextColor(Color.BLACK);
                a = 1;
                dangAnFragment = new DangAnFragment();
                manager = getSupportFragmentManager();
                FragmentTransaction fm = manager.beginTransaction();
                fm.replace(R.id.ll1, dangAnFragment).commit();
                }
            }
        });
        xinxi = (TextView) findViewById(R.id.xinxi);
        ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(XingZuoActivity.this);
                View view = LayoutInflater.from(XingZuoActivity.this).inflate(R.layout.dialog_item, null, false);
                RadioGroup rg = (RadioGroup) view.findViewById(R.id.rg);
                final AlertDialog show = builder.setView(view).show();
                rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        switch(checkedId){
                            case R.id.baiyang:
                                sp.edit().putString("xingzuo","aries").commit();
                                sp.edit().putInt("head",R.drawable.icon_sx_21).commit();
                                sp.edit().putInt("index",1).commit();
                                xingZuoHead.setImageResource(R.drawable.icon_sx_21);
                                break;
                            case R.id.jinniu:
                                sp.edit().putString("xingzuo","taurus").commit();
                                sp.edit().putInt("head",R.drawable.icon_sx_22).commit();
                                sp.edit().putInt("index",2).commit();
                                xingZuoHead.setImageResource(R.drawable.icon_sx_22);
                                break;
                            case R.id.shuangzi:
                                sp.edit().putString("xingzuo","gemini").commit();
                                sp.edit().putInt("head",R.drawable.icon_sx_23).commit();
                                sp.edit().putInt("index",3).commit();
                                xingZuoHead.setImageResource(R.drawable.icon_sx_23);
                                break;
                            case R.id.jvxie:
                                sp.edit().putString("xingzuo","cancer").commit();
                                sp.edit().putInt("head",R.drawable.icon_sx_24).commit();
                                sp.edit().putInt("index",4).commit();
                                xingZuoHead.setImageResource(R.drawable.icon_sx_24);
                                break;
                            case R.id.shizi:
                                sp.edit().putString("xingzuo","leo").commit();
                                sp.edit().putInt("head",R.drawable.icon_sx_25).commit();
                                sp.edit().putInt("index",5).commit();
                                xingZuoHead.setImageResource(R.drawable.icon_sx_25);
                                break;
                            case R.id.chunv:
                                sp.edit().putString("xingzuo","virgo").commit();
                                sp.edit().putInt("head",R.drawable.icon_sx_26).commit();
                                sp.edit().putInt("index",6).commit();
                                xingZuoHead.setImageResource(R.drawable.icon_sx_26);
                                break;
                            case R.id.tiancheng:
                                sp.edit().putString("xingzuo","libra").commit();
                                sp.edit().putInt("head",R.drawable.icon_sx_27).commit();
                                sp.edit().putInt("index",7).commit();
                                xingZuoHead.setImageResource(R.drawable.icon_sx_27);
                                break;
                            case R.id.tianxie:
                                sp.edit().putString("xingzuo","scorpio").commit();
                                sp.edit().putInt("head",R.drawable.icon_sx_28).commit();
                                sp.edit().putInt("index",8).commit();
                                xingZuoHead.setImageResource(R.drawable.icon_sx_28);
                                break;
                            case R.id.sheshou:
                                sp.edit().putString("xingzuo","sagittarius").commit();
                                sp.edit().putInt("head",R.drawable.icon_sx_29).commit();
                                sp.edit().putInt("index",9).commit();
                                xingZuoHead.setImageResource(R.drawable.icon_sx_29);
                                break;
                            case R.id.mojie:
                                sp.edit().putString("xingzuo","capricorn").commit();
                                sp.edit().putInt("head",R.drawable.icon_sx_30).commit();
                                sp.edit().putInt("index",10).commit();
                                xingZuoHead.setImageResource(R.drawable.icon_sx_30);
                                break;
                            case R.id.shuiping:
                                sp.edit().putString("xingzuo","aquarius").commit();
                                sp.edit().putInt("index",11).commit();
                                sp.edit().putInt("head",R.drawable.icon_sx_31).commit();
                                xingZuoHead.setImageResource(R.drawable.icon_sx_31);
                                break;
                            case R.id.shuangyu:
                                sp.edit().putString("xingzuo","pisces").commit();
                                sp.edit().putInt("head",R.drawable.icon_sx_32).commit();
                                sp.edit().putInt("index",12).commit();
                                xingZuoHead.setImageResource(R.drawable.icon_sx_32);
                                break;



                        }
                        getData();
                        show.cancel();
                        if(a==0){

                        xingZuoYunShiFragment = new XingZuoYunShiFragment();
                        manager = getSupportFragmentManager();
                        FragmentTransaction fm = manager.beginTransaction();
                        fm.replace(R.id.ll1, xingZuoYunShiFragment).commit();
                        }else{
                            dangAnFragment = new DangAnFragment();
                            manager = getSupportFragmentManager();
                            FragmentTransaction fm = manager.beginTransaction();
                            fm.replace(R.id.ll1,dangAnFragment).commit();
                        }
                    }
                });

            }
        });


        try {
            InputStream xingzuo = getAssets().open(sp.getString("xingzuo", "") + ".txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(xingzuo));
            String line = "";
            StringBuffer sb = new StringBuffer();
            while((line = reader.readLine())!=null){
                sb.append(line);
            }
            xinxi.setText(sb.toString());
//            this.xingzuo.setText(sp.getString("xingzuoming",""));
//            this.riqi.setText(sp.getString("riqi",""));
            List<XingZuo> xingzuo1 = DataSupport.where("xingzuo=?", sp.getString("xingzuo", "")).find(XingZuo.class);
            this.xingzuo.setText(xingzuo1.get(0).getXingzuoming());
            this.riqi.setText(xingzuo1.get(0).getRiqi());
            this.xingZuoHead.setImageResource(sp.getInt("head",0));

        } catch (IOException e) {
            e.printStackTrace();
        }



    }
    private void getData() {

        try {
            InputStream xingzuo = getAssets().open(sp.getString("xingzuo", "") + ".txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(xingzuo));
            String line = "";
            StringBuffer sb = new StringBuffer();
            while((line = reader.readLine())!=null){
                sb.append(line);
            }
            xinxi.setText(sb.toString());
//            this.xingzuo.setText(sp.getString("xingzuoming",""));
//            this.riqi.setText(sp.getString("riqi",""));
            List<XingZuo> xingzuo1 = DataSupport.where("xingzuo=?", sp.getString("xingzuo", "")).find(XingZuo.class);
            this.xingzuo.setText(xingzuo1.get(0).getXingzuoming());
            this.riqi.setText(xingzuo1.get(0).getRiqi());


        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
