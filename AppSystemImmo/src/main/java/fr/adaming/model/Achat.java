package fr.adaming.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity /**Cette annaotation permet de rendre cette classe persitante(prise en compte par l'ORM)*/
@Table(name="achats")/**Spécifier la table correspondante à cette classe*/
public class Achat extends BienImmo{
	
	/**Les attributs de BienImmo*/
	private double prixDemande;
	private String etat;
	//************************************************************
	/**Construsteur vide*/
	public Achat() {
		super();
	}
	public Achat(double prixDemande, String etat) {
		super();
		this.prixDemande = prixDemande;
		this.etat = etat;
	}
	

	public Achat(String categorie, String type, int noChambre, String statut, Date dateSoumis, Date dateDispo,
			double revenueCadastre, Byte[] photo, double prixDemande, String etat) {
		super(categorie, type, noChambre, statut, dateSoumis, dateDispo, revenueCadastre, photo);
		this.prixDemande = prixDemande;
		this.etat = etat;
	}
	
	
	public Achat(int id, String categorie, String type, int noChambre, String statut, Date dateSoumis, Date dateDispo,
			double revenueCadastre, Byte[] photo, double prixDemande, String etat) {
		super(id, categorie, type, noChambre, statut, dateSoumis, dateDispo, revenueCadastre, photo);
		this.prixDemande = prixDemande;
		this.etat = etat;
	}
	//************************************************************
	/**Getters et setters*/
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
	

}
