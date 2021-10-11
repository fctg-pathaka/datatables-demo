<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<div class="container-fluid">
    <jsp:include page="/WEB-INF/jsp/shared/nav.jsp"/>
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
        <br/><br/><br/><br/>
        <div class="row" style="justify-content: center;">
            <div class="col-xs-4 col-sm-4 col-md-4">
                <a href="${contextPath}/datatables" style="text-decoration: none;">
                    <div class="card text-center home-service-card">
                        <div class="card-header home-service-card-text">Datatables</div>
                    </div>
                </a>
            </div>

        </div>


    </main>
</div>
<jsp:include page="/WEB-INF/jsp/shared/footer.jsp"/>
</body>
</html>