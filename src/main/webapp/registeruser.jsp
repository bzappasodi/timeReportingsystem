<%@ page errorPage="error.jsp" %>

<jsp:include page="/template/header.jsp">
    <jsp:param name="title" value="Time reporting user registration"/>
</jsp:include>

<%--
<form action="LoginServlet.do" onsubmit="return checkReg(this);"class="form-horizontal"> <input
	type="HIDDEN" name="type" value="registeruser">

<table cellspacing="3" cellpadding="3" width="420" border="2"
	class="viewtable">

	<tr>
		<td>Please enter your first name</td>

		<td><input type="text" name="firstname" /></td>
	</tr>
	<tr>
		<td>Please enter your last name</td>
		<td><input type="text" name="lastname" /></td>
	</tr>
	<tr>
		<td>Please enter a username</td>
		<td><input type="text" name="un" /></td>
	</tr>
	<tr>
		<td>Please enter a password</td>
		<td><input type="password" name="pw" /></td>
	</tr>
	<tr>
		<td colspan="2"><input type="submit" value="Submit" class="btn">&nbsp;<input
			type="reset" class="btn" value="Reset" name="action" /></td>
	</tr>
</table>
      --%>

    <p><span class="contentRed">${databaseResponse}</span></p>

    <p><span class="contentRed">Please create an account</span></p>
    <br/>

    <form action="LoginServlet.do" onsubmit="return checkReg(this);" class="form-horizontal">
        <input type="HIDDEN" name="type" value="registeruser">
    <div class="control-group">
        <label class="control-label" for="inputfirstname">first name</label>

        <div class="controls">
            <input type="text" id="inputfirstname" placeholder="first name">
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputlastname">lastname</label>

        <div class="controls">
            <input type="text" id="inputlastname" placeholder="lastname">
        </div>
    </div>

    <div class="control-group">
        <label class="control-label" for="inputusername">username</label>

        <div class="controls">
            <input type="text" id="inputusername" placeholder="username">
        </div>
    </div>


    <div class="control-group">
        <label class="control-label" for="inputpassword">password</label>

        <div class="controls">
            <input type="password" id="inputpassword" placeholder="password">
        </div>
    </div>


    <button type="submit" class="btn btn-primary">Submit</button>



</form>

<%@ include file="/template/footer.jsp" %>