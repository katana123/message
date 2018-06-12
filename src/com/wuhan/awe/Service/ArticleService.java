package com.wuhan.awe.Service;

import com.wuhan.awe.Entity.Article;
import com.wuhan.awe.Entity.Comment;
import com.wuhan.awe.Repositry.ArticleRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class ArticleService {

    @Autowired
    private ArticleRepositry articleRepositry;

    @Transactional
    public Page<Article> getArticleByPageable(int pageNo, int pageSize) {
        Pageable pageable = new PageRequest(pageNo, pageSize);
        return articleRepositry.findAll(pageable);
    }

    //删除一个article对象
    @Transactional
    public void delete(Integer id){ articleRepositry.delete(id);}


    //获取一个article对象
    @Transactional(readOnly = true)
    public Article get(Integer id){
        return  articleRepositry.findOne(id);
    }

    //保存
    public void save(Article article){
        article.setCreateTime(new Date());
        articleRepositry.saveAndFlush(article);
    }

    //显示和分页
    @Transactional(readOnly = true)
    public Page<Article> getPage(int pageNo, int pageSize) {
        return (Page<Article>) articleRepositry.findAll(new Specification<Article>() {
            @Override
            public Predicate toPredicate(Root<Article> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> list = new ArrayList<>();
                Join<Article, Comment> join = root.join("comments", JoinType.LEFT);
                query.groupBy(root.get("id"));

                return cb.and(list.toArray(new Predicate[list.size()]));
            }
        }, new PageRequest(pageNo, pageSize));
    }


}
