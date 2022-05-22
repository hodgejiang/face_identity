<%--
  Created by IntelliJ IDEA.
  User: 18378
  Date: 2021/12/6
  Time: 13:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>首页左侧导航</title>
    <link rel="stylesheet" type="text/css" href="css/public.css" />
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/public.js"></script>
    <head></head>

<body id="bg">
<!-- 左边节点 -->
<div class="container">

    <div class="leftsidebar_box">
        <a href="${pageContext.request.contextPath}/Sign_infServlet" target="main"><div class="line">
            <img src="img/coin01.png" />&nbsp;签到记录
        </div></a>
        <dl class="system_log">
            <dd>
                <img class="coin11" src="img/coin111.png" /><img class="coin22"
                                                                 src="img/coin222.png" /><a class="cks" href="p4.html"
                                                                                            target="main">选择课程</a><img class="icon5" src="img/coin21.png" />
            </dd>
        </dl>
        <dl class="system_log">
            <dt>
                <img class="icon1" src="img/coin01.png" /><img class="icon2"
                                                               src="img/coin12.png" /> 课程管理<img class="icon3"
                                                                                                src="img/coin19.png" /><img class="icon4"
                                                                                                                            src="img/coin20.png" />
            </dt>
            <dd>
                <img class="coin11" src="img/coin111.png" /><img class="coin22"
                                                                 src="img/coin222.png" /><a class="cks" href="${pageContext.request.contextPath}/FindUserByPageServlet"
                                                                                            target="main">课程信息</a><img class="icon5" src="img/coin21.png" />
            </dd>

        </dl>
        <dl class="system_log">
            <dt>
                <img class="icon1" src="img/coin07.png" /><img class="icon2"
                                                               src="img/coin08.png" /> 学生信息管理<img class="icon3"
                                                                                                  src="img/coin19.png" /><img class="icon4"
                                                                                                                              src="img/coin20.png" />
            </dt>
            <dd>
                <img class="coin11" src="img/coin111.png" /><img class="coin22"
                                                                 src="img/coin222.png" /><a href="p2.html" target="main"
                                                                                            class="cks">学生信息管理</a><img class="icon5" src="img/coin21.png" />
            </dd>


        </dl>
        <dl class="system_log">
            <dt>
                <img class="icon1" src="img/coinL1.png" /><img class="icon2"
                                                               src="img/coinL2.png" /> 系统管理<img class="icon3"
                                                                                                src="img/coin19.png" /><img class="icon4"
                                                                                                                            src="img/coin20.png" />
            </dt>
            <dd>
                <img class="coin11" src="img/coin111.png" /><img class="coin22"
                                                                 src="img/coin222.png" /><a href="changepwd.jsp"
                                                                                            target="main" class="cks">修改密码</a><img class="icon5"
                                                                                                                                   src="img/coin21.png" />
            </dd>

        </dl>

    </div>

</div>
</body>
</html>
