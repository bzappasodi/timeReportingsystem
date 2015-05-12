<%@ page isErrorPage="true"%>
<%@ include file="/template/jspsupport.jsp" %>

<jsp:include page="/template/header.jsp">
	<jsp:param name="title" value="View all tasks for this project" />
</jsp:include>


<table border="2"
       id="viewtable" class="table">

	<tr>
		<td>Exception Class:</td>
		<td><%=exception.getClass()%></td>
	</tr>

	<tr>
		<td>Message:</td>
		<td><%=exception.getMessage()%></td>
	</tr>

</table>

<%@ include file="/template/footer.jsp"%>

