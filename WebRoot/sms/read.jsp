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
	<s:iterator value="#request.allSms" id="everySms">
	<tr><td><s:property value="#everySms.smsID"/></td>
		<td><s:property value="#everySms.smsUserName"/></td>
		<td><s:property value="#everySms.smsSender"/></td>
		<td><s:property value="#everySms.smsSendTime"/></td>
		<td><s:property value="#everySms.smsIsRead"/></td>
	</tr>
	<tr><td colspan="5"><s:property value="#everySms.smsContent"/></td></tr>
	</s:iterator>		
	</table>
	<a href="readFirstSms">��ҳ</a>
	<a href="readLastSms">��һҳ</a>
	<a href="readNextSms">��һҳ</a>
	<a href="readEndSms">���һҳ</a>
	<s:form action="../sms/readSms" method="get">
		<s:textfield name="smsPageNow" label="��ǰҳ" />
		<s:textfield name="smsPageCount" label="��ҳ��" />
		<s:textfield name="smsPageSize" label="��ʾ��" />
		<s:submit value="����" />
	</s:form>	
	<s:include value="../nav/footer.jsp" /> 
 </body>
</html>
