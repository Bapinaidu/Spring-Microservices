package com.epharma.logservice.model;


import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Table("summary")
public class Summary implements IModel{

    private static final long serialVersionUID = 1L;

    @PrimaryKeyColumn(name = "article_id",type = PrimaryKeyType.PARTITIONED)
    private Long articleId;

    @PrimaryKeyColumn(name = "hit_count",ordinal = 0,type = PrimaryKeyType.CLUSTERED,ordering = Ordering.DESCENDING)
    private Long hitCount;
}