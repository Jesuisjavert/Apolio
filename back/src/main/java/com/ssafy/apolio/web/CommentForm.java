package com.ssafy.apolio.web;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentForm {
    private String parent;
    private String board_id;
    private String community_id;
    private String username;
    private String content;

}
