package yushuangming.test01.u2.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import yushuangming.test01.u2.R;
import yushuangming.test01.u2.bean.JieQi;
import yushuangming.test01.u2.view.HeaderGridView;

public class JieqiActivity extends AppCompatActivity {
    TextView tv;
    HeaderGridView gv;
    List<JieQi> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jieqi);
        tv = (TextView) findViewById(R.id.tv);
        tv.setText("节气查询");
        list.add(new JieQi(R.drawable.ms_icon3,"立春"));
        list.add(new JieQi(R.drawable.ms_icon4,"雨水"));
        list.add(new JieQi(R.drawable.ms_icon5,"惊蛰"));
        list.add(new JieQi(R.drawable.ms_icon6,"春分"));
        list.add(new JieQi(R.drawable.ms_icon7,"清明"));
        list.add(new JieQi(R.drawable.ms_icon8,"谷雨"));
        list.add(new JieQi(R.drawable.ms_icon9,"立夏"));
        list.add(new JieQi(R.drawable.ms_icon10,"小满"));
        list.add(new JieQi(R.drawable.ms_icon11,"芒种"));
        list.add(new JieQi(R.drawable.ms_icon12,"夏至"));
        list.add(new JieQi(R.drawable.ms_icon13,"小暑"));
        list.add(new JieQi(R.drawable.ms_icon14,"大暑"));
        list.add(new JieQi(R.drawable.ms_icon15,"立秋"));
        list.add(new JieQi(R.drawable.ms_icon16,"处暑"));
        list.add(new JieQi(R.drawable.ms_icon17,"白露"));
        list.add(new JieQi(R.drawable.ms_icon18,"秋分"));
        list.add(new JieQi(R.drawable.ms_icon19,"寒露"));
        list.add(new JieQi(R.drawable.ms_icon20,"霜降"));
        list.add(new JieQi(R.drawable.ms_icon21,"立冬"));
        list.add(new JieQi(R.drawable.ms_icon22,"小雪"));
        list.add(new JieQi(R.drawable.ms_icon23,"大雪"));
        list.add(new JieQi(R.drawable.ms_icon24,"冬至"));
        list.add(new JieQi(R.drawable.ms_icon25,"小寒"));
        list.add(new JieQi(R.drawable.ms_icon26,"大寒"));
        gv = (HeaderGridView) findViewById(R.id.gv);
        gv.addHeaderView(LayoutInflater.from(this).inflate(R.layout.jieqi_headview, null, false));
        gv.setAdapter(new MyAdapter());
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(JieqiActivity.this, DangAnActivity.class);
                intent.putExtra("title", list.get(position-4).getName());
                intent.putExtra("url","http://aliyun.zhanxingfang.com/zxf/m/24jieqi/"+(position-3)+".txt");

                startActivity(intent);
            }
        });
    }
    class MyAdapter extends BaseAdapter{

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
            convertView = LayoutInflater.from(JieqiActivity.this).inflate(R.layout.jieqi_item, parent, false);
            TextView name = (TextView) convertView.findViewById(R.id.name);
            ImageView img = (ImageView) convertView.findViewById(R.id.img);
            name.setText(list.get(position).getName());
            img.setImageResource(list.get(position).getImg());
            return convertView;
        }
    }
}
