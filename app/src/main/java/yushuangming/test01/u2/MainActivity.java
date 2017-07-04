package yushuangming.test01.u2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

import yushuangming.test01.u2.activity.JieMengActivity;
import yushuangming.test01.u2.activity.MinSuActivity;
import yushuangming.test01.u2.activity.ShengXiaoActivity;
import yushuangming.test01.u2.activity.XingZuoActivity;
import yushuangming.test01.u2.bean.XingZuo;
import yushuangming.test01.u2.fragment.MainXingZuoYunShiFragment;

public class MainActivity extends AppCompatActivity {
    TextView xingzuo,shengxiao,cesuan,jiemeng;

    SharedPreferences sp;
    private ViewPager vp;
    private List<ImageView> imgs = new ArrayList<>();
    private int[] imgRes = {R.drawable.guangao1,R.drawable.guanggao2,R.drawable.guanggao3,R.drawable.guanggao4};
    private TextView jiazai,yunshi;
    private Timer timer;
    private int i = 0;
    private Handler handler;
    private LinearLayout ll;
    private FragmentManager manager;
    private MainXingZuoYunShiFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp = getSharedPreferences("xingzuo", MODE_PRIVATE);
        ll = (LinearLayout) findViewById(R.id.ll);
        jiemeng = (TextView) findViewById(R.id.jiemeng);
        jiazai = (TextView) findViewById(R.id.jiazai);
        cesuan = (TextView) findViewById(R.id.cesuan);
        yunshi = (TextView) findViewById(R.id.yunshi);

