package com.ssafy.apolio.web;

import com.ssafy.apolio.domain.Article;
import com.ssafy.apolio.domain.ArticleSearch;
import com.ssafy.apolio.domain.Comment;
import com.ssafy.apolio.domain.Tag;
import com.ssafy.apolio.repository.HeartRepository;
import com.ssafy.apolio.service.ArticleService;
import com.ssafy.apolio.service.CommentService;
import com.ssafy.apolio.service.HeartService;
import com.ssafy.apolio.service.TagService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
//@Controller
@RequiredArgsConstructor
public class ArticleController {
    private final ArticleService articleService;
    private final CommentService commentService;
    private final HeartService heartService;
    private final TagService tagService;

    @Autowired
    private HeartRepository heartRepository;

    @ApiOperation(value = "태그 아이디, 제목, 내용, 이미지를 입력받아서 게시물을 작성한다.", response = String.class)
    @PostMapping(value = "/article")
    public ResponseEntity<String> insertArticle(@RequestBody ArticleForm articleForm, @RequestParam("tagId") Long tagId){
        Long check = articleService.article(tagId, articleForm.getTitle(), articleForm.getContent(), articleForm.getImg_thumb());
        if(check != 0){
            return new ResponseEntity<String>("article success", HttpStatus.OK);
        }
        return new ResponseEntity<String>("article fail", HttpStatus.NO_CONTENT);
    }
    @ApiOperation(value = "게시물 전체를 조회한다.", response = List.class)
    @GetMapping(value = "/articles")
    public ResponseEntity<List<Article>> articleList(){
        List<Article> articles = articleService.findArticlesAll();
        for(Article article : articles){
            System.out.println("게시물 제목 : " + article.getTitle());
            System.out.println("게시물 내용 : " + article.getContent());
            List<Comment> commentList = article.getComments();
            for(Comment comment : commentList){
                System.out.println("게시물 댓글 : " + comment.getContent());
            }
        }
        return new ResponseEntity<List<Article>>(articles, HttpStatus.OK);
    }

    @ApiOperation(value = "태그 이름, 게시물 제목을 입력받아서 해당하는 게시물들을 조회한다.")
    @GetMapping(value = "/articles/search")
    public ResponseEntity<List<Article>> articleSearchList(@RequestBody ArticleSearch articleSearch){
        List<Article> articles = articleService.findArticles(articleSearch);
        return new ResponseEntity<List<Article>>(articles, HttpStatus.OK);
    }

    @ApiOperation(value = "게시물 번호를 입력받아 해당하는 게시물을 조회한다.", response = Article.class)
    @GetMapping(value = "/article/details/{article_id}")
    public ResponseEntity<Article> articleDetail(@PathVariable Long article_id){
        Article article = articleService.findArticle(article_id);
        System.out.println(article.getTitle());
//        for(Comment c : article.getComments()){
//            System.out.println("댓글 작성자: " + c.getAccount().getUsername());
//            System.out.println("댓글 내용: " + c.getContent());
//        }
        System.out.println(article.getContent());
        return new ResponseEntity<Article>(article, HttpStatus.OK);
    }
}
