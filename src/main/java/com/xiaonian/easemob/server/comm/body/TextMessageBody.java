package com.xiaonian.easemob.server.comm.body;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.databind.node.ContainerNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.xiaonian.easemob.server.comm.constant.MsgType;

public class TextMessageBody extends MessageBody {
	private String msg;

	public TextMessageBody(String targetType, String[] targets, String from, Map<String, Object> ext, String msg) {
		super(targetType, targets, from, ext);
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

    public ContainerNode<?> getBody() {
        if(!isInit()){
            ObjectNode jsonNode = JsonNodeFactory.instance.objectNode();
            jsonNode.put("type", MsgType.TEXT);
            jsonNode.put("msg", msg);
            this.getMsgBody().put("msg", jsonNode);
            this.setInit(true);
        }

        return this.getMsgBody();
    }

    public Boolean validate() {
		return super.validate() && StringUtils.isNotBlank(msg);
	}
}
