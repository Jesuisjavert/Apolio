package com.ssafy.apolio.web;

import com.ssafy.apolio.domain.account.AuthProvider;
import com.ssafy.apolio.domain.account.Role;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class AccountForm {
    private String username;

    private String password;

    private String email;

    private String picture;

    private String nickname;

    private Role role;

    private AuthProvider authProvider;
}
