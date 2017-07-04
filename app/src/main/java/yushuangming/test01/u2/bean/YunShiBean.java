package yushuangming.test01.u2.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/6/19.
 */

public class YunShiBean {

    /**
     * result : 0
     * msg : success
     * write_result :
     * data : {"ul":[{"label":"整体运势","value":"0.80"},{"label":"爱情运势","value":"0.80"},{"label":"事业学业","value":"0.80"},{"label":"财富运势","value":"0.60"},{"label":"健康指数","value":"93%"},{"label":"商谈指数","value":"93%"},{"label":"幸运颜色","value":"蓝色"},{"label":"幸运数字","value":"8"},{"label":"速配星座","value":"白羊座"},{"label":"短评","value":"十分畅快的一天。"}],"cont":[{"label":"整体运势","value":"今天事事顺心，心情好，可以好好联络人际关系，给客户送上一些小礼物，也许会有惊喜哦。手上的投资项目上升空间大，会有很好的收益。与爱人彼此情投意合，爱情甜蜜。"},{"label":"爱情运势","value":"有爱情好运，单身者可以向心上人表白，会有好回应。"},{"label":"事业学业","value":"工作能够进行顺利，得到同事领导的信任。"},{"label":"财富运势","value":"钱财要小心管理，消费尽可能节制一点。"},{"label":"健康运势","value":"健康状况不断回升，吃得好睡得香。"}]}
     */

    private int result;
    private String msg;
    private String write_result;
    private DataBean data;

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

    public String getWrite_result() {
        return write_result;
    }

    public void setWrite_result(String write_result) {
        this.write_result = write_result;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private List<UlBean> ul;
        private List<ContBean> cont;

        public List<UlBean> getUl() {
            return ul;
        }

        public void setUl(List<UlBean> ul) {
            this.ul = ul;
        }

        public List<ContBean> getCont() {
            return cont;
        }

        public void setCont(List<ContBean> cont) {
            this.cont = cont;
        }

        public static class UlBean {
            /**
             * label : 整体运势
             * value : 0.80
             */

            private String label;
            private String value;

            public String getLabel() {
                return label;
            }

            public void setLabel(String label) {
                this.label = label;
            }

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }
        }

        public static class ContBean {
            /**
             * label : 整体运势
             * value : 今天事事顺心，心情好，可以好好联络人际关系，给客户送上一些小礼物，也许会有惊喜哦。手上的投资项目上升空间大，会有很好的收益。与爱人彼此情投意合，爱情甜蜜。
             */

            private String label;
            private String value;

            public String getLabel() {
                return label;
            }

            public void setLabel(String label) {
                this.label = label;
            }

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }
        }
    }
}
