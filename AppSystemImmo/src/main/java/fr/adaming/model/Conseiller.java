package fr.adaming.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/*
 * Amandine
 * Classe modele Conseiller
 */

@Entity
@Table(name="conseillers")
public class Conseiller {

	/*
	 * Attributs
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String mdp;
	private String nom;
	

	/*
	 * association
	 */
	@OneToMany(mappedBy="conseiller")
	private List<Visite> listeVisiteConseiller; 
	
	
	
	/*
	 * constructeur
	 */
	public Conseiller() {
		super();
	}

	public Conseiller(int id, String mdp, String nom) {
		super();
		this.id = id;
		this.mdp = mdp;
		this.nom = nom;
	}

	public Conseiller(String mdp, String nom) {
		super();
		this.mdp = mdp;
		this.nom = nom;
	}

	/*
	 * getters et setters
	 */

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Visite> getListeVisiteCons() {
		return listeVisiteCons;
	}

	public void setListeVisiteCons(List<Visite> listeVisiteCons) {
		this.listeVisiteCons = listeVisiteCons;
	}
	
	
	
	
}
