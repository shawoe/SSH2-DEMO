<%@page contentType="text/html;charset=gbk"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
	<title>页脚</title>
</head>
<body>
	<hr/>
	当前在线用户： 
	<s:property value="#session.onlineUser"/><br/>
</body>
</html>
