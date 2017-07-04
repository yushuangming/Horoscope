package yushuangming.test01.u2.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/6/26.
 */

public class ShengXiao {

    /**
     * data : {"biaoQian":[{"title":"浜旇鍒嗘瀽锛�","text":"涓戝睘鍦�","des":"澶у悏锛屽ぉ鍋氳壇缂橈紝瀹堕亾澶х潃闃碉紝璐㈢洓瀹跺畞銆�"},{"title":"鏈懡浣涳細","text":"铏氱┖钘忚彥钀�"},{"title":"鍚夌ゥ棰滆壊锛�","text":"钃濄\u20ac佺孩銆佺传"},{"title":"澶у嚩棰滆壊锛�","text":"鐧借壊銆佺豢鑹�"},{"title":"骞歌繍鏁板瓧锛�","text":"1銆�9"},{"title":"澶у嚩鏁板瓧锛�","text":"3銆�4"},{"title":"骞歌繍鑺憋細","text":"閮侀噾棣欍\u20ac佷竾骞撮潚銆佹鑺�"},{"title":"鍚夌ゥ鏂逛綅锛�","text":"涓滃崡鏂广\u20ac佹鍗楁柟鍙婃鍖楁柟"},{"title":"浼樼偣","text":"娓╁帤鑰佸疄锛屾繁鎬濈啛铏戯紝鏈夋姳璐熴\u20ac�"},{"title":"缂虹偣","text":"鎷樿皑鍐锋紶锛屽浐鎵у繁瑙侊紝涓嶅杽娌熼\u20ac氥\u20ac�"},{"title":"浜嬩笟","text":"寰楀績搴旀墜锛屽ぇ鏈夊彲涓恒\u20ac�"},{"title":"鐖辨儏","text":"鐖辨啂鍒嗘槑锛岄娉㈡洸鎶橈紝涓焊骞宠　銆�"},{"title":"璐㈣繍","text":"杩愬娍楂樻定锛屽亸璐㈠皬鍚夈\u20ac�"},{"title":"鍋ュ悍","text":"鍋ュ悍鑹ソ锛屽叧娉ㄨ\u20ac抽蓟鍠夋棫鐥呭鍙戙\u20ac�"},{"title":"瀹滈厤","text":"榧犮\u20ac佽泧銆侀浮","des":"澶у悏锛屽ぉ鍋氳壇缂橈紝瀹堕亾澶х潃闃碉紝璐㈢洓瀹跺畞銆�"},{"title":"蹇岄厤","text":"椹\u20ac佺嫍銆佺緤","des":"鍚夊嚩鍚勬湁锛岀敇鑻﹀叡瀛橈紝鏃犺繘鍙栧績锛屽唴蹇冨蹇х枒鑻︽儴銆�"}],"zhuanTiDaQuan":[{"title":"鍏充簬灞炵墰鐨勪汉","url":"http://aliyun.zhanxingfang.com/zxf/m/shengxiao/2/1.txt"},{"title":"灞炵墰鐖辨儏濠氬Щ","url":"http://aliyun.zhanxingfang.com/zxf/m/shengxiao/2/2.txt"},{"title":"灞炵墰浠婂勾澶氬ぇ","url":"http://aliyun.zhanxingfang.com/zxf/m/shengxiao/2/3.txt"},{"title":"灞炵墰璐㈠瘜浜嬩笟","url":"http://aliyun.zhanxingfang.com/zxf/m/shengxiao/2/4.txt"},{"title":"灞炵墰鏈堜唤鍛借繍","url":"http://aliyun.zhanxingfang.com/zxf/m/shengxiao/2/5.txt"},{"title":"灞炵墰鏃惰景鎬ф牸","url":"http://aliyun.zhanxingfang.com/zxf/m/shengxiao/2/6.txt"},{"title":"鐢风墰鍜屽コ鐗涚殑灞炵浉濠氶厤琛�","url":"http://aliyun.zhanxingfang.com/zxf/m/shengxiao/2/7.txt"}],"shengXiaoJieDu":[{"title":"鍝簺鐢熻倴鑰愪笉浣忓瘋瀵�","url":"http://aliyun.zhanxingfang.com/zxf/m/shengxiao/2/8.txt"},{"title":"12鐢熻倴濡備綍鍌椇妗冭姳","url":"http://aliyun.zhanxingfang.com/zxf/m/shengxiao/2/9.txt"},{"title":"鍗佷簩鐢熻倴鐩哥埍鎸囧崡","url":"http://aliyun.zhanxingfang.com/zxf/m/shengxiao/2/10.txt"},{"title":"瓒婄湅瓒婅\u20ac愮湅鐨勭敓鑲栧コ","url":"http://aliyun.zhanxingfang.com/zxf/m/shengxiao/2/11.txt"},{"title":"鍝敓鑲栫殑浜虹敤鎯呮渶娣�","url":"http://aliyun.zhanxingfang.com/zxf/m/shengxiao/2/12.txt"},{"title":"鐢熻倴涓嶅悎璇ュ浣曞寲瑙�","url":"http://aliyun.zhanxingfang.com/zxf/m/shengxiao/2/13.txt"},{"title":"12鐢熻倴涓庢椂杈扮殑缁撳悎","url":"http://aliyun.zhanxingfang.com/zxf/m/shengxiao/2/14.txt"}]}
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private List<BiaoQianBean> biaoQian;
        private List<ZhuanTiDaQuanBean> zhuanTiDaQuan;
        private List<ShengXiaoJieDuBean> shengXiaoJieDu;

        public List<BiaoQianBean> getBiaoQian() {
            return biaoQian;
        }

        public void setBiaoQian(List<BiaoQianBean> biaoQian) {
            this.biaoQian = biaoQian;
        }

        public List<ZhuanTiDaQuanBean> getZhuanTiDaQuan() {
            return zhuanTiDaQuan;
        }

        public void setZhuanTiDaQuan(List<ZhuanTiDaQuanBean> zhuanTiDaQuan) {
            this.zhuanTiDaQuan = zhuanTiDaQuan;
        }

        public List<ShengXiaoJieDuBean> getShengXiaoJieDu() {
            return shengXiaoJieDu;
        }

        public void setShengXiaoJieDu(List<ShengXiaoJieDuBean> shengXiaoJieDu) {
            this.shengXiaoJieDu = shengXiaoJieDu;
        }

        public static class BiaoQianBean {
            /**
             * title : 浜旇鍒嗘瀽锛�
             * text : 涓戝睘鍦�
             * des : 澶у悏锛屽ぉ鍋氳壇缂橈紝瀹堕亾澶х潃闃碉紝璐㈢洓瀹跺畞銆�
             */

            private String title;
            private String text;
            private String des;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }

            public String getDes() {
                return des;
            }

            public void setDes(String des) {
                this.des = des;
            }
        }

        public static class ZhuanTiDaQuanBean {
            /**
             * title : 鍏充簬灞炵墰鐨勪汉
             * url : http://aliyun.zhanxingfang.com/zxf/m/shengxiao/2/1.txt
             */

            private String title;
            private String url;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }

        public static class ShengXiaoJieDuBean {
            /**
             * title : 鍝簺鐢熻倴鑰愪笉浣忓瘋瀵�
             * url : http://aliyun.zhanxingfang.com/zxf/m/shengxiao/2/8.txt
             */

            private String title;
            private String url;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }
    }
}
