package com.encuentrame.project.encuentrame.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.encuentrame.project.encuentrame.entities.Article;

public interface ArticleRepository extends JpaRepository<Article, UUID> {
    
}
