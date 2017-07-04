package yushuangming.test01.u2.bean;

import org.litepal.crud.DataSupport;

/**
 * Created by Administrator on 2017/6/20.
 */

public class XingZuo extends DataSupport {
    private String riqi,xingzuo,xingzuoming;

    public XingZuo() {
    }

    public XingZuo(String riqi, String xingzuo, String xingzuoming) {
        this.riqi = riqi;
        this.xingzuo = xingzuo;
        this.xingzuoming = xingzuoming;
    }

    public String getRiqi() {
        return riqi;
    }

    public void setRiqi(String riqi) {
        this.riqi = riqi;
    }

    public String getXingzuo() {
        return xingzuo;
    }

    public void setXingzuo(String xingzuo) {
        this.xingzuo = xingzuo;
    }

    public String getXingzuoming() {
        return xingzuoming;
    }

    public void setXingzuoming(String xingzuoming) {
        this.xingzuoming = xingzuoming;
    }
}
