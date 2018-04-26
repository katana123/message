package com.wuhan.awe.Handler;

import com.wuhan.awe.Entity.Article;
import com.wuhan.awe.Entity.Comment;
import com.wuhan.awe.Service.ArticleService;
import com.wuhan.awe.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

@Controller
public class CommentHandler {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private CommentService commentService;

    //完成添加并跳转到List页面
    @RequestMapping(value="/comment/{id}",method=RequestMethod.POST)
    public String update(@PathVariable("id") Integer id,Comment comment){
        Article article = articleService.get(id);
        comment.setArticle(article);
        commentService.save(comment);
        return "redirect:/article/read/"+id;
    }

    //article阅读和评论页面
    @RequestMapping(value = "/article/read/{id}", method = RequestMethod.GET)
    public String list(@PathVariable("id") Integer id, Map<String, Object> map){
        Article article =  articleService.get(id);
        List<Comment> commentList = commentService.getComments(id);
        map.put("article",article);
        map.put("commentlist",commentList);
        map.put("comment", new Comment());
            return "/article/read";
    }
}
