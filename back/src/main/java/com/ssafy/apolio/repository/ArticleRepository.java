package com.ssafy.apolio.repository;

import com.ssafy.apolio.domain.Article;
import com.ssafy.apolio.domain.ArticleSearch;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ArticleRepository {

    private final EntityManager em;

    public void save(Article article) {
        em.persist(article);
    }

    public Article findOne(Long id) {
        return em.find(Article.class, id);
    }

    public List<Article> findAll() {
        return em.createQuery("select a from Article a", Article.class)
                .getResultList();
    }

    //검색 조건에 동적으로 쿼리를 생성해서 Article 엔티티를 조회한다.
    //JPQL로 처리
    public List<Article> find(ArticleSearch articleSearch) {
        //language=JPQAL
        String jpql = "select a From Article a join a.tagArticles ta join ta.tag t";
        boolean isFirstCondition = true;
        //태그 선택
        if (articleSearch.getTagName() != null) {
            if (isFirstCondition) {
                jpql += " where";
                isFirstCondition = false;
            } else {
                jpql += " and";
            }
            jpql += " t.name = :tagName";
        }
        //게시글 제목 검색
        if (StringUtils.hasText(articleSearch.getArticleTitle())) {
            if (isFirstCondition) {
                jpql += " where";
                isFirstCondition = false;
            } else {
                jpql += " and";
            }
            jpql += " a.title like concat('%', :articleTitle, '%')";
        }
        TypedQuery<Article> query = em.createQuery(jpql, Article.class)
                .setMaxResults(1000); //최대 1000건
        if (articleSearch.getTagName() != null) {
            query = query.setParameter("tagName", articleSearch.getTagName());
        }
        if (StringUtils.hasText(articleSearch.getArticleTitle())) {
            query = query.setParameter("articleTitle", articleSearch.getArticleTitle());
        }
        return query.getResultList();
    }
}
