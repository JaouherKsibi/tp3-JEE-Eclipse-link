package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Categorie;
import model.LignePannier;
import model.Pannier;
import model.Produit;
import model.User;

public class GestionbdImp implements Gestionbd{
	public EntityManager em;

	public GestionbdImp() {
		EntityManagerFactory factory =Persistence.createEntityManagerFactory("test33");
		em = factory.createEntityManager();
	}
	public User getUserById(int id)
	{
		return em.find(User.class, id);
	}
	public User getUserByLoginAndPwd(String login,String pwd)
	{
		User u=null;
		
		Query q = em.createNativeQuery("select * from User where adresse_email=? and mdp=?", User.class);
		q.setParameter(1,login);
		q.setParameter(2, pwd);
		try {
			u=(User)q.getSingleResult();
		}
		catch (Exception e){
			return null;
		}
		
		return u;
	}
	public void addUser(User e)
	{
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
	}
	public void deleteUser(int e)
	{
		em.getTransaction().begin();
		User u = em.find(User.class, e);
		em.remove(u);
		em.getTransaction().commit();
	}
	public void setUserName(int id,String name)
	{
		em.getTransaction().begin();
		User e1 = em.find(User.class, id);
		e1.setNom(name);
		em.merge(e1);
		em.getTransaction().commit();
	}
	public List<Categorie> getAllCategories(){
		Query q = em.createNativeQuery("select * from Categorie ", Categorie.class);
		/*Query q = em.createQuery("SELECT e FROM Categorie e");*/
		List<Categorie> le=q.getResultList();
		return le;
	}
	public void addProduit(Produit p)
	{
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
	}
	public Categorie getCategoryById(int id)
	{
		
		Categorie u=em.find(Categorie.class, id);/*
		Query q = em.createNativeQuery("select * from Categorie where id_catgorie= ? ", Categorie.class);
		q.setParameter(1,id);*/
		/*try {
			u=(Categorie)q.getSingleResult();
		}
		catch (Exception e){
			return null;
		}*/
		
		return u;
	}
	public void addCategorie(Categorie c) {
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
	}
	public List<Produit> getAllProduit()
	{
		Query q = em.createNativeQuery("select * from Produit ", Produit.class);
		List<Produit> le=q.getResultList();
		return le;
	}
	public List<Produit> getAllProduitByIdCategorie(int id)
	{
		Query q = em.createNativeQuery("select * from Produit where id_categorie=?", Produit.class);
		q.setParameter(1,id);
		/*Query q = em.createQuery("SELECT e FROM Categorie e");*/
		List<Produit> le=q.getResultList();				
		return le;
				
	}
	public List<Produit> getAllProduitByName(String name)
	{
		Query q = em.createNativeQuery("select * from Produit where nom_produit like ?", Produit.class);
		q.setParameter(1,"%"+name+"%");
		/*Query q = em.createQuery("SELECT e FROM Categorie e");*/
		List<Produit> le=q.getResultList();				
		return le;
	}
	public Produit getProduitById(int id) {
		return em.find(Produit.class, id);/*****************************************/
		
		 
	}
	public void addquantite(Produit p,int q)
	{
		em.getTransaction().begin();
		Produit p1 = em.find(Produit.class, p.getId_produit());
		p1.setQuantite(q);
		em.merge(p1);
		em.getTransaction().commit();
	}
	public void addremise(Produit produitById, float parseInt) {
		em.getTransaction().begin();
		Produit p1 = em.find(Produit.class, produitById.getId_produit());
		p1.setRemise(parseInt);
		em.merge(p1);
		em.getTransaction().commit();
	}
	public void addPannier(Pannier p)
	{
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
	}
	public int getDernierPannier()
	{
		Query q = em.createNativeQuery("select max(id_categorie) from Pannier ", Pannier.class);
		int le=q.getFirstResult();				
		return le;

	}
	public void remplirPannier(Pannier p,float prix) {
		em.getTransaction().begin();
		Pannier p1 = em.find(Pannier.class, p.getId_pannier());
		p1.setNb_prod(p1.getNb_prod()+1);
		p1.setSomme(p1.getSomme()+prix);
		em.merge(p1);
		em.getTransaction().commit();
	}
	public List<LignePannier> getAllListePannier(){
		Query q = em.createNativeQuery("select * from LignePannier ", LignePannier.class);
		List<LignePannier> le=q.getResultList();
		return le;
	}
	public int getDerniereLigne()
	{
		
		int le=1;
		for (LignePannier i: this.getAllListePannier()) {
			if(i.getId_ligne()>le) {
				le=i.getId_ligne();
			}
		} 				
		return le;
	}
	public void addLignePannier(LignePannier l) {
		em.getTransaction().begin();
		em.persist(l);
		em.getTransaction().commit();
	}
	public void decrementerQuantiteProduit(Produit p) {
		em.getTransaction().begin();
		Produit p1 = em.find(Produit.class, p.getId_produit());
		p1.setQuantite(p.getQuantite()-1);
		em.merge(p1);
		em.getTransaction().commit();
		
	}
	public void changerquantite(Produit p,int qt) {
		Produit p1 = em.find(Produit.class, p.getId_produit());
		p1.setQuantite(qt);
		em.getTransaction().begin();
		em.merge(p1);
		em.getTransaction().commit();
	}
	public List<LignePannier> getAllLigneByIdPannier(int id)
	{
		Query q = em.createNativeQuery("select * from LignePannier where id_pannier=? ", LignePannier.class);
		q.setParameter(1,id);
		List<LignePannier> le=q.getResultList();
		return le;
	}
	public void decrimenter_pannier(Pannier p,float prix) {
		em.getTransaction().begin();
		Pannier p1 = em.find(Pannier.class, p.getId_pannier());
		p1.setNb_prod(p1.getNb_prod()-1);
		p1.setSomme(p1.getSomme()-prix);
		em.merge(p1);
		em.getTransaction().commit();	
	}
	public void deleteLigne(int id_ligne) {
		LignePannier e = em.find(LignePannier.class, id_ligne);
		Pannier p=em.find(Pannier.class,e.getPannier().getId_pannier());
		decrimenter_pannier(p, e.getPrixtot());
		em.getTransaction().begin();
		
		em.remove(e);
		em.getTransaction().commit();
	}
}
