package com.xiaonian.core.vo;

import java.util.List;
import java.util.Map;

/**
 * excel 导出参数对象
 *
 * Created by qqjbest on 2017/10/16.
 **/
public class VoExport{
    //列数
    private Byte cloumnCount;
     //顶部标题
    private String topTitle;
    //列名数组
    private String[] cloumnTitles;
    //字段-与数据表对应
    private String[] fieldNames;
    //数据集合
    private List<Map<String,Object>> datas;
    //文件名称
    private String fileName;

    public String getTopTitle() {
        return topTitle;
    }

    public void setTopTitle(String topTitle) {
        this.topTitle = topTitle;
    }

    public String[] getCloumnTitles() {
        return cloumnTitles;
    }

    public void setCloumnTitles(String[] cloumnTitles) {
        this.cloumnTitles = cloumnTitles;
    }

    public String[] getFieldNames() {
        return fieldNames;
    }

    public void setFieldNames(String[] fieldNames) {
        this.fieldNames = fieldNames;
    }

    public List<Map<String, Object>> getDatas() {
        return datas;
    }

    public void setDatas(List<Map<String, Object>> datas) {
        this.datas = datas;
    }

    public Byte getCloumnCount() {
        return cloumnCount;
    }

    public void setCloumnCount(Byte cloumnCount) {
        this.cloumnCount = cloumnCount;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
