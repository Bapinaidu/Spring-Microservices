package com.ebook.userservice.service;

public interface SecurityService {
    String findLoggedInUsername();
    void autoLogin(String username, String password);
}
