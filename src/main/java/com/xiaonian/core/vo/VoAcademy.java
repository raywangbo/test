package com.xiaonian.core.vo;

import java.io.Serializable;


/**
 * 
 * 
 * @author qqjbest
 * @email qqjbest@sina.com
 * @date 2017年10月09日 15:39:18
 */
public class VoAcademy implements Serializable {
	private static final long serialVersionUID = 1L;
	//
	private Integer id;
	//
	private Integer schoolId;
	//
	private String name;
	//
	private Long createTime;
	//
	private Long updateTime;
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getId() {
		return id;
	}
	public void setSchoolId(Integer schoolId) {
		this.schoolId = schoolId;
	}
	public Integer getSchoolId() {
		return schoolId;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}
	public Long getCreateTime() {
		return createTime;
	}
	public void setUpdateTime(Long updateTime) {
		this.updateTime = updateTime;
	}
	public Long getUpdateTime() {
		return updateTime;
	}
}
