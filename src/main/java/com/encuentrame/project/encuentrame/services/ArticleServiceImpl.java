package com.encuentrame.project.encuentrame.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import com.encuentrame.project.encuentrame.entities.Article;
import com.encuentrame.project.encuentrame.repositories.ArticleRepository;
import com.encuentrame.project.encuentrame.service.ArticleService;

public class ArticleServiceImpl implements ArticleService{
    private final ArticleRepository articleRepository;

    @Autowired
    public ArticleServiceImpl(ArticleRepository articleRepository) { 
        this.articleRepository = articleRepository; 
    }
    
    @Override
    public List<Article> getAllArticles() {
        return articleRepository.findAll(); 
    }

    @Override
    public Optional<Article> getArticleById(UUID id) {
        return articleRepository.findById(id);
    }

    @Override
    public Article createArticle(Article article) {
        return articleRepository.save(article);
    }

    @Override
    public Optional<Article> updateArticle(UUID id, Article updatedArticle) {
        return articleRepository.findById(id) 
                .map(article -> { 
                    article.setMyUser(updatedArticle.getMyUser()); 
                    article.setTitle(updatedArticle.getTitle()); 
                    article.setContent(updatedArticle.getContent()); 
                    return articleRepository.save(article); 
                });
    }

    @Override
    public boolean deleteArticle(UUID id) {
        return articleRepository.findById(id) 
                .map(article -> { 
                    articleRepository.delete(article); 
                    return true; 
                }) 
                .orElse(false); 
    }
    
}
