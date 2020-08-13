package com.ssafy.apolio.web;

import com.ssafy.apolio.domain.user.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BlogForm {
    private User user;
    private String title;
    private String content;
    private String img_thumb;
}
