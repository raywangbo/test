package com.xiaonian.core.mapper;

import java.util.List;
import java.util.Map;

/**
 * 
 * 泛型基础dao接口
 * <p>
 */
public abstract interface BaseMapper<T> {
	/**
	 * 根据ID查询对象
	 * @author lenovo  
	 * modify by qqjbest
	 * @since 2016年1月10日 下午9:13:37
	 * @param id
	 * @return
	 */
	T selectByPrimaryKey(Integer id);

	/**
	 * 保存对象
	 * @author lenovo
	 * modify by qqjbest
	 * @since 2016年1月10日 下午9:15:49
	 * @param t
	 */
	int insertSelective(T t);

	/**
	 * 根据ID更新对象，注意ID要有值
	 * @author lenovo
	 * @since 2016年1月10日 下午9:16:07
	 * @param t
	 */
	int updateByPrimaryKeySelective(T t);
	
	/**
	 * 根据map条件查询对象列表
	 * @author lenovo
	 * @since 2016年1月10日 下午9:14:00
	 * @param params
	 * @return
	 */
	List<T> getAllByMap(Map<String, Object> params);

	
	/**
	 * 根据条件计算个数
	 * @author lenovo
	 * @since 2016年1月10日 下午9:16:59
	 * @param params
	 * @return
	 */
	Integer countByMap(Map<String, Object> params);
	
	/**
	 * 根据IDS删除对象
	 * @author lenovo
	 * modify by qqjbest
	 * @since 2016年1月10日 下午9:14:25
	 * @param ids
	 */
	void deleteByPrimaryKeys(Integer[] ids);
	
	/**
	 * 根据ID删除对象
	 *  
	 * @author qqjbest
	 * @since 2016年4月12日 下午4:57:00
	 * @param id
	 * @return
	 */
	int deleteByPrimaryKey(Integer id);
	
	 /**
	  * 插入
	  *  
	  * @author qqjbest
	  * @since 2016年4月12日 下午7:34:32
	  * @param record
	  * @return
	  */
    int insert(T record);
}
