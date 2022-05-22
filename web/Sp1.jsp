<%--
  Created by IntelliJ IDEA.
  User: 18378
  Date: 2021/12/7
  Time: 22:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<!-- Popup -->
<div id="Popup">

    <!-- SubPopup -->
    <div id="SubPopup">
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
        <div class="form_boxC">

            <table cellpadding="0" cellspacing="0">
                <tr>
                    <th width="100">姓名 <span class="f_cB">*</span></th>
                    <td>
                        <div class="txtbox floatL" style="width:120px;">${findStu_infs.stuName}</div>
                    </td>
                </tr>
                <tr>
                    <th>学号 <span class="f_cB">*</span></th>
                    <td>
                        <div class="txtbox floatL" style="width:120px;">${findStu_infs.stuId}</div>
                    </td>
                </tr>
                <tr>
                    <th>所在学院 <span class="f_cB">*</span></th>
                    <td>
                        <div class="txtbox floatL" style="width:120px;">${findStu_infs.stuCollege}</div>
                    </td>
                </tr>

                <tr>
                    <th>专业班级 <span class="f_cB">*</span></th>
                    <td>
                        <div class="txtbox floatL" style="width:120px;">${findStu_infs.className}</div>
                    </td>
                </tr>

                <tr>
                    <th>电话号码 <span class="f_cB">*</span></th>
                    <td>
                        <div class="txtbox floatL" style="width:120px;">${findStu_infs.stuPhone}</div>
                    </td>
                </tr>

                <tr>
                    <th>照片</th>
                    <td>
                        <div class="txtbox"><img src="${pageContext.request.contextPath}/${findStu_infs.stuPic}"
                                                 width="124" height="170"></div>
                        <p class="f_cB pdg_t5">&nbsp;</p></td>
                </tr>
            </table>
        </div>
    </div>
    <!-- SubPopup -->


</div>
<!-- /Popup -->
</body>
</html>