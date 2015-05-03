

<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:useBean id="now" class="java.util.Date" />
<fmt:formatDate var="year" value="${now}" pattern="yyyy" />





</div>
<div id="ft" role="contentinfo">&copy;&nbsp;${year} bzappasodi</div>

</div>


</body>
</html>
