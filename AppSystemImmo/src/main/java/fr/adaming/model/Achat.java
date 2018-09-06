package fr.adaming.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@SuppressWarnings("serial")
@Entity /**
		 * Cette annaotation permet de rendre cette classe persitante(prise en
		 * compte par l'ORM)
		 */
@Table(name = "achats") /** Spécifier la table correspondante à cette classe */
public class Achat extends BienImmo implements Serializable {

	/** Les attributs de BienImmo */
	private double prixDemande;
	private String etat;

	@OneToMany(mappedBy = "achat")
	private List<Visite> listeVisiteAchat;

	@ManyToOne
	@JoinColumn(name = "proprietaire_id", referencedColumnName = "id")
	private Proprietaire proprietaire;

	@ManyToOne
	@JoinColumn(name = "classeStandard_id", referencedColumnName = "id", nullable = true)
	private ClasseStandard classeStandard;

	// ************************************************************
	/** Construsteur vide */
	public Achat() {
		super();
	}

	public Achat(String categorie, String type, int noChambre, String statut, Date dateSoumis, Date dateDispo,
			double revenueCadastre, Byte[] photo, Adresse adresse, double prixDemande, String etat) {
		super(categorie, type, noChambre, statut, dateSoumis, dateDispo, revenueCadastre, photo, adresse);
		this.prixDemande = prixDemande;
		this.etat = etat;
	}

	public Achat(int id, String categorie, String type, int noChambre, String statut, Date dateSoumis, Date dateDispo,
			double revenueCadastre, Byte[] photo, Adresse adresse, double prixDemande, String etat) {
		super(id, categorie, type, noChambre, statut, dateSoumis, dateDispo, revenueCadastre, photo, adresse);
		this.prixDemande = prixDemande;
		this.etat = etat;
	}

	// ************************************************************
	/** Getters et setters */
	public double getPrixDemande() {
		return prixDemande;
	}

	public void setPrixDemande(double prixDemande) {
		this.prixDemande = prixDemande;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public List<Visite> getListeVisiteAchat() {
		return listeVisiteAchat;
	}

	public void setListeVisiteAchat(List<Visite> listeVisiteAchat) {
		this.listeVisiteAchat = listeVisiteAchat;
	}

	@JsonIgnoreProperties("listeBienAchat")
	public Proprietaire getProprietaire() {
		return proprietaire;
	}

	public void setProprietaire(Proprietaire proprietaire) {
		this.proprietaire = proprietaire;
	}

	public ClasseStandard getClasseStandard() {
		return classeStandard;
	}

	public void setClasseStandard(ClasseStandard classeStandard) {
		this.classeStandard = classeStandard;
	}

}
