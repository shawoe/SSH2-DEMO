<%@page contentType="text/html;charset=gbk"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
	<title>������Java EE����ҵ������ʾ��</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="author" content="Shawoe">
	<meta name="description" content="A demonstration of what can be accomplished through Java EE.">
	<meta name="robots" content="all">
</head>
<body id="home-page">	
	<div class="primary">
	<s:if test="%{#session.currentUser == null}">
		<p>����δ��¼��</p>
    	<a href="user/login.jsp">���ڵ�¼</a>
    	<a href="user/register.jsp">����ע��</a>
	</s:if>
	<s:else>
		<img src="avatars/admin.jpg">
		<p><s:property value="#session.currentUser" />����ӭ����</p>
    	<a href="user/welcome.jsp">�������������ҳ</a>
  		<a href="logoutUser">�˳���¼</a>
  	</s:else>
	</div>
	
	<div class="secondary">
		<p>��ǰ�����û��� </p>
		<s:property value="#session.onlineUser"/>
	</div>
	
</body>
</html>
