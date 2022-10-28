<%@ page language ="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transactional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
<!--  Required meta tags  -->
<meta charset="utf-8">
<meta name="viewport"
  content="width=device-width, initial-scale=1, shirink-to-fit=no">
  
  <!--  Bootstarp CSS -->
  <link rel="stylesheet"
  href="http://stackpath.bootstrapdn.com/bootstrap/4.2.1/css/bootstap.min.css"
  integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
  crossorigin="anonymous">
  <title>Student Directory</title>
  </head>
  
  <body>
  
  <div class ="container">
  
  <h3>Students Directory</h3>
  <hr>
  
  <!--  Add a search form -->
  
  <form action="/Lab_5/student/search" class="form-inline">
  <a href ="/Lab_5/student/showFormForAdd"
  class="btn btn-primary btn-sm mb-3">Add Student</a>
  </form>
  
  <table class="table table-bordered table-striped">
  <thead class="thead-dark">
  <tr>
  <th>FirstName</th>
  <th>lastName</th>
  <th>course</th>
  <th>Country</th>
  <th>Action</th>
  
  </tr>
  </thead>
  
  <tbody>
  <c:forEach items="${Student}" var="tempStudent">
  <tr>
  <td><c:out value="${tempStudent.firstName }"/></td>
   <td><c:out value="${tempStudent.lasstName }"/></td>
    <td><c:out value="${tempStudent.course }"/></td>
     <td><c:out value="${tempStudent.country }"/></td>
     <td>
     <!--  Add "update" button/link -->
     <a
     href="/Lab_5/student/showFormForUpdate?studentId=${tempSudent.id }"
      class="btn btn-info btn-sm">Update</a>
      
      <!--  Add "delete" button/link -->
        <a
     href="/Lab_5/student/delete?studentId=${tempSudent.id }"
      class="btn btn-danger btn-sm"
      onclick="if(!(confirm('Are you sure you want to delete this student?')))return false">
      Delete</a>
      </td>
      </tr>
      </c:forEach>
     </tbody>
  </table>
  </div>
  </body>
  </html>