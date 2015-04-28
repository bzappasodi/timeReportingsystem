<%@ page errorPage="error.jsp"%>

<jsp:include page="/template/header.jsp">
	<jsp:param name="title" value="Insert a new project" />
</jsp:include>


<strong><span class="contentRed"><c:out
	value="${errors}" /></span></strong>

<div id="mycal2"></div>
<div id="mycal"></div>

<form action="SubmitTime.do" method="post" name="enterProject"><input
	type="HIDDEN" name="type" value="add">

<table border="0" cellspacing="3" cellpadding="3" class="viewtable">
	<tr>
		<td><b>Existing Clients</b></td>
		<td><select NAME="CLIENT_ID">
			<option value="" SELECTED>-- Please Select --</option>
			<c:forEach var="i" items="${clients}">
				<option value="<c:out value="${i.clientId}"/>"><c:out
					value="${i.client}" /></option>
			</c:forEach>
		</select>
		<td></td>
	</tr>
	<tr>
		<td width="33%"><b>Project</b></td>
		<td><textarea name="DESCRIPTION" rows="8" cols="30"><c:out
			value="" /></textarea></td>
		<td></td>
	</tr>
	<tr>
		<td width="33%"><b>Hours budgeted</b></td>

		<td><input type="text" name="HOURS" size="10" value=""></td>
		<td></td>
	</tr>
	<tr>
		<td width="33%"><b>Start date</b></td>

		<td><input type="text" name="START_DATE" id="START_DATE"
			size="20" value=""></td>
		<td></td>
	</tr>
	<tr>
		<td width="33%"><b>Due date</b></td>
		<td><input type="text" name="DUE_DATE" id="DUE_DATE" size="20"
			value=""></td>
		<td></td>
	</tr>
	<tr>
		<td width="33%"><b>Invoice sent</b></td>
		<td><select name="INVOICE_SENT">
			<option value="">--- Please select ---</option>
			<option value="yes">Yes</option>
			<option value="no">No</option>
		</select></td>
		<td></td>
	</tr>
	<tr>
		<td colspan="3"><input type="submit" class="btn" value="Submit"
			name="action" /> <input type="reset" class="btn" value="Reset"
			name="action" /></td>
	</tr>
</table>
</form>


<%@ include file="/template/footer.jsp"%>
