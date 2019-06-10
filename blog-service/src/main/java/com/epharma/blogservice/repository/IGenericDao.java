package com.epharma.blogservice.repository;

import java.util.List;

import com.epharma.blogservice.model.IModel;

import org.hibernate.Session;

public interface IGenericDao<T extends IModel>{
    T find(Long id);
    List<T> findAll();
    void save(T entity);
    T update(T entity);
    void delete(final Long id);
    Session getSession();

}