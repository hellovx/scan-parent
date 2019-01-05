<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
hello this is test.....

<img id="p1" src="<%=request.getContextPath()%>/test.jpg" height="100" width="100" onclick="hellophoto();">
</body>
<script type="text/javascript">
function hellophoto(){
	 var str=document.getElementById("p1").src;
	alert(str);
	window.open(str);
}
</script>
</html>