package com.xiaonian.easemob.server.api;

import java.io.File;

import com.xiaonian.easemob.server.comm.wrapper.BodyWrapper;
import com.xiaonian.easemob.server.comm.wrapper.HeaderWrapper;
import com.xiaonian.easemob.server.comm.wrapper.QueryWrapper;
import com.xiaonian.easemob.server.comm.wrapper.ResponseWrapper;

public interface RestAPIInvoker {
	ResponseWrapper sendRequest(String method, String url, HeaderWrapper header, BodyWrapper body, QueryWrapper query);
	ResponseWrapper uploadFile(String url, HeaderWrapper header, File file);
    ResponseWrapper downloadFile(String url, HeaderWrapper header, QueryWrapper query);
}
