<%@ page errorPage="error.jsp" %>
<jsp:include page="template/header.jsp">
    <jsp:param name="title" value="Time reporting system login"/>
</jsp:include>

    <p><span class="contentRed">${databaseResponse}</span></p>

    <form role="form" action="LoginServlet.do" onsubmit="return checkLogin(this);">
        <input type="HIDDEN" name="type" value="login" class="form-inline">
            <input type="text" name="un" class="input-small" placeholder="Name">
            <input type="password" name="pw" class="input-small" placeholder="Password">
            <button type="submit" class="btn btn-primary">Sign in</button>

    </form>




<%@ include file="template/footer.jsp" %>