<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<div class="container-fluid">
    <jsp:include page="shared/nav.jsp"/>
    <br/>
    <main>

        <div class="header-component">
            <p class="h4">Datatables Management</p>
            <p class="text-primary h6">
                <a href="/datatables/datatables-demo-form"><i class="fa fa-plus-circle fa-fw "></i> New Datatable Entry</a>
            </p>
        </div>
        <hr/>
        <c:if test="${error!=null}">
            <div class="alert alert-danger text-center" role="alert">
                <span>${error}</span>
            </div>
        </c:if>
        <c:if test="${message!=null}">
            <div class="alert alert-primary text-center" role="alert">
                <span>${message}</span>
            </div>
        </c:if>
        <table id="slider" class="table table-striped table-bordered table-hover" style="width:100%">
            <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Description</th>
                <th>Delete</th>
                <th>Update</th>
            </tr>
            </thead>
        </table>
    </main>
    <script src="${contextPath}/resources/js/datatables-demo.js"></script>
</div>
<jsp:include page="shared/footer.jsp"/>
</body>
</html>