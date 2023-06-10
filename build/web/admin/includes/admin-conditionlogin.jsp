<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${sessionScope.adminLogin == null}">
    <%response.sendRedirect(request.getContextPath()+"/admin/admin-login.jsp");%>
</c:if>
