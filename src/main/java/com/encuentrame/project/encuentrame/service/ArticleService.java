package com.encuentrame.project.encuentrame.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.encuentrame.project.encuentrame.entities.Article;

public interface ArticleService {
    List<Article> getAllArticles(); 
  
    Optional<Article> getArticleById(UUID id); 
    Article createArticle(Article Article); 
  
    Optional<Article> updateArticle(UUID id, Article updatedArticle); 
  
    boolean deleteArticle(UUID id); 
}
