package com.example.articlemanagement.repository;

import com.example.articlemanagement.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {}
