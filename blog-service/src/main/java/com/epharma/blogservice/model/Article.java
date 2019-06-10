package com.epharma.blogservice.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
// import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
// import javax.persistence.JoinColumn;
// import javax.persistence.JoinTable;
// import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "articles")
public class Article implements IModel{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "content",columnDefinition = "LONGBLOB")
    private String content;

    @Column(name = "author_id")
    private Long authorId;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @Column(name = "author")
    private String author;

    @Column(name = "create_date")
    private Date createTime = new Date();

    // @ManyToMany(fetch = FetchType.LAZY)
    // @JoinTable(name = "article_tag",
    //         joinColumns = @JoinColumn(name = "article_id"),
    //         inverseJoinColumns = @JoinColumn(name = "tag_id"))
    // @Column(nullable = false)
    // private List<Tag> tags;
    

}