package com.ebook.logservice.repository;

import java.util.UUID;

import com.ebook.logservice.model.Log;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends CrudRepository<Log,UUID>{

}