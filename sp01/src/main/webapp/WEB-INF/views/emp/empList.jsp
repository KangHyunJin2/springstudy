<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전체 사원 조회</title>
</head>
<body>
	<button></button>
	<table>
		<thead>
			<tr>
				<th>No.</th>
				<th>employee_id</th>
				<th>last_name</th>
				<th>email</th>
				<th>hire_date</th>
				<th>job_id</th>
				<th>salary</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${empList}" var="info" varStatus="sts">
				<tr onclick="location.href='empInfo?employeeId=${info.employeeId}'">
					<td class="line">${sts.count }</td>
					<td class="line">${info.employeeId}</td>
					<td class="line">${info.lastName}</td>
					<td class="line">${info.email}</td>
					<td class="line">
						<fmt:formatDate value="${info.hireDate}" pattern="yyyy년MM월dd일"/>
					</td>
					<td class="line">${info.jobId}</td>
					<td class="line">${info.salary}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<!-- JSP -> Servlet -> Java => html -> css -> javascript  해석이 되는 순간 -->
</body>
</html>

<style>
.line{
	text-align: center;
}
</style>