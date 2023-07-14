<%-- 
    Document   : index
    Created on : Jul 7, 2023, 1:08:19 PM
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Trang chủ</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    </head>
    <body>
        <h1>Hello World!</h1>

        <nav>
            <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
                <div class="container-fluid">
                    <a class="navbar-brand" href="#">Logo</a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="collapsibleNavbar">
                        <ul class="navbar-nav  me-auto">
                            <c:forEach items="${categories}" var="cates">
                                <c:url value="/" var="search">
                                    <c:param name="cateId" value="${cates.id}" ></c:param>
                                </c:url>
                                <li class="nav-item">
                                    <a class="nav-link" href="${search}">${cates.name}</a>
                                </li>
                            </c:forEach>
                        </ul>
                        <c:url value="/" var="action" />
                        <form class="d-flex" action="${action}">
                            <input class="form-control me-2" type="text" name="kw" placeholder="Search">
                            <button class="btn btn-primary" type="submit">Search</button>
                        </form>
                    </div>
                </div>
            </nav>
        </nav>

        <div class="container">
            <table class="table table-striped">
                <a href="#" class="btn btn-info">Thêm sản phẩm</a>
                <ul class="pagination">
                    <li class="page-item"><a class="page-link" href="#"></a></li>
                </ul>
                <thead>
                    <tr>
                        <th></th>
                        <th>Id</th>
                        <th>Tên sản phẩm</th>
                        <th>Giá</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${products}" var="p">
                        <tr>
                            <td>
                                <img src="${p.image}" alt="${p.name}" width="120"/>
                            </td>
                            <td>${p.id}</td>
                            <td>${p.name}</td>
                            <td>${p.price}</td>
                            <td>
                                <a href="#" class="btn btn-success">Cập nhật</a>                                
                                <a href="#" class="btn btn-danger">Xóa</a>
                            </td>
                        </tr>
                    </c:forEach>

                </tbody>
            </table>
        </div>

    </body>
</html>
