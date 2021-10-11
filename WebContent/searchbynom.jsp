<%@page import="model.Categorie"%>
<%@page import="java.util.List"%>
<%@page import="dao.GestionbdImp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="model.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="./bootstrap.css">
<link rel="stylesheet" type="text/css" href="./bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="./bootstrap-grid.css">
<link rel="stylesheet" type="text/css" href="./bootstrap-grid.min.css">
<link rel="stylesheet" type="text/css" href="./bootstrap-reboot.css">
<link rel="stylesheet" type="text/css" href="./bootstrap-reboot.min.css">
<link rel="stylesheet" type="text/css" href="./bootstrap-utilities.css">
<link rel="stylesheet" type="text/css" href="./bootstrap-utilities.min.css">
<title>search by name</title>
</head>
<%GestionbdImp g=new GestionbdImp();
List<Categorie> l=g.getAllCategories();
request.setAttribute("categories",l);%>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Ksibi ECommerce</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="./menu.jsp">Home</a></li><!-- ici on a tous les produits de toutes les categories  -->
      <li><a href="./searchbycat.jsp">search by category</a></li>
      <li><a href="#">search by name produit</a></li>
       <li><a href="#">${user.role}</a></li> 
      
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><span class="glyphicon glyphicon-log-in"></span> <form method="post" action="Logout">
 	<input type="submit" value="logout">
 	
 </form></li>
    </ul>
  </div>
</nav>
<div class="container-fluid">
<div class="row">
<ul class="nav nav-pills nav-stacked col-lg-4 col-md-4 " role="tablist">
    <li class="active"><a href="./menu.jsp?home=1">All</a></li>
    <c:forEach var="cat" items="${categories }">
    	<li class="active"><a href="CategorieServlet?id_categorie=${cat.id_categorie }"><c:out value="${cat.nom}"></c:out></a></li>
    </c:forEach>   
  </ul>


<div class="col-lg-8 col-md-8 col-sm-8">



<div>
<h2>Produits </h2>

<form action="SearchByNameServlet" method="post">
<input type="text" name="name">
<input type="submit" value="Search">
</form>
<table style="border-collapse: collapse">
<tr>
 <th>Id produit</th><th>nom</th><th>url</th><th>categorie</th><th>prix</th><th>remise</th><th>quantite</th></tr>
 <c:forEach var="mat" items="${prod}">
 	<tr style="border: 1px solid black">
				<td style="border: 1px solid black">${mat.id_produit}<br/></td>
				<td style="border: 1px solid black">${mat.nom_produit}<br/></td>
				<td style="border: 1px solid black">${mat.url_image_produit}<br/></td>
				<td style="border: 1px solid black">${mat.categorie_produit.nom}<br/></td>
				<td style="border: 1px solid black">${mat.prix_produit}<br/></td>
				<td style="border: 1px solid black">${mat.remise}<br/></td>
				<td style="border: 1px solid black">${mat.quantite}<br/></td>
			</tr>
 		
 	</c:forEach>
</table>
</div>
</div>
</div>
</div>
</body>
</html>