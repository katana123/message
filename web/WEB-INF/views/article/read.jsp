<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/25
  Time: 13:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>SSSP留言板</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
  </head>
  <body>
  <div class="container"  style="margin-top:20px;">
    <nav class="navbar navbar-default">
      <div class="container-fluid">
        <div class="navbar-header">
          <a class="navbar-brand" href="#">DaWang 留言本</a>
        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
          <ul class="nav navbar-nav">
            <li><a href="../articles">首页 <span class="sr-only">(current)</span></a></li>
            <li class="active"><a href="../article">发布留言</a></li>

          </ul>
        </div>
      </div>
    </nav>
    <div class="panel panel-default">
      <div class="panel-heading">{$article->title} {$article->create_time}</div>
      <div class="panel-body">
        {$article->content}
        <hr/>
        {volist name='comments' id='c'}
        <div class="well">
          {$c->content}
          <h6> {$c->username} 发表于 : {$c->create_time}</h6>
        </div>
        {/volist}
      </div>
    </div>
    <div class="panel panel-danger">
      <div class="panel-heading">发布评论</div>
      <div class="panel-body">
        <form method="post" action="/addcomment/{$article.id}">
          <div class="form-group">
            <label for="exampleInputEmail1">姓名：</label>
            <input type="text" class="form-control" name='username' placeholder="请输入姓名">
          </div>
          <div class="form-group">
            <label for="exampleInputPassword1">内容：</label>
            <textarea  class="form-control"  name="content" placeholder="请输入评论内容" rows="8"></textarea>
          </div>


          <button type="submit" class="btn btn-primary">发布评论</button>
        </form>
      </div>

    </div>
  </body>
</html>