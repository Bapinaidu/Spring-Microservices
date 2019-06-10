package com.epharma.logservice.repository;

import java.util.List;
import java.util.Optional;

import com.epharma.logservice.model.Summary;

import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface SummaryRepository extends CrudRepository<Summary,Long>{
    Optional<Summary> findByArticleId(Long articleId);

    @Query("update summary set hit_count = hit_count + 1 where article_id=?0")
    void incrementHitCount(Long articleId);

    @Query("select * from summary limit 100")
    List<Summary> findPopularArticles();
}