package com.xiaonian.core.bean;

import com.xiaonian.core.constanst.Constants;
import com.xiaonian.core.constanst.ErrCodeConstants;

;

/**
 * <p>
 * WebService請求返回結果共通Object.
 * </p>
 */
public class ResponseBean
{
	/** 响应代码 **/
	protected String status = Constants.API_STATUS_SUCCESS;
	/** 错误代码 **/
	protected Integer errCode = ErrCodeConstants.ERR_0_SUCCESS;
	/** 提示信息 **/
	protected String message = "";
	protected Object data = "";
	protected Boolean flag;
	
	public ResponseBean()
	{
		super();
	}

	public ResponseBean(String status, Integer errCode, String message)
	{
		super();
		this.status = status;
		this.errCode = errCode;
		this.message = message;
	}
	
	public ResponseBean(String status, Integer errCode, String message, Object data)
	{
		super();
		this.status = status;
		this.errCode = errCode;
		this.message = message;
		this.data = data;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getErrCode() {
		return errCode;
	}

	public void setErrCode(Integer errCode) {
		this.errCode = errCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Boolean getFlag() {
		return flag;
	}

	public void setFlag(Boolean flag) {
		this.flag = flag;
	}
}
