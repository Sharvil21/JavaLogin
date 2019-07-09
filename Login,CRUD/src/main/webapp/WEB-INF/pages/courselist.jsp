<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  <style>
    /* Set height of the grid so .sidenav can be 100% (adjust as needed) */
    .row.content {height: 550px}
    
    /* Set gray background color and 100% height */
    .sidenav {
      background-color: #f1f1f1;
      height: 100%;
    }
        
    /* On small screens, set height to 'auto' for the grid */
    @media screen and (max-width: 767px) {
      .row.content {height: auto;} 
    }
  </style>
  </head>
<body>
<nav class="navbar navbar-inverse visible-xs">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="#">Logo</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="#"></a></li>
        <li><a href="#"></a></li>
        <li><a href="#"></a></li>
        <li><a href="#"></a></li>
      </ul>
    </div>
  </div>
</nav>

<div class="container-fluid">
  <div class="row content">
    <div class="col-sm-3 sidenav hidden-xs">
      <h2>Dashboard</h2>
      <ul class="nav nav-pills nav-stacked">
      <li><a href="login">Main Page</a></li>
        <li class="active"><a href="#">Courses</a></li>
      </ul><br>
    </div>
    <br>
    
    <div class="col-sm-9">
      <div class="well">
<div align="center">
		<h3>List of Registered Courses</h3>
        
        <table border="1">
 	<tr>
            <th>Course Name</th>
 </tr>
         <c:forEach var="course" items="${listCourses}">
                <tr>
 
                    <td>${course.course_name}</td>
                    <%-- <td><a href="editCourse?id=${course.id}">Edit</a>
                             <a
                        href="deleteCourse?id=${course.id}">Delete</a></td> --%>
 
                </tr>
            </c:forEach>
        </table>
        <div align="right"><a href="/hb.smvc">Log Out</a></div>
       <!--  <h4>
            <a href="newCourse">Register for a New Course</a>
        </h4> -->
        
    </div>
      </div>
      </div>
      </div>
      </div>

<%-- <nav class="navbar navbar-dark bg-dark">
  <!-- Navbar content -->
<h5 style="color:white;">Welcome! ${WelcomeMessage}</h5>
<h5><a href="/hb.smvc">Log Out</a></h5>

<span style="color:white;">You have Been Logged In</span>
</nav>
 --%>

</body>
</html>