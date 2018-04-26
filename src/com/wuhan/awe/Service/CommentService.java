package com.wuhan.awe.Service;

import com.wuhan.awe.Entity.Comment;
import com.wuhan.awe.Repositry.CommentRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepositry commentRepositry;

    public void save(Comment comment){
        comment.setCreateTime(new Date());
        commentRepositry.saveAndFlush(comment);
    }
    //获取article下面的评论
    @Transactional(readOnly = true)
    public List<Comment> getComments(Integer articleId){
        return commentRepositry.getAllByArticle_Id(articleId);
    }
}
