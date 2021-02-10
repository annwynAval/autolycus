package com.annwyn.autolycus.platform.core.service;

import com.annwyn.autolycus.extra.model.QueryResponse;
import org.springframework.web.multipart.MultipartFile;

public interface MemberService {

    /**
     * 修改用户密码
     * @param memberMail .
     * @param password .
     * @param validPassword .
     * @return .
     */
    QueryResponse<String> changePassword(String memberMail, String password, String validPassword);

    /**
     * 修改用户基础信息
     * @param memberMail .
     * @param memberName .
     * @param phone .
     * @return .
     */
    QueryResponse<String> updateContact(String memberMail, String memberName, String phone);

    /**
     * 上传并更新用户头像
     * @param multipartFile .
     * @param memberMail .
     * @return .
     */
    QueryResponse<String> changeMemberIcon(MultipartFile multipartFile, String memberMail);
}
