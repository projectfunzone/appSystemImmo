package fr.adaming.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "clients")
public class Client extends Personne {

	// numéro de référence, correspondant à la date d'enregistrement auprès d'un
	// conseiller
	@Temporal(TemporalType.TIMESTAMP)
	private Date num;
	
	//transformation des associations UML en java
	@OneToMany(mappedBy="client")
	private List<Visite> listeVisiteCl;
	
	@ManyToMany
	@JoinTable(name="client_classeStandard", joinColumns=@JoinColumn(name="client_id"), inverseJoinColumns = @JoinColumn(name="id"))
	private List<ClasseStandard> listeClasseStandard;

	//constructeur
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

	//getter et setter
	public Date getNum() {
		return num;
	}

	public void setNum(Date num) {
		this.num = num;
	}

	public List<Visite> getListeVisiteCl() {
		return listeVisiteCl;
	}

	public void setListeVisiteCl(List<Visite> listeVisiteCl) {
		this.listeVisiteCl = listeVisiteCl;
	}

	public List<ClasseStandard> getListeClasseStandard() {
		return listeClasseStandard;
	}

	public void setListeClasseStandard(List<ClasseStandard> listeClasseStandard) {
		this.listeClasseStandard = listeClasseStandard;
	}

}
