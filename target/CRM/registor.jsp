<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="Michael" >
    <link rel="icon" href="../../favicon.ico">

    <title>Registration</title>

    <!-- Bootstrap core CSS -->
    <link href="lib/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="my/css/starter-template.css" rel="stylesheet">

</head>
<body>
<div class="span2">
    <div class="container">
        <h1>注册</h1>
        <p>请填写相关信息</p>
        <span>
        <form method="post" action="/registor">
            <span>${error}</span>
            <br>
          <div class="form-group">
             <label for="username">用户名</label>
              <input type="text" id="username" name="username" class="form-control" >
           </div>
           <div class="form-group">
             <label for="password">密码</label>
             <input type="password" class="form-control" id="password" name="password">
           </div>
           <div class="form-group">
             <label for="repassword">重复密码</label>
             <input type="password" class="form-control" id="repassword" name="repassword">
           </div>
            <div class="form-group">
             <label for="realName">真实姓名</label>
             <input type="text" class="form-control" id="realName" name="realName">
           </div>
            <div class="form-group">
             <label for="role">职业</label>
             <input type="text" class="form-control" id="role" name="role">
           </div>
            <div class="form-group">
             <label for="libID">图书证编号</label>
             <input type="text" class="form-control" id="libID" name="libID">
           </div>
            <div class="form-group">
             <label for="email">邮箱</label>
             <input type="email" class="form-control" id="email" name="email">
           </div>
            <div class="form-group">
             <label for="phoneNumber">手机</label>
             <input type="text" class="form-control" id="phoneNumber" name="phoneNumber">
           </div>
           <button type="submit" class="btn btn-success">提交</button>
         </form>

        </span>
        <br /><br />


    </div>
</div>




<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="lib/js/jquery-1.11.2.min.js"></script>
<script src="lib/js/bootstrap.min.js"></script>
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->

</body>
</html>

