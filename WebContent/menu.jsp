
<%@page import="model.Categorie"%>
<%@page import="java.util.List"%>
<%@page import="dao.GestionbdImp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="model.User"%>
<!DOCTYPE html>
<html>
<%
GestionbdImp g=new GestionbdImp();
User u=(User)session.getAttribute("user");
session.setAttribute("user", g.getUserById(u.getId()));

request.setAttribute("role","admin");%><!-- GestionbdImp g=new GestionbdImp(); -->
<%
List<Categorie> l=g.getAllCategories();
request.setAttribute("categories",l);
if((request.getParameter("home")!=null)||(request.getAttribute("home")!=null)){
	request.setAttribute("prod", g.getAllProduit());
}
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
<title>Insert title here</title>
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
      <c:if test="${user.role.equals(role)}"><li> <a>admin</a> </li></c:if>
    </ul>
    <ul class="nav navbar-nav navbar-right">
    <li><a href="./monpannier.jsp">Mon Pannier ${user.pan.nb_prod }</a></li>
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


<c:if  test="${user.role.equals(role)}">
<div style="border:1px solid black">
<h2>Ajouter un produit</h2>
<hr>

<!-- ---*************************************************************************************************** -->
<form class="needs-validation" action="AddProduit" method="post" novalidate>
  <div class="form-row">
    <div class="col-md-4 mb-3">
      <label for="validationTooltip01">Nom Produit</label>
      <input type="text" class="form-control" id="validationTooltip01"   name="nom" required>
      
    </div>
    <div class="col-md-4 mb-3">
      <label for="validationTooltip02">Image Du Produit</label>
      <input type="file" class="form-control" name="url_image_produit" name="url_image_produit" id="validationTooltip02" required>
      
    </div>
    <div class="col-md-4 mb-3">
      <label for="validationTooltip01">Prix Produit</label>
      <input type="number" class="form-control" id="validationTooltip01"   name="prix_produit" required>
      
    </div>
    </div>
    <div class="form-row">
    <div class="col-md-4 mb-3">
      <label for="validationTooltip01">Categorie Produit</label>
      <select id="validationTooltip01" name="categorie_produit" required="required" class="form-control">
		 <c:if test="${categories!=null}">
		 	<c:forEach var="cat" items="${categories}">
		 	<option value="${cat.id_categorie}">
		 		${cat.nom}
		 		</option >
		 	</c:forEach>
		 </c:if>
		</select>
    </div>
    <button class="btn btn-primary" type="submit" style="margin-top: 20px;margin-left : 10px">Submit form</button>

  </div>
  </form>
  <br>
  </div>
</c:if>


<!-- ---*************************************************************************************************** -->
 <!-- 
<form action="AddProduit" method="post">
 <table>
 tr><td><label for="nom">nom Produit</label></td><td><input type="text" name="nom" id="nom"></td></tr>
 <tr><td><label for="url_image_produit">url_image_produit</label></td><td><input type="file" name="url_image_produit" id="url_image_produit"></td></tr>
 <tr><td><label for="prix_produit">prix_produit</label></td><td><input type="number" name="prix_produit" id="prix_produit"></td></tr>
 <tr></tr>
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
-->

<c:if test="${user.role.equals(role)}">
<div  style="border:1px solid black;margin-top: 25px;">
<h2>Ajouter une categorie</h2>
<hr>
<form action="AddCategorie" method="post"class="needs-validation" novalidate>
 <label for="validationTooltip01">nom Categorie</label>
 <input type="text" name="nom" id="validationTooltip01" class="form-control">
 <input type="submit" class="btn btn-primary" style="margin-top: 20px;margin-left : 10px" value="ajouter">
 
 </form>
