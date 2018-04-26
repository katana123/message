package com.wuhan.awe.Repositry;

import com.wuhan.awe.Entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;

import javax.persistence.QueryHint;
import java.util.List;

public interface ArticleRepositry extends JpaRepository<Article, Integer> {

    @QueryHints({@QueryHint(name=org.hibernate.ejb.QueryHints.HINT_CACHEABLE,value="true")})
    @Query("FROM Article d")
    List<Article> getAll();

}
