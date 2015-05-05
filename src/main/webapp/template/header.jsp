<%@ include file="/template/jspsupport.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/trs-overrides.css">


<title>${param.title}</title>
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

    <script type="text/javascript" charset="utf8" src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.2.min.js"></script>
    <script type="text/javascript" charset="utf8" src="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/jquery.dataTables.min.js"></script>

</head>
<body>

<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <c:if  test="${not empty sessionScope.currentSessionUser}">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            </c:if>
            <a class="navbar-brand active" href="#">${param.title}</a>
        </div><c:if  test="${not empty sessionScope.currentSessionUser}">
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li><a href="SearchTime.do?type=viewprojects">View all projects</a></li>
                <li><a href="SearchTime.do?type=insertprojects">Insert a new project</a></li>
                <li><a href="addnewclient.jsp">Insert a new client</a></li>
            </ul>
        </div>
    </c:if>
        <!--/.nav-collapse -->
    </div>
</nav>

<div class="container-fluid">
    <div class="starter-template">
<c:if test="${not empty sessionScope.currentSessionUser}">

<p><h2>WELCOME USER: ${currentSessionUser}</h2>
<div id="logout">[ <a href="LogoutServlet.do?type=logout">logout</a> ]</div>
</p>

</c:if>
