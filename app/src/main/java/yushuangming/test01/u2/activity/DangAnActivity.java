package yushuangming.test01.u2.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;

import yushuangming.test01.u2.R;

public class DangAnActivity extends AppCompatActivity {
    private TextView title;
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_an);
        title = (TextView) findViewById(R.id.title);
        webView = (WebView) findViewById(R.id.wv);
        Intent intent = getIntent();
        title.setText(intent.getStringExtra("title"));
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(intent.getStringExtra("url"));
        WebSettings settings = webView.getSettings();
        settings.setSupportZoom(true);
        settings.setTextSize(WebSettings.TextSize.LARGER);
    }
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()) {
            webView.goBack(); //goBack()表示返回WebView的上一页面
            return true;
        }else{
            finish();
        }
        return false;
    }

}
