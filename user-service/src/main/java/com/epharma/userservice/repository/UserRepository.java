package com.epharma.userservice.repository;

import java.util.List;

import com.epharma.userservice.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User,Long>{
    User findByUsername(String username);

    @Query("select u.name from User u where u.id in (:pIdList)")
    List<String> findUserNames(@Param("pIdList")List<Long> idList);

}