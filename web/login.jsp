<!DOCTYPE HTML>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>登录</title>
    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <script type="text/javascript">
        //切换验证码
        function refreshCode() {
            //1.获取验证码图片对象
            var vcode = document.getElementById("vcode");

            //2.设置其src属性，加时间戳
            vcode.src = "${pageContext.request.contextPath}/checkCodeServlet?time=" + new Date().getTime();
        }

    </script>


    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/page.css"/>
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/public.js"></script>
</head>
<body>

<!-- 登录body -->

<!-- 登录body -->
<div class="logDiv">
    <img src="img/ns.jpg" height="900" class="background-size:cover  logBanner"/>
    <div class="logGet">
        <!-- 头部提示信息 -->
        <div class="logD logDtip">
            <p class="p1">人脸点名系统登录</p>
        </div>

        <!-- 输入框 -->
        <form id="form1" name="form1" method="get" action="${pageContext.request.contextPath}/loginServlet"
              onsubmit="myFunction()">
            <div class="lgD">
                <img class="img1" src="img/logName.png"/><input type="text"
                                                                name="id" placeholder="&nbsp;输入用户名"/>
            </div>
            <div class="lgD">
                <img class="img1" src="img/logPwd.png"/><input type="password"

                                                               name="pwd" placeholder="&nbsp;输入用户密码"/>
            </div>
            <div class="lgD">
                <table width="200">

                    <tr>
                        <td><label>
                            <input type="radio" name="RadioGroup1" value="0" id="RadioGroup1_0"
                                   style="width: 15px; height: 15px"/>
                            教师端登录</label></td>
                        <td>
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        </td>
                        <td><label>
                            <input type="radio" name="RadioGroup1" value="1" id="RadioGroup1_1"
                                   style="width: 15px; height: 15px"/>
                            学生端登录</label></td>
                    </tr>
                </table>
            </div>
            <div class="form-inline lgD ">
                <label for="vcode">验证码:&nbsp;</label>
                <input type="text" name="verifycode" class="form-control" id="verifycode" placeholder="验证码"
                       style="width: 100px; height: 30px"/>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <a href="javascript:refreshCode();">
                    <img src="${pageContext.request.contextPath}/checkCodeServlet" title="点击刷新" id="vcode"/>
                </a>
            </div>


            <div class="logC">
                <button type="submit">登 录</button>
            </div>
        </form>
        <br>
        <div class="alert alert-warning alert-dismissible" role="alert" style="display:${login_msg}" id="inform_i">
            <button type="button" class="close" data-dismiss="alert">
                <span>&times;</span>
            </button>
            <strong>${login_msg}</strong>
            <br>
        </div>
    </div>
</div>

<!-- 登录body  end -->

<!-- 登录页面底部 -->
<div class="logFoot">
    <p class="p1">版权所有：@</p>
    <p class="p1">&nbsp; </p>
</div>
<!-- 登录页面底部end -->

</body>
</html>
