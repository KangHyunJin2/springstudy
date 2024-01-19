<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <header class="d-flex flex-wrap justify-content-center py-3 mb-4 border-bottom">
      <a href="/" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto link-body-emphasis text-decoration-none">
        <svg class="bi me-2" width="40" height="32"><use xlink:href="#bootstrap"></use></svg>
        <span class="fs-4" style="font-weight: bold;">마라탕후루</span>
      </a>

      <ul class="nav nav-pills">
        <li class="nav-item"><a href="${pageContext.request.contextPath }/" class="nav-link active" aria-current="page">Home</a></li>
        <li class="nav-item"><a href="${pageContext.request.contextPath }/empList" class="nav-link">전체 사원 조회</a></li>
        <li class="nav-item"><a href="${pageContext.request.contextPath }/empInsert" class="nav-link">사원 정보 등록</a></li>
        <li class="nav-item"><a href="${pageContext.request.contextPath }/boardList" class="nav-link">게시판 조회</a></li>
        <li class="nav-item"><a href="${pageContext.request.contextPath }/boardInsert" class="nav-link">게시글 등록</a></li>
      </ul>
    </header>