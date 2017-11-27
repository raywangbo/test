package com.xiaonian.core.entity;

import java.util.Date;

/**
 * 代码生成实体类
 * 
 * @author qqjbest
 * @since 2017年5月24日 上午10:53:31
 */
public class Generator
{
	String tableName;
	String engine;
	String tableComment;
	Date createTime;
	public String getTableName()
	{
		return tableName;
	}
	public void setTableName(String tableName)
	{
		this.tableName = tableName;
	}
	public String getEngine()
	{
		return engine;
	}
	public void setEngine(String engine)
	{
		this.engine = engine;
	}
	public String getTableComment()
	{
		return tableComment;
	}
	public void setTableComment(String tableComment)
	{
		this.tableComment = tableComment;
	}
	public Date getCreateTime()
	{
		return createTime;
	}
	public void setCreateTime(Date createTime)
	{
		this.createTime = createTime;
	}
}
