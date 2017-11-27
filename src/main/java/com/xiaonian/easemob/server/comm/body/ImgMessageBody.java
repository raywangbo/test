package com.xiaonian.easemob.server.comm.body;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.databind.node.ContainerNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.xiaonian.easemob.server.comm.constant.MsgType;

public class ImgMessageBody extends MessageBody {
    private String url;
    private String filename;
    private String secret;
    private Long width;
    private Long height;

    public ImgMessageBody(String targetType, String[] targets, String from, Map<String, Object> ext, String url, String filename, String secret, Long width, Long height) {
        super(targetType, targets, from, ext);
        this.url = url;
        this.filename = filename;
        this.secret = secret;
        this.width = width;
        this.height = height;
    }

    public String getUrl() {
        return url;
    }

    public String getFilename() {
        return filename;
    }

    public String getSecret() {
        return secret;
    }

    public Long getWidth() {
        return width;
    }

    public Long getHeight() {
        return height;
    }

    public ContainerNode<?> getBody() {
        if(!this.isInit()) {
        	
        	ObjectNode jsonNode = JsonNodeFactory.instance.objectNode();
        	jsonNode.put("type", MsgType.IMG);
        	jsonNode.put("url", url);
        	jsonNode.put("filename", filename);
        	jsonNode.put("secret", secret);
        	 if (null != width && null != height) {
                 jsonNode.putObject("size").put("width", width).put("height", height);
             }
            this.getMsgBody().put("msg", jsonNode);
            this.setInit(true);
        }
        return this.getMsgBody();
    }

    public Boolean validate() {
        return super.validate() && StringUtils.isNoneBlank(url) && StringUtils.isNoneBlank(filename) && StringUtils.isNoneBlank(secret);
    }
}
