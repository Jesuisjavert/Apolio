package com.ssafy.apolio.web;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentForm {
    private String article_id;
    private String account_id;
    private String content;

}
