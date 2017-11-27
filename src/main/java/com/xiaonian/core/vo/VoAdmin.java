package com.xiaonian.core.vo;

import java.io.Serializable;


/**
 * 
 * 
 * @author qqjbest
 * @email qqjbest@sina.com
 * @date 2017年10月10日 15:21:19
 */
public class VoAdmin implements Serializable {
	private static final long serialVersionUID = 1L;
	//ID
	private Integer id;
	//姓名
	private String name;
	//账号
	private String account;
	//状态
	private Integer locked;
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getId() {
		return id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getAccount() {
		return account;
	}
	public void setLocked(Integer locked) {
		this.locked = locked;
	}
	public Integer getLocked() {
		return locked;
	}
}
