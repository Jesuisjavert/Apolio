package com.ssafy.apolio.service;

import com.ssafy.apolio.domain.Board;
import com.ssafy.apolio.domain.Comment;
import com.ssafy.apolio.domain.Community;
import com.ssafy.apolio.domain.user.User;
import com.ssafy.apolio.repository.AccountRepository;
import com.ssafy.apolio.repository.BoardRepository;
import com.ssafy.apolio.repository.CommentRepository;
import com.ssafy.apolio.repository.CommunityRepository;
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
    private final CommunityRepository blogRepository;

    @Transactional
    public long commentBoard(String username, Long board_id, String content){
        User user = accountRepository.findByName(username);
        Board board = boardRepository.findOne(board_id);
        Comment comment = Comment.createCommentBoard(user, board, content);
        commentRepository.save(comment);

        return comment.getId();
    }
    @Transactional
    public long replyBoard(Long parent, String username, Long board_id, String content){
        User user = accountRepository.findByName(username);
        Board board = boardRepository.findOne(board_id);
        Comment parentComment = commentRepository.findOneByBoardId(board_id, parent);
        int ok = commentRepository.updateParentComment(parentComment.getId());//첫번 째 댓글 그룹 지정
        if(ok != 0){
            Comment comment = Comment.createReplyBoard(parent, user, board, content);//대댓글 입력 및 그룹 지정
            commentRepository.save(comment);
            return comment.getId();
        }
//        Comment comment = Comment.createReplyBoard(parent, user, board, content);//대댓글 입력 및 그룹 지정
//        commentRepository.save(comment);

        return 0;
    }

    @Transactional
    public long commentCommunity(String username, Long blog_id, String content){
        User user = accountRepository.findByName(username);
        Community blog = blogRepository.findOne(blog_id);
        Comment comment = Comment.createCommentCommunity(user, blog, content);
        commentRepository.save(comment);

        return comment.getId();
    }
    @Transactional
    public long replyCommunity(Long parent, String username, Long blog_id, String content){
        User user = accountRepository.findByName(username);
        Community blog = blogRepository.findOne(blog_id);
        Comment parentComment = commentRepository.findOneByBlogId(blog_id, parent);
        int ok = commentRepository.updateParentComment(parentComment.getId());//첫번 째 댓글 그룹 지정
        if(ok != 0){
            Comment comment = Comment.createReplyCommunity(parent, user, blog, content);//대댓글 입력 및 그룹 지정
            commentRepository.save(comment);
            return comment.getId();
        }
//        Comment comment = Comment.createReplyBlog(parent, user, blog, content);
//        commentRepository.save(comment);

        return 0;
    }


    public List<Comment> findCommentByBoard(Long id){
        return commentRepository.findAllByBoardId(id);
    }

    public List<Comment> findCommentByCommunity(Long id){
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
        return commentRepository.deleteCommentById(comment_id);
    }

}
