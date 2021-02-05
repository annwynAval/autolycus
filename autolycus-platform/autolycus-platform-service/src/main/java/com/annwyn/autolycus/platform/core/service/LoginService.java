package com.annwyn.autolycus.platform.core.service;

import com.annwyn.autolycus.extra.model.QueryResponse;

public interface LoginService {

    QueryResponse<String> forgetPassword(String memberMail);

}
