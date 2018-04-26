package com.wuhan.awe.Handler;

import com.wuhan.awe.Entity.Article;
import com.wuhan.awe.Service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.Map;

@Controller
public class ArticleHandler {

    @Autowired
    private ArticleService articleService;

    //完成删除并跳转到List页面
    @RequestMapping(value="/article/{id}",method=RequestMethod.DELETE)
    public String delete(@PathVariable("id") Integer id){
        articleService.delete(id);
        return "redirect:/articles";
    }

    //完成修改并跳转到List页面
    @RequestMapping(value="/article/{id}",method=RequestMethod.PUT)
    public String save(Article article){
        article.setUpdateTime(new Date());
        articleService.save(article);
        return "redirect:/articles";
    }

    //修改回显，比添加多传一个id
    @RequestMapping(value="/article/{id}",method=RequestMethod.GET)
    public String input(@PathVariable("id") Integer id,Map<String, Object> map){
        Article article = articleService.get(id);
        map.put("article",article);
        return "/article/add";
    }

    //完成添加并跳转到List页面
    @RequestMapping(value="/article",method=RequestMethod.POST)
    public String update(Article article){
        articleService.save(article);
        return "redirect:/articles";
    }

    //添加回显
    @RequestMapping(value="/article",method=RequestMethod.GET)
    public String input(Map<String , Object>map){
        //用于回显，相当于struts2的prepare方法，在值栈放入Employee对象
        map.put("article", new Article());
        return "/article/add";
    }

    //分页显示
    @RequestMapping("/articles")
    public String list(@RequestParam(value = "pageNo", required = false,defaultValue = "1") String pageNoStr,
                       Map<String, Object> map){
        int pageNo = 1;

        try {
            pageNo = Integer.parseInt(pageNoStr);
            if(pageNo < 1){
                pageNo = 1;
            }
        } catch (Exception e) {}

        Page<Article> page = articleService.getPage(pageNo, 5);
        map.put("page", page);
        return "/article/list";
    }

}
