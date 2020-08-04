package com.ssafy.apolio.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Article {

    @Id
    @GeneratedValue
    @Column(name = "article_id")
    private Long id;

    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Heart> hearts = new ArrayList<>();

    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<TagArticle> tagArticles = new ArrayList<>();

    private String title;

    private String content;

    private String img_thumb;

    private LocalDateTime create_date;

    //==연관관계 메서드==//
    public void addComment(Comment comment) {
        comments.add(comment);
        comment.setArticle(this);
    }

    public void addHeart(Heart heart) {
        hearts.add(heart);
        heart.setArticle(this);
    }

    public void addTagArticle(TagArticle tagArticle) {
        tagArticles.add(tagArticle);
        tagArticle.setArticle(this);
    }

    //==생성 메서드==//
    public static Article createArticle( String title, String content, String img_thumb, TagArticle... tagArticles) {
        Article article = new Article();

        article.setTitle(title);
        article.setContent(content);
        article.setImg_thumb(img_thumb);
        article.setCreate_date(LocalDateTime.now());

        for (TagArticle tagArticle : tagArticles){
            article.addTagArticle(tagArticle);
        }

        return article;
    }

}
