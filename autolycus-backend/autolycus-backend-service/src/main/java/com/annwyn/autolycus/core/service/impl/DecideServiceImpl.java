package com.annwyn.autolycus.core.service.impl;


import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.Collections;

@Service("decide")
public class DecideServiceImpl {

    /**
     * 验证用户是否含有某权限
     * @param permission 权限名称
     * @return true: 权限验证通过
     */
    public boolean hasPermission(String permission) {
        if(StringUtils.isEmpty(permission)) {
            return false;
        }
        Collection<?> collection = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        if(CollectionUtils.isEmpty(collection)) {
            return false;
        }
        return collection.contains(permission);
    }


}
