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

	<header>
		<p>header</p>
	</header>
	
	<nav>
		<p>nav</p>
	</nav>
	
	<div class="primary">
	<s:if test="%{#session.currentUser == null}">
		<ul><p>����δ��¼��</p>
    		<li><a href="user/login.jsp">���ڵ�¼</a></li>
    		<li><a href="user/register.jsp">����ע��</a></li>
    	</ul>
	</s:if>
	<s:else>
		<ul>
			<spen><img src="avatars/admin.jpg"></spen>
			<spen><s:property value="#session.currentUser" />����ӭ����<spen>
    		<li><a href="user/welcome.jsp">�������������ҳ</a></li>
  			<li><a href="logoutUser">�˳���¼</a></li>
  		</ul>
  	</s:else>
	</div>
	
	<div class="secondary">
		<p>secondary</p>
		<p>��ǰ�����û��� </p>
		<s:property value="#session.onlineUser"/>
	</div>
	
	<footer>
		<p>footer</p>
	</footer>

</body>
</html>
