package com.xiaonian.core.constanst;

public class Constants
{
	/** Api访问返回状态码 - 0：访问失败 **/
	public final static String  API_STATUS_FAILURE = "0";
	/** Api访问返回状态码 - 1：访问成功 **/
	public final static String API_STATUS_SUCCESS = "1";


	/** 数据状态 0正常状态 **/
	public final static byte DATA_STATUS_NORMAL = 0;
	/** 数据状态  1删除状态**/
	public final static byte DATA_STATUS_DEL = 1;
	/** 页面大小**/
    public static final byte PAGE_SIZE = 10;

    /** 验证码类型 **/
	public class CODES_TYPE
	{
		/** 注册验证码 **/
		public final static byte REGISTERED = 1;

		/** 忘记密码 **/
		public final static byte FORGOT_PWD = 2;

		/** 旧手机验证码 **/
		public final static byte OLD_PHONE = 3;

		/** 新手机验证码 **/
		public final static byte NEW_PHONE = 4;
	}
	
}
	
