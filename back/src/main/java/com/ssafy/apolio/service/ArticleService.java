package com.ssafy.apolio.service;

import com.ssafy.apolio.domain.Article;
import com.ssafy.apolio.domain.ArticleSearch;
import com.ssafy.apolio.domain.Tag;
import com.ssafy.apolio.domain.TagArticle;
import com.ssafy.apolio.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ArticleService { //서비스에서는 단순히 엔티티에 필요한 요청을 위임하는 역할만 하고
    // 비즈니스 로직을 엔티티에서 하는 방식이 DDD(Domain Driven Design - 도메인 모델 패턴) 그 반대가 트랜잭션 스크립트 패턴

    private final ArticleRepository articleRepository;
    private final CommentRepository commentRepository;
    private final HeartRepository heartRepository;
    private final TagRepository tagRepository;

    /**
     * 게시글 작성
     */
    @Transactional
    public Long article(Long tagId, String title, String content, String img_thumb) {

        //엔티티 조회
        Tag tag = tagRepository.findOne(tagId);

        //태그 생성
        TagArticle tagArticle = TagArticle.createTagArticle(tag);

        //게시물 생성
        Article article = Article.createArticle(title, content, img_thumb, tagArticle);

        //게시물 저장
        articleRepository.save(article);

        return article.getId();
    }

    //게시물 전체 조회
    public List<Article> findArticlesAll() {
        return articleRepository.findAll();
    }
    public Article findArticle(Long article_id) { return articleRepository.findOne(article_id); }

    //게시물 검색
    public List<Article> findArticles(ArticleSearch articleSearch) {
        return articleRepository.find(articleSearch);
    }
}
