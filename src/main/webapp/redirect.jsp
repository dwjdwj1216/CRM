<%--
  Created by IntelliJ IDEA.
  User: 顾梦超
  Date: 2016/5/11
  Time: 21:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>Title</title>

</head>
<body>
${result}
<script language="javascript" type="text/javascript">
    window.location.href="${url}";
</script>

</body>
</html>
