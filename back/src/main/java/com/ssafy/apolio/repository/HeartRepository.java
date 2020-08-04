package com.ssafy.apolio.repository;

import com.ssafy.apolio.domain.Heart;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

public interface HeartRepository extends JpaRepository<Heart, Long> {
    Long countByarticleId(Long article_id);
}
