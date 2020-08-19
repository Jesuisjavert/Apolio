package com.ssafy.apolio.web;

import com.ssafy.apolio.domain.Heart;
import com.ssafy.apolio.repository.BlogRepository;
import com.ssafy.apolio.repository.HeartRepository;
import com.ssafy.apolio.repository.UserRepository;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RequestMapping("/api")
@RestController
public class HeartContorller {

    @Autowired
    HeartRepository heartRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    BlogRepository blogRepository;


    @GetMapping("/heart")
    public ResponseEntity<String> getHeart(HttpServletRequest request) {
        Long blog_id = Long.parseLong(request.getParameter("blog_id"));
        Long user_id = Long.parseLong(request.getParameter("user_id"));
        Optional<Heart> heart =  heartRepository.findByIdAndUserId(blog_id,user_id);
        System.out.println(heart);
        if (heart.isPresent()){
            return new ResponseEntity<String>("true", HttpStatus.OK);
        }
        return new ResponseEntity<String>("false", HttpStatus.OK);
    }

    @PostMapping("/heart")
    public ResponseEntity<String> createHeart(@RequestBody HeartForm heartForm) {
        Heart heart = new Heart();
        try {
            heart.setBlog(blogRepository.findOne(heartForm.getBlog_id()));
            heart.setUser(userRepository.findById(heartForm.getUser_id()).get());
            heartRepository.save(heart);
            return new ResponseEntity<String>("true", HttpStatus.OK);
        }catch (Exception err){
            System.out.println(err);
        }
        return new ResponseEntity<String>("false", HttpStatus.OK);
    }
}