        vp = (ViewPager) findViewById(R.id.vp);
        if(sp.getString("xingzuo","").equals("")){
            SharedPreferences.Editor edit = sp.edit();
            edit.putString("xingzuoming","白羊座");
            edit.putInt("head", R.drawable.icon_sx_21);
            edit.putInt("index", 1);
            edit.commit();
        }
        List<XingZuo> xingzuo1 = DataSupport.where("xingzuo=?", sp.getString("xingzuo", "")).find(XingZuo.class);
        yunshi.setText(xingzuo1.get(0).getXingzuoming()+"运势");
        jiemeng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, JieMengActivity.class));
            }
        });
        cesuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,MinSuActivity.class));
            }
        });
        jiazai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,XingZuoActivity.class));
            }
        });
        shengxiao = (TextView) findViewById(R.id.shengxiao);
        shengxiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ShengXiaoActivity.class));
            }
        });
        xingzuo = (TextView) findViewById(R.id.xingzuo);
        xingzuo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, XingZuoActivity.class));
            }
        });
        addData();
        vp.setAdapter(new IVAdapter());

        handler = new Handler(Looper.getMainLooper());
       new Thread(new Runnable() {
           @Override
           public void run() {
               while (true) {
                   //每隔2秒 更新页面 下一个ViewPager
                   try {
                       Thread.sleep(2000);

                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }

                   runOnUiThread(new Runnable() {
                       @Override
                       public void run() {
                           //现在是UI线程
                           //更新
                           int position = vp.getCurrentItem();

                           if (position == imgRes.length-1) {
                               vp.setCurrentItem(0);

                           } else {
                               vp.setCurrentItem(++position);
                           }

                       }
                       });
               }

           }
       }).start();
        manager = getSupportFragmentManager();
        fragment = new MainXingZuoYunShiFragment();
        FragmentTransaction fm = manager.beginTransaction();
        fm.replace(R.id.ll1, fragment).commit();


        ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.dialog_item, null, false);
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
                                break;
                            case R.id.jinniu:
                                sp.edit().putString("xingzuo","taurus").commit();
                                sp.edit().putInt("head",R.drawable.icon_sx_22).commit();
                                sp.edit().putInt("index",2).commit();
                                break;
                            case R.id.shuangzi:
                                sp.edit().putString("xingzuo","gemini").commit();
                                sp.edit().putInt("head",R.drawable.icon_sx_23).commit();
                                sp.edit().putInt("index",3).commit();
                                break;
                            case R.id.jvxie:
                                sp.edit().putString("xingzuo","cancer").commit();
                                sp.edit().putInt("head",R.drawable.icon_sx_24).commit();
                                sp.edit().putInt("index",4).commit();
                                break;
                            case R.id.shizi:
                                sp.edit().putString("xingzuo","leo").commit();
                                sp.edit().putInt("head",R.drawable.icon_sx_25).commit();
                                sp.edit().putInt("index",5).commit();
                                break;
                            case R.id.chunv:
                                sp.edit().putString("xingzuo","virgo").commit();
                                sp.edit().putInt("head",R.drawable.icon_sx_26).commit();
                                sp.edit().putInt("index",6).commit();
                                break;
                            case R.id.tiancheng:
                                sp.edit().putString("xingzuo","libra").commit();
                                sp.edit().putInt("head",R.drawable.icon_sx_27).commit();
                                sp.edit().putInt("index",7).commit();
                                break;
                            case R.id.tianxie:
                                sp.edit().putString("xingzuo","scorpio").commit();
                                sp.edit().putInt("head",R.drawable.icon_sx_28).commit();
                                sp.edit().putInt("index",8).commit();
                                break;
                            case R.id.sheshou:
                                sp.edit().putString("xingzuo","sagittarius").commit();
                                sp.edit().putInt("head",R.drawable.icon_sx_29).commit();
                                sp.edit().putInt("index",9).commit();
                                break;
                            case R.id.mojie:
                                sp.edit().putString("xingzuo","capricorn").commit();
                                sp.edit().putInt("head",R.drawable.icon_sx_30).commit();
                                sp.edit().putInt("index",10).commit();
                                break;
                            case R.id.shuiping:
                                sp.edit().putString("xingzuo","aquarius").commit();
                                sp.edit().putInt("index",11).commit();
                                sp.edit().putInt("head",R.drawable.icon_sx_31).commit();
                                break;
                            case R.id.shuangyu:
                                sp.edit().putString("xingzuo","pisces").commit();
                                sp.edit().putInt("head",R.drawable.icon_sx_32).commit();
                                sp.edit().putInt("index",12).commit();
                                break;



                        }
                        show.cancel();
                        List<XingZuo> xingzuo1 = DataSupport.where("xingzuo=?", sp.getString("xingzuo", "")).find(XingZuo.class);
                        yunshi.setText(xingzuo1.get(0).getXingzuoming()+"运势");
//                        manager = getSupportFragmentManager();
//                        fragment = new MainXingZuoYunShiFragment();
//                        FragmentTransaction fm = manager.beginTransaction();
//                        fm.replace(R.id.ll1, new MainXingZuoYunShiFragment()).commit();
                        MainXingZuoYunShiFragment fragment = new MainXingZuoYunShiFragment();
                        manager = getSupportFragmentManager();
                        FragmentTransaction fm = manager.beginTransaction();
                        fm.replace(R.id.ll1, fragment).commit();
                    }
                });

            }
        });
    }
    private void addData() {
        //网络
        for (int i = 0; i <imgRes.length; i++) {
            //动态添加
            ImageView imageView = new ImageView(this);
            //设置宽高
            //布局宽高的参数
            ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            //imageview设置了宽高
            imageView.setLayoutParams(params);
            //CENTER_CROP 居中裁剪
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            //ImageView

            //设置每一个Imageview的图片资源
            imageView.setImageResource(imgRes[i]);
            imgs.add(imageView);


        }



    }
    class IVAdapter extends PagerAdapter{

        @Override
        public int getCount() {
            return 4;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }
        @Override
        public ImageView instantiateItem(ViewGroup container, int position) {
            //添加当前视图到ViewPager中
            container.addView(imgs.get(position));
            return imgs.get(position);
        }
        @Override
        public void destroyItem(View container,int position,Object object){

            ((ViewGroup) container).removeView((View) object);

            object=null;

        }
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}
