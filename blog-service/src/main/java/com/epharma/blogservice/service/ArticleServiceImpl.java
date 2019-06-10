package com.epharma.blogservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.epharma.blogservice.model.Article;
import com.epharma.blogservice.model.Comment;
import com.epharma.blogservice.repository.ArticleRepository;
import com.epharma.blogservice.repository.CommentRepository;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public List<Article> allArticles() {
        return articleRepository.findAll();
    }

    @Override
    public List<Article> filterArticleByIdList(final List<Long> idList){
        return articleRepository.filterArticleByIdList(idList);
    }

    @Override
    public List<Article> filterArticles(final String content) {
        return articleRepository.filterArticles(content);
    }

    @Override
    public List<Comment> filterCommentsOfArticle(final Long ArticleId){
        return commentRepository.findAllCommentsOfArticle(ArticleId);
    }

    @Override
    public void saveComment(final Comment Comment){
        commentRepository.save(Comment);
    }

    @Override
    public Article findArticleById(Long ArticleId){
        return articleRepository.find(ArticleId);
    }

    @Override
    public void saveArticle(final Article article){
        articleRepository.save(article);
    }

    @Override
    public List<Article> findAuthorArticles(Long authorId){
        return articleRepository.filterArticleByAuthorId(authorId);
    }
}