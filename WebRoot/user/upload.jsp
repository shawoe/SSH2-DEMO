<%@ page contentType="text/html;charset=gbk"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
	<title>�ϴ�ͷ��</title>
</head>
<body>
	<s:include value="../nav/header.jsp" />
  	��ǰͷ��<br/>
	<img src="../avatar/admin.jpg"><br/>
	<form action="uploadAvatar" enctype="multipart/form-data" method="post">
          �ϴ�ͷ��:<input type="file" name="avatarImage" />
    	<input type="submit" value="����ͷ��" />
			<!-- ��ֹ���ظ��ύ -->
			<s:token />
	</form>
	<s:include value="../nav/footer.jsp" /> 
</body>
</html>

