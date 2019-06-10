package com.epharma.logservice.repository;

import java.util.UUID;

import com.epharma.logservice.model.Log;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends CrudRepository<Log,UUID>{

}