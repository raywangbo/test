package com.xiaonian.core.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xiaonian.core.bean.PagerBean;
import com.xiaonian.core.mapper.BaseMapper;
import com.xiaonian.core.service.IBaseService;
import com.xiaonian.core.utils.CommonUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * 泛型biz实现类
 * <p>
 * 
 * @author juvenile
 * @version 0.0.1
 * @since 2014年8月29日 下午3:34:17
 */
@SuppressWarnings("all")
public abstract class BaseService<T, Mapper extends BaseMapper<T>> implements IBaseService<T>
{
	public abstract Mapper getMapper();

	@Override
	public T getById(Integer id)
	{
		return getMapper().selectByPrimaryKey(id);
	}

	@Override
	public void getAll(PagerBean<T> pager)
	{
		if (pager.isPage())
		{
			Page<T> page = PageHelper.startPage(pager.getCurPage(), pager.getLimit());
			getMapper().getAllByMap(pager.getSearch());
			pager.setRowData(page.getResult());
			pager.setTotal((int) page.getTotal());
		}
		else
		{
			pager.setRowData(getMapper().getAllByMap(pager.getSearch()));
		}
	}

	@Override
	public List<T> getAll(Map<String, Object> Search)
	{
		return getMapper().getAllByMap(Search);
	}

	@Override
	public List<T> getAll()
	{
		return getMapper().getAllByMap(new HashMap<String, Object>());
	}

	@Override
	public void deleteByIds(String ids)
	{
		getMapper().deleteByPrimaryKeys(CommonUtil.strArray2intArray(ids.trim().split(",")));
	}

	@Override
	public void save(T t)
	{
		getMapper().insertSelective(t);
	}
	

	@Override
	public void update(T t)
	{
		getMapper().updateByPrimaryKeySelective(t);
	}

	@Override
	public boolean exist(Map<String, Object> map)
	{
		return getMapper().countByMap(map) > 0;
	}

	@Override
	public Integer countByMap(Map<String, Object> map)
	{
		return getMapper().countByMap(map);
	}
}
