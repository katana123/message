package com.wuhan.awe.Service;

import com.wuhan.awe.Entity.Article;
import com.wuhan.awe.Repositry.ArticleRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;


@Service
public class ArticleService {

    @Autowired
    private ArticleRepositry articleRepositry;

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
    public Page<Article> getPage(int pageNo, int pageSize){
        PageRequest pageable = new PageRequest(pageNo-1, pageSize);
        return articleRepositry.findAll(pageable);
    }
}
