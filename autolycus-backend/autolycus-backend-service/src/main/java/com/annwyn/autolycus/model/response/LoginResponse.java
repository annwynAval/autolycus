package com.annwyn.autolycus.model.response;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class LoginResponse implements Serializable {

    private String managerName;
    private String roleName;
    private String clientToken;
}
