package com.epharma.blogservice.service;

import java.util.List;

import com.epharma.blogservice.model.Article;
import com.epharma.blogservice.model.Comment;

public interface ArticleService {

    List<Article> allArticles();

    List<Article> filterArticleByIdList(List<Long> idList);

    List<Article> filterArticles(String content);

    List<Comment> filterCommentsOfArticle(Long articleId);

    void saveComment(Comment comment);

    Article findArticleById(Long articleId);

    void saveArticle(Article article);

    List<Article> findAuthorArticles(Long authorId);
}