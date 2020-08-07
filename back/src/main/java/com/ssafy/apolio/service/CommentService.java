package com.ssafy.apolio.service;

import com.ssafy.apolio.domain.Board;
import com.ssafy.apolio.domain.Comment;
import com.ssafy.apolio.domain.Blog;
import com.ssafy.apolio.domain.account.User;
import com.ssafy.apolio.repository.AccountRepository;
import com.ssafy.apolio.repository.BoardRepository;
import com.ssafy.apolio.repository.CommentRepository;
import com.ssafy.apolio.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final BoardRepository boardRepository;
    private final AccountRepository accountRepository;
    private final BlogRepository blogRepository;

    @Transactional
    public long commentBoard(Long user_id, Long article_id, String content){
        User user = accountRepository.findOne(user_id);
        Board board = boardRepository.findOne(article_id);
        Comment comment = Comment.createCommentBoard(user.getUsername(), board, content);
        commentRepository.save(comment);

        return comment.getId();
    }

    @Transactional
    public long commentBlog(Long user_id, Long blog_id, String content){
        User user = accountRepository.findOne(user_id);
        Blog blog = blogRepository.findOne(blog_id);
        Comment comment = Comment.createCommentBlog(user.getUsername(), blog, content);
        commentRepository.save(comment);

        return comment.getId();
    }


    public List<Comment> findCommentByBoard(Long id){
        return commentRepository.findAllByBoardId(id);
    }

    public List<Comment> findCommentByBlog(Long id){
        return commentRepository.findAllByBlogId(id);
    }

    public List<Comment> findCommentAll(){
        return commentRepository.findAll();
    }

    @Transactional
    public int update(Comment comment){
        return commentRepository.updateCommentById(comment);
    }

    @Transactional
    public int delete(Long comment_id){
        return commentRepository.deleteComment(comment_id);
    }

}
