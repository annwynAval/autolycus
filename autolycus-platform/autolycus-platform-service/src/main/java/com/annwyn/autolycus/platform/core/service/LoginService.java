package com.annwyn.autolycus.platform.core.service;

import com.annwyn.autolycus.extra.model.QueryResponse;

public interface LoginService {

    /**
     * 登录请求
     * @param memberMail .
     * @param password .
     * @return .
     */
    QueryResponse<String> login(String memberMail, String password);

    /**
     * 忘记密码, 更新信息并将密码发送至邮箱
     * @param memberMail .
     * @return .
     */
    QueryResponse<String> forgetPassword(String memberMail);

}
