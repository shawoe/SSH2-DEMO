<%@page contentType="text/html;charset=gbk"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
	<title>ҳü</title>
</head>
<body>
	<s:if test="%{#session.currentUser == null}">
		����δ��¼��<br/>
    	<a href="../user/login.jsp">���ڵ�¼</a><br/>
    	<a href="../user/register.jsp">����ע��</a><br/>
	</s:if>
	<s:else>	
		<img src="../avatar/admin.jpg"><br/>
		<s:property value="#session.currentUser" />����ӭ����<br/>
    	<a href="../user/welcome.jsp">������ҳ</a><br/>
  		<a href="logoutUser">�˳���¼</a><br/>
	</s:else>
	<hr/>
</body>
</html>
