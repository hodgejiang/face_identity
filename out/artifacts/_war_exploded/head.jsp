<%--
  Created by IntelliJ IDEA.
  User: 18378
  Date: 2021/12/6
  Time: 0:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta http-equiv="Content-Type" content="text/html"; charset="utf-8" />
  <title>头部</title>
  <link rel="stylesheet" type="text/css" href="css/public.css" />
  <script type="text/javascript" src="js/jquery.min.js"></script>
  <script type="text/javascript" src="js/public.js"></script>
</head>

<body>
<!-- 头部 -->
<div class="head">
  <div class="headL">
    <h1><img src="img/history.png" width="70" height="70" style="margin: 0px 40px -20px 0px;" class="headLogo"/><span style="font-size: 15px"><strong><em>${user.name},欢迎来到人脸点名系统</em></strong></span></h1>
  </div>
  <div class="headR">
    <span style="color:#FFF">欢迎：${sessionScope.user.id}</span> <a href="login.jsp" target="_top" rel="external">【退出】</a>
  </div>
</div>
<h1>&nbsp;</h1>
</body>
</html>