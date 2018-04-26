package com.wuhan.awe.Repositry;

import com.wuhan.awe.Entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepositry extends JpaRepository<Article, Integer> {

}
