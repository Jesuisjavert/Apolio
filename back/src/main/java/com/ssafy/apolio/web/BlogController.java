package com.ssafy.apolio.web;

import com.ssafy.apolio.domain.Blog;
import com.ssafy.apolio.service.BlogService;
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
public class BlogController {

    private final BlogService blogService;

    @ApiOperation(value = "유저 아이디, 제목, 내용을 입력받아서 블로그 게시물을 작성한다.", response = String.class)
    @PostMapping(value = "/blog")
    public ResponseEntity<String> insertBlog(@RequestBody BlogForm blogForm){
        Long check = blogService.blog(blogForm.getTitle(), blogForm.getContent(), blogForm.getUsername());
        if(check != 0){
            return new ResponseEntity<String>("blog success", HttpStatus.OK);
        }
        return new ResponseEntity<String>("blog fail", HttpStatus.NO_CONTENT);
    }
    @ApiOperation(value = "블로그 게시물 전체를 조회한다.", response = List.class)
    @GetMapping(value = "/blog")
    public ResponseEntity<List<Blog>> blogList(){
        List<Blog> blogs = blogService.findBlogAll();
        return new ResponseEntity<List<Blog>>(blogs, HttpStatus.OK);
    }

    @ApiOperation(value = "게시물 번호에 해당하는 블로그 게시물을 조회한다.", response = Blog.class)
    @GetMapping(value = "/blog/{id}")
    public ResponseEntity<Blog> blogSearch(@PathVariable Long id){
        Blog blog = blogService.findBlog(id);

        return new ResponseEntity<Blog>(blog, HttpStatus.OK);
    }
    @ApiOperation(value = "게시물 번호에 해당하는 블로그 게시물을 받아서 수정한다.", response = String.class)
    @PutMapping("/blog/{id}")
    public ResponseEntity<String> updateBlog(@RequestBody Blog blog){
        int check = blogService.updateBlog(blog);
        if(check != 0){
            return new ResponseEntity<String>("success", HttpStatus.OK);
        }
        return new ResponseEntity<String>("fail", HttpStatus.NO_CONTENT);
    }


    @ApiOperation(value = "게시물 번호로 블로그 게시물을 삭제한다.", response = String.class)
    @DeleteMapping("/blog/{id}")
    public ResponseEntity<String> deleteBlog(@PathVariable Long id){
        int check = blogService.deleteBlog(id);
        if(check != 0){
            return new ResponseEntity<String>("success", HttpStatus.OK);
        }
        return new ResponseEntity<String>("fail", HttpStatus.NO_CONTENT);
    }


}
