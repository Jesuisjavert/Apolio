package com.ssafy.apolio.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;


@Entity
@Getter
@Setter
public class TagArticle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tag_article_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "tag_id")
    @JsonBackReference
    private Tag tag;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "article_id")
    @JsonBackReference
    private Article article;

    //==생성 메서드==//
    public static TagArticle createTagArticle(Tag tag) {
        TagArticle tagArticle = new TagArticle();
        tagArticle.setTag(tag);

        return tagArticle;
    }
}
