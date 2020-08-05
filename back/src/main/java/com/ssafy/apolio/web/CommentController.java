package com.ssafy.apolio.web;


import com.ssafy.apolio.domain.Comment;
import com.ssafy.apolio.service.CommentService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CommentController {

    private final CommentService commentService;

    @ApiOperation(value = "유저 번호, 블로그 게시물 번호, 댓글 내용을 받아서 댓글에 입력시킨다", response = String.class)
    @PostMapping(value = "/comment/article")
    public ResponseEntity<String> insertCommentArticle(@RequestBody CommentForm commentForm){
        Long check = commentService.commentArticle(Long.parseLong(commentForm.getAccount_id()), Long.parseLong(commentForm.getArticle_id()), commentForm.getContent());
        if(check != 0){
            return new ResponseEntity<String>("comment success", HttpStatus.OK);
        }
        return new ResponseEntity<String>("comment fail", HttpStatus.NO_CONTENT);
    }

    @ApiOperation(value = "유저 번호, 커뮤니티 게시물 번호, 댓글 내용을 받아서 댓글에 입력시킨다", response = String.class)
    @PostMapping(value = "/comment/community")
    public ResponseEntity<String> insertCommentCommunity(@RequestBody CommentForm commentForm){
        Long check = commentService.commentCommunity(Long.parseLong(commentForm.getAccount_id()), Long.parseLong(commentForm.getCommunity_id()), commentForm.getContent());
        if(check != 0){
            return new ResponseEntity<String>("comment success", HttpStatus.OK);
        }
        return new ResponseEntity<String>("comment fail", HttpStatus.NO_CONTENT);
    }

    @ApiOperation(value = "블로그 게시물 번호에 해당하는 댓글들을 조회한다", response = List.class)
    @GetMapping(value = "/comment/article/{article_id}")
    public ResponseEntity<List<Comment>> ArticleComment(@PathVariable Long article_id){
        List<Comment> commentList = commentService.findCommentByArticle(article_id);
        for(Comment c : commentList){
            System.out.println("댓글 작성자: " + c.getAccount().getUsername());
            System.out.println("댓글 내용: " + c.getContent());
        }
        System.out.println("end point");
        return new ResponseEntity<List<Comment>>(commentList, HttpStatus.OK);
    }

    @ApiOperation(value = "커뮤니티 게시물 번호에 해당하는 댓글들을 조회한다", response = List.class)
    @GetMapping(value = "/comment/community/{community_id}")
    public ResponseEntity<List<Comment>> CommunityComment(@PathVariable Long community_id){
        List<Comment> commentList = commentService.findCommentByCommunity(community_id);
        for(Comment c : commentList){
            System.out.println("댓글 작성자: " + c.getAccount().getUsername());
            System.out.println("댓글 내용: " + c.getContent());
        }
        System.out.println("end point");
        return new ResponseEntity<List<Comment>>(commentList, HttpStatus.OK);
    }

    @ApiOperation(value = "댓글 전체를 조회한다", response = List.class)
    @GetMapping(value = "/comment")
    public ResponseEntity<List<Comment>> listCommentAll(){
        List<Comment> commentList = commentService.findCommentAll();
        return new ResponseEntity<List<Comment>>(commentList, HttpStatus.OK);
    }

    @ApiOperation(value = "댓글 번호에 해당하는 댓글을 수정한다", response = String.class)
    @PutMapping(value = "/comment/{comment_id}")
    public ResponseEntity<String> updateComment(@RequestBody Comment comment){
        int check = commentService.update(comment);
        if(check != 0){
            return new ResponseEntity<String>("success", HttpStatus.OK);
        }
        return new ResponseEntity<String>("fail", HttpStatus.NO_CONTENT);
    }

    @ApiOperation(value = "댓글 번호에 해당하는 댓글을 삭제한다", response = String.class)
    @DeleteMapping(value = "/comment/{comment_id}")
    public ResponseEntity<String> deleteComment(@PathVariable Long comment_id){
        int check = commentService.delete(comment_id);
        if(check != 0){
            return new ResponseEntity<String>("success", HttpStatus.OK);
        }
        return new ResponseEntity<String>("fail", HttpStatus.NO_CONTENT);
    }

}
