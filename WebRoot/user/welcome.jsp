<%@page contentType="text/html;charset=gbk"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
	<title>登录成功</title>
</head>
<body>
	<s:include value="../nav/header.jsp" />
	<a href="upload.jsp">上传头像</a><br/>
	<a href="showUser">查看用户资料</a><br/>
	<a href="command.jsp">修改密码</a><br/>
	<a href="../sms/readFirstSMS">查看短信</a><br/>
	<a href="../sms/readFirstLogger">查看日志</a><br/>
	<a href="../sms/write.jsp">写新短信</a><br/>
	<a href="showAllUsers">查看所有用户</a><br/>	
	<s:include value="../nav/footer.jsp" /> 
  </body>
</html>
