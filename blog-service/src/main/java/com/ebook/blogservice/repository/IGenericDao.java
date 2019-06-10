package com.ebook.blogservice.repository;

import java.util.List;

import com.ebook.blogservice.model.IModel;

import org.hibernate.Session;

public interface IGenericDao<T extends IModel>{
    T find(Long id);
    List<T> findAll();
    void save(T entity);
    T update(T entity);
    void delete(final Long id);
    Session getSession();

}