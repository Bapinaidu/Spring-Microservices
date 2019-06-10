package com.ebook.logservice.service;

import java.util.List;

import com.ebook.logservice.model.Log;
import com.ebook.logservice.model.Summary;

public interface LogService {
    Log saveOrUpdate(Log log);
    Summary saveOrUpdate(Summary summary);
    List<Summary> findPopularArticles();
    Summary findSummaryByArticleId(Long articleId);
}