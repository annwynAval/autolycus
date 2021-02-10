package com.annwyn.autolycus.authorize;

import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.support.SecurityContextProvider;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;



@Component("authorize")
public class AuthorizeDecideService {

    private final Logger logger = LoggerFactory.getLogger(AuthorizeDecideService.class);

    /**
     * 验证权限是否通过
     * @param permissions .
     * @return .
     */
    public boolean hasPermission(String... permissions) {
        if(permissions == null || permissions.length == 0) {
            return true;
        }

        return false;
    }


}
