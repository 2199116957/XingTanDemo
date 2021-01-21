package com.jy.xingtandemo.bean;

public class HomeBannerBody {
//      {\"advLocation\":\"7\",\"platShow\":\"0\"}
    private String advLocation;
    private String platShow;


    public String getAdvLocation() {
        return advLocation;
    }

    public void setAdvLocation(String advLocation) {
        this.advLocation = advLocation;
    }

    public String getPlatShow() {
        return platShow;
    }

    public void setPlatShow(String platShow) {
        this.platShow = platShow;
    }

    @Override
    public String toString() {
        return "HomeBannerBody{" +
                "advLocation='" + advLocation + '\'' +
                ", platShow='" + platShow + '\'' +
                '}';
    }
}
