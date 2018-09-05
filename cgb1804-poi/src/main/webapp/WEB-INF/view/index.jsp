<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%@include file="common.jsp"%>
<body>

	<div class="table-responsive">
		<table class="table">

			<thead class="Table cell">
				<td>ID</td>
				<td>title</td>
				<td>price</td>
				<td>are</td>
				<td>modle</td>
				<td>hight</td>
				<td>bear</td>
				<td>sub</td>
				<td>str</td>
				<td>loc</td>
				<td>tim</td>
				<td>url</td>
			</thead>

			<tbody>
				<c:forEach var="housesrc" items="${housesrc}">
					<tr class="success">
						<td>${housesrc.id}</td>
						<td>${housesrc.title}</td>
						<td>${housesrc.price}</td>
						<td>${housesrc.are}</td>
						<td>${housesrc.modle}</td>
						<td>${housesrc.hight}</td>
						<td>${housesrc.bear}</td>
						<td>${housesrc.sub}</td>
						<td>${housesrc.str}</td>
						<td>${housesrc.loc}</td>
						<td>${housesrc.tim}</td>
						<td>${housesrc.url}</td>
					</tr>
				</c:forEach>
				>
			</tbody>

		</table>
		<a href="/export"><button type="button" class="btn btn-primary">导出</button></a>

		<form class="form-horizontal" id="form_table" action="/import"
			enctype="multipart/form-data" method="post">
			<br /> <br />
			<button type="submit" class="btn btn-primary">导入</button>
			<input class="form-input" type="file" name="filename"></input>
		</form>

	</div>


</body>
</html>