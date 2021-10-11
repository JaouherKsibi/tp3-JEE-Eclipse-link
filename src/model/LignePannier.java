package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import dao.GestionbdImp;

@Entity
public class LignePannier {
	@Id
	private int id_ligne;
	@OneToOne
	@JoinColumn(name="id_produit")
	private Produit produit;
	@ManyToOne
	@JoinColumn(name="id_pannier")
	private Pannier pannier;
	private int qte;
	private float prixtot;
	public LignePannier() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LignePannier(int id_ligne, Produit produit, Pannier pannier) {
		super();
		GestionbdImp g=new GestionbdImp();
		this.id_ligne = id_ligne;
		this.produit = produit;
		this.pannier = pannier;
	}
	public LignePannier(Produit produit, Pannier pannier) {
		super();
		this.produit = produit;
		this.pannier = pannier;
	}
	public int getQte() {
		return qte;
	}
	public void setQte(int qte) {
		this.qte = qte;
	}
	public float getPrixtot() {
		return prixtot;
	}
	public void setPrixtot(float prixtot) {
		this.prixtot = prixtot;
	}
	public int getId_ligne() {
		return id_ligne;
	}
	public void setId_ligne(int id_ligne) {
		this.id_ligne = id_ligne;
	}
	public Produit getProduit() {
		return produit;
	}
	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	public Pannier getPannier() {
		return pannier;
	}
	public void setPannier(Pannier pannier) {
		this.pannier = pannier;
	}
	@Override
	public String toString() {
		return "LignePannier [id_ligne=" + id_ligne + ", produit=" + produit + ", pannier=" + pannier + "]";
	}
	
}
