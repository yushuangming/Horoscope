package yushuangming.test01.u2.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import yushuangming.test01.u2.R;
import yushuangming.test01.u2.bean.JieMentDetail;
import yushuangming.test01.u2.fragment.JieMentFragment;
import yushuangming.test01.u2.view.WrapContentViewPager;

public class JieMengDetailActivity extends AppCompatActivity {

    private WrapContentViewPager vp;
    private TextView tv;
    private TabLayout tl;
    private List<String> list = new ArrayList<>();
    private List<Fragment> fragmentList = new ArrayList<>();
    private JieMengDetailActivity.MyFragmentAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jie_meng_detail);
        tl = (TabLayout) findViewById(R.id.tl);
        vp = (WrapContentViewPager) findViewById(R.id.vp);
        tv = (TextView) findViewById(R.id.tv);
        tv.setText("周公解梦");
        int id = getIntent().getIntExtra("id", 1);
        x.http().get(new RequestParams("http://aliyun.zhanxingfang.com/zxf/appclient/zhougong_new.php?act=show_content&id=" + id), new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String s) {
                Gson gson = new Gson();
                JieMentDetail detail = gson.fromJson(s, JieMentDetail.class);
                List<JieMentDetail.DataBean.ContentBean> content = detail.getData().getContent();
                for (int i = 0; i < content.size(); i++) {
                    fragmentList.add(new JieMentFragment(content.get(i).getContent(),vp,i));
                    list.add(content.get(i).getTitle());
                }



                adapter = new JieMengDetailActivity.MyFragmentAdapter(getSupportFragmentManager());
                vp.setAdapter(adapter);
                vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                    @Override
                    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                    }

                    @Override
                    public void onPageSelected(int position) {
                        vp.resetHeight(position);
                    }

                    @Override
                    public void onPageScrollStateChanged(int state) {

                    }
                });
                vp.resetHeight(0);
                tl.setTabMode(TabLayout.MODE_FIXED);
                tl.setupWithViewPager(vp);

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

    }
    class MyFragmentAdapter extends FragmentStatePagerAdapter {

        public MyFragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return list.get(position);
        }

        @Override
        public int getItemPosition(Object object) {
            return PagerAdapter.POSITION_NONE;
        }
    }
}
