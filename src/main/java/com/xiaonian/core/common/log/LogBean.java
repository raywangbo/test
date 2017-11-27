package com.xiaonian.core.common.log;

public final class LogBean
{
	String remark;
    byte objType;
    byte operType;
	public String getRemark()
	{
		return remark;
	}
	public void setRemark(String remark)
	{
		this.remark = remark;
	}
	public byte getObjType()
	{
		return objType;
	}
	public void setObjType(byte objType)
	{
		this.objType = objType;
	}
	public byte getOperType()
	{
		return operType;
	}
	public void setOperType(byte operType)
	{
		this.operType = operType;
	}
}
