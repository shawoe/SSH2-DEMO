<%@page contentType="text/html;charset=gbk"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
	<title>��ʾ��Ϣ</title>
</head>
<body>
	<s:include value="../nav/header.jsp" />
	<table border="2px">
	<tr><th>ID</th><th>�û�</th><th>������</th><th>ʱ��</th><th>�Ѷ�</th></tr>
	<s:iterator value="#request.allSMS" id="everySMS">
	<tr><td><s:property value="#everySMS.SMSID"/></td>
		<td><s:property value="#everySMS.SMSUserName"/></td>
		<td><s:property value="#everySMS.SMSSender"/></td>
		<td><s:property value="#everySMS.SMSSendTime"/></td>
		<td><s:property value="#everySMS.SMSIsRead"/></td>
	</tr>
	<tr><td colspan="5"><s:property value="#everySMS.SMSContent"/></td></tr>
	</s:iterator>		
	</table>
	<a href="readFirstSMS">��ҳ</a>
	<a href="readLastSMS">��һҳ</a>
	<a href="readNextSMS">��һҳ</a>
	<a href="readEndSMS">���һҳ</a>
	<s:form action="../SMS/readSMS" method="get">
		<s:textfield name="SMSPageNow" label="��ǰҳ" />
		<s:textfield name="SMSPageCount" label="��ҳ��" />
		<s:textfield name="SMSPageSize" label="��ʾ��" />
		<s:submit value="����" />
	</s:form>	
	<s:include value="../nav/footer.jsp" /> 
 </body>
</html>
