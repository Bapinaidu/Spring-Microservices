package com.ebook.userservice.controller;

import java.security.Principal;
import java.util.List;

import com.ebook.userservice.model.Role;
import com.ebook.userservice.model.User;
import com.ebook.userservice.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/service/registration")
    public ResponseEntity<?> register(@RequestBody User user) {
        if(userService.findByUsername(user.getUsername())!= null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        user.setRole(Role.USER);
        userService.save(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping("/service/user")
    public ResponseEntity<?> getUser(Principal principal) {
        if(principal==null || principal.getName() == null){
            return ResponseEntity.ok(principal);
        }
        return new ResponseEntity<User>(userService.findByUsername(principal.getName()),HttpStatus.OK);
        
    }
    @RequestMapping(method = RequestMethod.POST,value = "/service/names")
    public ResponseEntity<?> getUsers(@RequestBody List<Long> idList) {
        return ResponseEntity.ok(userService.findUsers(idList));
        
    }
    
    @RequestMapping(method = RequestMethod.GET,value = "/service/userdetails/{name}")
    public ResponseEntity<?> getDetails(@PathVariable String name) {
        return new ResponseEntity<User>(userService.findByUsername(name),HttpStatus.OK);
        
    }
    
    @RequestMapping(method = RequestMethod.GET,value = "/service/hello/{name}")
    public String getUserHello(@PathVariable String name) {
        return "Hi How Are you "+name;
        
    }
}