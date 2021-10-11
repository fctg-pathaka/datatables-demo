<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<div class="container-fluid">
    <jsp:include page="shared/nav.jsp"/>
    <br/>
    <main>
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
        <form:form method="POST" action="/datatables/datatables-demo-form"
                   modelAttribute="datatables-form" enctype="multipart/form-data">
            <form:input type="hidden" class="form-control" id="id" path="id"/>
            <spring:bind path="name">
                <div class="form-group row ${status.error ? 'has-error' : ''}">
                    <label for="name" class="col-sm-2 col-form-label">Name&nbsp;&nbsp;:</label>
                    <div class="col-sm-10">
                        <form:input type="text" class="form-control" id="name" placeholder="Example Name"
                                    path="name" requred="true"/>
                        <form:errors path="name" class="errors text-danger"/>
                    </div>
                </div>
            </spring:bind>
            <spring:bind path="description">
                <div class="form-group row ${status.error ? 'has-error' : ''}">
                    <label for="description" class="col-sm-2 col-form-label">Description&nbsp;&nbsp;:</label>
                    <div class="col-sm-10">
                        <form:input type="text" class="form-control" id="description" placeholder="Description"
                                    path="description" requred="true"/>
                        <form:errors path="description" class="errors text-danger"/>
                    </div>
                </div>
            </spring:bind>
            <div class="action-buttons">
                <button type="submit" class="btn btn-outline-success">Save</button>&nbsp;&nbsp;&nbsp;
                <button type="reset" class="btn btn-outline-secondary">Clear</button>
            </div>
        </form:form>
    </main>
</div>

</body>
</html>