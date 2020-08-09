package com.ssafy.apolio.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.ssafy.apolio.domain.account.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@Setter
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "blog_id")
    private Long id;

    @ManyToOne(fetch = LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

    @OneToMany(mappedBy = "blog", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "blog", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Heart> hearts = new ArrayList<>();

    private String title;

    private String content;

    private LocalDateTime create_date;

    public void addComment(Comment comment) {
        comments.add(comment);
        comment.setBlog(this);
    }

    public void addHeart(Heart heart) {
        hearts.add(heart);
        heart.setBlog(this);
    }

    public static Blog createBlog(String title, String content, User user) {
        Blog blog = new Blog();
        blog.setTitle(title);
        blog.setContent(content);
        blog.setUser(user);
        blog.setCreate_date(LocalDateTime.now());
        return blog;
    }
}
