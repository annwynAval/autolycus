package com.annwyn.autolycus.platform.core.service;

import com.annwyn.autolycus.extra.model.QueryResponse;
import com.annwyn.autolycus.platform.model.RegisterRequest;

public interface RegisterService {

    /**
     *
     * @param mailAddress
     * @return
     */
    QueryResponse<String> captcha(String mailAddress);

    /**
     *
     * @param registerRequest
     * @return
     */
    QueryResponse<String> register(RegisterRequest registerRequest);


}
