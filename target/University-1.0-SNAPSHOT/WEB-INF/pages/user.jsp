
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:url value="/user" var="action" />       
<section class="container">
    <h1 class="text-center text-success mt-1">DANH SÁCH TÀI KHOẢN</h1>

    <div class="d-flex justify-content-between">
        <div>
            <a href="<c:url value="/add_user" />" class="btn btn-info mt-1">Thêm tài khoản</a>
        </div>
        <div>
            <form class="d-flex" action="${action}">
                <input class="form-control me-2" name="kw" type="text" placeholder="Nhập từ khóa...">
                <button class="btn btn-primary" type="submit">Tìm</button>
            </form>
        </div>
    </div>


    <table class="table table-hover">
        <thead>
            <tr>
                <th>ID</th>
                <th></th>
                <th>Email</th>
                <th>Chức vụ</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${user}" var="l">
                <tr>
                    <th>${l.id}</th>
                    <td>
                        <img src="${l.avatar}" width="100" />
                    </td>
                    <td>${l.email}</td>
                    <td>
                        <c:choose>
                            <c:when test="${l.role eq 'ROLE_GIAOVU'}">
                                Giáo vụ
                            </c:when>
                            <c:when test="${l.role eq 'ROLE_GIANGVIEN'}">
                                Giảng viên
                            </c:when>
                            <c:otherwise>
                                Sinh viên
                            </c:otherwise>
                        </c:choose>
                    </td>                 
                    <td>
                        <c:url value="/add_user/${l.id}" var="api" />
                        <a href="${api}" class="btn btn-info">Cập nhật</a>
                        <button class="btn btn-danger" onclick="deleteUser('${api}')">Xóa</button>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</section>
<script src="<c:url value="/js/main.js" />"></script>