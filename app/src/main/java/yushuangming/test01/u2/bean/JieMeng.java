package yushuangming.test01.u2.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/6/27.
 */

public class JieMeng {

    /**
     * result : 0
     * msg : success
     * data : [{"cid":"20","name":"身体类","create_time":"2015-02-04 20:25:47"},{"cid":"19","name":"鬼神类","create_time":"2015-02-04 20:25:42"},{"cid":"18","name":"情感类","create_time":"2015-02-04 20:25:32"},{"cid":"17","name":"建筑类","create_time":"2015-02-04 20:25:25"},{"cid":"16","name":"植物类","create_time":"2015-02-04 20:25:14"},{"cid":"15","name":"动物类","create_time":"2015-02-04 20:25:08"},{"cid":"14","name":"物品类","create_time":"2015-02-04 20:25:03"},{"cid":"13","name":"自然类","create_time":"2015-02-04 20:24:54"},{"cid":"12","name":"生活类","create_time":"2015-02-04 01:21:33"},{"cid":"11","name":"人物类","create_time":"2015-02-04 01:02:07"}]
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
        /**
         * cid : 20
         * name : 身体类
         * create_time : 2015-02-04 20:25:47
         */

        private String cid;
        private String name;
        private String create_time;

        public String getCid() {
            return cid;
        }

        public void setCid(String cid) {
            this.cid = cid;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCreate_time() {
            return create_time;
        }

        public void setCreate_time(String create_time) {
            this.create_time = create_time;
        }
    }
}
