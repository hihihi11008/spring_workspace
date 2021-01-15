<%@page import="com.koreait.fashionshop.model.domain.Qna"%>
<%@page import="com.koreait.fashionshop.model.common.Pager"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%
	Pager pager = (Pager)request.getAttribute("pager");
	List<Qna> qnaList = (List)pager.getList();
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="description" content="">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<%@ include file="../inc/header.jsp" %>
<style>
.container {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}
table {
  border-collapse: collapse;
  border-spacing: 0;
  width: 100%;
  border: 1px solid #ddd;
}

th, td {
  text-align: left;
  padding: 16px;
}

tr:nth-child(even) {
  background-color: #f2f2f2;
}
</style>	
<script>
</script>		
</head>
<body>
<%@include file="../inc/top.jsp" %>
	<table>
		<tr>
			<th>No</th>
			<th>제목</th>
			<th>작성자</th>
			<th>등록일</th>
			<th>조회수</th>
		</tr>
		<% 
			int curPos=pager.getCurPos();
			int num = pager.getNum();
		%>
		<%for(int i=1; i<pager.getPageSize();i++){ %>
		<%if(num<1)break; %>
		<%Qna qna = qnaList.get(i); %>
		<tr>
			<td><%=num-- %></td>
			<td><%=qna.getTitle() %></td>
			<td><%=qna.getWriter() %></td>
			<td><%=qna.getRegdate()%></td>
			<td><%=qna.getHit() %></td>
		</tr>
		<%} %>

		<tr>
			<td colspan="5">
				<button onclick="location.href='/shop/cs/qna/registForm'">글등록</button>
			</td>
		</tr>
		
		<tr>
			<td>
				<div class="pagination" align="center">
		          	<%for(int i=pager.getFirstPage();i<=pager.getLastPage();i++){ %>
					<%if(i>pager.getTotalPage()) break; %>
					<a <%if(pager.getCurrentPage()==i){ %>class="pageNum"<%} %> href="/client/cs/qna/list?currentPage=<%=i%>">[<%=i %>]</a>
		           	<%} %>
	           	</div>
			</td>
		</tr>
	</table>
<%@ include file="../inc/footer.jsp" %>
</div>
</body>
</html>