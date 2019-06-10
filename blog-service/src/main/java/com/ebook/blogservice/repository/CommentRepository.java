package com.ebook.blogservice.repository;

import java.util.List;

import com.ebook.blogservice.model.Comment;

public interface CommentRepository extends IGenericDao<Comment>{
    List<Comment> findAllCommentsOfArticle(final Long articleId);
    
}