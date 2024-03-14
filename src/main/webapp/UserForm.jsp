<%@page import="com.um.model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User form</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
   
   <nav class="navbar navbar-expand-lg bg-body-tertiary">
  <div class="container-fluid">
    <a class="navbar-brand">User Management System</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="<%= request.getContextPath()%>/list">Users</a>
        </li>
      </ul>
    </div>
   </div>
  </nav>     
  
  
  
  <br/>
  
  
  <c:if test="${edit==null}">
     <form action="insert" method="post"> 
  </c:if>
  
  <c:if test="${edit!=null}">
         <form action="update" method="post"> 
  </c:if>
  

  <c:if test="${edit==null}">
     <h2 align="center">Add User</h2> 
  </c:if>
 
 
 <c:if test="${edit!=null}">
     <h2 align="center">Edit User</h2> 
  </c:if>
  
 
  <center>
  
   <div class="mb-3 container">
  <input type="hidden" class="form-control" id="tbid" name="tbid" value="${edit.id}"  style="width:300px">
 </div>
  
     <div class="mb-3 container">
  <label for="tbname" class="form-label">Name</label>
  <input type="text" class="form-control" id="tbname" name="tbname" value="${edit.name}" placeholder="Enter Your Name" style="width:300px">
 </div>
 
  <div class="mb-3 container">
  <label for="tbemail" class="form-label">Email</label>
  <input type="email" class="form-control" id="tbemail" name="tbemail" value="${edit.email}" placeholder="Enter Your Email" style="width:300px">
 </div>
 
  <div class="mb-3 container">
  <label for="tbcity" class="form-label">City</label>
  <input type="text" class="form-control" id="tbcity" name="tbcity" value="${edit.city}" placeholder="Enter Your City" style="width:300px">
 </div>
 
 
  <div class="mb-3 container">
  <input type="submit" value="Save" class="btn btn-success" style="width:130px"/>
  </div>
  
  
  </center>
</form> 

</body>
</html>