package com.ssafy.apolio.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.ssafy.apolio.domain.account.Account;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;


import static javax.persistence.FetchType.LAZY;


@Entity
@Getter
@Setter
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long id;


    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "article_id")
    @JsonBackReference
    private Article article;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "account_id")
    @JsonBackReference
    private Account account;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "community_id")
    @JsonBackReference
    private Community community;

    private String content;

    private LocalDateTime create_date;


    // 댓글 작성 메소드
    public static Comment createCommentArticle(Account account, Article article, String content){
        Comment comment = new Comment();
        comment.setAccount(account);
        comment.setArticle(article);
        comment.setContent(content);//댓글 내용
        comment.setCreate_date(LocalDateTime.now());//댓글 작성 시간
        return comment;

    }

    public static Comment createCommentCommuinty(Account account, Community community, String content){
        Comment comment = new Comment();
        comment.setAccount(account);
        comment.setCommunity(community);
        comment.setContent(content);//댓글 내용
        comment.setCreate_date(LocalDateTime.now());//댓글 작성 시간
        return comment;

    }

}
