package com.xiaonian.core.entity;

/**
 * ${DESCRIPTION}
 *
 * @auther Administrator Ray
 * @create 2017/11/3
 */
public class Bank {
    private Integer bankId;
    private String code;
    private String subBranchName;
    private Integer provinceId;
    private Integer cityId;

    public Integer getBankId() {
        return bankId;
    }

    public void setBankId(Integer bankId) {
        this.bankId = bankId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return subBranchName;
    }

    public void setName(String name) {
        this.subBranchName = name;
    }

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }
}
