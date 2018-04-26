<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/25
  Time: 13:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
            <li><a href="../../articles">首页 <span class="sr-only">(current)</span></a></li>
            <li class="active"><a href="../../article">发布留言</a></li>

          </ul>
        </div>
      </div>
    </nav>
    <div class="panel panel-default">
      <div class="panel-heading">${article.title} ${article.createTime}</div>
      <div class="panel-body">
        ${article.content}
        <hr/>
          <c:forEach items="${commentlist}" var="comment">
            <div class="well">
                ${comment.content}
              <h6> ${comment.username} 发表于 : ${comment.createTime}</h6>
            </div>
          </c:forEach>
      </div>
    </div>
    <div class="panel panel-danger">
      <div class="panel-heading">发布评论</div>
      <div class="panel-body">


        <form:form action="${pageContext.request.contextPath }/comment/${article.id}" method="POST" modelAttribute="comment">
          <div class="form-group">
            <label>姓名：</label>
            <form:input path="username" type="text" class="form-control" placeholder="请输入姓名"/>
          </div>
          <div class="form-group">
            <label>内容：</label>
            <form:textarea path="content" rows="8" class="form-control" placeholder="请输入评论内容"></form:textarea>
          </div>


          <button type="submit" class="btn btn-primary">发布评论</button>
        </form:form>

      </div>

    </div>
  </body>
</html>