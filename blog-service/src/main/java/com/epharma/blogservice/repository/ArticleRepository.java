package com.epharma.blogservice.repository;

import java.util.List;

import com.epharma.blogservice.model.Article;

public interface ArticleRepository extends IGenericDao<Article>{
    List<Article> filterArticles(final String text);
    List<Article> filterArticleByIdList(final List<Long> idList);
    List<Article> filterArticleByAuthorId(final Long authorId);
}