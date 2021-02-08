package com.annwyn.autolycus.platform.core.controller;

import com.annwyn.autolycus.extra.exception.ServiceException;
import com.annwyn.autolycus.extra.model.QueryResponse;
import com.annwyn.autolycus.platform.core.service.MemberService;
import com.annwyn.autolycus.platform.utils.ConstantUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.hibernate.validator.constraints.Length;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import java.util.Arrays;
import java.util.List;

import static com.annwyn.autolycus.platform.utils.ConstantUtils.MemberValidUtils.MAIL_MAX_LENGTH;
import static com.annwyn.autolycus.platform.utils.ConstantUtils.MemberValidUtils.NAME_MAX_LENGTH;
import static com.annwyn.autolycus.platform.utils.ConstantUtils.MemberValidUtils.PASSWORD_MAX_LENGTH;
import static com.annwyn.autolycus.platform.utils.ConstantUtils.MemberValidUtils.PHONE_MAX_LENGTH;

@RestController
@RequestMapping("region")
@Api(tags = "用户相关api")
public class MemberController {

    @Resource
    private MemberService memberService;

    @PostMapping("changePassword.html")
    @ApiOperation("用户修改密码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "memberMail", value = "用户邮箱", paramType = "query"), //
            @ApiImplicitParam(name = "password", value = "新密码", paramType = "query"), //
            @ApiImplicitParam(name = "validPassword", value = "旧密码", paramType = "query") //
    })
    public QueryResponse<String> changePassword(@NotEmpty @Length(max = MAIL_MAX_LENGTH) @RequestParam String memberMail, //
                                                @NotEmpty @Length(max = PASSWORD_MAX_LENGTH) @RequestParam String password, //
                                                @NotEmpty @Length(max = PASSWORD_MAX_LENGTH) @RequestParam String validPassword) {
        return this.memberService.changePassword(memberMail, password, validPassword);
    }

    @PostMapping("updateContact.html")
    @ApiOperation("修改用户基础信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "memberMail", value = "用户邮箱", paramType = "query"), //
            @ApiImplicitParam(name = "memberName", value = "用户名称", paramType = "query"), //
            @ApiImplicitParam(name = "phone", value = "用户手机", paramType = "query") //
    })
    public QueryResponse<String> updateContact(@NotEmpty @Length(max = MAIL_MAX_LENGTH) @RequestParam String memberMail,
                                               @NotEmpty @Length(max = NAME_MAX_LENGTH) @RequestParam String memberName,
                                               @NotEmpty @Length(max = PHONE_MAX_LENGTH) @RequestParam String phone) {
        return this.memberService.updateContact(memberMail, memberName, phone);
    }

    @PostMapping("/changeMemberIcon.html")
    @ApiOperation("上传并更新用户头像")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "memberMail", value = "用户邮箱", paramType = "query"), //
            @ApiImplicitParam(name = "file", value = "待上传的文件", paramType = "query") //
    })
    public QueryResponse<String> changeMemberIcon(@NotNull @RequestParam("file") MultipartFile multipartFile,
                                                  @NotEmpty @Length(max = MAIL_MAX_LENGTH) @RequestParam String memberMail) {
        // 图片大小验证
        if(multipartFile.getSize() >= ConstantUtils.IMAGE_MAX_SIZE) {
            throw new ServiceException("图片文件大小过大, 请上传15M以内的图片!");
        }
        // 验证文件后缀名
        boolean isSuffixValidated = false;
        for(String suffix : ConstantUtils.IMAGE_SUFFIXES) {
            if(StringUtils.endsWithIgnoreCase(multipartFile.getOriginalFilename(), suffix)) {
                isSuffixValidated = true;
                break;
            }
        }
        if(!isSuffixValidated) {
            throw new ServiceException("上传文件的后缀名: {0}不正确", multipartFile);
        }

        return this.memberService.changeMemberIcon(multipartFile, memberMail);
    }
}
