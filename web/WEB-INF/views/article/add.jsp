<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/25
  Time: 13:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>发布留言－SSSP留言板</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
  </head>
  <body>
  <div class="container" style="margin-top:20px;">
    <nav class="navbar navbar-default">
      <div class="container-fluid">
        <div class="navbar-header">
          <a class="navbar-brand" href="#">AWE 留言本</a>
        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
          <ul class="nav navbar-nav">
            <c:choose>
              <c:when test="${article.id != null}">
                <li><a href="../articles">首页 <span class="sr-only">(current)</span></a></li>
                <li class="active"><a href="../article">发布留言</a></li>
              </c:when>
              <c:otherwise>
                <li><a href="articles">首页 <span class="sr-only">(current)</span></a></li>
                <li class="active"><a href="article">发布留言</a></li>
              </c:otherwise>
            </c:choose>


          </ul>

          <ul class="nav navbar-nav navbar-right">
            <li><a href="#">注册</a></li>
            <li><a href="#">登录</a></li>

          </ul>
        </div>
      </div>
    </nav>

    <c:set value="${pageContext.request.contextPath }/article" var="url"></c:set>
    <c:if test="${article.id != null}">
      <c:set value="${pageContext.request.contextPath }/article/${article.id}" var="url"></c:set>
    </c:if>

    <form:form class="form-horizontal" action="${url}" method="POST" modelAttribute="article">

      <c:if test="${article.id != null}">
        <form:hidden path="id"/>
        <input type="hidden" name="_method" value="PUT"/>
      </c:if>

      <div class="form-group">
        <label class="col-sm-2 control-label">标题</label>
        <div class="col-sm-10">
          <form:input path="title" type="text" class="form-control" placeholder="请输入标题"/>
        </div>
      </div>
      <div class="form-group">
        <label  class="col-sm-2 control-label">内容</label>
        <div class="col-sm-10">
          <form:textarea path="content" rows="10" class="form-control" placeholder="请输入内容"></form:textarea>
        </div>
      </div>

      <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
          <button type="submit" class="btn btn-primary">发布留言</button>
        </div>
      </div>
    </form:form>
  </div>
  </body>
</html>