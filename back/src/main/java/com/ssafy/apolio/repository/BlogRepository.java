package com.ssafy.apolio.repository;

import com.ssafy.apolio.domain.Blog;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class BlogRepository {
    private final EntityManager em;

    public void save(Blog community) {
        em.persist(community);
    }

    public Blog findOne(Long id) {
        return em.find(Blog.class, id);
    }

    public List<Blog> findAll() {
        return em.createQuery("select c from Blog c", Blog.class)
                .getResultList();
    }
    public int updateCommunityById(Blog community){
        String jpql = "update Blog c set c.title = :title, c.content = :content where c.id = :id";
        Query query = em.createQuery(jpql);
        query.setParameter("title", community.getTitle());
        query.setParameter("content", community.getContent());
        query.setParameter("id", community.getId());
        int check = query.executeUpdate();
        return check;
    }

    public int deleteCommunityById(Long id){
        String jpql = "delete from Blog c where c.id = :id";
        Query query = em.createQuery(jpql);
        query.setParameter("id", id);
        int check = query.executeUpdate();
        return check;
    }
}
