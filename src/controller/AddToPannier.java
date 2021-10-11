package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GestionbdImp;
import model.LignePannier;
import model.Pannier;
import model.Produit;
import model.User;

/**
 * Servlet implementation class AddToPannier
 */
@WebServlet("/AddToPannier")
public class AddToPannier extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToPannier() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GestionbdImp g=new GestionbdImp();
		User u=g.getUserById(Integer.parseInt(request.getParameter("user1")));
		Produit p=g.getProduitById(Integer.parseInt(request.getParameter("prod1")));
		//int id_ligne=g.getDerniereLigne();
		LignePannier l=new LignePannier(p,u.getPan());
		g.addLignePannier(l);
		/*g.addquantite(p, p.getQuantite()-1);*/
		/*g.decrementerQuantiteProduit(p);*/
		g.remplirPannier(u.getPan(), p.getPrix_produit());
		g.changerquantite(p, p.getQuantite()-1);
		request.setAttribute("home", 1);
		request.getServletContext().getRequestDispatcher("/menu.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GestionbdImp g=new GestionbdImp();
		User u=g.getUserById(Integer.parseInt(request.getParameter("user1")));
		Produit p=g.getProduitById(Integer.parseInt(request.getParameter("prod1")));
		//int id_ligne=g.getDerniereLigne();
		LignePannier l=new LignePannier(p,u.getPan());
		l.setQte(Integer.parseInt(request.getParameter("qtcmd")));
		l.setPrixtot(l.getQte()*p.getPrix_produit());
		g.addLignePannier(l);
		/*g.addquantite(p, p.getQuantite()-1);*/
		/*g.decrementerQuantiteProduit(p);*/
		g.remplirPannier(u.getPan(), l.getPrixtot());/***/
		g.changerquantite(p, p.getQuantite()-l.getQte());
		request.setAttribute("home", 1);
		request.getServletContext().getRequestDispatcher("/menu.jsp").forward(request, response);
		
	}

}
