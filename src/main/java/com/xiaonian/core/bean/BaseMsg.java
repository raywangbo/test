package com.xiaonian.core.bean;

/**
 * @ClassName: BaseMsg
 * @Description: 消息基类
 * @author zhutulang
 * @date 2016年1月3日
 * @version V1.0
 */
public class BaseMsg {

	/**
	 * 开发者微信号
	 */
	private String toUserName;
	/**
	 * 发送方帐号（一个OpenID）
	 */
	private String fromUserName;
	/**
	 * 消息创建时间 （整型）
	 */
	private String createTime;
	/**
	 * 消息类型
	 */
	private String msgType;
	/**
	 * 消息id，64位整型
	 */
	private String msgId;
	
	private String event;
	
	private String eventKey;
	
	public String getToUserName() {
		return toUserName;
	}
	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}
	public String getFromUserName() {
		return fromUserName;
	}
	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getMsgType() {
		return msgType;
	}
	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}
	public String getMsgId() {
		return msgId;
	}
	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}
	public String getEvent()
	{
		return event;
	}
	public void setEvent(String event)
	{
		this.event = event;
	}
	public String getEventKey()
	{
		return eventKey;
	}
	public void setEventKey(String eventKey)
	{
		this.eventKey = eventKey;
	}
}
