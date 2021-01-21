package com.jy.mvplivrary.utils;

public class UrlConstant {
//    http://182.92.233.35:5840/api/

    //测试环境
//    public static String BASEURL = "http://182.92.233.35:5840/";
    //正式环境
    public static String BASE_URL = "http://123.57.141.103:5710/";
    //首页
    //Banner
    public static String HOME_BANNER="course/api/adv/list";


    /*"course/app/api/course/category/list";//课程分类接口   一级     参数为type   默认为0

        "course/app/api/grade/list";//分类下班级的展示
    二级   参数为：
    {"categoryId1":"一级id","categoryId2":"二级id","type":"0"}*/

    //首页列表一级数据
    public static String HOME_CAREGORY = "course/app/api/course/category/list";
    //首页列表二级数据
    public static String HOME_CLASSIFYSCOED = "course/app/api/grade/list";

}
