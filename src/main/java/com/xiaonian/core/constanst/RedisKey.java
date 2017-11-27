package com.xiaonian.core.constanst;

public class RedisKey
{
	/** 网页title **/
	public final static String URL_TITLE = "URL_TITLE";
	
	/** 视频封面 **/
	public final static String BG_URL = "BG_URL";
	
	/** 视频播放URL **/
	public final static String PLAY_URL = "PLAY_URL";
	
	/** 热门+最新话题 **/
	public final static String HOT_DYNAMIC = "HOT_DYNAMIC";
	
	/** 热门话题 **/
	public final static String HOT_TOPIC = "HOT_TOPIC";
	
	/** 热门置顶话题 **/
	public final static String HOT_TOP_TOPIC = "HOT_TOP_TOPIC";
	
	/** 最新话题 **/
	public final static String LATEST_TOPIC = "LATEST_TOPIC";
	
	/** 竞拍错误记录 **/
	public final static String AUCTION_ERR_LOG_KEY = "AUCTION_ERR_LOG_KEY_";
	
	/** 竞拍记录 **/
	public final static String AUCTION_LOG_KEY = "AUCTION_LOG_KEY_";
	
	/** 进行中的拍卖 **/
	public final static String AUCTION_ONGOING = "AUCTION_ONGOING";
	
	/** 七牛token **/
	public final static String QINIU_TOKEN = "QINIU_TOKEN";
	
	/** 七牛token有效时间 1小时 **/
	public final static int QINIU_TOKEN_EXPIRE_TIME = 3600;
	
	/** 拍卖的最高价格 **/
	public final static String MAX_AUCTION_PRICE = "MAX_AUCTION_PRICE";
	
	/** 拍卖的开始时间和结束时间 **/
	public final static String AUCTION_STARTTIME_ENDTIME = "AUCTION_STARTTIME_ENDTIME_";
	
	/** 已通知的最高价格 **/
	public final static String AUCTION_NOTIFIED_MAX_PRICE = "AUCTION_NOTIFIED_MAX_PRICE";
	
	/** 竞拍日志尚未迁移的标识 **/
	public final static String AUCTION_LOG_TRANSFER_FLAG = "AUCTION_LOG_TRANSFER_FLAG";
	
	public final static String AUCTION_START_NOTICE = "AUCTION_START_NOTICE_";
	
	//发同学说（等级奖励）
	public final static String DYNAMIC_REWARD_LEVEL = "DYNAMIC_REWARD_LEVEL";

	//评论或转发(等级奖励)
	public final static String COMMENT_OR_FORWARD_LEVEL = "COMMENT_OR_FORWARD_LEVEL";
	
	/** 分享同学说(学分奖励) **/
	public final static String SHARE_DYNAMIC_REWARD_POINT = "SHARE_DYNAMIC_REWARD_POINT";

	/** 分享竞品 **/
	public final static String SHARE_AUCTION_REWARD_POINT = "SHARE_AUCTION_REWARD_POINT";
	
	/** 人气榜 **/
	public final static String RED_MAN_LIST = "POPULARITY_RANK_LIST";
	
	/** 活跃度排行榜 **/
	public final static String ACTIVITY_RANK_LIST = "ACTIVITY_RANK_LIST";
	
	/** 等级排行榜 **/
	public final static String LEVEL_RANK_LIST = "LEVEL_RANK_LIST";
	
	/** 推荐同学说列表 **/
	public final static String RECOMMEND_DYNAMIC_LIST = "RECOMMEND_DYNAMIC_LIST";
	
	/** 热门话题过期时间  2个小时重新生成一次 **/
	public final static int HOT_EXPIRE_TIME = 2 * 60 * 60;
	
	/** TOKEN 集合 **/
	public final static String TOKEN_LIST = "TOKEN_LIST";
	
	/** 用户访问权限 **/
	public final static String USER_ACCESS_RIGHTS = "USER_ACCESS_RIGHTS";
	
	/** 新用户访问标识 **/
	public final static String NEW_USER_ACCESS_FLAG = "NEW_USER_ACCESS_FLAG";
	
	/** 推荐同学说的最后一条的时间记录标识 **/
	public final static String RECOMMEND_LAST_DYNAMIC_CREATE_TIME = "RECOMMEND_LAST_DYNAMIC_CREATE_TIME";
	
	/** 在线房间 **/
	public final static String AUCTION_ONGOING_CHAT_ROOM = "AUCTION_ONGOING_CHAT_ROOM_";
	
	/** 环信光标 **/
	public final static String CHAT_CURSOR = "CHAT_CURSOR";
	
	/** 环信时间 **/
	public final static String CHAT_TIME = "CHAT_TIME";
	
	/** 环信聊天记录 **/
	public final static String CHAT_MESSAGE_LOG = "CHAT_MESSAGE_LOG";
	
	/** 环信聊天解析错误记录 **/
	public final static String CHAT_MESSAGE_ERROR_LOG = "CHAT_MESSAGE_ERROR_LOG";
	
	/** 用户注册验证码 **/
	public final static String USER_REGISTERED_CODES = "USER_REGISTERED_CODES_";
	
	/** 用户忘记密码验证码 **/
	public final static String USER_FORGOT_PWD_CODES = "USER_FORGOT_PWD_CODES_";
	
	/** 用户旧手机验证码 **/
	public final static String USER_OLD_PHONE_CODES = "USER_OLD_PHONE_CODES_";
	
	/**　用户新手机验证码 **/
	public final static String USER_NEW_PHONE_CODES = "USER_NEW_PHONE_CODES_";
	
	
	
	/** 用户账号验证码超时时间 **/
	public final static int TEL_CODES_EXPIRE_TIME = 5 * 60;
	
	/** 同学说阅读量 **/
	public final static String DYNAMIC_READ_NUM = "DYNAMIC_READ_NUM";
	
	/** 通知列表 **/
	public final static String NOTICE_LIST = "NOTICE_LIST";
	
	/** 通知异常列表 **/
	public final static String NOTICE_REEOR_LIST = "NOTICE_REEOR_LIST";
	
	/** 邀请码 **/
	public final static String INVITE_CODE = "INVITE_CODE";
	
	/** 用户禁言 **/
	public final static String USERS_GAG = "USERS_GAG_";
	
	/** 用户昵称元素1 **/
	public final static String SCREEN_NAME_ELEMENT1 = "SCREEN_NAME_ELEMENT1";
	
	/** 用户昵称元素2 **/
	public final static String SCREEN_NAME_ELEMENT2 = "SCREEN_NAME_ELEMENT2";
	
	/** 用户昵称元素3 **/
	public final static String SCREEN_NAME_ELEMENT3 = "SCREEN_NAME_ELEMENT3";
	
	/** 用户数量 **/
	public final static String USER_COUNT = "USER_COUNT";
	
	/** 竞拍广告提醒 **/
	public final static String AUCTION_TIP = "AUCTION_TIP";
	
	/** 微信accessToken **/
	public final static String WX_ACCESS_TOKEN = "WX_ACCESS_TOKEN";
	
	/** 本月补签次数 **/
	public final static String MONTH_PAST_SIGN_TIMES = "MONTH_PAST_SIGN_TIMES";
	
	/** 推荐话题的最新同学说内容 **/
	public final static String RECOMMENT_TOPIC_DYC = "RECOMMENT_TOPIC_DYC";
	
}
