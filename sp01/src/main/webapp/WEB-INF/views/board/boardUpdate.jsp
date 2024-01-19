<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="container">
	<h1>게시글 수정</h1>
	<form name="updateForm"> <!-- 어디로 통신할껀지 action 써서 처리할 controller 정의해주고 -->
		<table class="table">
			<tr>
				<th>번호</th>
				<td><input type="text" name="bno" value="${boardInfo.bno }" readonly></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="title" value="${boardInfo.title }"></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><input type="text" name="writer" value="${boardInfo.writer }"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea name="contents">${boardInfo.contents }</textarea></td>
			</tr>
			<tr>
				<th>이미지</th>
				<td><input type="file" name="image" value="${boardInfo.image }"></td>
			</tr>
		</table>
		<div>
			<button type="button" onclick="location.href='boardList'">목록으로</button>
			<button type="button">저장</button>
		</div>
	</form>
	
</div>

<script>
	$('form button:contains(저장)').on('click', boardUpdateAjax); // 선택자 

	function boardUpdateAjax(event){
		// 통신 진행 여부 결정
		if(!validation()) return;

		// 통신하기 위한 데이터 가져오기
		let boardDta = getBoardInfo();
		console.log('boardDta', boardDta);

		$.ajax('boardUpdate', {
			type : 'post',
			// 커멘드 객체
			//data : boardDta
			
			//@RequestBody
			contentType : 'application/json',
			data : JSON.stringify(boardDta)
		})
		.then(result => {
			console.log(result);
		})
		.fail(err => console.log(err));
	}
	function validation(){

		let title = $('[name="title"]');
		let writer = $('[name="writer"]')

		if(title.val() == ''){
			alert('제목을 확인해주세요.');
			title.focus();
			return false;
		}

		if(writer.val() == ''){
			alert('작성자를 확인해주세요.');
			writer.focus();
			return false;
		}

		return true; // 리턴하는 트루가 없으면 돌지 못한다 undefind가 뜨면서...
	}

	function getBoardInfo(){
		let formAry = $('form[name="updateForm"]').serializeArray();
		console.log(formAry);

		let formObj = {};			// 단순하게 외우자
		$(formAry).each((idx, tag) =>{
			console.log(idx, tag);
			formObj[tag.name] = tag.value;
		});
		return formObj;
	}
</script>