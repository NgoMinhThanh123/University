<%-- 
    Document   : header
    Created on : Jul 22, 2023, 1:08:26 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/" var="action" />
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">OU University Website</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="collapsibleNavbar">
            <ul class="navbar-nav me-auto">
                <li class="nav-item">
                    <a class="nav-link" href="${action}">Trang chủ</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="/faculty" />">Khoa</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="/major" />"> Chuyên ngành</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${action}">Nhân viên</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${action}">Giảng viên</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${action}">Sinh viên</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="/user" />">Tài Khoản</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${action}">Lớp học</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${action}#">Môn học</a>
                </li>                        
            </ul>                   
        </div>
    </div>
</nav>
