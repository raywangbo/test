package com.xiaonian.easemob.server.api.impl;

import com.xiaonian.easemob.server.api.ChatMessageAPI;
import com.xiaonian.easemob.server.api.EasemobRestAPI;
import com.xiaonian.easemob.server.comm.constant.HTTPMethod;
import com.xiaonian.easemob.server.comm.helper.HeaderHelper;
import com.xiaonian.easemob.server.comm.wrapper.HeaderWrapper;
import com.xiaonian.easemob.server.comm.wrapper.QueryWrapper;

public class EasemobChatMessage extends EasemobRestAPI implements ChatMessageAPI {

    private static final String ROOT_URI = "/chatmessages";

    public Object exportChatMessages(Long limit, String cursor, String query) {
        String url = getContext().getSeriveURL() + getResourceRootURI();
        HeaderWrapper header = HeaderHelper.getDefaultHeaderWithToken();
        QueryWrapper queryWrapper = QueryWrapper.newInstance().addLimit(limit).addCursor(cursor).addQueryLang(query);

        return getInvoker().sendRequest(HTTPMethod.METHOD_GET, url, header, null, queryWrapper);
    }

    @Override
    public String getResourceRootURI() {
        return ROOT_URI;
    }
}
