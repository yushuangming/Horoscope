package yushuangming.test01.u2.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import yushuangming.test01.u2.R;

public class MinSuActivity extends AppCompatActivity {
TextView shouxiang,jiri,jishi,jiehun,shouji,chepai,huangli,jieqi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_min_su);
        shouxiang = (TextView) findViewById(R.id.shouxiang);
        jiri = (TextView) findViewById(R.id.jiri);
        jishi = (TextView) findViewById(R.id.jishi);
        jiehun = (TextView) findViewById(R.id.jiehun);
        shouji = (TextView) findViewById(R.id.shouji);
        chepai = (TextView) findViewById(R.id.chepai);
        huangli = (TextView) findViewById(R.id.huangli);
        jieqi = (TextView) findViewById(R.id.jieqi);
        jieqi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MinSuActivity.this,JieqiActivity.class));
            }
        });
        huangli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MinSuActivity.this, JiRiActivity.class);
                intent.putExtra("url", "http://aliyun.zhanxingfang.com/zxf/web_free/lhl.php");
                startActivity(intent);
            }
        });
        chepai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MinSuActivity.this, JiRiActivity.class);
                intent.putExtra("url", "http://aliyun.zhanxingfang.com/zxf/web_free/car.php");
                startActivity(intent);
            }
        });
        shouji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MinSuActivity.this, JiRiActivity.class);
                intent.putExtra("url", "http://aliyun.zhanxingfang.com/zxf/web_free/mobile.php");
                startActivity(intent);
            }
        });
        jiehun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MinSuActivity.this, JiRiActivity.class);
                intent.putExtra("url", "http://aliyun.zhanxingfang.com/zxf/web_free/jhzr.php");
                startActivity(intent);
            }
        });
        jishi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MinSuActivity.this, JiRiActivity.class);
                intent.putExtra("url", "http://aliyun.zhanxingfang.com/zxf/web_free/jscx.php");
                startActivity(intent);
            }
        });
        jiri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MinSuActivity.this, JiRiActivity.class);
                intent.putExtra("url", "http://aliyun.zhanxingfang.com/zxf/web_free/jscx.php");
                startActivity(intent);
            }
        });
        shouxiang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MinSuActivity.this,ShouXiangActivity.class));
            }
        });
    }
}
