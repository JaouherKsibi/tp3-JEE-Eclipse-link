package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.GestionbdImp;
import model.User;

/**
 * Servlet implementation class Authentification
 */
@WebServlet("/Authentification")
public class Authentification extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Authentification() {
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
		
		
		System.out.println("mrigl 7ad lenna");
		
		
		User u=gdb.getUserByLoginAndPwd(request.getParameter("username"), request.getParameter("password"));
		
		if(u==null)
		{
			System.out.println("user est null ");
			request.getServletContext().getRequestDispatcher("/index.html").forward(request, response);
		}
		if(request.getSession()==null) {
			HttpSession session=request.getSession(true);
			session.setAttribute("user",u);
		}
		
		HttpSession session=request.getSession();
		if(session.getAttribute("user")==null) {
			session.setAttribute("user",u);
		}
		request.setAttribute("prod", gdb.getAllProduit());
		request.setAttribute("categories", gdb.getAllCategories());
		request.getServletContext().getRequestDispatcher("/menu.jsp").forward(request, response);
		
		/*if(u==null)
		{
			System.out.println("user est null ");
			request.getServletContext().getRequestDispatcher("/index.html").forward(request, response);
		}
		else if(u!=null)
		{
			System.out.println("user n est pas null");
			
			if(request.getSession()==null) {
				System.out.println("jaw1");
				HttpSession session=request.getSession(true);
				System.out.println("jaw2");
				session.setAttribute("user",u);
				System.out.println("jaw3");
				request.getServletContext().getRequestDispatcher("/menu.jsp").forward(request, response);
			}
			
			HttpSession session=request.getSession();
			if(session.getAttribute("user")!=null) {
				
				session.setAttribute("user",u);System.out.println("mayjich hakka");
				request.getServletContext().getRequestDispatcher("/menu.jsp").forward(request, response);System.out.println("mayjich hakka");
			}

		}*/
	}

}
