<%--
  Created by IntelliJ IDEA.
  User: 18378
  Date: 2021/12/11
  Time: 10:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE HTML>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title></title>
    <meta name="keywords" content=""/>
    <meta name="description" content=""/>
    <meta name="generator" content=""/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link href="css/haiersoft.css" rel="stylesheet" type="text/css" media="screen,print"/>
    <link href="css/print.css" rel="stylesheet" type="text/css" media="print"/>
    <style type="text/css">
        body, td, th {
            font-family: Verdana, Arial, Helvetica, Meiryo, "微软雅黑", sans-serif;
        }

        body {
            margin-left: 0px;
        }
    </style>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery-1.10.1.min.js"></script>
    <script src="js/side.js" type="text/javascript"></script>
    <script>

        function datetime() {
            var now = new Date();
            document.getElementById("time").value = now.getFullYear() + "-"
                + (now.getMonth() + 1) + "-" + now.getDate();
            document.getElementById("time").value += " " + now.getHours() + ":"
                + now.getMinutes() + ":" + now.getSeconds();
        }

        window.setInterval("datetime()", 1000);

        LANGUAGE = "JavaScript" >
            function reP() {
                document.getElementById('oImg').style.display = "block";
            }
    </script>


    <!--[if lt IE 9]>
    <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
    <script src="http://css3-mediaqueries-js.googlecode.com/svn/trunk/css3-mediaqueries.js"></script>
    <![endif]-->
</head>

<body>
<!-- wrap_left -->

<!-- /wrap_left -->

<!-- picBox -->
<div class="picBox" onClick="switchSysBar()" id="switchPoint"></div>
<!-- /picBox -->


<!-- wrap_right -->
<div class="wrap_right">
    <header>
        <!-- Header -->

        <!-- /Header -->
    </header>


    <!-- Contents -->
    <div id="Contents">
        <script type="text/javascript">
            $(function () {
                $(".select").each(function () {
                    var s = $(this);
                    var z = parseInt(s.css("z-index"));
                    var dt = $(this).children("dt");
                    var dd = $(this).children("dd");
                    var _show = function () {
                        dd.slideDown(200);
                        dt.addClass("cur");
                        s.css("z-index", z + 1);
                    };
                    var _hide = function () {
                        dd.slideUp(200);
                        dt.removeClass("cur");
                        s.css("z-index", z);
                    };
                    dt.click(function () {
                        dd.is(":hidden") ? _show() : _hide();
                    });
                    dd.find("a").click(function () {
                        dt.html($(this).html());
                        _hide();
                    });
                    $("body").click(function (i) {
                        !$(i.target).parents(".select").first().is(s) ? _hide() : "";
                    });
                })
            })
        </script>

        <!-- MainForm -->
        <div id="MainForm">
            <div class="form_boxB">
                <h2>签到记录</h2>
                <table cellpadding="0" cellspacing="0" class="table table-bordered table-hover table-striped">
                    <tr>
                        <td colspan="10" class="info_boxA"><p>
                            教师：${sessionScope.user.name}&nbsp;&nbsp;&nbsp;&nbsp;日期：<input id="time"
                                                                                          style="text-align: center;"/>
                        </p></td>
                    </tr>
                    <tr>
                        <th width="5%">序号</th>
                        <th width="12%">课程名称</th>
                        <th width="12%">班级</th>
                        <th width="15%">签到时间</th>
                        <th width="9%">详细签到信息</th>
                        <th width="9%">签到照片</th>
                        <th width="8%">操作</th>

                    </tr>

                    <c:forEach items="${pb.list}" var="sign_inf" varStatus="s">
                        <tr>

                            <td>${s.count}</td>
                            <td>${sign_inf.courseName}</td>
                            <td>${sign_inf.className}</td>
                            <td>${sign_inf.signinTime}</td>

                            <td><a class="btn btn-default btn-sm"
                                   href="${pageContext.request.contextPath}/StuSign_inf?id=${sign_inf.signID}&courseID=${sign_inf.courseID}">
                                查看 </a></td>
                            <td><a value='显示图片' target="_self" class="btn btn-default btn-sm"> <img id="oImg"
                                                                                                    width="60px"
                                                                                                    hight="100px"
                                                                                                    src="sign_photo/${sign_inf.signID}.jpg"></a>
                            </td>
                            <td><a class="btn btn-default btn-sm" data-toggle="modal" data-target="#myModal${s.count}">删除</a>
                            </td>
                            <div class="modal fade" id="myModal${s.count}" tabindex="-1" role="dialog"
                                 aria-labelledby="myModalLabel">
                                <div class="modal-dialog" role="document">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                <span aria-hidden="true">&times;</span></button>
                                            <h4 class="modal-title" id="myModalLabel">删除签到记录</h4>
                                        </div>
                                        <div class="modal-body">
                                            确认删除本条签到记录？
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-default" data-dismiss="modal">取消
                                            </button>
                                            <a href="${pageContext.request.contextPath}/DelSign_inf?id=${sign_inf.signID}">
                                                <button type="button" class="btn btn-primary" id="button_p">确认</button>
                                            </a>

                                        </div>
                                    </div>
                                </div>
                            </div>
                        </tr>

                    </c:forEach>
                </table>
                <p class="msg">总签到记录${pb.totalCount}条，当前显示第${pb.currentPage}页</p>
            </div>
        </div>
        <!-- /MainForm -->


        <!-- BtmMain -->
        <div id="BtmMain"><!-- txtbox --><!-- /txtbox -->

            <!-- txtbox --><!-- /txtbox -->

            <!-- btn_box -->
            <div class="btn_box floatR mag_l20"></div>
            <!-- /btn_box -->

            <!-- btn_box -->
            <div class="btn_box floatR mag_l20"></div>
            <!-- /btn_box -->

            <!-- btn_box --><!-- /btn_box -->
        </div>
        <!-- /BtmMain -->

        <!-- PageNum -->
        <ul id="PageNum">
            <li><a href="${pageContext.request.contextPath}/Sign_infServlet?currentPage=1&rows=9">首页</a></li>

            <c:if test="${pb.currentPage > 1}">
                <li>
                    <a href="${pageContext.request.contextPath}/Sign_infServlet?currentPage=${pb.currentPage - 1}&rows=9">上一页</a>
                </li>
            </c:if>
            <c:forEach begin="1" end="${pb.totalPage}" var="i">

                <c:if test="${pb.currentPage == i}">
                    <li class="active"><a
                            href="${pageContext.request.contextPath}/Sign_infServlet?currentPage=${i}&rows=9">${i}</a>
                    </li>
                </c:if>
                <c:if test="${pb.currentPage != i}">
                    <li><a href="${pageContext.request.contextPath}/Sign_infServlet?currentPage=${i}&rows=9">${i}</a>
                    </li>
                </c:if>
            </c:forEach>


            <c:if test="${pb.currentPage < pb.totalPage}">
                <li>
                    <a href="${pageContext.request.contextPath}/Sign_infServlet?currentPage=${pb.currentPage + 1}&rows=9">下一页</a>
                </li>
            </c:if>

        </ul>
        <!-- /PageNum -->
    </div>
    <!-- /Contents -->

    <!-- /footer -->
    <footer>
        <address>2021 Corporation,All Rights</address>
    </footer>
    <!-- /footer -->

</div>
<!-- /wrap_right -->
</body>
</html>
