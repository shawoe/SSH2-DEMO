<%@ page contentType="text/html;charset=gbk"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
	<title>上传头像</title>
</head>
<body>
	<s:include value="../nav/header.jsp" />
  	当前头像：<br/>
	<img src="../avatar/admin.jpg"><br/>
	<form action="uploadAvatar" enctype="multipart/form-data" method="post">
          上传头像:<input type="file" name="avatarImage" />
    	<input type="submit" value="保存头像" />
			<!-- 防止表单重复提交 -->
			<s:token />
	</form>
	<s:include value="../nav/footer.jsp" /> 
</body>
</html>

