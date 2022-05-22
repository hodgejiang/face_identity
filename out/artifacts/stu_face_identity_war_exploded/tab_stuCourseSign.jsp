<%--
  Created by IntelliJ IDEA.
  User: 18378
  Date: 2021/12/8
  Time: 21:40
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
    <meta name="viewport" content="width=device-width; initial-scale=1.0; maximum-scale=1.0; user-scalable=0;">
    <link href="css/haiersoft.css" rel="stylesheet" type="text/css" media="screen,print"/>
    <link href="css/print.css " rel="stylesheet" type="text/css" media="print"/>

    <script src="js/side.js " type="text/javascript"></script>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/fileinput.min.css" rel="stylesheet">
    \
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <script src="js/fileinput.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <script src="js/zh"></script>

    <!--[if lt IE 9]>
    <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
    <script src="http://css3-mediaqueries-js.googlecode.com/svn/trunk/css3-mediaqueries.js"></script>

    <![endif]-->

    <style>

        /*a  upload */
        .a-upload {
            padding: 4px 10px;
            height: 30px;
            line-height: 20px;
            position: relative;
            cursor: pointer;
            color: #888;
            background: #fafafa;
            border: 1px solid #ddd;
            border-radius: 4px;
            overflow: hidden;
            display: inline-block;
            *display: inline;
            *zoom: 1
        }

        .a-upload input {
            position: absolute;
            font-size: 100px;
            right: 0;
            top: 0;
            opacity: 0;
            filter: alpha(opacity=0);
            cursor: pointer
        }

        .a-upload:hover {
            color: #444;
            background: #eee;
            border-color: #ccc;
            text-decoration: none
        }
    </style>
    <script type="text/javascript">
        $('#exampleModal').on('show.bs.modal', function (event) {
            var button = $(event.relatedTarget) // Button that triggered the modal
            var recipient = button.data('whatever') // Extract info from data-* attributes
            // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
            // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
            var modal = $(this)
            modal.find('.modal-title').text('New message to ' + recipient)
            modal.find('.modal-body input').val(recipient)
        })


        $(function () {
            $("#btnA").click(function () {
                $("#myForm").submit();
            });
        });
    </script>
</head>

<body>


<!-- MainForm -->
<div id="MainForm">
    <div class="form_boxA">
        <h2>所有课程</h2>

        <table cellpadding="0" cellspacing="0" style="margin-top:10px"
               class="table table-bordered table-striped table-hover">
            <tr>
                <th width="5%">序号</th>
                <th width="11%">签到时间</th>
                <th width="7%">人脸签到分数</th>
                <th width="12%">是否签到</th>
            </tr>

            <c:forEach items="${pb.list}" var="course_inf" varStatus="s">

                <c:if test="${course_inf.is_sign=='未到'}">
                    <tr bgcolor="red">
                        <td>${s.count}</td>
                        <td>${course_inf.signinTime}</td>
                        <td>${course_inf.faceGrades}</td>
                        <td>${course_inf.is_sign}</td>
                    </tr>

                </c:if>
                <c:if test="${course_inf.is_sign=='已到'}">
                    <tr>
                        <td>${s.count}</td>
                        <td>${course_inf.signinTime}</td>
                        <td>${course_inf.faceGrades}</td>
                        <td>${course_inf.is_sign}</td>
                    </tr>

                </c:if>


            </c:forEach>

        </table>

        <p class="msg">签到记录${pb.totalCount}条，当前显示第${pb.currentPage}页</p>

    </div>
</div>
<!-- /MainForm -->
<ul id="PageNum">
    <li><a href="${pageContext.request.contextPath}/StuCourseSign?currentPage=1&rows=9&id=${temp_id}">首页</a></li>


    <c:if test="${pb.currentPage > 1}">
        <li>
            <a href="${pageContext.request.contextPath}/StuCourseSign?currentPage=${pb.currentPage - 1}&rows=9&id=${temp_id}">上一页</a>
        </li>
    </c:if>
    <c:forEach begin="1" end="${pb.totalPage}" var="i">

        <c:if test="${pb.currentPage == i}">
            <li class="active"><a
                    href="${pageContext.request.contextPath}/StuCourseSign?currentPage=${i}&rows=9&id=${temp_id}">${i}</a>
            </li>
        </c:if>
        <c:if test="${pb.currentPage != i}">
            <li>
                <a href="${pageContext.request.contextPath}/StuCourseSign?currentPage=${i}&rows=9&id=${temp_id}">${i}</a>
            </li>
        </c:if>
    </c:forEach>


    <c:if test="${pb.currentPage < pb.totalPage}">
        <li>
            <a href="${pageContext.request.contextPath}/StuCourseSign?currentPage=${pb.currentPage + 1}&rows=9&id=${temp_id}">下一页</a>
        </li>
    </c:if>


</ul>
<!-- /PageNum -->
</div>
</body>
</html>