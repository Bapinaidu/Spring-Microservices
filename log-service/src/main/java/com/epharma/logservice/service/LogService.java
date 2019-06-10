package com.epharma.logservice.service;

import java.util.List;

import com.epharma.logservice.model.Log;
import com.epharma.logservice.model.Summary;

public interface LogService {
    Log saveOrUpdate(Log log);
    Summary saveOrUpdate(Summary summary);
    List<Summary> findPopularArticles();
    Summary findSummaryByArticleId(Long articleId);
}