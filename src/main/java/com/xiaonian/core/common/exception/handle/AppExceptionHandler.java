package com.xiaonian.core.common.exception.handle;

import javax.servlet.http.HttpServletRequest;

import com.xiaonian.core.common.exception.RestServiceExceptionHandler;

public class AppExceptionHandler extends RestServiceExceptionHandler {

	@Override
	public boolean isRestServiceException(HttpServletRequest request) {
//		if (request.getServletPath().startsWith(Sysutils.getWebServerindex()))
			return true;
//		else
//			return false;
	}
}
