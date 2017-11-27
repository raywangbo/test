package com.xiaonian.easemob.server.api.impl;

import com.xiaonian.easemob.server.api.EasemobRestAPI;
import com.xiaonian.easemob.server.api.SendMessageAPI;
import com.xiaonian.easemob.server.comm.constant.HTTPMethod;
import com.xiaonian.easemob.server.comm.helper.HeaderHelper;
import com.xiaonian.easemob.server.comm.wrapper.BodyWrapper;
import com.xiaonian.easemob.server.comm.wrapper.HeaderWrapper;

public class EasemobSendMessage extends EasemobRestAPI implements SendMessageAPI {
    private static final String ROOT_URI = "/messages";

    @Override
    public String getResourceRootURI() {
        return ROOT_URI;
    }

    public Object sendMessage(Object payload) {
        String  url = getContext().getSeriveURL() + getResourceRootURI();
        HeaderWrapper header = HeaderHelper.getDefaultHeaderWithToken();
        BodyWrapper body = (BodyWrapper) payload;

        return getInvoker().sendRequest(HTTPMethod.METHOD_POST, url, header, body, null);
    }
}
