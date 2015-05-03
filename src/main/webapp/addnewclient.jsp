<%@ page errorPage="error.jsp"%>
<%@ include file="/template/jspsupport.jsp" %>


<jsp:include page="/template/header.jsp">
	<jsp:param name="title" value="Add a new client" />
</jsp:include>

<strong><span class="contentRed"><c:out
	value="${errors}" /></span></strong>

<form action="SubmitTime.do" method="post" name="enterProject"><input
	type="HIDDEN" name="type" value="addnewclient">
<table border="0" cellspacing="3" cellpadding="3" class="viewtable">
	<tr>
		<td width="33%"><b>Client Name</b></td>
		<td><input type="text" name="NAME" size="30"
			value="<c:out value="${param.NAME}" />"></td>
		<td></td>
	</tr>
	<tr>
		<td width="33%"><b>Address</b></td>
		<td><textarea name="ADDRESS" rows="8" cols="30"><c:out
			value="${param.ADDRESS}" /></textarea></td>
		<td></td>
	</tr>
	<tr>
		<td colspan="3"><input type="submit" class="btn" value="Submit"
			name="action" /> <input type="reset" class="btn" value="Reset"
			name="action" /></td>
	</tr>
</table>
</form>


<%@ include file=/template/footer.jsp"%>
