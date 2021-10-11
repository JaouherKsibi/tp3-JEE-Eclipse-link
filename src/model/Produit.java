package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Produit {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_produit;
	@Column(nullable=false) 
	private String nom_produit ;
	@Column(nullable=false) 
	private String url_image_produit;
	@Column(nullable=false) 
	private Float prix_produit;
	private float remise;
	private int quantite;
	
	@ManyToOne
	@JoinColumn(name="id_categorie")/*il peut y avoir une rreur */
	private Categorie categorie_produit;
	
	public Produit() {
		
	}
	public Produit(int id_produit, String nom_produit, String url_image_produit, Float prix_produit,
			Categorie categorie_produit,int qtite,float somme) {
		super();
		this.id_produit = id_produit;
		this.nom_produit = nom_produit;
		this.url_image_produit = url_image_produit;
		this.prix_produit = prix_produit;
		this.categorie_produit = categorie_produit;
		this.quantite=qtite;
		this.remise=somme;
	}
	@Override
	public String toString() {
		return "Produit [id_produit=" + id_produit + ", nom_produit=" + nom_produit + ", url_image_produit="
				+ url_image_produit + ", prix_produit=" + prix_produit + ", categorie_produit=" + categorie_produit
				+ "]";
	}
	public int getId_produit() {
		return id_produit;
	}
	public void setId_produit(int id_produit) {
		this.id_produit = id_produit;
	}
	public String getNom_produit() {
		return nom_produit;
	}
	public void setNom_produit(String nom_produit) {
		this.nom_produit = nom_produit;
	}
	public String getUrl_image_produit() {
		return url_image_produit;
	}
	public void setUrl_image_produit(String url_image_produit) {
		this.url_image_produit = url_image_produit;
	}
	public Float getPrix_produit() {
		return prix_produit;
	}
	public void setPrix_produit(Float prix_produit) {
		this.prix_produit = prix_produit;
	}
	public Categorie getCategorie_produit() {
		return categorie_produit;
	}
	public void setCategorie_produit(Categorie categorie_produit) {
		this.categorie_produit = categorie_produit;
	}
	public float getRemise() {
		return remise;
	}
	public void setRemise(float remise) {
		this.remise = remise;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public Produit(int id_produit, String nom_produit, String url_image_produit, Float prix_produit,
			Categorie categorie_produit) {
		super();
		this.id_produit = id_produit;
		this.nom_produit = nom_produit;
		this.url_image_produit = url_image_produit;
		this.prix_produit = prix_produit;
		this.categorie_produit = categorie_produit;
		this.quantite=0;
		this.remise=0;
	}
	
	
	

}
