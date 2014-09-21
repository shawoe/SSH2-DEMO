<%@page contentType="text/html;charset=gbk"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
	<title>显示信息</title>
</head>
<body>
	<s:include value="../nav/header.jsp" />
	<table border="2px">
	<tr><th>ID</th><th>用户</th><th>寄信人</th><th>时间</th><th>已读</th></tr>
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
	<a href="readFirstSms">首页</a>
	<a href="readLastSms">上一页</a>
	<a href="readNextSms">下一页</a>
	<a href="readEndSms">最后一页</a>
	<s:form action="../sms/readSms" method="get">
		<s:textfield name="smsPageNow" label="当前页" />
		<s:textfield name="smsPageCount" label="总页数" />
		<s:textfield name="smsPageSize" label="显示量" />
		<s:submit value="跳至" />
	</s:form>	
	<s:include value="../nav/footer.jsp" /> 
 </body>
</html>
