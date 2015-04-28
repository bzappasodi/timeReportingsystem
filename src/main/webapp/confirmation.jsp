<%@ page contentType="text/html"%>

<jsp:include page="/template/header.jsp">
	<jsp:param name="title" value="Confirmation" />
</jsp:include>

<span class="contentRed"><c:out value="${databaseResponse}" /></span>

<%@ include file="/template/footer.jsp"%>
