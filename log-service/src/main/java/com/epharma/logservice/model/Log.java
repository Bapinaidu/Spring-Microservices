package com.epharma.logservice.model;

import java.time.LocalDateTime;
import java.util.UUID;

import com.datastax.driver.core.DataType;

import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.Data;

@Data
@Table("log")
public class Log implements IModel{

    private static final long serialVersionUID = 1L;

    @PrimaryKey
    @CassandraType(type = DataType.Name.UUID)
    private UUID id;

    @Column("ip")
    private String ip;

    @Column("article_id")
    private Long articleId;

    @Column("log_date")
    private LocalDateTime logDate;


}