<%@ page errorPage="error.jsp"%>

<%@ include file="/template/jspsupport.jsp" %>

<jsp:include page="/template/header.jsp">
	<jsp:param name="title" value="Edit task for this project" />
</jsp:include>


<form action="SubmitTime.do" method="post" name="enterProject"><input
	type="HIDDEN" name="type" value="update">
	<input type="HIDDEN" name="PROJECT_ID" value="${projectId}" />


    <table border="2"
           id="viewtable" class="table">
		<tr>
			<td width="33%"><b>Project</b></td>
			<td align="left"><textarea name="DESCRIPTION" rows="8" cols="30">
				${description}</textarea></td>

		</tr>
		<tr>
			<td width="33%"><b>Hours Budgeted</b></td>
			<td><input type="text" name="HOURS" size="20"
				value="${hours}"></td>

		</tr>
		<tr>
			<td width="33%"><b>Start date</b></td>
			<td><input type="text" name="START_DATE" id="START_DATE"
				size="20" value="${startdate}"> </td>

		</tr>
		<tr>
			<td width="33%"><b>Due date</b></td>
			<td><input type="text" name="DUE_DATE" id="DUE_DATE" size="20"
				value="${duedate}"> </td>

		</tr>
		<tr>
			<td width="33%"><b>Invoice sent</b></td>
			<td><select name="INVOICE_SENT">
				<c:choose>
					<c:when test='${invoicesent == "yes"}'>
						<option value="yes" SELECTED>Yes</option>
						<option value="no">No</option>
					</c:when>
					<c:otherwise>
						<option value="yes">Yes</option>
						<option value="no" SELECTED>No</option>
					</c:otherwise>
				</c:choose>
			</select></td>

		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="Submit"
				name="action" class="btn btn-primary btn-lg" /> <input type="reset" value="Reset"
				name="action" class="btn btn-primary btn-lg" /></td>
		</tr>

	</table>
</form>

<%@ include file="/template/footer.jsp"%>
