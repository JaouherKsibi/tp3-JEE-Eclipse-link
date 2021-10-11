<%@page import="model.Produit"%>
<%@page import="model.Categorie"%>
<%@page import="java.util.List"%>
<%@page import="dao.GestionbdImp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="model.User"%>
<!DOCTYPE html>
<html>
<%
GestionbdImp g=new GestionbdImp();
User u=(User)session.getAttribute("user");
session.setAttribute("user", g.getUserById(u.getId()));
System.out.println(u);
request.setAttribute("prod",g.getAllLigneByIdPannier(u.getPan().getId_pannier())) ;

request.setAttribute("role","admin");%><!-- GestionbdImp g=new GestionbdImp(); -->
<%
List<Categorie> l=g.getAllCategories();
request.setAttribute("categories",l);


%>
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
<title>Pannier de ${user.nom} ${user.prenom }</title>
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Ksibi ECommerce</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">Home</a></li><!-- ici on a tous les produits de toutes les categories  -->
      <li><a href="./searchbycat.jsp">search by category</a></li>
      <li><a href="./searchbynom.jsp">search by name produit</a></li>
      <li><a >${user.nom}</a></li>
      <c:if test="${user.role.equals(role)}"><li> <a>admin</a> </li></c:if>
    </ul>
    <ul class="nav navbar-nav navbar-right">
    <li><a>Mon Pannier ${user.pan.nb_prod }</a></li>
    	<li><a>${user.nom } ${user.prenom}</a></li>
      <li>
      <a href="./Logout">Logout</a></li>
      
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
<h2>Mes produits</h2>
<table class="table table-hover">
  <thead>
    <tr>
      <th scope="col">Id produit</th>
      <th scope="col">nom</th>
      <th scope="col">categorie</th>
      <th scope="col">prix unitaire </th>
      <th scope="col">quantite commande</th>
      <th scope="col">prix tot</th>
      <th scope="col">#</th>
      <th scope="col">#</th>
    </tr>
  </thead>
  <tbody>
    
    <c:forEach var="mat" items="${prod}">
    <tr>
      <th scope="row">${mat.produit.id_produit}</th>
      <td>${mat.produit.nom_produit}</td>
      <td>${mat.produit.categorie_produit.nom}</td>
      <td>${mat.produit.prix_produit}</td>
      <td>${mat.qte}</td>
      <td>${mat.produit.prix_produit*mat.qte}</td>
      <td><a href="SuprimerLigne?id_ligne=${mat.id_ligne }">payer</a> </td>
      <td><a href="SuprimerLigne?id_ligne=${mat.id_ligne }">suprimer</a> </td>
    </tr>
    </c:forEach>
  </tbody>
</table>
<h1>Total: <c:out value=" ${user.pan.somme}"></c:out></h1>
</div>
</div>
</div>
</div>
</body>
</html>