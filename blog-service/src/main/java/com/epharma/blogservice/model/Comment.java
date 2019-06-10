package com.epharma.blogservice.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@Entity
@NoArgsConstructor
@Table(name = "comments")
public class Comment implements IModel {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "comment_body", columnDefinition = "BLOB")
    @NotEmpty(message = "*Please write something")
    private String body;

    @Column(name = "create_date", nullable = false, updatable = false)
    private LocalDateTime createDate ;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "article_id", referencedColumnName = "id")
    @NotNull
    private Article article;

    @Column(name = "user_id")
    @NotNull
    private Long userId;

}