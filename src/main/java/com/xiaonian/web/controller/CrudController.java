/**
 * 
 */
package com.xiaonian.web.controller;

import com.xiaonian.core.bean.PagerBean;
import com.xiaonian.core.bean.ResponseBean;
import com.xiaonian.core.constanst.Constants;
import com.xiaonian.core.constanst.ErrCodeConstants;
import com.xiaonian.core.service.IBaseService;
import org.apache.log4j.Logger;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.util.Map;


/**
 * @author juvenile
 *
 */
public abstract class CrudController<T, Service extends IBaseService<T>>
//																		extends BaseController	
{
	protected HttpServletRequest request;
	
	protected HttpServletResponse response;
	
	protected Logger logger = Logger.getLogger(this.getClass());
	/* 抽象Service 由继承类实现 */
	public abstract Service getService();

	/* 接收、传递entity 对象。主要在编辑/新增/查询页面中使用 */
	protected T entity;

	/* 泛型对应的Class */
	protected Class<T> entityClass;

	protected PagerBean<T> pager = new PagerBean<T>();

	protected ResponseBean responseBean = new ResponseBean(
			Constants.API_STATUS_SUCCESS, ErrCodeConstants.ERR_0_SUCCESS, "");

	/**
	 * 分页查询
	 * 
	 * @return 返回分页查询结果
	 */

	public PagerBean<T> getAll(PagerBean<T> pager)
	{
		Map<String,Object> searchParam = pager.getSearch();
		if(searchParam.containsKey("startTime"))
		{
			pager.getSearch().put("startTime", new Timestamp(Long.parseLong(searchParam.get("startTime").toString())));
		}
		if(pager.getSearch().containsKey("endTime"))
		{
			pager.getSearch().put("endTime", new Timestamp(Long.parseLong(searchParam.get("endTime").toString())));
		}
		if(searchParam.containsKey("start"))
		{
			pager.getSearch().put("start", new Timestamp(Long.parseLong(searchParam.get("start").toString())));
		}
		if(pager.getSearch().containsKey("end"))
		{
			pager.getSearch().put("end", new Timestamp(Long.parseLong(searchParam.get("end").toString())));
		}
		// 排序列表
		if (pager.getSortOrder() != null)
		{
			// 排序名称
			if (!StringUtils.isEmpty(pager.getSort()))
			{
				try
				{
					entity = instanceAnnotationObject();

					//entity.getClass().getDeclaredField(pager.getSortName());// 检查字段是否存在，不存在会发生异常

					pager.getSearch().put("sortName", pager.getSort());

					pager.getSearch().put("sortOrder", pager.getSortOrder().toString());

				}
				catch (SecurityException e)
				{
					e.printStackTrace();
				}

			}
		}
		getService().getAll(pager);
		return pager;
	}

	/**
	 * 编辑
	 * @return 编辑结果
	 */
	public ResponseBean save(T entity)
	{
		getService().save(entity);
		return responseBean;
	}

	/**
	 * 编辑
	 * @return 编辑结果
	 */
	public ResponseBean edit(T entity)
	{
		getService().update(entity);
		return responseBean;
	}

	/**
	 * 批量删除
	 * @return 删除结果
	 */
	public ResponseBean del(String ids)
	{
		getService().deleteByIds(ids);
		return responseBean;
	}

	/**
	 * 根据ID加载数据
	 * @return 编辑页面
	 */
	public void Integer(Integer id)
	{
		this.entity = getService().getById(id);
	}

	public void outMessage(String message)
	{
		try
		{
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(message);
			response.getWriter().flush();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	/*public ResponseBean toResponseJson(Object data)
	{
		responseBean.setData(data);
		return toResponseJson();
	}*/


	/**
	 * 判断对象是否存在
	 * <p>
	 * 
	 * @return 是否存在结果
	 */
	public ResponseBean isNotExist()
	{
		return responseBean;
	}

	/**
	 * 根据泛型类型实例化对象
	 * <p>
	 * 
	 * @return 返回泛型实例
	 * @throws Exception
	 * 实例化泛型类异常
	 */
	@SuppressWarnings("unchecked")
	public T instanceAnnotationObject()
	{
		Class<?> cl = this.getClass();
		// 得到泛型类型参数数组就是<>里面的值
		Type[] types = ((ParameterizedType) cl.getGenericSuperclass())
				.getActualTypeArguments();
		try
		{
			return ((Class<T>) types[0]).newInstance();
		}
		catch (Exception e)
		{
			logger.error("CrudAction的泛型类型实例化失败! 错误信息: ", e);
			throw new RuntimeException(e);
		}
	}

	/**
	 * @return entity
	 */
	public T getEntity()
	{
		return entity;
	}

	/**
	 * @param entity
	 * 要设置的 entity
	 */
	public void setEntity(T entity)
	{
		this.entity = entity;
	}

	/**
	 * @return entityClass
	 */
	public Class<T> getEntityClass()
	{
		return entityClass;
	}

	/**
	 * @param entityClass
	 * 要设置的 entityClass
	 */
	public void setEntityClass(Class<T> entityClass)
	{
		this.entityClass = entityClass;
	}

	public PagerBean<T> getPager()
	{
		return pager;
	}

	public void setPager(PagerBean<T> pager) {
		this.pager = pager;
	}
	public ResponseBean toResponseJson()
	{
		responseBean.setStatus(Constants.API_STATUS_SUCCESS);
		responseBean.setErrCode(ErrCodeConstants.ERR_0_SUCCESS);
		responseBean.setMessage("");
		return responseBean;
	}

	public ResponseBean toErrorResponseJson(String message)
	{
		responseBean.setStatus(Constants.API_STATUS_FAILURE);
		responseBean.setErrCode(ErrCodeConstants.ERR_1_LOGIN_FAILE);
		responseBean.setMessage(message);
		return responseBean;
	}

	public ResponseBean toResponseData(Object data)
	{
		responseBean.setStatus(Constants.API_STATUS_SUCCESS);
		responseBean.setErrCode(ErrCodeConstants.ERR_0_SUCCESS);
		responseBean.setMessage("");
		responseBean.setData(data);
		return responseBean;
	}
}
