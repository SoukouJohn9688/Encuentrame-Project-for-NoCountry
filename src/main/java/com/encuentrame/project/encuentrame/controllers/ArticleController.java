package com.encuentrame.project.encuentrame.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.encuentrame.project.encuentrame.entities.Article;
import com.encuentrame.project.encuentrame.repositories.ArticleRepository;
import com.encuentrame.project.encuentrame.services.ArticleServiceImpl;

@RestController
public class ArticleController {

    private final ArticleRepository articleRepository;
    private final ArticleServiceImpl articleServiceImpl;

    @Autowired
    public ArticleController(ArticleRepository articleRepository, ArticleServiceImpl articleServiceImpl) { 
        this.articleRepository = articleRepository;
        this.articleServiceImpl = articleServiceImpl; 
    } 
  
    // Endpoint to retrieve all articles 
    @GetMapping("/api/articles")
    public ResponseEntity<List<Article>> getAllArticles() { 
        List<Article> articles = articleServiceImpl.getAllArticles();
        return new ResponseEntity<>(articles, HttpStatus.OK); 
    } 
  
    // Endpoint to retrieve a article by ID 
    @GetMapping("/api/articles/{id}") 
    public ResponseEntity<Article> getArticleById(@PathVariable UUID id) { 
        return articleRepository.findById(id).map(article -> new ResponseEntity<>(article, HttpStatus.OK)) 
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND)); 
    } 
  
    // Endpoint to create a new article 
    @PostMapping("/api/articles")
    public ResponseEntity<Article> createArticle(@RequestBody Article article) { 
        Article savedArticle = articleRepository.save(article); 
        return new ResponseEntity<>(savedArticle, HttpStatus.CREATED); 
    } 
  
    // Endpoint to update an existing article 
    @PutMapping("/api/articles/{id}") 
    public ResponseEntity<Article> updateArticle(@PathVariable UUID id, @RequestBody Article updatedArticle) { 
        return articleRepository.findById(id).map(article -> { 
            article.setTitle(updatedArticle.getTitle()); 
            article.setContent(updatedArticle.getContent()); 
            Article savedArticle = articleRepository.save(article); 
            return new ResponseEntity<>(savedArticle, HttpStatus.OK); 
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND)); 
    } 
  
    // Endpoint to delete a article by ID 
    @DeleteMapping("/api/articles/{id}") 
    public ResponseEntity<Void> deletearticle(@PathVariable UUID id) { 
        return articleRepository.findById(id).map(article -> { 
            articleRepository.delete(article); 
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT); 
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND)); 
    } 
} 