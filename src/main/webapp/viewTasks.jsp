<%@ page errorPage="error.jsp"%>
<%@ include file="/template/jspsupport.jsp" %>
<jsp:include page="/template/header.jsp">
	<jsp:param name="title" value="View tasks for this project" />
</jsp:include>
<c:forEach var="i" items="${tasks}">
    <table border="2"
           id="viewtable" class="table">
		<tr>
			<td width="33%"><b>Task</b></td>
			<td><c:out value="${i.description}" /></td>

		</tr>
		<tr>
			<td width="33%"><b>Hours</b></td>
			<td><c:out value="${i.hours}" /></td>

		</tr>
		<tr>
			<td width="33%"><b>Date</b></td>
			<td><c:out value="${i.hoursadded}" /></td>
		</tr>
	</table>
	<br />
</c:forEach>


<%@ include file="/template/footer.jsp"%>
