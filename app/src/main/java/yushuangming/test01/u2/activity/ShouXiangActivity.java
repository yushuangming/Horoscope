package yushuangming.test01.u2.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import yushuangming.test01.u2.R;

public class ShouXiangActivity extends AppCompatActivity {

    private RadioGroup rp;
    private RadioButton rb;
    private WebView web;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shou_xiang);
        rp = (RadioGroup) findViewById(R.id.rp);
        rb = (RadioButton) findViewById(R.id.btn1);

        web = (WebView) findViewById(R.id.web);
        WebSettings settings = web.getSettings();
        settings.setJavaScriptEnabled(true);

        settings.setTextSize(WebSettings.TextSize.LARGER);
        web.setWebViewClient(new WebViewClient() {
            //当点击链接时,希望覆盖而不是打开新窗口
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);  //加载新的url
                return true;    //返回true,代表事件已处理,事件流到此终止
            }
        });


        rp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.btn1:
                        web.loadUrl("http://aliyun.zhanxingfang.com/zxf/m/shouxiangsuanming/cs_sxgq.html");  //加载url
                        web.requestFocus(); //获取焦点
                        break;
                    case R.id.btn2:
                        web.loadUrl("http://aliyun.zhanxingfang.com/zxf/m/shouxiangsuanming/cs_sxsy.html");  //加载url
                        web.requestFocus(); //获取焦点
                        break;
                    case R.id.btn3:
                        web.loadUrl("http://aliyun.zhanxingfang.com/zxf/m/shouxiangsuanming/cs_sxsm.html");  //加载url
                        web.requestFocus(); //获取焦点
                        break;

                }
            }
        });
        rp.check(R.id.btn1);
    }
}
