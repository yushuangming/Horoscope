package yushuangming.test01.u2.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.List;

import yushuangming.test01.u2.R;
import yushuangming.test01.u2.bean.ShengXiao;

public class ShengXiaoActivity extends AppCompatActivity {
    private SharedPreferences sp;
    private ImageView iv;
    private TextView tv1,tv2,tv3,tv4,tv5,tv6,tv7,tv8,tv9,tv10,tv11,tv12,tv13,tv14,tv15,tv16,tv17,tv18;
    private int[] a = new int[]{R.drawable.sx_banner1,R.drawable.sx_banner2,R.drawable.sx_banner3,R.drawable.sx_banner4,R.drawable.sx_banner5,R.drawable.sx_banner6,R.drawable.sx_banner7,R.drawable.sx_banner8,R.drawable.sx_banner9,R.drawable.sx_banner10,R.drawable.sx_banner11,R.drawable.sx_banner12};
    private TextView tv_1,tv_2,tv_3,tv_4,tv_5,tv_6,tv_7,zhuanti,gexing;
    List<ShengXiao.DataBean.ZhuanTiDaQuanBean> zhuanTi;
    private SharedPreferences.Editor edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sheng_xiao);
        sp =  getSharedPreferences("xingzuo", MODE_PRIVATE);
        if (sp.getString("shengxiao", "").equals("")) {
            SharedPreferences.Editor edit = sp.edit();
            edit.putString("shengxiao","shu");
            edit.putInt("shengxiaoindex", 1);
            edit.putString("shengxiaoming","子鼠");
        }
        iv = (ImageView) findViewById(R.id.iv);
        zhuanti = (TextView) findViewById(R.id.zhuanti);
        gexing = (TextView) findViewById(R.id.gexing);
        tv_1 = (TextView) findViewById(R.id.tv_1);
        tv_2 = (TextView) findViewById(R.id.tv_2);
        tv_3 = (TextView) findViewById(R.id.tv_3);
        tv_4 = (TextView) findViewById(R.id.tv_4);
        tv_5 = (TextView) findViewById(R.id.tv_5);
        tv_6 = (TextView) findViewById(R.id.tv_6);
        tv_7 = (TextView) findViewById(R.id.tv_7);
        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        tv3 = (TextView) findViewById(R.id.tv3);
        tv4 = (TextView) findViewById(R.id.tv4);
        tv5 = (TextView) findViewById(R.id.tv5);
        tv6 = (TextView) findViewById(R.id.tv6);
        tv7 = (TextView) findViewById(R.id.tv7);
        tv8 = (TextView) findViewById(R.id.tv8);
        tv9 = (TextView) findViewById(R.id.tv9);
        tv10 = (TextView) findViewById(R.id.tv10);
        tv11 = (TextView) findViewById(R.id.tv11);
        tv12 = (TextView) findViewById(R.id.tv12);
        tv13 = (TextView) findViewById(R.id.tv13);
        tv14 = (TextView) findViewById(R.id.tv14);
        tv15 = (TextView) findViewById(R.id.tv15);
        tv16 = (TextView) findViewById(R.id.tv16);
        tv17 = (TextView) findViewById(R.id.tv17);
        tv18 = (TextView) findViewById(R.id.tv18);
        zhuanti.setText(sp.getString("shengxiaoming","子鼠")+"的专题大全");
        gexing.setText(sp.getString("shengxiaoming","子鼠")+"的个性标签");
        iv.setImageResource(a[sp.getInt("shengxiaoindex",1)-1]);
        x.http().get(new RequestParams("http://aliyun.zhanxingfang.com/zxf/m/shengxiao/" + sp.getInt("shengxiaoindex", 1) + "/" + sp.getString("shengxiao", "shu") + ".txt"), new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String s) {
                Gson gson = new Gson();
                ShengXiao shengXiao = gson.fromJson(s, ShengXiao.class);
                List<ShengXiao.DataBean.BiaoQianBean> biaoQian = shengXiao.getData().getBiaoQian();
                tv1.setText(biaoQian.get(0).getText());
                tv2.setText(biaoQian.get(1).getText());
                tv3.setText(biaoQian.get(2).getText());
                tv4.setText(biaoQian.get(3).getText());
                tv5.setText(biaoQian.get(4).getText());
                tv6.setText(biaoQian.get(5).getText());
                tv7.setText(biaoQian.get(6).getText());
                tv8.setText(biaoQian.get(7).getText());
                tv9.setText(biaoQian.get(8).getText());
                tv10.setText(biaoQian.get(9).getText());
                tv11.setText(biaoQian.get(10).getText());
                tv12.setText(biaoQian.get(11).getText());
                tv13.setText(biaoQian.get(12).getText());
                tv14.setText(biaoQian.get(13).getText());
                tv15.setText(biaoQian.get(14).getText());
                tv16.setText(biaoQian.get(15).getText());
                tv17.setText(biaoQian.get(14).getDes());
                tv18.setText(biaoQian.get(15).getDes());
                zhuanTi = shengXiao.getData().getZhuanTiDaQuan();
                tv_1.setText(zhuanTi.get(0).getTitle());
                tv_2.setText(zhuanTi.get(1).getTitle());
                tv_3.setText(zhuanTi.get(2).getTitle());
                tv_4.setText(zhuanTi.get(3).getTitle());
                tv_5.setText(zhuanTi.get(4).getTitle());
                tv_6.setText(zhuanTi.get(5).getTitle());
                tv_7.setText(zhuanTi.get(6).getTitle());
            }

            @Override
            public void onError(Throwable throwable, boolean b) {

            }

            @Override
            public void onCancelled(CancelledException e) {

            }

            @Override
            public void onFinished() {

            }
        });
        tv_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShengXiaoActivity.this, DangAnActivity.class);
                intent.putExtra("title", zhuanTi.get(0).getTitle());
                intent.putExtra("url", zhuanTi.get(0).getUrl());
                startActivity(intent);
            }
        });
    tv_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShengXiaoActivity.this, DangAnActivity.class);
                intent.putExtra("title", zhuanTi.get(1).getTitle());
                intent.putExtra("url", zhuanTi.get(1).getUrl());
                startActivity(intent);
            }
        });
    tv_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShengXiaoActivity.this, DangAnActivity.class);
                intent.putExtra("title", zhuanTi.get(2).getTitle());
                intent.putExtra("url", zhuanTi.get(2).getUrl());
                startActivity(intent);
            }
        });
    tv_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShengXiaoActivity.this, DangAnActivity.class);
                intent.putExtra("title", zhuanTi.get(3).getTitle());
                intent.putExtra("url", zhuanTi.get(3).getUrl());
                startActivity(intent);
            }
        });
    tv_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShengXiaoActivity.this, DangAnActivity.class);
                intent.putExtra("title", zhuanTi.get(4).getTitle());
                intent.putExtra("url", zhuanTi.get(4).getUrl());
                startActivity(intent);
            }
        });
    tv_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShengXiaoActivity.this, DangAnActivity.class);
                intent.putExtra("title", zhuanTi.get(5).getTitle());
                intent.putExtra("url", zhuanTi.get(5).getUrl());
                startActivity(intent);
            }
        });
    tv_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShengXiaoActivity.this, DangAnActivity.class);
                intent.putExtra("title", zhuanTi.get(6).getTitle());
                intent.putExtra("url", zhuanTi.get(6).getUrl());
                startActivity(intent);
            }
        });
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ShengXiaoActivity.this);
                View view = LayoutInflater.from(ShengXiaoActivity.this).inflate(R.layout.shengxiao_dialog_item,null,false);
                RadioGroup rg = (RadioGroup) view.findViewById(R.id.rg);
                final AlertDialog show = builder.setView(view).show();
                rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        switch(checkedId){
                            case R.id.zishu:
                                edit = sp.edit();
                                edit.putString("shengxiao","shu");
                                edit.putInt("shengxiaoindex", 1);
                                edit.putString("shengxiaoming","子鼠");
                                edit.commit();
                                break;
                            case R.id.chouniu:
                                edit = sp.edit();
                                edit.putString("shengxiao","niu");
                                edit.putInt("shengxiaoindex", 2);
                                edit.putString("shengxiaoming","丑牛");
                                edit.commit();
                                break;
                            case R.id.yinhu:
                                edit = sp.edit();
                                edit.putString("shengxiao","hu");
                                edit.putInt("shengxiaoindex", 3);
                                edit.putString("shengxiaoming","寅虎");
                                edit.commit();
                                break;
                            case R.id.maotu:
                                edit = sp.edit();
                                edit.putString("shengxiao","tu");
                                edit.putInt("shengxiaoindex", 4);
                                edit.putString("shengxiaoming","卯兔");
                                edit.commit();
                                break;
                            case R.id.chenlong:
                                edit = sp.edit();
                                edit.putString("shengxiao","long");
                                edit.putInt("shengxiaoindex", 5);
                                edit.putString("shengxiaoming","辰龙");
                                edit.commit();
                                break;
                            case R.id.yishe:
                                edit = sp.edit();
                                edit.putString("shengxiao","she");
                                edit.putInt("shengxiaoindex", 6);
                                edit.putString("shengxiaoming","巳蛇");
                                edit.commit();
                                break;
                            case R.id.wuma:
                                edit = sp.edit();
                                edit.putString("shengxiao","ma");
                                edit.putInt("shengxiaoindex", 7);
                                edit.putString("shengxiaoming","午马");
                                edit.commit();
                                break;
                            case R.id.weiyang:
                                edit = sp.edit();
                                edit.putString("shengxiao","yang");
                                edit.putInt("shengxiaoindex", 8);
                                edit.putString("shengxiaoming","未羊");
                                edit.commit();
                                break;
                            case R.id.shenhou:
                                edit = sp.edit();
                                edit.putString("shengxiao","hou");
                                edit.putInt("shengxiaoindex", 9);
                                edit.putString("shengxiaoming","申猴");
                                edit.commit();
                                break;
                            case R.id.youji:
                                edit = sp.edit();
                                edit.putString("shengxiao","ji");
                                edit.putInt("shengxiaoindex", 10);
                                edit.putString("shengxiaoming","酉鸡");
                                edit.commit();
                                break;
                            case R.id.xvgou:
                                edit = sp.edit();
                                edit.putString("shengxiao","gou");
                                edit.putInt("shengxiaoindex", 11);
                                edit.putString("shengxiaoming","戌狗");
                                edit.commit();
                                break;
                            case R.id.haizhu:
                                edit = sp.edit();
                                edit.putString("shengxiao","zhu");
                                edit.putInt("shengxiaoindex", 12);
                                edit.putString("shengxiaoming","亥猪");
                                edit.commit();
                                break;



                        }
                        iv.setImageResource(a[sp.getInt("shengxiaoindex",1)-1]);
                        zhuanti.setText(sp.getString("shengxiaoming","子鼠")+"的专题大全");
                        gexing.setText(sp.getString("shengxiaoming","子鼠")+"的个性标签");
                        x.http().get(new RequestParams("http://aliyun.zhanxingfang.com/zxf/m/shengxiao/" + sp.getInt("shengxiaoindex", 1) + "/" + sp.getString("shengxiao", "shu") + ".txt"), new Callback.CommonCallback<String>() {
                            @Override
                            public void onSuccess(String s) {
                                Gson gson = new Gson();
                                ShengXiao shengXiao = gson.fromJson(s, ShengXiao.class);
                                List<ShengXiao.DataBean.BiaoQianBean> biaoQian = shengXiao.getData().getBiaoQian();
                                tv1.setText(biaoQian.get(0).getText());
                                tv2.setText(biaoQian.get(1).getText());
                                tv3.setText(biaoQian.get(2).getText());
                                tv4.setText(biaoQian.get(3).getText());
                                tv5.setText(biaoQian.get(4).getText());
                                tv6.setText(biaoQian.get(5).getText());
                                tv7.setText(biaoQian.get(6).getText());
                                tv8.setText(biaoQian.get(7).getText());
                                tv9.setText(biaoQian.get(8).getText());
                                tv10.setText(biaoQian.get(9).getText());
                                tv11.setText(biaoQian.get(10).getText());
                                tv12.setText(biaoQian.get(11).getText());
                                tv13.setText(biaoQian.get(12).getText());
                                tv14.setText(biaoQian.get(13).getText());
                                tv15.setText(biaoQian.get(14).getText());
                                tv16.setText(biaoQian.get(15).getText());
                                tv17.setText(biaoQian.get(14).getDes());
                                tv18.setText(biaoQian.get(15).getDes());
                                zhuanTi = shengXiao.getData().getZhuanTiDaQuan();
                                tv_1.setText(zhuanTi.get(0).getTitle());
                                tv_2.setText(zhuanTi.get(1).getTitle());
                                tv_3.setText(zhuanTi.get(2).getTitle());
                                tv_4.setText(zhuanTi.get(3).getTitle());
                                tv_5.setText(zhuanTi.get(4).getTitle());
                                tv_6.setText(zhuanTi.get(5).getTitle());
                                tv_7.setText(zhuanTi.get(6).getTitle());
                            }

                            @Override
                            public void onError(Throwable throwable, boolean b) {

                            }

                            @Override
                            public void onCancelled(CancelledException e) {

                            }

                            @Override
                            public void onFinished() {

                            }
                        });
                        show.cancel();
                    }
                });


            }
        });

    }
}
