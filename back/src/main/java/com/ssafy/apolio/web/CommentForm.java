package com.ssafy.apolio.web;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentForm {
    private String board_id;
    private String blog_id;
    private String username;
    private String content;

}
