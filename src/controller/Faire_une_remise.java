package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GestionbdImp;

/**
 * Servlet implementation class Faire_une_remise
 */
@WebServlet("/Faire_une_remise")
public class Faire_une_remise extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Faire_une_remise() {
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
		GestionbdImp g=new GestionbdImp();
		g.addremise(g.getProduitById(Integer.parseInt(request.getParameter("id_prod"))),Float.parseFloat(request.getParameter("remise")));
		request.setAttribute("home",1);
		request.getServletContext().getRequestDispatcher("/menu.jsp").forward(request, response);
	}

}
