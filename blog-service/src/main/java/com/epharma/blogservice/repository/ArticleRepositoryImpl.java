package com.epharma.blogservice.repository;

import java.util.List;

import javax.persistence.Query;

import com.epharma.blogservice.model.Article;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class ArticleRepositoryImpl extends AbstractGenericDao<Article> implements ArticleRepository {

    @Override
    public List<Article> filterArticles(final String text){
        String hql = "Select c from Article c Where 1=1 AND c.status = VERIFIED ";
        if(text!= null && !"".equals(text.trim())){
            hql+="AND (lower(c.title) like lower(:pText) or lower(c.category) like lower(:pText) or lower(c.author) like  lower(:pText)";
        }

        Query query = em.createQuery(hql);
        if (text!=null && !"".equals(text.trim())){
            query.setParameter("pText","%"+text+"%");

        }
        return query.getResultList();
    }

    @Override
    public List<Article> filterArticleByIdList(final List<Long> idList){
        String hql = "Select c from Article c where c.id = (:pIdList)";
        Query query = em.createQuery(hql);
        query.setParameter("pIdList", idList);
        return query.getResultList();
        
    }

    @Override
    public List<Article> filterArticleByAuthorId(final Long authorId){
        String hql = "Select c from Article c where c.authorId = (:pAuthorId)";
        Query query = em.createQuery(hql);
        query.setParameter("pAuthorId", authorId);
        return query.getResultList();
    }
    
}