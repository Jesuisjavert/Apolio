package com.ssafy.apolio.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.ssafy.apolio.domain.user.User;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDateTime;
import static javax.persistence.FetchType.LAZY;


@Entity
@Data
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long id;


    @ManyToOne(fetch = LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "board_id")
    @JsonBackReference
    private Board board;

    @ManyToOne(fetch = LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "blog_id")
    @JsonBackReference
    private Blog blog;

    private Long parent;

    private String content;

    private LocalDateTime create_date;


    // 댓글 작성 메소드
    public static Comment createCommentBoard(User user, Board board, String content){
        Comment comment = new Comment();
        comment.setUser(user);
        comment.setBoard(board);
        comment.setContent(content);//댓글 내용
        comment.setCreate_date(LocalDateTime.now());//댓글 작성 시간
        user.addComment(comment);
        board.addComment(comment);
        return comment;

    }

    public static Comment createCommentBlog(User user, Blog blog, String content){
        Comment comment = new Comment();
        comment.setUser(user);
        comment.setBlog(blog);
        comment.setContent(content);//댓글 내용
        comment.setCreate_date(LocalDateTime.now());//댓글 작성 시간
        user.addComment(comment);
        blog.addComment(comment);
        return comment;

    }

    //대댓글 작성 메소드
    public static Comment createReplyBoard(Long parent, User user, Board board, String content){
        Comment comment = new Comment();
        comment.setUser(user);
        comment.setBoard(board);
        comment.setContent(content);//대댓글 내용
        comment.setCreate_date(LocalDateTime.now());//대댓글 작성 시간
        comment.setParent(parent);//대댓글의 부모 댓글
        user.addComment(comment);
        board.addComment(comment);
        return comment;

    }

    public static Comment createReplyBlog(Long parent, User user, Blog blog, String content){
        Comment comment = new Comment();
        comment.setUser(user);
        comment.setBlog(blog);
        comment.setContent(content);//대댓글 내용
        comment.setCreate_date(LocalDateTime.now());//대댓글 작성 시간
        comment.setParent(parent);//대댓글의 부모 댓글
        user.addComment(comment);
        blog.addComment(comment);
        return comment;

    }

}
