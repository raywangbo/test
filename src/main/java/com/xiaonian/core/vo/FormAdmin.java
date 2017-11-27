package com.xiaonian.core.vo;

/**
 * 管理员表单对象
 * 
 * @author qqjbest
 * @since 2016年7月12日 下午10:55:00
 */
public class FormAdmin
{
	private Integer id;

    private String name;

    private String account;

    private boolean locked = false;
    
    private String roles;

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public boolean isLocked()
	{
		return locked;
	}

	public void setLocked(boolean locked)
	{
		this.locked = locked;
	}

	public String getRoles()
	{
		return roles;
	}

	public void setRoles(String roles)
	{
		this.roles = roles;
	}
	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}
}

