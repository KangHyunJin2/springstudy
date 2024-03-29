<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="container">
	<h1>자유 게시판</h1>
	<div>
		<button type="button" onclick="location.href='boardInsert'">등록</button>
	</div>
	<table class="table">
		<thead>
			<tr>
				<th>No.</th>	
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th> <!-- yyyy년MM월dd일 -->
			</tr>
		</thead>
		<tbody>
			<tr>
				<c:forEach items="${boardList}" var="board" varStatus="sts">
				<tr onclick="location.href='boardInfo?bno=${board.bno}'"> <!-- 페이지 강제 전환 -->
					<td>${sts.count }</td>
					<td>${board.bno}</td>
					<td>${board.title}</td>
					<td>${board.writer}</td>
					<td>
						<fmt:formatDate value="${board.regdate}" pattern="yyyy년MM월dd일"/>
					</td>
				</tr>
			</c:forEach>
			</tr>
		</tbody>
	</table>
</div>


<style>

</style>