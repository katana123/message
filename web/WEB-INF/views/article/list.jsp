<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/25
  Time: 13:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
  <head>
    <title>SSSP 留言板</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <script type="text/javascript" src="${pageContext.request.contextPath }/scripts/jquery-1.9.1.min.js"></script>
    <script type="text/javascript">
        $(function(){
            $(".delete").click(function(){
                var lable = $(this).next(":hidden").val();
                var flag = confirm("确定要删除" + lable + "的信息吗？");
                if(flag){
                    var url = $(this).attr("href");

                    $("#_form").attr("action", url);
                    $("#_method").val("DELETE");
                    $("#_form").submit();
                }
                return false;
            });
        })
    </script>
  </head>
  <body>

  <form action="" method="POST" id="_form">
    <input type="hidden" id="_method" name="_method"/>
  </form>

  <div class="container" style="margin-top:20px;">
    <nav class="navbar navbar-default">
      <div class="container-fluid">
        <div class="navbar-header">
          <a class="navbar-brand" href="#">AWE 留言本</a>
        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
          <ul class="nav navbar-nav">
            <li class="active"><a href="articles">首页 <span class="sr-only">(current)</span></a></li>
            <li><a href="article">发布留言</a></li>

          </ul>

        </div>
      </div>
    </nav>

    <table class="table">
      <tr>
        <td>编号</td>
        <td>标题</td>
        <td>评论</td>
        <td>发布日期</td>
        <td>操作</td>
      </tr>

      <c:if test="${page == null || page.numberOfElements == 0 }">
      <tr>
        <td colspan="5">
        没有任何记录
        </td>
      </tr>
      </c:if>


      <c:if test="${page != null && page.numberOfElements > 0 }">
        <c:forEach items="${page.content}" var="article">
        <tr>
          <td>${article.id}</td>
          <td><a href="#">${article.title}</a></td>
          <td>2</td>
          <td>
              <fmt:formatDate value="${article.createTime}" pattern="yyyy-MM-dd hh:mm:ss"/>
          </td>
          <td>
            <a href="${pageContext.request.contextPath }/article/${article.id}" class="btn btn-primary">修改</a>
            <a href="${pageContext.request.contextPath }/article/${article.id}" class="btn btn-danger delete">删除</a>
            <input type="hidden" value="${article.title}">
          </td>
        </tr>
        </c:forEach>

      </c:if>

    </table>
    <nav aria-label="Page navigation">
      <ul class="pagination">
        <c:choose>
          <c:when test="${page.isFirstPage() == true}">
            <li class="disabled">
              <a href="javascript:void(0);" aria-label="Previous">
                <span aria-hidden="true">&laquo;</span>
              </a>
            </li>
          </c:when>
          <c:otherwise>
            <li>
              <a href="?pageNo=${page.number + 1 - 1}" aria-label="Previous">
                <span aria-hidden="true">&laquo;</span>
              </a>
            </li>
          </c:otherwise>
        </c:choose>
        <c:forEach var="li" begin="1" end="${page.totalPages }">
          <c:choose>
            <c:when test="${page.number + 1 == li}">
              <li class="active"><a href="?pageNo=${li}">${li}</a></li>
            </c:when>
            <c:otherwise>
              <li><a href="?pageNo=${li}">${li}</a></li>
            </c:otherwise>
          </c:choose>
        </c:forEach>

        <c:choose>
          <c:when test="${page.isLastPage() == true}">
            <li class="disabled">
              <a href="javascript:void(0);" aria-label="Previous">
                <span aria-hidden="true">&raquo;</span>
              </a>
            </li>
          </c:when>
          <c:otherwise>
            <li>
              <a href="?pageNo=${page.number + 1 + 1}" aria-label="Next">
                <span aria-hidden="true">&raquo;</span>
              </a>
            </li>
          </c:otherwise>
        </c:choose>

      </ul>
    </nav>
    <div class="well">
      用SSSP开发的一款留言本
    </div>
  </div>
  </body>
</html>