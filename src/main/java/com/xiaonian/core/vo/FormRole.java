package com.xiaonian.core.vo;

/**
 * 角色表单对象
 * 
 * @author qqjbest
 * @since 2016年7月12日 下午10:11:38
 */
public class FormRole
{
	private Integer id;

    private String name;

    private String remark;

    private Byte status;

    private String strategys;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	public String getStrategys() {
		return strategys;
	}

	public void setStrategys(String strategys) {
		this.strategys = strategys;
	}
}

