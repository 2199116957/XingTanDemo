package com.jy.xingtandemo.bean;

import java.util.List;

public class HomeCaregoryBean {

    /**
     * code : 200
     * msg :
     * data : {"courseCategoryList":[{"id":"1325280683323973633","categoryName":"执业医师","floor":1,"remark":null,"subList":[{"id":"1325641143281934337","categoryName":"临床助理","floor":2,"remark":null,"subList":[]},{"id":"1325641175901036545","categoryName":"临床执业","floor":2,"remark":null,"subList":[]},{"id":"1340140241271795714","categoryName":"中医执业","floor":2,"remark":null,"subList":[]},{"id":"1340140286167625729","categoryName":"中医助理","floor":2,"remark":null,"subList":[]},{"id":"1340140325992542210","categoryName":"中西医执业","floor":2,"remark":null,"subList":[]},{"id":"1340140359345647617","categoryName":"中西医助理","floor":2,"remark":null,"subList":[]},{"id":"1340140403192901633","categoryName":"乡村全科助理","floor":2,"remark":null,"subList":[]}]},{"id":"1325634667888926721","categoryName":"执业药师","floor":1,"remark":null,"subList":[{"id":"1325634726881812482","categoryName":"精讲班","floor":2,"remark":null,"subList":[]},{"id":"1325634757340848130","categoryName":"一年取证班","floor":2,"remark":null,"subList":[]},{"id":"1325637909460967426","categoryName":"VIP班","floor":2,"remark":null,"subList":[]},{"id":"1325637940947607553","categoryName":"高端协议班","floor":2,"remark":null,"subList":[]},{"id":"1325640672114794497","categoryName":"终极取证班","floor":2,"remark":null,"subList":[]},{"id":"1325640724543594497","categoryName":"导师班","floor":2,"remark":null,"subList":[]}]},{"id":"1325642812321325058","categoryName":"健康管理师","floor":1,"remark":null,"subList":[{"id":"1340142770206420994","categoryName":"健康管理师","floor":2,"remark":null,"subList":[]}]},{"id":"1325642922929315841","categoryName":"职称药师","floor":1,"remark":null,"subList":[{"id":"1339496179443314689","categoryName":"初级师（药学）","floor":2,"remark":null,"subList":[]},{"id":"1339496213492674562","categoryName":"初级师（中药学）","floor":2,"remark":null,"subList":[]},{"id":"1340192884572696577","categoryName":"初级士（中药学）","floor":2,"remark":null,"subList":[]},{"id":"1340192942366011393","categoryName":"初级士（药学）","floor":2,"remark":null,"subList":[]},{"id":"1340192998112505857","categoryName":"中级（中药学）","floor":2,"remark":null,"subList":[]},{"id":"1340193049815691265","categoryName":"中级（药学）","floor":2,"remark":null,"subList":[]}]},{"id":"1326446226219360258","categoryName":"中医（专长）","floor":1,"remark":null,"subList":[{"id":"1341255252949995521","categoryName":"中医（专长）","floor":2,"remark":null,"subList":[]}]},{"id":"1339081418075418625","categoryName":"学历提升","floor":1,"remark":null,"subList":[{"id":"1340142243385061377","categoryName":"高起专","floor":2,"remark":null,"subList":[]},{"id":"1340142269532352513","categoryName":"高起本","floor":2,"remark":null,"subList":[]},{"id":"1340142296942129154","categoryName":"专升本","floor":2,"remark":null,"subList":[]},{"id":"1340142331712909314","categoryName":"申硕","floor":2,"remark":null,"subList":[]}]},{"id":"1340142191765762050","categoryName":"技能培训","floor":1,"remark":null,"subList":[{"id":"1340143061693771778","categoryName":"中医适宜技术推广","floor":2,"remark":null,"subList":[]},{"id":"1341286912789712898","categoryName":"职业技能证书","floor":2,"remark":null,"subList":[]}]}]}
     */

    private Integer code;
    private String msg;
    private DataBean data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
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
        private List<CourseCategoryListBean> courseCategoryList;

        public List<CourseCategoryListBean> getCourseCategoryList() {
            return courseCategoryList;
        }

        public void setCourseCategoryList(List<CourseCategoryListBean> courseCategoryList) {
            this.courseCategoryList = courseCategoryList;
        }

        public static class CourseCategoryListBean {
            /**
             * id : 1325280683323973633
             * categoryName : 执业医师
             * floor : 1
             * remark : null
             * subList : [{"id":"1325641143281934337","categoryName":"临床助理","floor":2,"remark":null,"subList":[]},{"id":"1325641175901036545","categoryName":"临床执业","floor":2,"remark":null,"subList":[]},{"id":"1340140241271795714","categoryName":"中医执业","floor":2,"remark":null,"subList":[]},{"id":"1340140286167625729","categoryName":"中医助理","floor":2,"remark":null,"subList":[]},{"id":"1340140325992542210","categoryName":"中西医执业","floor":2,"remark":null,"subList":[]},{"id":"1340140359345647617","categoryName":"中西医助理","floor":2,"remark":null,"subList":[]},{"id":"1340140403192901633","categoryName":"乡村全科助理","floor":2,"remark":null,"subList":[]}]
             */

            private String id;
            private String categoryName;
            private Integer floor;
            private Object remark;
            private List<SubListBean> subList;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getCategoryName() {
                return categoryName;
            }

            public void setCategoryName(String categoryName) {
                this.categoryName = categoryName;
            }

            public Integer getFloor() {
                return floor;
            }

            public void setFloor(Integer floor) {
                this.floor = floor;
            }

            public Object getRemark() {
                return remark;
            }

            public void setRemark(Object remark) {
                this.remark = remark;
            }

            public List<SubListBean> getSubList() {
                return subList;
            }

            public void setSubList(List<SubListBean> subList) {
                this.subList = subList;
            }

            public static class SubListBean {
                /**
                 * id : 1325641143281934337
                 * categoryName : 临床助理
                 * floor : 2
                 * remark : null
                 * subList : []
                 */

                private String id;
                private String categoryName;
                private Integer floor;
                private Object remark;
                private List<?> subList;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getCategoryName() {
                    return categoryName;
                }

                public void setCategoryName(String categoryName) {
                    this.categoryName = categoryName;
                }

                public Integer getFloor() {
                    return floor;
                }

                public void setFloor(Integer floor) {
                    this.floor = floor;
                }

                public Object getRemark() {
                    return remark;
                }

                public void setRemark(Object remark) {
                    this.remark = remark;
                }

                public List<?> getSubList() {
                    return subList;
                }

                public void setSubList(List<?> subList) {
                    this.subList = subList;
                }
            }
        }
    }
}
