package com.annwyn.autolycus.platform.core.service;

import com.annwyn.autolycus.extra.model.QueryResponse;
import com.annwyn.autolycus.platform.model.request.RegisterRequest;

public interface RegisterService {

    /**
     * 生产验证码并发送到指定邮箱内
     * @param mailAddress .
     * @return .
     */
    QueryResponse<String> captcha(String mailAddress);

    /**
     * 注册并保存用户信息
     * @param registerRequest .
     * @return .
     */
    QueryResponse<String> register(RegisterRequest registerRequest);


}
