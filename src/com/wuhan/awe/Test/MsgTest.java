package com.wuhan.awe.Test;

import com.wuhan.awe.Entity.Article;
import com.wuhan.awe.Service.ArticleService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MsgTest {

    private ApplicationContext ctx = null;
    @Autowired
    private ArticleService articleService = null;

    {
        ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        articleService = ctx.getBean(ArticleService.class);
    }

    @Test
    public void testDataSource() throws SQLException {
        DataSource dataSource = ctx.getBean(DataSource.class);
        System.out.println(dataSource.getConnection());
    }

    @Test
    public void testJS() {
        Page<Article> articles = articleService.getPage(2, 5);
        Map map = new HashMap();
//        System.out.println(articles.getClass());
//        System.out.println(articles.getTotalElements());
//        //按照当前分页大小，总页数
//        System.out.println(articles.getTotalPages());
//        //按照当前页数、分页大小，查出的分页结果集合
//        for (Article article: articles.getContent()) {
//            System.out.println(article.toString());
//        }
        map.put("aa", map);
        for (Object obj : map.keySet()) {
            Object value = map.get(obj);
            System.out.println(value);
        }
        System.out.println("-------------------------------------------");
    }

}
