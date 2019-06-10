package com.ebook.userservice.service;

import java.util.List;

import com.ebook.userservice.model.User;

public interface UserService {
    void save(User user);
    User findByUsername(String username);

    List<String> findUsers(List<Long> idList);
}