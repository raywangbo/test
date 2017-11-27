package com.xiaonian.core.utils;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionException;
import org.apache.shiro.session.mgt.DefaultSessionManager;
import org.apache.shiro.subject.Subject;

import java.util.Collection;

/**
 * Created by qqjbest on 2017/10/11.
 */
public class BusinessUtil {


    /**
     * 退出登录
     * @param account
     */
    public static void logout(String account){
        DefaultSecurityManager securityManager = (DefaultSecurityManager) SecurityUtils.getSecurityManager();
        DefaultSessionManager sessionManager =  (DefaultSessionManager) securityManager.getSessionManager();
        Collection<Session> activeSessions = sessionManager.getSessionDAO().getActiveSessions();
        for (Session session: activeSessions){
            if(account.equals(""+session.getAttribute("org.apache.shiro.subject.support.DefaultSubjectContext_PRINCIPALS_SESSION_KEY")))
            {
                Subject.Builder builder = new Subject.Builder(securityManager);
                builder.sessionId(session.getId());
                Subject subject = builder.buildSubject();
                if (null != subject) {
                    try {
                        subject.logout();
                    } catch (SessionException e) {
                    }
                }
            }
        }
    }


}
