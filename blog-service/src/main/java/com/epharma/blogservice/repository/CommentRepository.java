package com.epharma.blogservice.repository;

import java.util.List;

import com.epharma.blogservice.model.Comment;

public interface CommentRepository extends IGenericDao<Comment>{
    List<Comment> findAllCommentsOfArticle(final Long articleId);
    
}