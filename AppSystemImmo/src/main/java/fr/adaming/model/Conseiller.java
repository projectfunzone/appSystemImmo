package fr.adaming.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*
 * Amandine
 * Classe modele Conseiller
 */

@Entity
@Table(name = "conseillers")
public class Conseiller implements Serializable {

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
	@Fetch(FetchMode.SELECT)
	@OneToMany(mappedBy = "conseiller", fetch=FetchType.EAGER)
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

	@JsonIgnoreProperties("conseiller")
	public List<Visite> getListeVisiteConseiller() {
		return listeVisiteConseiller;
	}

	public void setListeVisiteConseiller(List<Visite> listeVisiteConseiller) {
		this.listeVisiteConseiller = listeVisiteConseiller;
	}

}
