<%@page contentType="text/html;charset=gbk"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
	<title>��ʾ�����û�</title>
</head>
<body>
	<s:include value="../nav/header.jsp" />
	<table border="2px">
	<tr><th>ID</th><th>�û�</th><th>�Ա�</th><th>����</th><th>����</th><th>����</th></tr>
	<s:iterator value="#request.allUsers" id="user">
	<tr><td><s:property value="#user.userID"/></td>
		<td><s:property value="#user.userName"/></td>
		<td><s:property value="#user.userSex"/></td>
		<td><s:property value="#user.userBirth"/></td>
		<td><s:property value="#user.userEmail"/></td>
		<td><s:property value="#user.userOnline"/></td>
	</tr>
	</s:iterator>		
	</table>
	<s:include value="../nav/footer.jsp" /> 
 </body>
</html>