</div>
</c:if>
<c:if test="${user.role.equals(role)}">
<div class="row" style="border:1px solid black;margin-top: 20px">
<h2>Modifier produit </h2>
<hr>
<div  style="border:1px solid black;padding: 25px;margin:25px">
<h3>ajouter une quantité</h3>
<hr>
<form action="Ajouterdesproduits" method="post">
<label for="id_prod">id produit</label><input type="number" id="id_prod" name="id_prod" >
<label for="quantite">quantite à ajouter </label><input type="number" name="quantite" >
<input type="submit" value="update">
</form> 
</div>
<div style="border:1px solid black;padding: 25px;margin:25px">
<h3>Faire une remise</h3>
<form action="Faire_une_remise" method="post">
<label for="id_prod">id produit</label><input type="number" id="id_prod" name="id_prod" >
<label for="remise">Pourcentage remise</label><input type="text" id="remise" name="remise" >
<input type="submit" value="update">
</form> </div>
</div>
</c:if>
<div>
<h2>Tous les produits</h2>
<div class="row">
<c:forEach var="mat" items="${prod}">
<div class="col-lg-4 col-md-6 col-12" style="background-image:url(${mat.url_image_produit})">
    <div class="single-banner">
        <img alt="" src="${mat.url_image_produit}">
        <div class="content" style="background-image:url(${mat.url_image_produit})">
            <p>id:${mat.id_produit}</p>
            <h3>nom produit:${mat.nom_produit} <br> categorie:${mat.categorie_produit.nom}</h3>
            <h3>Remise:${mat.remise}</h3>
            <h3>quantite restante:${mat.quantite}</h3>
            <c:choose>
				<c:when test="${mat.quantite==0}">epuisé</c:when>
				<c:when test="${mat.remise!=0}">remise</c:when>
				<c:otherwise>en stock</c:otherwise>
            </c:choose>
            <c:if test="${mat.quantite>0}">
                <div>
				<form action="AddToPannier" method="post">
				 <select name="qtcmd"><c:forEach var="i" begin="1" end="${mat.quantite}"><option value="${i}">${i}</option></c:forEach> </select>
				 <input type="hidden" value="${mat.id_produit}" name="prod1">
				<input type="hidden" value="${user.id }" name="user1">
 				<input type="submit" value="ajouter"> <!--<td style="border: 1px solid black"><a href="AddToPannier?user1=${user.id }&prod1=${mat.id_produit}&qtcmd=${i}">ajouter au panier${qtcm}</a>-->
				
				</form></div>
			</c:if>
        </div>
    </div>
</div>
</c:forEach>
</div>
 <!--table style="border-collapse: collapse">
 
<tr>
 <th>Id produit</th><th>nom</th><th>url</th><th>categorie</th><th>prix</th><th>remise</th><th>quantite</th> <th>etat</th><th>add</th> <th>quantite commande</tr>
 <c:forEach var="mat" items="${prod}">
 	<tr style="border: 1px solid black">
				<td style="border: 1px solid black">${mat.id_produit}<br/></td>
				<td style="border: 1px solid black">${mat.nom_produit}<br/></td>
				<td style="border: 1px solid black">${mat.url_image_produit}<br/></td>
				<td style="border: 1px solid black">${mat.categorie_produit.nom}<br/></td>
				<td style="border: 1px solid black">${mat.prix_produit}<br/></td>
				<td style="border: 1px solid black">${mat.remise}<br/></td>
				<td style="border: 1px solid black">${mat.quantite}<br/></td>
				<td style="border: 1px solid black"><c:choose>
				<c:when test="${mat.quantite==0}">epuisé</c:when>
				<c:when test="${mat.remise!=0}">remise</c:when>
				<c:otherwise>en stock</c:otherwise>
				</c:choose></td>
				<!--  <c:if test="${mat.quantite>0}"><td style="border: 1px solid black"><a href="AddToPannier?user1=${user.id }&prod1=${mat.id_produit}">ajouter au panier</a></td></c:if>
				<c:if test="${mat.quantite>0}">
				<form action="AddToPannier" method="post">
				 <td><select name="qtcmd"><c:forEach var="i" begin="1" end="${mat.quantite}"><option value="${i}">${i}</option></c:forEach> </select></td>
				 <input type="hidden" value="${mat.id_produit}" name="prod1">
				<input type="hidden" value="${user.id }" name="user1">
 				<td><input type="submit" value="ajouter"></td> <!--<td style="border: 1px solid black"><a href="AddToPannier?user1=${user.id }&prod1=${mat.id_produit}&qtcmd=${i}">ajouter au panier${qtcm}</a>
				
				</form>
				</c:if>
				
			</tr>
 		
 	</c:forEach>
</table>-->
</div>
</div>
</div>
</div>
</body>
</html>