<%-- 
    Document   : index
    Created on : Jul 8, 2023, 3:08:58 PM
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:url value="/" var="action" />       
<section class="container">
    <h1 class="text-center text-success mt-1">DANH SÁCH GIẢNG VIÊN</h1>

    <div class="d-flex justify-content-between">
        <div>
            <a href="#" class="btn btn-info mt-1">Thêm Giảng viên</a>
        </div>
        <div>
            <form class="d-flex" action="${action}">
                <input class="form-control me-2" name="kw" type="text" placeholder="Nhập từ khóa...">
                <button class="btn btn-primary" type="submit">Tìm</button>
            </form>
        </div>
    </div>

    <c:if test="${pages > 1}">
        <ul class="pagination mt-1">
            <li class="page-item"><a class="page-link" href="${action}">Tất cả</a></li>
                <c:forEach begin="1" end="${pages}" var="i">
                    <c:url value="/" var="pageUrl">
                        <c:param name="page" value="${i}" /> 
                    </c:url>
                <li class="page-item"><a class="page-link" href="${pageUrl}">${i}</a></li>
                </c:forEach>
            <li class="page-item">
                <form action="${action}" id="pageNumber">
                    <input type="number" min="1" max="${pages}" name="page" onchange="document.getElementById('pageNumber').submit()" />
                </form>
            </li>
        </ul>

    </c:if>

    <table class="table table-hover">
        <thead>
            <tr>
                <th>Id</th>
                <th>Tên giảng viên</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${lecturers}" var="l">
                <tr>   
                    <td>${l.id}</td>
                    <td>${l.name}</td>
                    <td>
                        <a href="#" class="btn btn-info">Cập nhật</a>
                        <button class="btn btn-danger">Xóa</button>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</section>