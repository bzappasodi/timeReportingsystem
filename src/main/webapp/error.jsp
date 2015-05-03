<%@ page isErrorPage="true"%>
<%@ include file="/template/jspsupport.jsp" %>

<jsp:include page="/template/header.jsp">
	<jsp:param name="title" value="View all tasks for this project" />
</jsp:include>



<TABLE width="100%" cellspacing="3" cellpadding="3">

	<tr>
		<td>Exception Class:</td>
		<td><%=exception.getClass()%></td>
	</tr>

	<tr>
		<td>Message:</td>
		<td><%=exception.getMessage()%></td>
	</tr>

</TABLE>

<%@ include file="/template/footer.jsp"%>

