package com.fashionteer.application.account.endpoint.controller.form;

import lombok.Data;

@Data
public class SignUpForm {
    private String nickname;
    private String email;
    private String password;
}