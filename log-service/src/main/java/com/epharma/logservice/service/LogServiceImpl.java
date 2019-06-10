package com.epharma.logservice.service;

import java.util.List;
import java.util.UUID;

import com.epharma.logservice.model.Log;
import com.epharma.logservice.model.Summary;
import com.epharma.logservice.repository.LogRepository;
import com.epharma.logservice.repository.SummaryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class LogServiceImpl implements LogService{

    @Autowired
    private LogRepository logRepository;

    @Autowired
    private SummaryRepository summaryRepository;

    @Override
    public Log saveOrUpdate(Log log){
        Summary exitSummary = summaryRepository.findByArticleId(log.getArticleId()).orElse(null);
        if (exitSummary!=null){
            summaryRepository.delete(exitSummary);
            exitSummary.setHitCount(exitSummary.getHitCount()+1);
            summaryRepository.save(exitSummary);
        }else{
            Summary Summary = new Summary();
            Summary.setArticleId(log.getArticleId());
            Summary.setHitCount(1L);
            summaryRepository.save(Summary);
        }
        log.setId(UUID.randomUUID());
        logRepository.save(log);
        return log;
    }
    @Override
    public Summary saveOrUpdate(Summary summary) {
        summaryRepository.save(summary);
        return summary;
    }
    @Override
    public List<Summary> findPopularArticles(){
        return summaryRepository.findPopularArticles();
    }
    @Override
    public Summary findSummaryByArticleId(Long articleId){
        return summaryRepository.findByArticleId(articleId).orElse(null);
    }
}