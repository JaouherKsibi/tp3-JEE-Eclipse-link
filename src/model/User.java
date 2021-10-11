package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import dao.GestionbdImp;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String numcin;
	private String nom;
	private String prenom ;
	private String adresse_email;
	private String mdp;
	private String role;
	@OneToOne
	@JoinColumn(name="id_pannier")
	private Pannier pan;
	
	public User() {}
	public User(int id,String numcin, String nom, String prenom, String adresse_email, String mdp, String role) {
		this.id=id;
		this.numcin = numcin;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse_email = adresse_email;
		this.mdp = mdp;
		this.role = role;
	}
	public User(int id, String numcin, String nom, String prenom, String adresse_email, String mdp, String role,
			Pannier pan) {
		super();
		this.id = id;
		this.numcin = numcin;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse_email = adresse_email;
		this.mdp = mdp;
		this.role = role;
		this.pan = pan;
	}
	/**********constructeur a 5 parametres***********/
	public User(String numcin, String nom, String prenom, String adresse_email, String mdp) {
		GestionbdImp g=new GestionbdImp();
		this.numcin = numcin;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse_email = adresse_email;
		this.mdp = mdp;
		this.role = "client";
		this.pan=new Pannier();
		g.addPannier(pan);
	}
	/**********constructeur a 6 parametres***********/
	public User(String numcin, String nom, String prenom, String adresse_email, String mdp,Pannier pan) {
		GestionbdImp g=new GestionbdImp();
		this.id=0;
		this.numcin = numcin;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse_email = adresse_email;
		this.mdp = mdp;
		this.role = "client";
		this.pan=pan;
		}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNumcin() {
		return numcin;
	}
	public void setNumcin(String numcin) {
		this.numcin = numcin;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getAdresse_email() {
		return adresse_email;
	}
	public void setAdresse_email(String adresse_email) {
		this.adresse_email = adresse_email;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Pannier getPan() {
		return pan;
	}
	public void setPan(Pannier pan) {
		this.pan = pan;
	}
	@Override
	public String toString() {
		return "User [numcin=" + numcin + ", nom=" + nom + ", prenom=" + prenom + ", adresse_email=" + adresse_email
				+ ", mdp=" + mdp + ", role=" + role +"panier"+pan+ "]";
	}
	
	
	

}
