package com.ssafy.apolio.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.ssafy.apolio.domain.user.User;
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
    @JoinColumn(name = "board_id")
    @JsonBackReference
    private Board board;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "blog_id")
    @JsonBackReference
    private Blog blog;

    private Long parent;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq;

    private String content;

    private LocalDateTime create_date;


    // 댓글 작성 메소드
    public static Comment createCommentBoard(String username, Board board, String content){
        Comment comment = new Comment();
        User user = new User();
        user.setUsername(username);
        comment.setUser(user);
        comment.setBoard(board);
        comment.setContent(content);//댓글 내용
        comment.setCreate_date(LocalDateTime.now());//댓글 작성 시간
        user.addComment(comment);
        board.addComment(comment);
        return comment;

    }

    public static Comment createCommentBlog(String username, Blog blog, String content){
        Comment comment = new Comment();
        User user = new User();
        user.setUsername(username);
        comment.setUser(user);
        comment.setBlog(blog);
        comment.setContent(content);//댓글 내용
        comment.setCreate_date(LocalDateTime.now());//댓글 작성 시간
        user.addComment(comment);
        blog.addComment(comment);
        return comment;

    }

}
