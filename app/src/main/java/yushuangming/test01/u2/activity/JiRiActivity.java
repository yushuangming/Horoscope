package yushuangming.test01.u2.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import yushuangming.test01.u2.R;

public class JiRiActivity extends AppCompatActivity {
private WebView web;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ji_ri);
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
        web.loadUrl(getIntent().getStringExtra("url"));  //加载url
        web.requestFocus(); //获取焦点
    }
}
