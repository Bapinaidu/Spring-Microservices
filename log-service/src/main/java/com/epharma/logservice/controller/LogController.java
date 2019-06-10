package com.epharma.logservice.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.epharma.logservice.model.Log;
import com.epharma.logservice.model.Summary;
import com.epharma.logservice.service.LogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogController{
    @Autowired
    private LogService logService;

    @PostMapping("/service/create")
    public ResponseEntity<?> saveLog(@RequestBody Log log){
        log.setLogDate(LocalDateTime.now());
        logService.saveOrUpdate(log);
        return ResponseEntity.ok(log);
    }

    @GetMapping("/service/popular")
    public ResponseEntity<?> findPopularArticles(){
        List<Long> idList = null;
        List<Summary> populars = logService.findPopularArticles();
        if(populars !=null){
            idList = populars.parallelStream().map(s->s.getArticleId()).collect(Collectors.toList());

        }
        return ResponseEntity.ok(idList);
        
    }

    @GetMapping("/service/summary")
    public ResponseEntity<?> getSummaryOfArticle(@RequestBody Long articleId){
        return new ResponseEntity<>(logService.findSummaryByArticleId(articleId),HttpStatus.OK);

    }

}