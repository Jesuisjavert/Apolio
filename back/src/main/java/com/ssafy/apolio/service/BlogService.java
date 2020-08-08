package com.ssafy.apolio.service;

import com.ssafy.apolio.domain.Blog;
import com.ssafy.apolio.domain.user.User;
import com.ssafy.apolio.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BlogService {

    @Transactional
    public Long blog(String title, String content, String username) {
        User user = new User();
        user.setUsername(username);
        Blog community = Blog.createBlog(title, content, user);
        blogRepository.save(community);

        return community.getId();
    }

    private final BlogRepository blogRepository;

    public List<Blog> findBlogAll() {
        return blogRepository.findAll();
    }
    public Blog findBlog(Long community_id) {
        return blogRepository.findOne(community_id);
    }
    @Transactional
    public int updateBlog(Blog community){
        return blogRepository.updateCommunityById(community);
    }

    @Transactional
    public int deleteBlog(Long id){
        return blogRepository.deleteCommunityById(id);
    }


}
