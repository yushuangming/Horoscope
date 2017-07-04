package yushuangming.test01.u2.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import yushuangming.test01.u2.R;
import yushuangming.test01.u2.bean.JieMengDetail;

public class JieMentSouSuoActivity extends AppCompatActivity implements AbsListView.OnScrollListener {

    private ListView listView;
    private int index = 1;
    private EditText editText;
    private List<JieMengDetail.DataBean> list1 = new ArrayList<>();
    List<JieMengDetail.DataBean> data;
    private List<String> lists = new ArrayList<String>();
    private ArrayAdapter<String> adapter;
    // 创建handler接收消息并处理消息
    private View view_more;
    private ProgressBar pb;
    private TextView tvLoad;
    private int lastVisibleIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jie_ment_sou_suo);
        // 控件初始化
        initViews();
        editText = (EditText) findViewById(R.id.et);

        // 初始化数据
        initData();

    }

    private void initData() {
        // 模拟网络请求获取数据，一次获取15条
        RequestParams params = new RequestParams("http://aliyun.zhanxingfang.com/zxf/appclient/zhougong_new.php?act=get");
        params.addBodyParameter("cid", String.valueOf(getIntent().getIntExtra("id",20)));
        params.addBodyParameter("page", String.valueOf(index));
        params.addBodyParameter("page_num", String.valueOf(15));
        x.http().post(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String s) {
                Gson gson = new Gson();
                JieMengDetail detail = gson.fromJson(s, JieMengDetail.class);
                data = detail.getData();
                for (int i = 0; i < data.size(); i++) {
                    lists.add(data.get(i).getTitle());
                    list1.add(new JieMengDetail.DataBean(data.get(i).getCid(), data.get(i).getId(), data.get(i).getTitle()));
                }

                adapter = new ArrayAdapter<String>(JieMentSouSuoActivity.this,
                        R.layout.adapter_item, lists);
                // 设置adapter
                listView.setAdapter(adapter);
                // 添加底部加载布局
                listView.addFooterView(view_more);
                // 设置监听
                setListeners();
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

    private void setListeners() {
        if (data.size() == 15) {
            // listView设置滑动简监听
            listView.setOnScrollListener(this);
        } else {
            // 假如数据总数少于等于15条，直接移除底部的加载布局，不需要再加载更多的数据
            listView.removeFooterView(view_more);
        }
    }

    private void initViews() {
        listView = (ListView) findViewById(R.id.listView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(JieMentSouSuoActivity.this, JieMengDetailActivity.class);
                String id1 = list1.get(position).getId();
                intent.putExtra("id", Integer.parseInt(id1));
                startActivity(intent);
            }
        });
        // 构建底部加载布局
        view_more = (View) getLayoutInflater()
                .inflate(R.layout.view_more, null);
        // 进度条
        pb = (ProgressBar) view_more.findViewById(R.id.progressBar);
        // “正在加载...”文本控件
        tvLoad = (TextView) view_more.findViewById(R.id.tv_Load);
    }

    /**
     * 监听listView的滑动状态的改变
     */
    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        Log.e("TAG", "lastVisibleIndex = " + lastVisibleIndex);
        Log.e("TAG", "adapter.getCount() = " + adapter.getCount());
        // 滑到底部后自动加载，判断listView已经停止滚动并且最后可视的条目等于adapter的条目
        // 注意这里在listView设置好adpter后，加了一个底部加载布局。
        // 所以判断条件为：lastVisibleIndex == adapter.getCount()
        if (scrollState == SCROLL_STATE_IDLE
                && lastVisibleIndex == adapter.getCount()) {
            /**
             * 这里也要设置为可见，是因为当你真正从网络获取数据且获取失败的时候。
             * 我在失败的方法里面，隐藏了底部的加载布局并提示用户加载失败。所以再次监听的时候需要
             * 继续显示隐藏的控件。因为我模拟的获取数据，失败的情况这里不给出。实际中简单的加上几句代码就行了。
             */
            pb.setVisibility(View.VISIBLE);
            tvLoad.setVisibility(View.VISIBLE);
            loadMoreData();// 加载更多数据
        }
    }

    private void loadMoreData() {
        index++;

        if (data.size() < 15) {
            listView.removeFooterView(view_more);

        }else{
            RequestParams params = new RequestParams("http://aliyun.zhanxingfang.com/zxf/appclient/zhougong_new.php?act=get");
            params.addBodyParameter("cid", String.valueOf(getIntent().getIntExtra("id",20)));
            params.addBodyParameter("page", String.valueOf(index));
            params.addBodyParameter("page_num", String.valueOf(15));
            x.http().post(params, new Callback.CommonCallback<String>() {
                @Override
                public void onSuccess(String s) {
                    Gson gson = new Gson();
                    JieMengDetail detail = gson.fromJson(s, JieMengDetail.class);
                    data = detail.getData();
                    for (int i = 0; i < data.size(); i++) {
                        lists.add(data.get(i).getTitle());
                        list1.add(new JieMengDetail.DataBean(data.get(i).getCid(), data.get(i).getId(), data.get(i).getTitle()));
                    }

                    adapter.notifyDataSetChanged();
                    // 设置adapter



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

    }

    /**
     * 监听listView的滑动
     */
    @Override
    public void onScroll(AbsListView view, int firstVisibleItem,
                         int visibleItemCount, int totalItemCount) {
        // 计算最后可见条目的索引
        lastVisibleIndex = firstVisibleItem + visibleItemCount - 1;
        // 当adapter中的所有条目数已经和要加载的数据总条数相等时，则移除底部的View
        if (totalItemCount == data.size()*index) {
            // 移除底部的加载布局
            listView.removeFooterView(view_more);
        }

    }

    public void sousuo(View view) {
//        http://aliyun.zhanxingfang.com/zxf/appclient/zhougong.php?act=search_title
        if(editText.getText().toString().equals("")){
            Toast.makeText(this, "不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        lists.clear();
        RequestParams params = new RequestParams("http://aliyun.zhanxingfang.com/zxf/appclient/zhougong.php?act=search_title");
        params.addBodyParameter("keyword", editText.getText().toString());
        x.http().post(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String s) {
                Gson gson = new Gson();
                JieMengDetail detail = gson.fromJson(s, JieMengDetail.class);
                data = detail.getData();
                for (int i = 0; i < data.size(); i++) {
                    lists.add(data.get(i).getTitle());
                    list1.add(new JieMengDetail.DataBean(data.get(i).getCid(), data.get(i).getId(), data.get(i).getTitle()));
                }

                adapter = new ArrayAdapter<String>(JieMentSouSuoActivity.this,
                        R.layout.adapter_item, lists);
                // 设置adapter
                listView.setAdapter(adapter);
                // 添加底部加载布局
                listView.addFooterView(view_more);
                // 设置监听
                setListeners();
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

}
