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
 * Servlet implementation class AddProduit
 */
@WebServlet("/AddProduit")
public class AddProduit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProduit() {
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
		/*System.out.println(gdb.getCategoryById(Integer.parseInt(request.getParameter("categorie_produit"))));*/
		Produit p=new Produit(1 , request.getParameter("nom") , request.getParameter("url_image_produit") , Float.parseFloat(request.getParameter("prix_produit")) ,
				gdb.getCategoryById(Integer.parseInt(request.getParameter("categorie_produit"))));
		System.out.println(p);
		gdb.addProduit(p);
		request.setAttribute("home",1);
		request.setAttribute("categories", gdb.getAllCategories());
		request.getServletContext().getRequestDispatcher("/menu.jsp").forward(request, response);
	}

}
