package com.wuhan.awe.Repositry;

import com.wuhan.awe.Entity.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;

import javax.persistence.QueryHint;
import java.util.List;

@Repository
public interface ArticleRepositry extends JpaRepository<Article, Integer>, JpaSpecificationExecutor<Article> {

    @QueryHints({@QueryHint(name=org.hibernate.ejb.QueryHints.HINT_CACHEABLE,value="true")})
    @Query("FROM Article d")
    List<Article> getAll();

    @Override
    @Query(value = "select a.*,count(c.cid) as num from article a left join comment c on a.id = c.article_id group by a.id", nativeQuery = true)
    Page<Article> findAll(Pageable pageable);
}
