package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GestionbdImp;
import model.Categorie;
import model.Produit;

/**
 * Servlet implementation class addCategorie
 */
@WebServlet("/AddCategorie")
public class AddCategorie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCategorie() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GestionbdImp gdb=new GestionbdImp();
		Categorie p=new Categorie(1 , request.getParameter("nom"));
		System.out.println(p);
		gdb.addCategorie(p);
		
		request.setAttribute("categories", gdb.getAllCategories());
		request.getServletContext().getRequestDispatcher("/menu.jsp").forward(request, response);
	
	}

}
