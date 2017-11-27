package com.xiaonian.easemob.server.comm.body;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.databind.node.ContainerNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.xiaonian.easemob.server.comm.constant.MsgType;

public class CommandMessageBody extends MessageBody {
	private String action;

	public CommandMessageBody(String targetType, String[] targets, String from, Map<String, Object> ext, String action) {
		super(targetType, targets, from, ext);
		this.action = action;
	}

	public String getAction() {
		return action;
	}

	public ContainerNode<?> getBody() {
		if(!this.isInit()){
			 ObjectNode jsonNode = JsonNodeFactory.instance.objectNode();
	            jsonNode.put("type", MsgType.CMD);
	            jsonNode.put("action", action);
	            this.getMsgBody().put("msg", jsonNode);
	            this.setInit(true);
		}

		return this.getMsgBody();
	}
	
	@Override
	public Boolean validate() {
		return super.validate() && StringUtils.isNotBlank(action);
	}
}
