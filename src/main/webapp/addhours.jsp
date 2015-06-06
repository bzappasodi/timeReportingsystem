<%@ page errorPage="error.jsp" %>

<%@ include file="/template/jspsupport.jsp" %>

<jsp:include page="/template/header.jsp">
    <jsp:param name="title" value="Add a task for this project"/>
</jsp:include>

<form action="SubmitTime.do" method="post" name="enterProject">
    <input type="HIDDEN" name="type" value="add_hours">
    <input type="HIDDEN" name="PROJECT_ID" value="${projectId}"/>


    <table border="2"
           id="viewtable" class="table">

        <tr>
            <td width="33%"><b>Project</b></td>
            <td>${description}</td>

        </tr>
        <tr>
            <td width="33%"><b>Task description</b></td>
            <td><textarea name="DESCRIPTION" rows="8" cols="30"></textarea></td>


        </tr>

        <tr>
            <td width="33%"><b>Date</b></td>
            <td><input type="text" name="HOURS_ADDED" id="START_DATE"
                       size="20" value="<c:out value="${param.START_DATE}" />">
            </td>

        </tr>
        <tr>
            <td width="33%"><b>Hours</b></td>
            <td><input type="number" name="HOURS" size="20" value=""></td>

        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Submit" name="action"
                                   class="btn btn-primary btn-lg"/> <input type="reset" value="Reset" name="action"
                                                                           class="btn btn-primary btn-lg"/></td>
        </tr>
    </table>


</form>

<%@ include file="/template/footer.jsp" %>
