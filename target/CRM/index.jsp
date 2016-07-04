<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE HTML>
<html >
  <head>
	  <base href="<%=basePath%>">
    <title>login</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/signin.css" rel="stylesheet">
	<script type="text/javascript">
		function register(){
			window.location.href='/register';
		}
	</script>

  </head>
  
  <body>

    <div class="signin">
		<div class="signin-head"><img src="/images/test/head_120.png" alt="" class="img-circle"></div>
		<form class="form-signin" action="/Login" method="post">
			<span>${error}</span>
			<input type="text" class="form-control" placeholder="用户名" required autofocus name="username"/>
			<input type="password" class="form-control" placeholder="密码" required name="password"/>
			<button class="btn btn-lg btn-warning btn-block" type="submit" name="login" >登录</button>
			<button class="btn btn-lg btn-warning btn-block" type="button" name="register" onclick="javascript:window.location.href='/registor';">注册</button>
		</form>
	</div>
  </body>
</html>
