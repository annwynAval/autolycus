package com.annwyn.autolycus.backend.core.service;

import com.annwyn.autolycus.backend.model.DefaultUserDetails;
import com.annwyn.autolycus.extra.model.QueryResponse;

public interface LoginService {

    /**
     * 管理员登录
     * @param managerMail .
     * @param password .
     * @return .
     */
    DefaultUserDetails login(String managerMail, String password);

    /**
     * 管理员修改密码
     * @param managerMail .
     * @param password .
     * @param validPassword .
     * @return .
     */
    QueryResponse<String> changePassword(String managerMail, String password, String validPassword);


}
