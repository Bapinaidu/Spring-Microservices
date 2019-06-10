package com.epharma.blogservice.repository;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import com.epharma.blogservice.model.Comment;

import org.springframework.stereotype.Repository;

@Transactional
@Repository
public class CommentRepositoryImpl extends AbstractGenericDao<Comment> implements CommentRepository {

    @Override
    public List<Comment> findAllCommentsOfArticle(final Long articleId){
        String hql = "Select t from Comment t Where t.article.id = :pArticleId";
        Query query = em.createQuery(hql);
        query.setParameter("pArticleId", articleId);
        return query.getResultList();
    }




}