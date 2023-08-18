
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:url value="/faculty" var="action" />       
<section class="container">
    <h1 class="text-center text-success mt-1">DANH SÁCH KHOA</h1>

    <div class="d-flex justify-content-between">
        <div>
            <a href="<c:url value="/add_faculty"/>" class="btn btn-info mt-1">Thêm Khoa</a>
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
                <th>Id</th>
                <th>Tên khoa</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${faculty}" var="l">
                <tr>   
                    <td>${l.id}</td>
                    <td>${l.name}</td>
                    <td>
                        <c:url value="/update_faculty/${l.id}" var="api" />
                        <a href="${api}" class="btn btn-info">Cập nhật</a>
                        <button class="btn btn-danger" onclick="deleteFaculty('${api}')">Xóa</button>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</section>
<script src="<c:url value="/js/main.js" />"></script>