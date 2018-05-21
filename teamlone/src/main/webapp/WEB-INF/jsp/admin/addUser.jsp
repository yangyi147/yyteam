<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/comm/bootstrap/css/bootstrap.css" media="all">
		<link rel="stylesheet" type="text/css" href="/css/bootstrap.css" />
		<link rel="stylesheet" type="text/css" href="/comm/global.css" media="all">
		<link rel="stylesheet" type="text/css" href="/css/personal.css" media="all">
		<script src="/js/jquery-3.0.0.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="/comm/bootstrap/js/bootstrap.js" type="text/javascript" charset="utf-8"></script>
</head>
<body>


<div style="position: absolute; left: 20%;top: 20%; width: 450px;">

<form class="form-horizontal" action="/admin/user/addUser" method="post">
  <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">登陆账号</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="login_name" id="login_name" value="">
    </div>
  </div>
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">登陆密码</label>
    <div class="col-sm-10">
      <input type="password" class="form-control" id="login_pwd" name="login_pwd"  value="">
    </div>
  </div>
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">真实姓名</label>
    <div class="col-sm-10">
      <input type="password" class="form-control" id="user_name" name="user_name"  value="">
    </div>
  </div>

  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">Email</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="email" name="email" value="">
    </div>
  </div>
    <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">电话</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="tel" name="tel" value="">
    </div>
  </div>
    <div class="form-group" id="js">
    <label for="inputPassword3" class="col-sm-2 control-label">角色</label>
    <div class="col-sm-10">
            <select class="form-control" id="role_id" name="role_id">
            <c:forEach items="${allSys_Role }" var="roles">
             <option value="1"  >${roles.role_name } </option>
             </c:forEach>
            </select>
    </div>
  </div>

  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-default">提交</button>
      <button type="button" id="close"  class="btn btn-default">取消</button>
    </div>
  </div>
</form>

</div>

<script type="text/javascript">
$(function () {
	$("#close").click(function () {
		window.location.href="/admin/user/list";
	})

</script>

</body>
</html>