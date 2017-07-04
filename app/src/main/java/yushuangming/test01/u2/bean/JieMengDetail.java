package yushuangming.test01.u2.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/6/27.
 */

public class JieMengDetail {

    /**
     * result : 0
     * msg : success
     * data : [{"id":"6683","cid":"20","title":"梦见眉毛"},{"id":"6681","cid":"20","title":"梦见舌头"},{"id":"6680","cid":"20","title":"梦见变瘦"},{"id":"6678","cid":"20","title":"梦见胳膊"},{"id":"6675","cid":"20","title":"梦见嘴唇"},{"id":"6674","cid":"20","title":"梦见瘸腿"},{"id":"6670","cid":"20","title":"梦见大腿"},{"id":"6669","cid":"20","title":"梦见女演员"},{"id":"6667","cid":"20","title":"梦见腹部"},{"id":"6664","cid":"20","title":"梦见鼻子"},{"id":"6662","cid":"20","title":"梦见大肚子"},{"id":"6659","cid":"20","title":"梦见断肢"},{"id":"6658","cid":"20","title":"梦见眼睛"},{"id":"6657","cid":"20","title":"梦见骨头"},{"id":"6653","cid":"20","title":"梦见肛门"}]
     */

    private int result;
    private String msg;
    private List<DataBean> data;

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        public DataBean(String cid, String id, String title) {
            this.cid = cid;
            this.id = id;
            this.title = title;
        }

        public DataBean() {
        }

        /**
         * id : 6683
         * cid : 20
         * title : 梦见眉毛
         */

        private String id;
        private String cid;
        private String title;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getCid() {
            return cid;
        }

        public void setCid(String cid) {
            this.cid = cid;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
