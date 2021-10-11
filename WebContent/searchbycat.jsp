<%@page import="model.User"%>
<%@page import="model.Categorie"%>
<%@page import="java.util.List"%>
<%@page import="dao.GestionbdImp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="./bootstrap.css">
<link rel="stylesheet" type="text/css" href="./bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="./bootstrap-grid.css">
<link rel="stylesheet" type="text/css" href="./bootstrap-grid.min.css">
<link rel="stylesheet" type="text/css" href="./bootstrap-reboot.css">
<link rel="stylesheet" type="text/css" href="./bootstrap-reboot.min.css">
<link rel="stylesheet" type="text/css" href="./bootstrap-utilities.css">
<link rel="stylesheet" type="text/css" href="./bootstrap-utilities.min.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%GestionbdImp g=new GestionbdImp();
List<Categorie> l=g.getAllCategories();
request.setAttribute("categories",l);%>
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Ksibi ECommerce</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="./menu.jsp?">Home</a></li><!-- ici on a tous les produits de toutes les categories  -->
      <li><a href="#">search by category</a></li>
      <li><a href="./searchbynom.jsp">search by name produit</a></li>
      <li><a href="#"> ${user.role} </a></li> 
      
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
<%
User u=(User)session.getAttribute("user");

request.setAttribute("role","admin");%>

<c:if  test="${user.role.equals(role)}">
<h2>Ajouter un produit</h2>
<form action="AddProduit" method="post">
 <table>
 <tr><td><label for="nom">nom Produit</label></td><td><input type="text" name="nom" id="nom"></td></tr>
 <tr><td><label for="url_image_produit">url_image_produit</label></td><td><input type="text" name="url_image_produit" id="url_image_produit"></td></tr>
 <tr><td><label for="prix_produit">prix_produit</label></td><td><input type="number" name="prix_produit" id="prix_produit"></td></tr>
 <tr><td><label for="categorie_produit">categorie</label></td> 
 <td><select name="categorie_produit">
 <c:if test="${categories!=null}">
 	<c:forEach var="cat" items="${categories}">
 	<option value="${cat.id_categorie}">
 		${cat.nom}
 		</option >
 	</c:forEach>
 </c:if>
 </select></td></tr>
 <tr><td><input type="submit" value="ajouter"></td></tr>
 </table>
 
 </form>

</c:if>
<c:if test="${user.role.equals(role)}">
<h2>Ajouter une categorie</h2>
<form action="AddCategorie" method="post">
 <table>
 <tr><td><label for="nom">nom Categorie</label></td><td><input type="text" name="nom" id="nom"></td></tr>
 <tr><td><input type="submit" value="ajouter"></td></tr>
 </table>
 
 </form>

</c:if>
<div>
<h2>Tous les produits</h2>
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