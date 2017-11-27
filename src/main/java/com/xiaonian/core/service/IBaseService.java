package com.xiaonian.core.service;

import java.util.List;
import java.util.Map;

import com.xiaonian.core.bean.PagerBean;

/**
 * 
 * 泛型Service接口
 * 
 * @author qqjbest
 * @since 2016年4月11日 下午3:30:34
 */
public abstract interface IBaseService<T> {

	/**
	 * 根据ID查询对象
	 * @author qqjbest
	 * @since 2016年1月10日 下午9:13:37
	 * @param id
	 * @return
	 */
	T getById(Integer id);

	/**
	 * 根据page条件查询对象列表
	 * @author qqjbest
	 * @since 2016年1月10日 下午9:14:00
	 * @param page
	 * @return
	 */
	void getAll(PagerBean<T> page);
	
	/**
	 * 根据map条件查询对象列表
	 * @author qqjbest
	 * @since 2016年1月10日 下午9:14:00
	 * @param searchParams
	 * @return
	 */
	List<T> getAll(Map<String, Object> params);
	
	/**
	 * 查询所有
	 * @author qqjbest
	 * @since 2016年1月10日 下午9:14:00
	 * @param searchParams
	 * @return
	 */
	List<T> getAll();

	/**
	 * 根据IDS删除对象
	 * @author qqjbest
	 * @since 2016年1月10日 下午9:14:25
	 * @param ids
	 */
	void deleteByIds(String ids);
	
	
	/**
	 * 保存对象
	 * @author qqjbest
	 * @since 2016年1月10日 下午9:15:49
	 * @param t
	 */
	void save(T t);

	/**
	 * 根据ID更新对象，注意ID要有值
	 * @author qqjbest
	 * @since 2016年1月10日 下午9:16:07
	 * @param t
	 */
	void update(T t);
	
	/**
	 * 根据map条件查询是否存在对象
	 * @author qqjbest
	 * @since 2016年1月10日 下午9:16:07
	 * @param map
	 */
	boolean exist(Map<String, Object> map);

	/**
	 * 根据条件计算个数
	 * @author qqjbest
	 * @since 2016年1月10日 下午9:16:59
	 * @param map
	 * @return
	 */
	Integer countByMap(Map<String, Object> map);
}
