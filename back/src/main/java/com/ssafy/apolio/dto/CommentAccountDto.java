package com.ssafy.apolio.dto;

import lombok.Getter;
import net.minidev.json.JSONObject;

import javax.persistence.ColumnResult;
import java.time.LocalDateTime;

@Getter
public class CommentAccountDto {

    private Long comment_id;
    private String content;
    private LocalDateTime create_date;

    private String username;
    private String email;
    private String picture;

    public CommentAccountDto(Long comment_id, String content, LocalDateTime create_date, String username, String email, String picture) {
        this.comment_id = comment_id;
        this.content = content;
        this.create_date = create_date;
        this.username = username;
        this.email = email;
        this.picture = picture;
    }

    public JSONObject getJSON() {
        JSONObject data = new JSONObject();
        data.put("comment_id",this.getComment_id());
        data.put("content",this.getContent());
        data.put("create_date",this.getCreate_date());
        data.put("username",this.getUsername());
        data.put("email",this.getEmail());
        data.put("picture",this.getPicture());
        return data;
    }
}
