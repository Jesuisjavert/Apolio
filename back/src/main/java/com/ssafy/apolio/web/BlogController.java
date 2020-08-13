package com.ssafy.apolio.web;

import com.ssafy.apolio.domain.Blog;
import com.ssafy.apolio.domain.BlogSearch;
import com.ssafy.apolio.domain.Comment;
import com.ssafy.apolio.repository.HeartRepository;
import com.ssafy.apolio.service.BlogService;
import com.ssafy.apolio.service.CommentService;
import com.ssafy.apolio.service.HeartService;
import com.ssafy.apolio.service.TagService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class BlogController {
    private final BlogService blogService;
    private final CommentService commentService;
    private final HeartService heartService;
    private final TagService tagService;

    @Autowired
    private HeartRepository heartRepository;

    @ApiOperation(value = "태그 아이디, 제목, 내용, 이미지를 입력받아서 게시물을 작성한다.", response = String.class)
    @PostMapping(value = "/blog")
    public ResponseEntity<String> insertBoard(@RequestBody BlogForm blogForm, @RequestParam("tagId") Long tagId){
        Long check = blogService.blog(blogForm.getUser(), tagId, blogForm.getTitle(), blogForm.getContent(), blogForm.getImg_thumb());
        if(check != 0){
            return new ResponseEntity<String>("blog success", HttpStatus.OK);
        }
        return new ResponseEntity<String>("blog fail", HttpStatus.NO_CONTENT);
    }
    @ApiOperation(value = "게시물 전체를 조회한다.", response = List.class)
    @GetMapping(value = "/blog")
    public ResponseEntity<List<Blog>> blogList(){
        List<Blog> blogs = blogService.findBlogsAll();
        for(Blog blog : blogs){
            System.out.println("게시물 제목 : " + blog.getTitle());
            System.out.println("게시물 내용 : " + blog.getContent());
            List<Comment> commentList = blog.getComments();
            for(Comment comment : commentList){
                System.out.println("게시물 댓글 : " + comment.getContent());
            }
        }
        return new ResponseEntity<List<Blog>>(blogs, HttpStatus.OK);
    }

    @ApiOperation(value = "태그 이름, 게시물 제목을 입력받아서 해당하는 게시물들을 조회한다.")
    @GetMapping(value = "/blog/search")
    public ResponseEntity<List<Blog>> blogSearchList(@RequestBody BlogSearch blogSearch){
        List<Blog> blogs = blogService.findBlogs(blogSearch);
        return new ResponseEntity<List<Blog>>(blogs, HttpStatus.OK);
    }

    @ApiOperation(value = "게시물 번호를 입력받아 해당하는 게시물을 조회한다.", response = Blog.class)
    @GetMapping(value = "/blog/{id}")
    public ResponseEntity<Blog> blogDetail(@PathVariable Long id){
        Blog blog = blogService.findBlog(id);
        System.out.println(blog.getTitle());
//        for(Comment c : board.getComments()){
//            System.out.println("댓글 작성자: " + c.getUser().getUsername());
//            System.out.println("댓글 내용: " + c.getContent());
//        }
        System.out.println(blog.getContent());
        return new ResponseEntity<Blog>(blog, HttpStatus.OK);
    }
}
