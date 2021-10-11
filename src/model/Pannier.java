package model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import dao.GestionbdImp;
@Entity
public class Pannier {
	@Id
	private int id_pannier;
	@OneToMany
	@JoinColumn(name="id_ligne")
	private List<LignePannier> list_ligne;
	private float somme;
	private int nb_prod;
	public Pannier() {
		
		this.somme = 0.0f;
		this.nb_prod = 0;
	}
	public Pannier(int id_pannier, List<LignePannier> list_ligne, float somme, int nb_prod) {
		super();
		this.id_pannier = id_pannier;
		this.list_ligne = list_ligne;
		this.somme = somme;
		this.nb_prod = nb_prod;
	}
	public int getId_pannier() {
		return id_pannier;
	}
	public void setId_pannier(int id_pannier) {
		this.id_pannier = id_pannier;
	}
	
	public List<LignePannier> getList_ligne() {
		return list_ligne;
	}
	public void setList_ligne(List<LignePannier> list_ligne) {
		this.list_ligne = list_ligne;
	}
	public float getSomme() {
		return somme;
	}
	public void setSomme(float somme) {
		this.somme = somme;
	}
	public int getNb_prod() {
		return nb_prod;
	}
	public void setNb_prod(int nb_prod) {
		this.nb_prod = nb_prod;
	}
	@Override
	public String toString() {
		return "Pannier [id_pannier=" + id_pannier +  ", list_ligne=" + list_ligne + ", somme="
				+ somme + ", nb_prod=" + nb_prod + "]";
	}
	
}
