
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:url value="/major" var="action" />       
<section class="container">
    <h1 class="text-center text-success mt-1">DANH SÁCH CHUYÊN NGÀNH</h1>

    <div class="d-flex justify-content-between">
        <div>
            <a href="<c:url value="/add_major"/>" class="btn btn-info mt-1">Thêm Chuyên ngành</a>
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
                <th>Tên chuyên ngành</th>
                <th>Khoa</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${major}" var="l">
                <tr>   
                    <td>${l.id}</td>
                    <td>${l.name}</td>
                    <td>${l.facultyId.name}</td>
                    <td>
                        <a href="<c:url value="/add_major/${l.id}" />" class="btn btn-info">Cập nhật</a>
                        <button class="btn btn-danger">Xóa</button>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</section>