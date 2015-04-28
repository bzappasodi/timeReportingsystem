<%@ page errorPage="error.jsp" %>


<jsp:include page="/template/header.jsp">
    <jsp:param name="title" value="Add a task for this project"/>
</jsp:include>

<form action="SubmitTime.do" method="post" name="enterProject"><input
        type="HIDDEN" name="type" value="add_hours"> <input
        type="HIDDEN" name="PROJECT_ID" value="${projectId}"/>

    <div id="mycal2"></div>
    <div id="mycal"></div>
    <table border="0" cellspacing="3" cellpadding="3" class="viewtable">

        <tr>
            <td width="33%"><b>Project</b></td>
            <td>${description}</td>
            <td></td>
        </tr>
        <tr>
            <td width="33%"><b>Task description</b></td>
            <td><textarea name="DESCRIPTION" rows="8" cols="30"></textarea></td>
            <td></td>

        </tr>

        <tr>
            <td width="33%"><b>Date</b></td>
            <td><input type="text" name="HOURS_ADDED" id="START_DATE"
                       size="20" value="<c:out value="${param.START_DATE}" />">
            </td>
            <td></td>
        </tr>
        <tr>
            <td width="33%"><b>Hours</b></td>
            <td><input type="text" name="HOURS" size="20" value=""></td>
            <td align="right"><br>
            </td>
        </tr>
        <tr>
            <td colspan="3"><input type="submit" value="Submit" name="action"
                                   class="btn"/> <input type="reset" value="Reset" name="action"
                                                        class="btn"/></td>
        </tr>
    </table>


</form>

<%@ include file="/template/footer.jsp" %>