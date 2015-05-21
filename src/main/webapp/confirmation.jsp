<%@ page contentType="text/html"%>
<%@ include file="/template/jspsupport.jsp" %>

<jsp:include page="/template/header.jsp">
	<jsp:param name="title" value="Confirmation" />
</jsp:include>

<span class="content-red"><c:out value="${databaseResponse}" /></span>

<%@ include file="/template/footer.jsp"%>
