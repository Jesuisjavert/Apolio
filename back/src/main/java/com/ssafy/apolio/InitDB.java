package com.ssafy.apolio;

import com.ssafy.apolio.domain.Blog;
import com.ssafy.apolio.domain.Tag;
import com.ssafy.apolio.domain.TagBlog;
import com.ssafy.apolio.domain.user.User;
import com.ssafy.apolio.domain.user.Role;
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
//        initService.dbInit1();
//        initService.dbInit2();
//        initService.dbInit3();
//        initService.dbInit4();
//        initService.dbInit5();
        initService.dbInit6();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService {
        private final EntityManager em;

        public void dbInit1() {
            User user = createAccount("강동훈", "donghoon@gmail.com", "https://www.google.com/url?sa=i&url=http%3A%2F%2Fm.blog.naver.com%2Fsjinwon2%2F220022462092%23%3A~%3Atext%3D%5B%25EC%259B%2590%25EB%25B3%25B8%2520%25EB%25B3%25B4%25EA%25B8%25B0%5D&psig=AOvVaw0agqQHDXly_HYWLse5urJ_&ust=1596707835818000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCICny63mg-sCFQAAAAAdAAAAABAD", "후니", Role.ADMIN);
            em.persist(user);
            Tag tag1 = createTag("웹");
            em.persist(tag1);
            Tag tag2 = createTag("앱");
            em.persist(tag2);
            TagBlog tagBlog1 = TagBlog.createTagBlog(tag1);
            TagBlog tagBlog2 = TagBlog.createTagBlog(tag2);
            Blog blog = Blog.createBlog(user,"잘생겨지는 방법", "응 타고나~","description", null, tagBlog1, tagBlog2);
            em.persist(blog);
        }

        public void dbInit2() {
            User user = createAccount("최일송", "ilsong@gmail.com", "https://www.google.com/url?sa=i&url=http%3A%2F%2Fm.blog.naver.com%2Fsjinwon2%2F220022462092%23%3A~%3Atext%3D%5B%25EC%259B%2590%25EB%25B3%25B8%2520%25EB%25B3%25B4%25EA%25B8%25B0%5D&psig=AOvVaw0agqQHDXly_HYWLse5urJ_&ust=1596707835818000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCICny63mg-sCFQAAAAAdAAAAABAD", "쏭이", Role.MEMBER);
            em.persist(user);
            Tag tag1 = createTag("스프링");
            em.persist(tag1);
            Tag tag2 = createTag("클라우드");
            em.persist(tag2);
            TagBlog tagBlog1 = TagBlog.createTagBlog(tag1);
            TagBlog tagBlog2 = TagBlog.createTagBlog(tag2);
            Blog blog = Blog.createBlog(user,"귀여워지는 방법", "큐티 앙","description", null, tagBlog1, tagBlog2);
            em.persist(blog);
        }

        public void dbInit3() {
            User user = createAccount("박승범", "seungbum@gmail.com", "https://www.google.com/url?sa=i&url=http%3A%2F%2Fm.blog.naver.com%2Fsjinwon2%2F220022462092%23%3A~%3Atext%3D%5B%25EC%259B%2590%25EB%25B3%25B8%2520%25EB%25B3%25B4%25EA%25B8%25B0%5D&psig=AOvVaw0agqQHDXly_HYWLse5urJ_&ust=1596707835818000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCICny63mg-sCFQAAAAAdAAAAABAD", "뻐미", Role.MEMBER);
            em.persist(user);
            Tag tag1 = createTag("디비");
            em.persist(tag1);
            Tag tag2 = createTag("네트워크");
            em.persist(tag2);
            TagBlog tagBlog1 = TagBlog.createTagBlog(tag1);
            TagBlog tagBlog2 = TagBlog.createTagBlog(tag2);
            Blog blog = Blog.createBlog(user,"섹시해지는 방법", "땀 흘리는 남자 박승범", "description", "sssssss", tagBlog1, tagBlog2);
            em.persist(blog);
        }

        public void dbInit4() {
            User user = createAccount("배용균", "younggyun@gmail.com", "https://www.google.com/url?sa=i&url=http%3A%2F%2Fm.blog.naver.com%2Fsjinwon2%2F220022462092%23%3A~%3Atext%3D%5B%25EC%259B%2590%25EB%25B3%25B8%2520%25EB%25B3%25B4%25EA%25B8%25B0%5D&psig=AOvVaw0agqQHDXly_HYWLse5urJ_&ust=1596707835818000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCICny63mg-sCFQAAAAAdAAAAABAD", "뀨니", Role.MEMBER);
            em.persist(user);
            Tag tag1 = createTag("자료구조");
            em.persist(tag1);
            Tag tag2 = createTag("알고리즘");
            em.persist(tag2);
            TagBlog tagBlog1 = TagBlog.createTagBlog(tag1);
            TagBlog tagBlog2 = TagBlog.createTagBlog(tag2);
            Blog blog = Blog.createBlog(user,"깜찍해지는 방법", "뀨잉뀨잉", "description", "wwss.fa", tagBlog1, tagBlog2);
            em.persist(blog);
        }

        public void dbInit5() {
            User user = createAccount("이준희", "junhee@gmail.com", "https://www.google.com/url?sa=i&url=http%3A%2F%2Fm.blog.naver.com%2Fsjinwon2%2F220022462092%23%3A~%3Atext%3D%5B%25EC%259B%2590%25EB%25B3%25B8%2520%25EB%25B3%25B4%25EA%25B8%25B0%5D&psig=AOvVaw0agqQHDXly_HYWLse5urJ_&ust=1596707835818000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCICny63mg-sCFQAAAAAdAAAAABAD", "쭈니", Role.MEMBER);
            em.persist(user);
            Tag tag1 = createTag("운영체제");
            em.persist(tag1);
            Tag tag2 = createTag("소프트웨어공학");
            em.persist(tag2);
            TagBlog tagBlog1 = TagBlog.createTagBlog(tag1);
            TagBlog tagBlog2 = TagBlog.createTagBlog(tag2);
            Blog blog = Blog.createBlog(user,"DFS란 무엇인가", "BFS와의 차이점을 알려드리겠습니다.", "description", "aa", tagBlog1, tagBlog2);
            em.persist(blog);
        }

        public void dbInit6() {
            User user = createAccount("이준희", "junhee@gmail.com", "https://www.google.com/url?sa=i&url=http%3A%2F%2Fm.blog.naver.com%2Fsjinwon2%2F220022462092%23%3A~%3Atext%3D%5B%25EC%259B%2590%25EB%25B3%25B8%2520%25EB%25B3%25B4%25EA%25B8%25B0%5D&psig=AOvVaw0agqQHDXly_HYWLse5urJ_&ust=1596707835818000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCICny63mg-sCFQAAAAAdAAAAABAD", "쭈니", Role.MEMBER);
            em.persist(user);
            Tag tag1 = createTag("운영체제");
            em.persist(tag1);
            Tag tag2 = createTag("소프트웨어공학");
            em.persist(tag2);
            TagBlog tagBlog1 = TagBlog.createTagBlog(tag1);
            TagBlog tagBlog2 = TagBlog.createTagBlog(tag2);

            Blog blog = Blog.createBlog(
                    user,
                    "하드코딩이지만 괜찮아.",
                    "일타싸피 하드코딩으로 광주가 1등한거 실화냐.. ㄹㅇ 가슴이 웅장해진다. 그뿐만 아니라 후공일 상황도 대비하여 탄탄한 알고리즘을 짜내다니 이것이 광주 클라스~",
                    "일타싸피 하드코딩으로 광주가 1등한거 실화냐.. ㄹㅇ 가슴이 웅장해진다. 그뿐만 아니라 후공일 상황도 대비하여 탄탄한 알고리즘을 짜내다니 이것이 광주 클라스~",
                    "http://imgnews.naver.net/image/108/2020/06/12/0002870435_001_20200612061503720.jpg",
                    tagBlog1, tagBlog2
            );
            em.persist(blog);
            blog = Blog.createBlog(
                    user,
                    "코딩의 숲",
                    "content",
                    "프론트엔드와 백엔드... 그 끝을 알 수 없는 숨막히는 코딩대결... 과연 코딩의 숲에서 살아남는 자는 누군인가",
                    "http://imgnews.naver.net/image/5307/2017/07/31/0000182231_001_20170731113428477.jpg",
                    tagBlog1, tagBlog2
            );
            em.persist(blog);
        }
        private User createAccount(String username, String email, String picture, String nickname, Role role) {
            User user = new User();
            user.setUsername(username);
            user.setEmail(email);
            user.setPicture(picture);
            user.setNickname(nickname);
            user.setRole(role);
            return user;
        }

        private Tag createTag(String name) {
            Tag tag = new Tag();
            tag.setName(name);
            return tag;
        }

    }

}
