package com.ssafy.apolio.repository;

import com.ssafy.apolio.domain.Comment;
import com.ssafy.apolio.domain.Portfolio;
import com.ssafy.apolio.dto.CommentAccountDto;
import lombok.RequiredArgsConstructor;
import net.minidev.json.JSONArray;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class CommentRepository {

    private final EntityManager em;

    public void save(Comment comment) {
        em.persist(comment);
    }

    public List<Comment> findAllById(Long id){
        String jpql = "select c from Comment c where c.article.id = :id";
        TypedQuery<Comment> query = em.createQuery(jpql, Comment.class);
        query.setParameter("id", id);
        List<Comment> commentList = query.getResultList();
        for(Comment comment : commentList){
            System.out.println("댓글 달린 게시물 번호: " + comment.getArticle().getId());
            System.out.println("댓글 내용: " + comment.getContent());
        }
        return commentList;
    }


    public List<Comment> findAll(){
        return em.createQuery("select c from Comment c", Comment.class).getResultList();
    }

    public int updateCommentById(Comment comment){
        String jpql = "update Comment c set c.content = :content where c.id = :id";
        Query query = em.createQuery(jpql);
        query.setParameter("content", comment.getContent());
        query.setParameter("id", comment.getId());
        int check = query.executeUpdate();
        return check;
    }

    public int deleteComment(Long comment_id){
        String jpql = "delete from Comment c where c.id = :id";
        Query query = em.createQuery(jpql);
        query.setParameter("id", comment_id);
        int check = query.executeUpdate();
        return check;
    }

    public JSONArray findByArticleId(Long article_id) {

        Query nativeQuery = em.createNativeQuery("select a.comment_id, a.content, a.create_date, b.username, b.email, b.picture" +
                " from Comment a, Account b " +
                "where a.article_id = :article_id", "CommentAccountMapping")
                .setParameter("article_id", article_id);
        List<CommentAccountDto> data = nativeQuery.getResultList();
        JSONArray commentList = new JSONArray();
        for(CommentAccountDto ojt : data){
            commentList.add(ojt.getJSON());
        }

        return commentList;
    }

}
