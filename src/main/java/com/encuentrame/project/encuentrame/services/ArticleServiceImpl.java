package com.encuentrame.project.encuentrame.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import com.encuentrame.project.encuentrame.entities.Article;
import com.encuentrame.project.encuentrame.entities.MyUser;
import com.encuentrame.project.encuentrame.repositories.ArticleRepository;
import com.encuentrame.project.encuentrame.repositories.MyUserRepository;
import com.encuentrame.project.encuentrame.service.ArticleService;

public class ArticleServiceImpl implements ArticleService{
    private final ArticleRepository articleRepository;
    private final MyUserRepository myUserRepository;

    @Autowired
    public ArticleServiceImpl(ArticleRepository articleRepository) { 
        this.articleRepository = articleRepository;
        this.myUserRepository = null; 
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
    public Article createArticle(String title, String content, UUID user_id) {
        MyUser myUser = myUserRepository.findById(user_id).orElseThrow();

        Article article = new Article();
        article.setTitle(title);
        article.setContent(content);
        article.setMyUser(myUser);

        return articleRepository.save(article);

    }

    @Override
    public Optional<Article> updateArticle(UUID id, Article updatedArticle) {
        return articleRepository.findById(id) 
                .map(article -> { 
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
