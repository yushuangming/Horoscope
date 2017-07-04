package yushuangming.test01.u2.fragment;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import yushuangming.test01.u2.R;
import yushuangming.test01.u2.activity.DangAnActivity;
import yushuangming.test01.u2.bean.DangAn;
import yushuangming.test01.u2.view.ListViewForScrollView;

/**
 * A simple {@link Fragment} subclass.
 */
public class DangAnFragment extends Fragment {



    private View view;
    private ListViewForScrollView lv;
    private SharedPreferences sp;
    private TextView tv00,tv01,tv02,tv03,tv04,tv05,tv06,tv07,tv08,tv09,tv10,tv11,tv12,tv13,tv14;
    List<DangAn.BaiyangBean.GuanJianZiBean> guanJianZi;
    private List<Integer> listColor = new ArrayList<>();
    public DangAnFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_dang_an, container, false);
        lv = (ListViewForScrollView) view.findViewById(R.id.lv);
        sp = getContext().getSharedPreferences("xingzuo", Context.MODE_PRIVATE);
        tv00 = (TextView) view.findViewById(R.id.tv00);
        tv01 = (TextView) view.findViewById(R.id.tv01);
        tv02 = (TextView) view.findViewById(R.id.tv02);
        tv03 = (TextView) view.findViewById(R.id.tv03);
        tv04 = (TextView) view.findViewById(R.id.tv04);
        tv05 = (TextView) view.findViewById(R.id.tv05);
        tv06 = (TextView) view.findViewById(R.id.tv06);
        tv07 = (TextView) view.findViewById(R.id.tv07);
        tv08 = (TextView) view.findViewById(R.id.tv08);
        tv09 = (TextView) view.findViewById(R.id.tv09);
        tv10 = (TextView) view.findViewById(R.id.tv10);
        tv11 = (TextView) view.findViewById(R.id.tv11);
        tv12 = (TextView) view.findViewById(R.id.tv12);
        tv13 = (TextView) view.findViewById(R.id.tv13);
        tv14 = (TextView) view.findViewById(R.id.tv14);
        listColor.add(R.drawable.dangan_guanjian_shape1);
        listColor.add(R.drawable.dangan_guanjian_shape2);
        listColor.add(R.drawable.dangan_guanjian_shape3);
        listColor.add(R.drawable.dangan_guanjian_shape4);
        listColor.add(R.drawable.dangan_guanjian_shape5);
        listColor.add(R.drawable.dangan_guanjian_shape6);
        listColor.add(R.drawable.dangan_guanjian_shape7);
        lv.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {
                // TODO Auto-generated method stub
                lv.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });
        RequestParams params = new RequestParams("http://aliyun.zhanxingfang.com/zxf/m/xingzuo/" + sp.getInt("index", 1) + "/" + sp.getString("xingzuo", "") + ".txt");
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String s) {
                Gson gson =new Gson();
                DangAn dangAn = gson.fromJson(s, DangAn.class);
                List<DangAn.BaiyangBean.BiaoQianBean> biaoQian = dangAn.getBaiyang().getBiaoQian();

                guanJianZi = dangAn.getBaiyang().getGuanJianZi();
                tv00.setText(biaoQian.get(0).getText());
                tv01.setText(biaoQian.get(1).getText());
                tv02.setText(biaoQian.get(2).getText());
                tv03.setText(biaoQian.get(3).getText());
                tv04.setText(biaoQian.get(4).getText());
                tv05.setText(biaoQian.get(5).getText());
                tv06.setText(biaoQian.get(6).getText());
                tv07.setText(biaoQian.get(7).getText());
                tv08.setText(biaoQian.get(8).getText());
                tv09.setText(biaoQian.get(9).getText());
                tv10.setText(biaoQian.get(10).getText());
                tv11.setText(biaoQian.get(11).getText());
                tv12.setText(biaoQian.get(12).getText());
                tv13.setText(biaoQian.get(13).getText());
                tv14.setText(biaoQian.get(14).getText());
                lv.setAdapter(new DangAnAdapter());
                lv.setListViewHeight(lv);

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
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent= new Intent(getContext(), DangAnActivity.class);
                intent.putExtra("title", guanJianZi.get(position).getTitle());
                intent.putExtra("url", guanJianZi.get(position).getUrl());
                startActivity(intent);
            }
        });

        return view;
    }


    class DangAnAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return guanJianZi.size();
        }

        @Override
        public Object getItem(int position) {
            return guanJianZi.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.dangan_item, parent, false);
            TextView detail = (TextView) convertView.findViewById(R.id.detail);
            TextView title = (TextView) convertView.findViewById(R.id.title);
            title.setBackgroundResource(listColor.get(position));
            detail.setText(guanJianZi.get(position).getText());
            title.setText(guanJianZi.get(position).getTitle());
            return convertView;
        }
    }
}
