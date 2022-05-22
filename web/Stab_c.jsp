<%--
  Created by IntelliJ IDEA.
  User: 18378
  Date: 2021/12/8
  Time: 20:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title></title>
    <meta name="keywords" content=""/>
    <meta name="description" content=""/>
    <meta name="generator" content=""/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width; initial-scale=1.0; maximum-scale=1.0; user-scalable=0;">
    <link href="css/haiersoft.css" rel="stylesheet" type="text/css" media="screen,print"/>
    <link href="css/print.css" rel="stylesheet" type="text/css" media="print"/>
    <script src="js/jquery-1.10.1.min.js"></script>
    <script src="js/side.js" type="text/javascript"></script>

    <!--[if lt IE 9]>
    <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
    <script src="http://css3-mediaqueries-js.googlecode.com/svn/trunk/css3-mediaqueries.js"></script>
    <![endif]-->
</head>

<body>


<!-- MainForm -->
<div id="MainForm">
    <div class="form_boxA">
        <h2>所有课程</h2>
        &nbsp;&nbsp;&nbsp;
        <table cellpadding="0" cellspacing="0">
            <tr>
                <th width="6%">序号</th>
                <th width="18%">课程</th>
                <th width="9%">教师</th>
                <th width="23%">班级</th>
                <th width="18%">学期</th>
                <th width="8%">点名次数</th>
                <th width="8%">签到次数</th>
                <th width="10%">到课比例</th>
                <th width="8%">签到图片</th>

            </tr>

            <tr>
                <td>1</td>
                <td>高级程序设计语言</td>
                <td>张老师</td>
                <td>电子信息专硕211班</td>
                <td>2021-2022上学期</td>
                <td>30</td>
                <td>20</td>
                <td>66.6%</td>
                <td class="f_cA">查看</td>

            </tr>

            <tr>
                <td>3</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>

            </tr>
        </table>
        <p class="msg">总课程10门，当前显示从第1条至第10条</p>

    </div>
</div>
<!-- /MainForm -->
<ul id="PageNum">
    <li><a href="#">首页</a></li>
    <li><a href="#">上一页</a></li>
    <li><a href="#">1</a></li>
    <li><a href="#">2</a></li>
    <li><a href="#">3</a></li>
    <li><a href="#">4</a></li>
    <li><a href="#">5</a></li>
    <li><a href="#">6</a></li>
    <li><a href="#">下一页</a></li>
    <li><a href="#">尾页</a></li>
</ul>
<!-- /PageNum -->
</div>
</body>
</html>