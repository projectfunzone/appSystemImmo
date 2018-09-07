package fr.adaming.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@SuppressWarnings("serial")
@Entity
@Table(name = "clients")
public class Client extends Personne implements Serializable {

	// numéro de référence, correspondant à la date d'enregistrement auprès d'un
	// conseiller
	@Temporal(TemporalType.TIMESTAMP)
	private Date num;

	// transformation des associations UML en java
	@Fetch(FetchMode.SELECT)
	@OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
	private List<Visite> listeVisiteCl;

	@Fetch(FetchMode.SELECT)
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "client_classeStandard", joinColumns = @JoinColumn(name = "client_id"), inverseJoinColumns = @JoinColumn(name = "id"))
	private List<ClasseStandard> listeClasseStandard;

	// constructeur
	public Client() {
		super();
	}

	public Client(String nom, String prenom, String telPrive, Adresse adresse, Date num) {
		super(nom, prenom, telPrive, adresse);
		this.num = num;
	}

	public Client(int id, String nom, String prenom, String telPrive, Adresse adresse, Date num) {
		super(id, nom, prenom, telPrive, adresse);
		this.num = num;
	}

	// getter et setter
	public Date getNum() {
		return num;
	}

	public void setNum(Date num) {
		this.num = num;
	}
	@JsonIgnoreProperties("client")
	public List<Visite> getListeVisiteCl() {
		return listeVisiteCl;
	}
	
	public void setListeVisiteCl(List<Visite> listeVisiteCl) {
		this.listeVisiteCl = listeVisiteCl;
	}
	@JsonIgnoreProperties("client")
	public List<ClasseStandard> getListeClasseStandard() {
		return listeClasseStandard;
	}

	public void setListeClasseStandard(List<ClasseStandard> listeClasseStandard) {
		this.listeClasseStandard = listeClasseStandard;
	}

}
