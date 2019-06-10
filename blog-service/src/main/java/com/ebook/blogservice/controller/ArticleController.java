package com.ebook.blogservice.controller;

import java.time.LocalDateTime;
import java.util.List;

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

import com.ebook.blogservice.intercomm.LogClient;
import com.ebook.blogservice.intercomm.UserClient;
import com.ebook.blogservice.model.Comment;
import com.ebook.blogservice.service.ArticleService;

@RestController
public class ArticleController{

    @Autowired
    private LogClient logClient;

    @Autowired
    private UserClient userClient;

    @Autowired
    private ArticleService articleService;

    @GetMapping("/popular")
    public ResponseEntity<?> popularArticles(){
        List<Long> popularIdList = logClient.getPopularArticles();
        if(popularIdList==null || popularIdList.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(articleService.filterArticleByIdList(popularIdList), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<?> allArticles(){
        return new ResponseEntity<>(articleService.allArticles(), HttpStatus.OK);
    }

    @PostMapping("/filter")
    public ResponseEntity<?> filterCourses(@RequestBody String text){
        return new ResponseEntity<>(articleService.filterArticles(text), HttpStatus.OK);
    }

    @PostMapping("/comment")
    public ResponseEntity<?> saveTransaction(@RequestBody Comment comment){
        comment.setCreateDate(LocalDateTime.now());
        comment.setArticle(articleService.findArticleById(comment.getArticle().getId()));
        articleService.saveComment(comment);
        return ResponseEntity.ok(comment);
    }

    @PostMapping("/user")
    public ResponseEntity<?> authorArticles(@RequestBody Long authorId){
        return new ResponseEntity<>(articleService.findAuthorArticles(authorId), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET,value = "/service/userdetails/{name}")
    public ResponseEntity<?> getDetails(@PathVariable String name) {
        return new ResponseEntity<>(userClient.getDetails(name),HttpStatus.OK);
        
    }
    
    @RequestMapping(method = RequestMethod.GET,value = "/service/hello/{name}")
    public String getUserHello(@PathVariable String name) {
        return userClient.getUserHello(name);
        
    }
    

}