package com.ssafy.apolio;

import com.ssafy.apolio.domain.Article;
import com.ssafy.apolio.domain.Tag;
import com.ssafy.apolio.domain.TagArticle;
import com.ssafy.apolio.domain.account.Account;
import com.ssafy.apolio.domain.account.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;

@Component
@RequiredArgsConstructor
public class InitDB {
    private final InitService initService;

    @PostConstruct
    public void init() {
        initService.dbInit1();
        initService.dbInit2();
        initService.dbInit3();
        initService.dbInit4();
        initService.dbInit5();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService {
        private final EntityManager em;

        public void dbInit1() {
            Account account = createAccount("강동훈", "donghoon@gmail.com", "https://www.google.com/url?sa=i&url=http%3A%2F%2Fm.blog.naver.com%2Fsjinwon2%2F220022462092%23%3A~%3Atext%3D%5B%25EC%259B%2590%25EB%25B3%25B8%2520%25EB%25B3%25B4%25EA%25B8%25B0%5D&psig=AOvVaw0agqQHDXly_HYWLse5urJ_&ust=1596707835818000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCICny63mg-sCFQAAAAAdAAAAABAD", "후니", Role.ADMIN);
            em.persist(account);
            Tag tag1 = createTag("웹");
            em.persist(tag1);
            Tag tag2 = createTag("앱");
            em.persist(tag2);
            TagArticle tagArticle1 = TagArticle.createTagArticle(tag1);
            TagArticle tagArticle2 = TagArticle.createTagArticle(tag2);
            Article article = Article.createArticle("잘생겨지는 방법", "응 타고나~", null, tagArticle1, tagArticle2);
            em.persist(article);
        }

        public void dbInit2() {
            Account account = createAccount("최일송", "ilsong@gmail.com", "https://www.google.com/url?sa=i&url=http%3A%2F%2Fm.blog.naver.com%2Fsjinwon2%2F220022462092%23%3A~%3Atext%3D%5B%25EC%259B%2590%25EB%25B3%25B8%2520%25EB%25B3%25B4%25EA%25B8%25B0%5D&psig=AOvVaw0agqQHDXly_HYWLse5urJ_&ust=1596707835818000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCICny63mg-sCFQAAAAAdAAAAABAD", "쏭이", Role.MEMBER);
            em.persist(account);
            Tag tag1 = createTag("스프링");
            em.persist(tag1);
            Tag tag2 = createTag("클라우드");
            em.persist(tag2);
            TagArticle tagArticle1 = TagArticle.createTagArticle(tag1);
            TagArticle tagArticle2 = TagArticle.createTagArticle(tag2);
            Article article = Article.createArticle("귀여워지는 방법", "큐티 앙", null, tagArticle1, tagArticle2);
            em.persist(article);
        }

        public void dbInit3() {
            Account account = createAccount("박승범", "seungbum@gmail.com", "https://www.google.com/url?sa=i&url=http%3A%2F%2Fm.blog.naver.com%2Fsjinwon2%2F220022462092%23%3A~%3Atext%3D%5B%25EC%259B%2590%25EB%25B3%25B8%2520%25EB%25B3%25B4%25EA%25B8%25B0%5D&psig=AOvVaw0agqQHDXly_HYWLse5urJ_&ust=1596707835818000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCICny63mg-sCFQAAAAAdAAAAABAD", "뻐미", Role.MEMBER);
            em.persist(account);
            Tag tag1 = createTag("디비");
            em.persist(tag1);
            Tag tag2 = createTag("네트워크");
            em.persist(tag2);
            TagArticle tagArticle1 = TagArticle.createTagArticle(tag1);
            TagArticle tagArticle2 = TagArticle.createTagArticle(tag2);
            Article article = Article.createArticle("섹시해지는 방법", "땀 흘리는 남자 박승범", "sssssss", tagArticle1, tagArticle2);
            em.persist(article);
        }

        public void dbInit4() {
            Account account = createAccount("배용균", "younggyun@gmail.com", "https://www.google.com/url?sa=i&url=http%3A%2F%2Fm.blog.naver.com%2Fsjinwon2%2F220022462092%23%3A~%3Atext%3D%5B%25EC%259B%2590%25EB%25B3%25B8%2520%25EB%25B3%25B4%25EA%25B8%25B0%5D&psig=AOvVaw0agqQHDXly_HYWLse5urJ_&ust=1596707835818000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCICny63mg-sCFQAAAAAdAAAAABAD", "뀨니", Role.MEMBER);
            em.persist(account);
            Tag tag1 = createTag("자료구조");
            em.persist(tag1);
            Tag tag2 = createTag("알고리즘");
            em.persist(tag2);
            TagArticle tagArticle1 = TagArticle.createTagArticle(tag1);
            TagArticle tagArticle2 = TagArticle.createTagArticle(tag2);
            Article article = Article.createArticle("깜찍해지는 방법", "뀨잉뀨잉", "wwss.fa", tagArticle1, tagArticle2);
            em.persist(article);
        }

        public void dbInit5() {
            Account account = createAccount("이준희", "junhee@gmail.com", "https://www.google.com/url?sa=i&url=http%3A%2F%2Fm.blog.naver.com%2Fsjinwon2%2F220022462092%23%3A~%3Atext%3D%5B%25EC%259B%2590%25EB%25B3%25B8%2520%25EB%25B3%25B4%25EA%25B8%25B0%5D&psig=AOvVaw0agqQHDXly_HYWLse5urJ_&ust=1596707835818000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCICny63mg-sCFQAAAAAdAAAAABAD", "쭈니", Role.MEMBER);
            em.persist(account);
            Tag tag1 = createTag("운영체제");
            em.persist(tag1);
            Tag tag2 = createTag("소프트웨어공학");
            em.persist(tag2);
            TagArticle tagArticle1 = TagArticle.createTagArticle(tag1);
            TagArticle tagArticle2 = TagArticle.createTagArticle(tag2);
            Article article = Article.createArticle("DFS란 무엇인가", "BFS와의 차이점을 알려드리겠습니다.", "aa", tagArticle1, tagArticle2);
            em.persist(article);
        }

        private Account createAccount(String username, String email, String picture, String nickname, Role role) {
            Account account = new Account();
            account.setUsername(username);
            account.setEmail(email);
            account.setPicture(picture);
            account.setNickname(nickname);
            account.setRole(role);
            return account;
        }

        private Tag createTag(String name) {
            Tag tag = new Tag();
            tag.setName(name);
            return tag;
        }

    }

}
