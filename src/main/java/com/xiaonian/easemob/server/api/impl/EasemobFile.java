package com.xiaonian.easemob.server.api.impl;

import java.io.File;

import com.xiaonian.easemob.server.api.EasemobRestAPI;
import com.xiaonian.easemob.server.api.FileAPI;
import com.xiaonian.easemob.server.comm.helper.HeaderHelper;
import com.xiaonian.easemob.server.comm.wrapper.HeaderWrapper;

public class EasemobFile extends EasemobRestAPI implements FileAPI {
    private static final String ROOT_URI = "/chatfiles";

    @Override
    public String getResourceRootURI() {
        return ROOT_URI;
    }

    public Object uploadFile(Object file) {
        String url = getContext().getSeriveURL() + getResourceRootURI();
        HeaderWrapper header = HeaderHelper.getUploadHeaderWithToken();

        return getInvoker().uploadFile(url, header, (File) file);
    }

    public Object downloadFile(String fileUUID, String shareSecret, Boolean isThumbnail) {
        String url = getContext().getSeriveURL() + getResourceRootURI() + "/" + fileUUID;
        HeaderWrapper header = HeaderHelper.getDownloadHeaderWithToken(shareSecret, isThumbnail);

        return getInvoker().downloadFile(url, header, null);
    }
}
