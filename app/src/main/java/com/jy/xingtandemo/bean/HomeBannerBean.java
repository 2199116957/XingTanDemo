package com.jy.xingtandemo.bean;

import java.util.List;

public class HomeBannerBean {
    /**
     * code : 200
     * data : {"advList":[{"advImg":"https://xingtan-upload.oss-cn-shanghai.aliyuncs.com/course_pic/8d9d664da2ae4c1d92d6cf4305b19bca.jpg","advLocation":7,"advTarget":"_blank","advTitle":"app首页轮播","advUrl":"http://xingtanedu.com","id":"1338665453302530049","sort":1}]}
     * msg :
     */

    private Integer code;
    private DataDTO data;
    private String msg;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public DataDTO getData() {
        return data;
    }

    public void setData(DataDTO data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static class DataDTO {
        private List<AdvListDTO> advList;

        public List<AdvListDTO> getAdvList() {
            return advList;
        }

        public void setAdvList(List<AdvListDTO> advList) {
            this.advList = advList;
        }

        public static class AdvListDTO {
            /**
             * advImg : https://xingtan-upload.oss-cn-shanghai.aliyuncs.com/course_pic/8d9d664da2ae4c1d92d6cf4305b19bca.jpg
             * advLocation : 7
             * advTarget : _blank
             * advTitle : app首页轮播
             * advUrl : http://xingtanedu.com
             * id : 1338665453302530049
             * sort : 1
             */

            private String advImg;
            private Integer advLocation;
            private String advTarget;
            private String advTitle;
            private String advUrl;
            private String id;
            private Integer sort;

            public String getAdvImg() {
                return advImg;
            }

            public void setAdvImg(String advImg) {
                this.advImg = advImg;
            }

            public Integer getAdvLocation() {
                return advLocation;
            }

            public void setAdvLocation(Integer advLocation) {
                this.advLocation = advLocation;
            }

            public String getAdvTarget() {
                return advTarget;
            }

            public void setAdvTarget(String advTarget) {
                this.advTarget = advTarget;
            }

            public String getAdvTitle() {
                return advTitle;
            }

            public void setAdvTitle(String advTitle) {
                this.advTitle = advTitle;
            }

            public String getAdvUrl() {
                return advUrl;
            }

            public void setAdvUrl(String advUrl) {
                this.advUrl = advUrl;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public Integer getSort() {
                return sort;
            }

            public void setSort(Integer sort) {
                this.sort = sort;
            }
        }
    }
}
