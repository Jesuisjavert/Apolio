package com.ssafy.apolio.repository;

import com.ssafy.apolio.domain.Board;
import com.ssafy.apolio.domain.BoardSearch;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardRepository {

    private final EntityManager em;

    public void save(Board board) {
        em.persist(board);
    }

    public Board findOne(Long id) {
        return em.find(Board.class, id);
    }

    public List<Board> findAll() {
        return em.createQuery("select a from Board a", Board.class)
                .getResultList();
    }

    //검색 조건에 동적으로 쿼리를 생성해서 Board 엔티티를 조회한다.
    //JPQL로 처리
    public List<Board> find(BoardSearch boardSearch) {
        //language=JPQAL
        String jpql = "select a From Board a join a.tagArticles ta join ta.tag t";
        boolean isFirstCondition = true;
        //태그 선택
        if (boardSearch.getTagName() != null) {
            if (isFirstCondition) {
                jpql += " where";
                isFirstCondition = false;
            } else {
                jpql += " and";
            }
            jpql += " t.name = :tagName";
        }
        //게시글 제목 검색
        if (StringUtils.hasText(boardSearch.getArticleTitle())) {
            if (isFirstCondition) {
                jpql += " where";
                isFirstCondition = false;
            } else {
                jpql += " and";
            }
            jpql += " a.title like concat('%', :articleTitle, '%')";
        }
        TypedQuery<Board> query = em.createQuery(jpql, Board.class)
                .setMaxResults(1000); //최대 1000건
        if (boardSearch.getTagName() != null) {
            query = query.setParameter("tagName", boardSearch.getTagName());
        }
        if (StringUtils.hasText(boardSearch.getArticleTitle())) {
            query = query.setParameter("articleTitle", boardSearch.getArticleTitle());
        }
        return query.getResultList();
    }
}
