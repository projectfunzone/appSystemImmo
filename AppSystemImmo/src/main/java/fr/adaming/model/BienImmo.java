package fr.adaming.model;

import java.io.Serializable;
import java.util.Date;


import javax.persistence.Embedded;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Lob;

import javax.persistence.MappedSuperclass;


@MappedSuperclass
public class BienImmo implements Serializable {
	// ************************************************************
	/** Les attributs de BienImmo */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String categorie;
	private String type;
	private int noChambre;
	private String statut;
	private Date dateSoumis;
	private Date dateDispo;
	private double revenueCadastre;
	@Lob
	private Byte[] photo;
	// ************************************************************
	/** Transformation de l'association UML en JAVA */

	@Embedded
	private Adresse adresse;

	// ************************************************************
	/** Construsteur vide */
	public BienImmo() {
		super();
	}

	public BienImmo(String categorie, String type, int noChambre, String statut, Date dateSoumis, Date dateDispo,
			double revenueCadastre, Byte[] photo, Adresse adresse) {
		super();
		this.categorie = categorie;
		this.type = type;
		this.noChambre = noChambre;
		this.statut = statut;
		this.dateSoumis = dateSoumis;
		this.dateDispo = dateDispo;
		this.revenueCadastre = revenueCadastre;
		this.photo = photo;
		this.adresse = adresse;
	}

	public BienImmo(int id, String categorie, String type, int noChambre, String statut, Date dateSoumis,
			Date dateDispo, double revenueCadastre, Byte[] photo, Adresse adresse) {
		super();
		this.id = id;
		this.categorie = categorie;
		this.type = type;
		this.noChambre = noChambre;
		this.statut = statut;
		this.dateSoumis = dateSoumis;
		this.dateDispo = dateDispo;
		this.revenueCadastre = revenueCadastre;
		this.photo = photo;
		this.adresse = adresse;
	}

	// ************************************************************
	/** Getters et setters */

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getNoChambre() {
		return noChambre;
	}

	public void setNoChambre(int noChambre) {
		this.noChambre = noChambre;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public Date getDateSoumis() {
		return dateSoumis;
	}

	public void setDateSoumis(Date dateSoumis) {
		this.dateSoumis = dateSoumis;
	}

	public Date getDateDispo() {
		return dateDispo;
	}

	public void setDateDispo(Date dateDispo) {
		this.dateDispo = dateDispo;
	}

	public double getRevenueCadastre() {
		return revenueCadastre;
	}

	public void setRevenueCadastre(double revenueCadastre) {
		this.revenueCadastre = revenueCadastre;
	}

	public Byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(Byte[] photo) {
		this.photo = photo;
	}

	// ************************************************************
	/** Getters et setters pour la transformation de l'asso UML en JAVA */

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

}
