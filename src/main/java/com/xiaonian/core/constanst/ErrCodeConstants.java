package com.xiaonian.core.constanst;

public class ErrCodeConstants
{
	/** 访问成功 **/
	public final static int ERR_0_SUCCESS = 0;
	public final static int ERR_1_LOGIN_FAILE = 1;
	public final static int ERR_2_LOGIN_REQUIRED = 2;
	
	// 2：请求参数非法 [1000~1999]
	/** 参数错误 **/
	public final static int ERR_1000_PARAMS_ERR = 1000;
	
	/** TOKEN **/
	public final static int ERR_1001_TOKEN_ERR = 1001;
	
	/** 已过试用期，并且审核次数少于3次**/
	public final static int ERR_1002_ACCESS_ERR = 1002;
	
	/** 已过试用期，并且审核次数大于3次**/
	public final static int ERR_1003_ACCESS_ERR = 1003;
	
	/** 业务异常 **/
	public final static int ERR_2000_BUSINESS_ERR = 2000;
	
	/** 学分异常 **/
	public final static int ERR_2001_POINT_ERR = 2001;
	
	/** 版本号错误码 **/
	public final static int ERR_2005_POINT_ERR = 2005;
	
	// 4：服务器系统异常 [3000~9999]
	/** 服务器异常 **/
	public final static int ERR_3000_SERVER_ERR = 3000;
	/** SMS阿里大鱼服务器错误 **/
	public final static int ERR_3001_SMS_API_ERR = 3001;
	/** 百度地图Api服务异常 **/
	public final static int ERR_3002_BAIDUMAP_API_ERR = 3002;
	/** 环信服务异常 **/
	public final static int ERR_3003_EASEMOB_API_ERR = 3003;
	
}
