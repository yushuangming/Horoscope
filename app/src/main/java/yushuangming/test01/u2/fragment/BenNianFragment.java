package yushuangming.test01.u2.fragment;


import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.List;

import butterknife.ButterKnife;
import yushuangming.test01.u2.R;
import yushuangming.test01.u2.bean.YunShiBean;
import yushuangming.test01.u2.view.WrapContentViewPager;

/**
 * A simple {@link Fragment} subclass.
 */
public class BenNianFragment extends Fragment {
    private String index = "";
    private WrapContentViewPager vp;
    private TextView tv00,tv01,tv02,tv03,tv04,tv_00,tv_01,tv_02,tv_03,tv_04;
    public BenNianFragment() {
        // Required empty public constructor
    }

    public BenNianFragment(String index, WrapContentViewPager vp) {
        this.index = index;
        this.vp = vp;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ben_nian, container, false);

        init(view);

        return view;
    }

    private void init(View view) {
        ButterKnife.bind(this, view);
        vp.setObjectForPosition(view,Integer.parseInt(index));
        tv00 = (TextView) view.findViewById(R.id.tv00);
        tv01 = (TextView) view.findViewById(R.id.tv01);
        tv02 = (TextView) view.findViewById(R.id.tv02);
        tv03 = (TextView) view.findViewById(R.id.tv03);
        tv04 = (TextView) view.findViewById(R.id.tv04);
        tv_00 = (TextView) view.findViewById(R.id.tv_00);
        tv_01 = (TextView) view.findViewById(R.id.tv_01);
        tv_02 = (TextView) view.findViewById(R.id.tv_02);
        tv_03 = (TextView) view.findViewById(R.id.tv_03);
        tv_04 = (TextView) view.findViewById(R.id.tv_04);
        RequestParams params = new RequestParams("http://aliyun.zhanxingfang.com/zxf/appclient/fortune.php");
        params.addBodyParameter("category",index);
        params.addBodyParameter("xingzuo",getContext().getSharedPreferences("xingzuo", Context.MODE_PRIVATE).getString("xingzuo",""));

        x.http().post(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(final String s) {
                Gson gson = new Gson();
                YunShiBean yunShiBean = gson.fromJson(s, YunShiBean.class);
                final List<YunShiBean.DataBean.UlBean> ul = yunShiBean.getData().getUl();
                final List<YunShiBean.DataBean.ContBean> cont = yunShiBean.getData().getCont();
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {

                        tv00.setText(""+getXing(ul.get(0).getValue())+"星");
                        tv01.setText(""+getXing(ul.get(1).getValue())+"星");
                        tv02.setText(""+getXing(ul.get(2).getValue())+"星");
                        tv03.setText(""+getXing(ul.get(3).getValue())+"星");
                        tv04.setText(ul.get(4).getValue());
                        tv_00.setText(cont.get(0).getValue());
                        tv_01.setText(cont.get(1).getValue());
                        tv_02.setText(cont.get(2).getValue());
                        tv_03.setText(cont.get(3).getValue());
                        tv_04.setText(cont.get(4).getValue());
                    }
                });
            }

            @Override
            public void onError(Throwable throwable, boolean b) {
                Log.d("sdf", throwable.toString());
            }

            @Override
            public void onCancelled(CancelledException e) {

            }

            @Override
            public void onFinished() {

            }
        });
    }

    public int getXing(String xing){
        double v = Double.parseDouble(xing);
        int v1 = (int) (v * 10 / 2);
        return v1;
    }

}
