<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<script>
function regist(){
	var form =document.querySelector("form");
	form.action="/emp/regist";
	form.method="post";
	form.submit();
}
</script>
</head>
<body>
	[입사등록 양식]
	
	<form action="">
		<input type="text" name="deptno" placeholder="부서번호">
		<input type="text" name="dname" placeholder="부서이름">
		<input type="text" name="loc" placeholder="부서지역">

		<input type="text" name="empno" placeholder="사원번호">
		<input type="text" name="ename" placeholder="사원이름">
		<input type="text" name="sal" placeholder="급여">
		<button type="button" onclick="regist()">사원등록</button>
	
	</form>
</body>
</html>