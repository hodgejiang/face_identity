<%--
  Created by IntelliJ IDEA.
  User: 18378
  Date: 2021/12/8
  Time: 21:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=gb2312" language="java" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE HTML>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title></title>
    <meta name="keywords" content="" />
    <meta name="description" content="" />
    <meta name="generator" content="" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width; initial-scale=1.0; maximum-scale=1.0; user-scalable=0;">
    <link href="css/haiersoft.css" rel="stylesheet" type="text/css" media="screen,print" />
    <link href="css/print.css " rel="stylesheet" type="text/css"  media="print" />

    <script src="js/side.js " type="text/javascript"></script>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/fileinput.min.css" rel="stylesheet">
 \
    <!-- 2. jQuery���룬����ʹ��1.9���ϵİ汾 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <script src="js/fileinput.min.js"></script>
    <!-- 3. ����bootstrap��js�ļ� -->
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

        .a-upload  input {
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


        $(function(){
            $("#btnA").click(function(){
                $("#myForm").submit();
            });
        });
    </script>
</head>

<body>


<!-- MainForm -->
<div id="MainForm">
    <div class="form_boxA">
        <h2>���пγ�</h2>


        <button type="button" style="margin-left:91%;margin-top:5px" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal" data-whatever="@fat">��ӿγ�</button>


        <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <form class="form-horizontal" autocomplete="off" action="${pageContext.request.contextPath}/AddCourseServlet" method="post">
                    <div class="modal-body">


                            <div class="modal-header">
                                <button class="close" data-dismiss="modal">x</button>
                                <h3>��ӿγ�</h3>
                            </div>
                            <div class="modal-body">
                                <div class="form-group">
                                    <label for="courseName" class="col-sm-2 control-label">�γ�����</label>
                                    <div class="col-sm-6">
                                        <input type="text" name="courseName" class="form-control"  id="courseName" placeholder="">
                                    </div>

                                </div>
                                <div class="form-group">
                                    <label for="coursetime" class="col-sm-2 control-label">�ܿ�ʱ</label>
                                    <div class="col-sm-6">
                                        <input type="text" name="courseTime" class="form-control" id="coursetime" placeholder="" >
                                    </div>

                                </div>
                                <div class="form-group">
                                    <label for="classnum" class="col-sm-2 control-label">�༶����</label>
                                    <div class="col-sm-6">
                                        <input type="text" class="form-control" name="classNum" id="classnum" placeholder="" >
                                    </div>
                                    <div class="col-sm-4 tips"></div>
                                </div>
                                <div class="form-group">
                                    <label for="classnum"  class="col-sm-2 control-label">�༶</label>
                                    <div class="col-sm-6">
                                        <!-- Single button -->
                                        <select class="form-control" name="className">
                                            <option>��ѡ��</option>
                                            <option>������Ϣ211��</option>
                                            <option>�������ѧ�뼼��211��</option>
                                        </select>


                                    </div>
                                    <div class="col-sm-4 tips"></div>
                                </div>
                                <div class="form-group">
                                    <label for="classnum" class="col-sm-2 control-label">ѧ��</label>
                                    <div class="col-sm-6">
                                        <!-- Single button -->
                                        <select class="form-control" name="term">
                                            <option>��ѡ��</option>
                                            <option>2021-2022ѧ�� ��һѧ��</option>
                                            <option>2021-2022ѧ�� �ڶ�ѧ��</option>
                                        </select>


                                    </div>
                                    <div class="col-sm-4 tips"></div>
                                </div>
                            </div>


                    </div>

                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">ȡ��</button>
                        <button type="submit" class="btn btn-primary">ȷ�����</button>
                    </div>
                    </form>
                </div>
            </div>
        </div>
        <table cellpadding="0" cellspacing="0" style="margin-top:10px" class="table table-bordered table-striped table-hover">
            <tr>
                <th width="5%">���</th>
                <th width="11%">�γ�����</th>
                <th width="7%">��ʦ</th>
                <th width="12%">�༶</th>
                <th width="15%">ѧ��</th>
                <th width="6%">�༶����</th>
                <th width="5%">�ܿ�ʱ</th>
                <th width="6%">�ѵ��ʱ</th>
                <th width="8%">ǩ����¼</th>
                <th width="10%">����</th>
                <th width="12%">��ʼǩ��</th>
            </tr>

                <c:forEach items="${pb.list}" var="course_inf"  varStatus="s">
            <tr>

                <td>${s.count}</td>
                <td>${course_inf.courseName}</td>
                <td>${course_inf.teaName}</td>
                <td>${course_inf.className}</td>
                <td>${course_inf.term}</td>
                <td>${course_inf.classNum}</td>
                <td>${course_inf.courseTime}</td>
                <td>${course_inf.courseCount}</td>
                <td><a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/Sign_infSameServlet?id=${course_inf.courseID}"> �鿴 </a></td>
                <td><a class="btn btn-default btn-sm"  data-toggle="modal"  data-target="#exampleModal1${s.count}"> �޸� </a>&nbsp;
                    <a class="btn btn-default btn-sm" data-toggle="modal"  data-target="#myModal${s.count}" >ɾ��</a>
                    <div class="modal fade" id="myModal${s.count}" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                    <h4 class="modal-title" id="myModalLabel">ɾ���γ�</h4>
                                </div>
                                <div class="modal-body">
                                    ȷ��ɾ���γ���Ϣ��
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-default" data-dismiss="modal" >ȡ��</button>
                                    <a href="${pageContext.request.contextPath}/DelCourseServlet?id=${course_inf.courseID}">
                                        <button type="button" class="btn btn-primary" id="button_p" >ȷ��</button>
                                    </a>

                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="modal fade" id="exampleModal1${s.count}" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <form class="form-horizontal" autocomplete="off" action="${pageContext.request.contextPath}/UpdateCourseServlet?id=${course_inf.courseID}" method="post">
                                    <div class="modal-body">


                                        <div class="modal-header">
                                            <button class="close" data-dismiss="modal">x</button>
                                            <h3>�޸Ŀγ�</h3>
                                        </div>
                                        <div class="modal-body">
                                            <div class="form-group">
                                                <label for="courseName" class="col-sm-2 control-label">�γ�����</label>
                                                <div class="col-sm-6">
                                                    <input type="text" name="courseName" class="form-control"  value="${course_inf.courseName}" placeholder="">
                                                </div>

                                            </div>
                                            <div class="form-group">
                                                <label for="coursetime" class="col-sm-2 control-label">�ܿ�ʱ</label>
                                                <div class="col-sm-6">
                                                    <input type="text" name="courseTime" class="form-control" value="${course_inf.courseTime}" placeholder="" >
                                                </div>

                                            </div>
                                            <div class="form-group">
                                                <label for="classnum" class="col-sm-2 control-label">�༶����</label>
                                                <div class="col-sm-6">
                                                    <input type="text" class="form-control" name="classNum" value="${course_inf.classNum}" placeholder="" >
                                                </div>
                                                <div class="col-sm-4 tips"></div>
                                            </div>
                                            <div class="form-group">
                                                <label for="classnum" class="col-sm-2 control-label">�༶</label>
                                                <div class="col-sm-6">
                                                    <!-- Single button -->
                                                    <select class="form-control" name="className">
                                                        <c:if test="${course_inf.className == '������Ϣ211��'}">

                                                            <option>��ѡ��</option>
                                                            <option selected value="������Ϣ211��">������Ϣ211��</option>
                                                            <option value="�������ѧ�뼼��211��">�������ѧ�뼼��211��</option>

                                                        </c:if>
                                                        <c:if test="${course_inf.className == '�������ѧ�뼼��211��'}">

                                                            <option>��ѡ��</option>
                                                            <option  value="������Ϣ211��">������Ϣ211��</option>
                                                            <option selected value="�������ѧ�뼼��211��">�������ѧ�뼼��211��</option>

                                                        </c:if>
                                                    </select>


                                                </div>
                                                <div class="col-sm-4 tips"></div>
                                            </div>
                                            <div class="form-group">
                                                <label for="classnum" class="col-sm-2 control-label">ѧ��</label>
                                                <div class="col-sm-6">
                                                    <!-- Single button -->
                                                    <select class="form-control" name="term">
                                                        <c:if test="${course_inf.term == '2021-2022ѧ�� ��һѧ��'}">

                                                            <option>��ѡ��</option>
                                                            <option selected value="2021-2022ѧ�� ��һѧ��">2021-2022ѧ�� ��һѧ��</option>
                                                            <option value="2021-2022ѧ�� �ڶ�ѧ��">2021-2022ѧ�� �ڶ�ѧ��</option>

                                                        </c:if>
                                                        <c:if test="${course_inf.term == '2021-2022ѧ�� �ڶ�ѧ��'}">

                                                            <option>��ѡ��</option>
                                                            <option  value="2021-2022ѧ�� ��һѧ��">2021-2022ѧ�� ��һѧ��</option>
                                                            <option selected value="2021-2022ѧ�� �ڶ�ѧ��">2021-2022ѧ�� �ڶ�ѧ��</option>

                                                        </c:if>
                                                    </select>


                                                </div>
                                                <div class="col-sm-4 tips"></div>
                                            </div>
                                        </div>


                                    </div>

                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-default" data-dismiss="modal">ȡ��</button>
                                        <button type="submit" class="btn btn-primary">ȷ�����</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </td>
                <td>
                    <form action="${pageContext.request.contextPath}/Face_photoServlet?courseID=${course_inf.courseID}" id="myForm${s.count}" enctype="multipart/form-data" method="post">

                        <a href="javascript:;" class="a-upload" >
                            <input type="file" name="sign_photo"  id="photo_face">�ϴ���Ƭ
                        </a>
                        <a class="a-upload"  id="btnA${s.count}">�ύ</a>
                    </form>
                    <script>
                        $(function(){
                            $("#btnA${s.count}").click(function(){
                                $("#myForm${s.count}").submit();
                            });
                        });
                    </script>
                </td>
            </tr>


                </c:forEach>

        </table>

        <p class="msg">�ܿγ�${pb.totalCount}�ţ���ǰ��ʾ��${pb.currentPage}ҳ</p>

    </div>
</div>
<!-- /MainForm -->
<ul id="PageNum">
    <li><a href="${pageContext.request.contextPath}/FindUserByPageServlet?currentPage=1&rows=9">��ҳ</a></li>



    <c:if test="${pb.currentPage > 1}">
        <li><a href="${pageContext.request.contextPath}/FindUserByPageServlet?currentPage=${pb.currentPage - 1}&rows=9">��һҳ</a></li>
    </c:if>
    <c:forEach begin="1" end="${pb.totalPage}" var="i">

        <c:if test="${pb.currentPage == i}">
            <li class="active"><a href="${pageContext.request.contextPath}/FindUserByPageServlet?currentPage=${i}&rows=9">${i}</a></li>
        </c:if>
        <c:if test="${pb.currentPage != i}">
            <li ><a href="${pageContext.request.contextPath}/FindUserByPageServlet?currentPage=${i}&rows=9">${i}</a></li>
        </c:if>
    </c:forEach>


    <c:if test="${pb.currentPage < pb.totalPage}">
        <li><a href="${pageContext.request.contextPath}/FindUserByPageServlet?currentPage=${pb.currentPage + 1}&rows=9">��һҳ</a></li>
    </c:if>


</ul>
<!-- /PageNum -->
</div>
</body>
</html>