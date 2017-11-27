package com.xiaonian.web.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ryan on 16/3/14.
 */
public class Page {
    private Integer pageSize;
    private Integer pageIndex;
    private Integer rowCount;
    private boolean isSuccess;

    private String message;
    private Map<Object,Object> result = new HashMap<Object,Object>();


    public void addResult(Object key,Object value){
        result.put(key,value);
    }


    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public Map<Object, Object> getResult() {
        return result;
    }

    public void setResult(Map<Object, Object> result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getRowCount() {
        return rowCount;
    }

    public void setRowCount(Integer rowCount) {
        this.rowCount = rowCount;
    }
}
