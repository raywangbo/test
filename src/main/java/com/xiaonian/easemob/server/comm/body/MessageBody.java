package com.xiaonian.easemob.server.comm.body;

import java.util.Iterator;
import java.util.Map;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.xiaonian.easemob.server.comm.wrapper.BodyWrapper;

public abstract class MessageBody implements BodyWrapper{
	
	private static Logger log = LoggerFactory.getLogger(MessageBody.class);
	private ObjectNode msgBody;

    private String targetType;

    private String[] targets;

    private String from;

    private Map<String, Object> ext;

    private boolean init = false;

    public MessageBody(String targetType, String[] targets, String from, Map<String, Object> ext) {
        this.targetType = targetType;
        this.targets = targets;
        this.from = from;
        this.ext = ext;
    }

    public String getTargetType() {
        return targetType;
    }


    public String[] getTargets() {
        return targets;
    }

    public String getFrom() {
        return from;
    }

    public Map<String, Object> getExt() {
        return ext;
    }

    public boolean isInit() {
        return init;
    }

    public void setInit(boolean init) {
        this.init = init;
    }

    protected ObjectNode getMsgBody() {
        if(null == this.msgBody) {
            this.msgBody = JsonNodeFactory.instance.objectNode();
            msgBody.put("target_type", targetType);
            ArrayNode targetsNode = msgBody.putArray("target");
            for (String target: targets ) {
                targetsNode.add(target);
            }
            msgBody.put("from", from);

            if(null != ext) {
                ObjectNode extNode = msgBody.putObject("ext");
                Iterator<String> iter = ext.keySet().iterator();
                while(iter.hasNext()){
                    String key = iter.next();
                    Object value = ext.get(key);
                    if(value instanceof Map)
                    {
                    	try
						{
                    		ObjectMapper objectMapper = new ObjectMapper();  
                            String userMapJson = objectMapper.writeValueAsString(value);  
                            JsonNode node = objectMapper.readTree(userMapJson); 
                        	extNode.put(key, node);
						}
						catch (Exception e)
						{
							log.error("消息发送类型转换异常", e);
						}
                    }
                    else
					{
                    	extNode.put(key, value.toString());
					}
                }
            }
        }
		return msgBody;
	}

    public Boolean validate() {
        return StringUtils.isNotBlank(targetType) && isValidTargetType() && ArrayUtils.isNotEmpty(targets) && StringUtils.isNotBlank(from);
    }

    private boolean isValidTargetType() {
        return "users".equals(targetType) || "chatgroups".equals(targetType) || "chatrooms".equals(targetType);
    }
}
