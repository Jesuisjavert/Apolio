package com.ssafy.apolio.web;

import com.ssafy.apolio.domain.account.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardForm {
    private User user;
    private String title;
    private String content;
    private String img_thumb;
}
