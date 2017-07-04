package yushuangming.test01.u2.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import yushuangming.test01.u2.R;
import yushuangming.test01.u2.bean.JieMeng;
import yushuangming.test01.u2.bean.JieQi;

public class JieMengActivity extends AppCompatActivity {
    List<JieQi> list = new ArrayList<>();
    private GridView gv;
    private List<JieMeng.DataBean> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jie_meng);
        gv = (GridView) findViewById(R.id.gv);
        RequestParams params = new RequestParams("http://aliyun.zhanxingfang.com/zxf/appclient/zhougong.php?act=get_cats");
        params.addBodyParameter("act","get_cats");
        x.http().post(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String s) {
                Gson gson = new Gson();
                JieMeng jieMeng = gson.fromJson(s, JieMeng.class);
                data = jieMeng.getData();
                list.add(new JieQi(R.drawable.zgjm_icon1,data.get(0).getName()));
                list.add(new JieQi(R.drawable.zgjm_icon2,data.get(1).getName()));
                list.add(new JieQi(R.drawable.zgjm_icon3,data.get(2).getName()));
                list.add(new JieQi(R.drawable.zgjm_icon4,data.get(3).getName()));
                list.add(new JieQi(R.drawable.zgjm_icon5,data.get(4).getName()));
                list.add(new JieQi(R.drawable.zgjm_icon6,data.get(5).getName()));
                list.add(new JieQi(R.drawable.zgjm_icon7,data.get(6).getName()));
                list.add(new JieQi(R.drawable.zgjm_icon8,data.get(7).getName()));
                list.add(new JieQi(R.drawable.zgjm_icon9,data.get(8).getName()));
                list.add(new JieQi(R.drawable.zgjm_icon10,data.get(9).getName()));
                gv.setAdapter(new MyAdapter());
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
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(JieMengActivity.this, JieMentSouSuoActivity.class);
                intent.putExtra("id", data.get(position).getCid());
                startActivity(intent);
            }
        });
    }
    class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public JieQi getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = LayoutInflater.from(JieMengActivity.this).inflate(R.layout.jieqi_item, parent, false);
            TextView name = (TextView) convertView.findViewById(R.id.name);
            ImageView img = (ImageView) convertView.findViewById(R.id.img);
            name.setText(list.get(position).getName());
            img.setImageResource(list.get(position).getImg());
            return convertView;
        }
    }

}
