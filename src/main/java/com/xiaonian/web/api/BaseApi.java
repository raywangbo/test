package com.xiaonian.web.api;

import com.xiaonian.core.bean.ResponseBean;
import com.xiaonian.core.constanst.Constants;
import com.xiaonian.core.constanst.ErrCodeConstants;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BaseApi
{

	protected HttpServletRequest request;

	protected HttpServletResponse response;

	protected Logger logger = Logger.getLogger(this.getClass());

	protected ResponseBean responseBean;

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

	public ResponseBean toResponseJson()
	{
		responseBean = new ResponseBean(Constants.API_STATUS_SUCCESS, ErrCodeConstants.ERR_0_SUCCESS, "");
		return responseBean;
	}

	public ResponseBean toResponseJson(Object data)
	{
		responseBean = new ResponseBean(Constants.API_STATUS_SUCCESS, ErrCodeConstants.ERR_0_SUCCESS, "", data);
		return responseBean;
	}

	public ResponseBean toResponseJson(Integer errCode, String message)
	{
		responseBean = new ResponseBean(Constants.API_STATUS_SUCCESS, errCode, message);
		return responseBean;
	}

	public ResponseBean toResponseJson(String status, Integer errCode, String message)
	{
		responseBean = new ResponseBean(status, errCode, message);
		return responseBean;
	}

}
