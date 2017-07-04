package yushuangming.test01.u2.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/6/27.
 */

public class JieMentDetail {

    /**
     * result : 0
     * msg : success
     * data : {"title":"梦见汽车着火","id":"2142","cid":"14","name":"物品类","content":[{"title":"梦见汽车着火","content":"梦见汽车着火了，在梦中火代表了好运与财运。这预示着最近有意外之财，或者你正在努力的事情有意想不到的收获。\r\n梦见汽车着火了，将火扑灭，预示你与机会失之交臂。\r\n梦见汽车着火了，怎么都无法扑灭，火越烧越大。预示最近有很好的事情发生，但是要多加小心，否则可能会节外生枝。"}]}
     */

    private int result;
    private String msg;
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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * title : 梦见汽车着火
         * id : 2142
         * cid : 14
         * name : 物品类
         * content : [{"title":"梦见汽车着火","content":"梦见汽车着火了，在梦中火代表了好运与财运。这预示着最近有意外之财，或者你正在努力的事情有意想不到的收获。\r\n梦见汽车着火了，将火扑灭，预示你与机会失之交臂。\r\n梦见汽车着火了，怎么都无法扑灭，火越烧越大。预示最近有很好的事情发生，但是要多加小心，否则可能会节外生枝。"}]
         */

        private String title;
        private String id;
        private String cid;
        private String name;
        private List<ContentBean> content;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

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

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<ContentBean> getContent() {
            return content;
        }

        public void setContent(List<ContentBean> content) {
            this.content = content;
        }

        public static class ContentBean {
            /**
             * title : 梦见汽车着火
             * content : 梦见汽车着火了，在梦中火代表了好运与财运。这预示着最近有意外之财，或者你正在努力的事情有意想不到的收获。
             梦见汽车着火了，将火扑灭，预示你与机会失之交臂。
             梦见汽车着火了，怎么都无法扑灭，火越烧越大。预示最近有很好的事情发生，但是要多加小心，否则可能会节外生枝。
             */

            private String title;
            private String content;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }
        }
    }
}
