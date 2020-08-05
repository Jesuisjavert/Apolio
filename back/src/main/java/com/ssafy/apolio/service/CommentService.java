package com.ssafy.apolio.service;

import com.ssafy.apolio.domain.Article;
import com.ssafy.apolio.domain.Comment;
import com.ssafy.apolio.domain.Community;
import com.ssafy.apolio.domain.account.Account;
import com.ssafy.apolio.repository.AccountRepository;
import com.ssafy.apolio.repository.ArticleRepository;
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
    private final ArticleRepository articleRepository;
    private final AccountRepository accountRepository;
    private final CommunityRepository communityRepository;

    @Transactional
    public long commentArticle(Long account_id, Long article_id, String content){
        Account account = accountRepository.findOne(account_id);
        Article article = articleRepository.findOne(article_id);
        Comment comment = Comment.createCommentArticle(account, article, content);
        commentRepository.save(comment);

        return comment.getId();
    }

    @Transactional
    public long commentCommunity(Long account_id, Long community_id, String content){
        Account account = accountRepository.findOne(account_id);
        Community community = communityRepository.findOne(community_id);
        Comment comment = Comment.createCommentCommuinty(account, community, content);
        commentRepository.save(comment);

        return comment.getId();
    }


    public List<Comment> findCommentByArticle(Long id){
        return commentRepository.findAllByArticleId(id);
    }

    public List<Comment> findCommentByCommunity(Long id){
        return commentRepository.findAllByCommId(id);
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
