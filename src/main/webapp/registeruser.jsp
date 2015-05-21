<%@ page errorPage="error.jsp" %>
<%@ include file="/template/jspsupport.jsp" %>

<jsp:include page="/template/header.jsp">
    <jsp:param name="title" value="Time reporting user registration"/>
</jsp:include>

<div class="container">
    <br/>
    <p><span class="content-red">${databaseResponse}</span></p>

    <p><span class="content-red">Please create an account</span></p>
    <br/>

    <form action="LoginServlet.do" onsubmit="return checkReg(this);" class="form-horizontal" role="form">
        <input type="HIDDEN" name="type" value="registeruser">
        <div class="form-group">
            <label class="control-label col-sm-2" for="inputfirstname">First Name:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="inputfirstname" placeholder="First Name">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="inputlasttname">Last Name:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="inputlasttname" placeholder="Last Name">
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-sm-2" for="inputusername">User Name:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="inputusername" placeholder="User Name">
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-sm-2" for="inputpassword">Password:</label>
            <div class="col-sm-10">
                <input type="password" class="form-control" id="inputpassword" placeholder="Password">
            </div>
        </div>


        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-primary btn-lg">Submit</button>
            </div>
        </div>
    </form>



</form>
</div>

<%@ include file="/template/footer.jsp" %>