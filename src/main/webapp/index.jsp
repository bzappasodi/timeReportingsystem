<%@ page errorPage="error.jsp" %>
<jsp:include page="template/header.jsp">
    <jsp:param name="title" value="Time reporting system login"/>
</jsp:include>
<div class="starter-template">


    <p><span class="contentRed">${databaseResponse}</span></p>

    <form role="form" action="LoginServlet.do" onsubmit="return checkLogin(this);">
        <input type="HIDDEN" name="type" value="login">

        <div class="form-group">
            <label for="name">Please enter your username</label>
            <input type="text" name="un" class="form-control" id="name">
        </div>
        <div class="form-group">
            <label for="pwd">Please enter your password</label>
            <input type="password" name="pw" class="form-control" id="pwd">
        </div>


        <div class="btn-group btn-group-justified" role="group">
            <div class="btn-group" role="group">
                <button type="submit" class="btn btn-default btn-lg" value="Submit">Submit</button>

            </div>
            <div class="btn-group" role="group">

                <button type="reset" class="btn btn-default btn-lg" value="Reset" name="action">Reset</button>
            </div>
        </div>


    </form>

</div>


<%@ include file="template/footer.jsp" %>