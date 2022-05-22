<%--
  Created by IntelliJ IDEA.
  User: 18378
  Date: 2021/12/5
  Time: 23:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html >
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>修改密码</title>
    <link rel="stylesheet" type="text/css" href="css/css.css" />
    <script type="text/javascript" src="js/jquery-2.1.0.min.js"></script>
    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>


    <script type="text/javascript" >

            function checkpwd1(){

                var user = document.getElementById('pwd1').value.trim();

                var flag1 =user.length >= 6 && user.length <= 12 && ${sessionScope.user.pwd} == user;
                if (flag1) {
                    $("#pwd1").parent().find(".imga").show();
                    $("#pwd1").parent().find(".imgb").hide();

                }else{
                    $("#pwd1").parent().find(".imgb").show();
                    $("#pwd1").parent().find(".imga").hide();
                };
                return flag1;
            }

            function checkpwd2(){
                var user = document.getElementById('pwd2').value.trim();
                var flag2 = user.length >= 6 && user.length <= 12
                if (flag2) {
                    $("#pwd2").parent().find(".imga").show();
                    $("#pwd2").parent().find(".imgb").hide();
                }else{
                    $("#pwd2").parent().find(".imgb").show();
                    $("#pwd2").parent().find(".imga").hide();
                };

                return flag2;
            }
            function checkpwd3(){
                var user = document.getElementById('pwd3').value.trim();
                var pwd = document.getElementById('pwd2').value.trim();
                var flag3 = user.length >= 6 && user.length <= 12 && user == pwd;
                if (flag3) {
                    $("#pwd3").parent().find(".imga").show();
                    $("#pwd3").parent().find(".imgb").hide();
                }else{
                    $("#pwd3").parent().find(".imgb").show();
                    $("#pwd3").parent().find(".imga").hide();

                };

                return flag3;
            }


            function check_123()
            {
                var flag = checkpwd1()&&checkpwd2()&& checkpwd3();


                return flag;
            }

            function check_e()
            {
                var elementById = document.getElementById('e_check');
                var flag = checkpwd1()&&checkpwd2()&& checkpwd3();
                if(flag)
                {
                    elementById.dataset.target = "#myModal";
                }
                else
                {
                    elementById.dataset.target = "#myModal_e";
                }
            }






    </script>
</head>
<body>
<div id="pageAll">
    <div class="pageTop">
        <div class="page">
            <img src="img/coin02.png" /><span><a href="#">首页</a>&nbsp;-&nbsp;<a
                href="#">系统管理</a>&nbsp;-</span>&nbsp;修改密码
        </div>
    </div>
    <div class="page ">
        <!-- 修改密码页面样式 -->
        <div class="bacen">


            <div class="bbD">&nbsp;&nbsp;&nbsp;&nbsp; 账号ID：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${sessionScope.user.id}</div>

            <form action="${pageContext.request.contextPath}/ChangePwdServlet" method="get" id="form_1" onsubmit="return check_123()" >
                <div class="bbD">
                    &nbsp;&nbsp;&nbsp;&nbsp;输入旧密码：<input type="password" placeholder="请输入6-12位的密码" class="input3"
                                                         id="pwd1" onblur="checkpwd1()"/><img class="imga" src="img/ok.png" /><img
                        class="imgb" src="img/no.png" />
                </div>
                <div class="bbD">
                    &nbsp;&nbsp;&nbsp;&nbsp;输入新密码：<input type="password" placeholder="请输入6-12位的密码" class="input3"
                                                          id="pwd2" onblur="checkpwd2()"/> <img class="imga"
                                                                                                src="img/ok.png" /><img class="imgb" src="img/no.png" />
                </div>
                <div class="bbD">
                    再次确认密码：<input type="password" name='changePwd' placeholder="请输入6-12位的密码" class="input3"
                                  id="pwd3" onblur="checkpwd3()"/> <img class="imga" src="img/ok.png" /><img
                        class="imgb" src="img/no.png" />
                </div>
                <div class="bbD" align="center" style="position:relative;top:10px">
                    <p class="bbDP">
                        <button  type="button" class="btn btn-primary btn-lg" data-toggle="modal"  data-target=""  id="e_check" onclick="check_e()">
                            提交修改
                        </button>

                    </p>
                </div>

                <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                <h4 class="modal-title" id="myModalLabel">修改密码</h4>
                            </div>
                            <div class="modal-body">
                                确认修改密码？
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                                <button type="submit"  class="btn btn-primary" id="button_p" >确认</button>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="modal fade" id="myModal_e" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                <h4 class="modal-title" id="myModalLabel_e">修改密码</h4>
                            </div>
                            <div class="modal-body">
                                密码信息错误，请重新输入！
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                                <button type="submit"  class="btn btn-primary" id="button_p_e" >确认</button>
                            </div>
                        </div>
                    </div>
                </div>


            </form>
            <!-- Button trigger modal -->


            <!-- Modal -->


        </div>

        <!-- 修改密码页面样式end -->
    </div>
</div>


</body>

</html>