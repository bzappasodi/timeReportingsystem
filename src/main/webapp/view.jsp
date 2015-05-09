<%@ page errorPage="error.jsp"%>
<%@ include file="/template/jspsupport.jsp" %>
<jsp:include page="/template/header.jsp">
    <jsp:param name="title" value="View projects"/>
</jsp:include>
<script>
    $(function(){
        $("#viewtable").dataTable();
    })
</script><div class="table-responsive">
<table border="2"
       id="viewtable" class="table">
    <tr>
        <th>Delete</th>
        <th>Edit</th>
        <th>Add tasks</th>
        <th>View tasks</th>
        <th>Client</th>
        <th>Description</th>
        <th>Hours budgeted</th>
        <th>Start date</th>
        <th>Due date</th>
        <th>Invoice sent</th>
    </tr>
    <c:forEach var="i" items="${projects}">
        <tr>
            <td class=content><a
                    href="SubmitTime.do?projectId=${i.projectId}&type=delete"
                    onclick="return confirm('Are you sure you want to delete?')"/>Delete</a></td>
            <td class=content><a
                    href="SearchTime.do?type=edit&projectId=${i.projectId}"/>Edit</a></td>
            <td class=content><a
                    href="SearchTime.do?type=addtasks&projectId=${i.projectId}"/>Add
                tasks</a></td>
            <td class="content"><a
                    href="SearchTime.do?type=viewtasks&projectId=${i.projectId}">View
                tasks</a></td>
            <td class=content><c:out value="${i.client}"/></td>
            <td class=content><c:out value="${i.description}"/></td>
            <td class=content><c:out value="${i.hours}"/></td>
            <!-- <td class=content><c:out value="${i.totalhours}" /></td> -->
            <td class=content><c:out value="${i.startdate}"/></td>
            <td class=content><c:out value="${i.duedate}"/></td>
            <td class=content><c:out value="${i.invoicesent}"/></td>
        </tr>
    </c:forEach>


</table>
    </div>
<%@ include file="/template/footer.jsp" %>


