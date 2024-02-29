<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- 로그인 한 세션 가져오기 -->


<div id="header" class="clearfix">
			<h1>
				<a href="">MySite${pageContext.request.contextPath}</a>
			</h1>
			
			<c:choose>
				<c:when test="${!empty sessionScope.authUser }">
					<!-- 세션 영역에 값이 있으면 로그인 성공 -->
					<ul>
						<li>${sessionScope.authUser.name }님 안녕하세요^^</li>
						<li><a href="" class="btn_s">로그아웃</a></li>
						<li><a href="" class="btn_s">회원정보수정</a></li>
					</ul>
				</c:when>
				<c:otherwise>
					<!-- 세션 영역에 값이 없으면 로그인 안 된 상태 -->
					<ul>
						<li><a href="" class="btn_s">로그인</a></li>
						<li><a href="" class="btn_s">회원가입</a></li>
					</ul>
				</c:otherwise>			
			</c:choose>


			

			
			
		</div>
		
		<div id="nav">
			<ul class="clearfix">
				<li><a href="">입사지원서</a></li>
				<li><a href="">게시판</a></li>
				<li><a href="">갤러리</a></li>
				<li><a href="">방명록</a></li>
			</ul>
		</div>