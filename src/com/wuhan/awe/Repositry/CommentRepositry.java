package com.wuhan.awe.Repositry;

import com.wuhan.awe.Entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepositry extends JpaRepository<Comment, Integer>{

    List<Comment> getAllByArticle_Id(Integer id);
}
