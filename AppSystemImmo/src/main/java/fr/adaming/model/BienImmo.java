package fr.adaming.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embedded;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Lob;

import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public class BienImmo implements Serializable {
	// ************************************************************
	/** Les attributs de BienImmo */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String categorie;
	private String type;

	private int surface;
	private int noChambre;
	private String statut;

	@Temporal(TemporalType.DATE)
	private Date dateSoumis;

	@Temporal(TemporalType.DATE)
	private Date dateDispo;

	private double revenueCadastre;

	protected double lat;
	protected double lng;

	// ************************************************************
	/** Transformation de l'association UML en JAVA */

	@Embedded
	private Adresse adresse;

	// ************************************************************
	/** Construsteur vide */
	public BienImmo() {
		super();
	}

	public BienImmo(String categorie, String type, int surface, int noChambre, String statut, Date dateSoumis,
			Date dateDispo, double revenueCadastre, Adresse adresse) {
		super();
		this.categorie = categorie;
		this.type = type;
		this.surface = surface;
		this.noChambre = noChambre;
		this.statut = statut;
		this.dateSoumis = dateSoumis;
		this.dateDispo = dateDispo;
		this.revenueCadastre = revenueCadastre;

		this.adresse = adresse;
	}

	public BienImmo(int id, String categorie, String type, int surface, int noChambre, String statut, Date dateSoumis,
			Date dateDispo, double revenueCadastre, Adresse adresse) {
		super();
		this.id = id;
		this.categorie = categorie;
		this.type = type;
		this.surface = surface;
		this.noChambre = noChambre;
		this.statut = statut;
		this.dateSoumis = dateSoumis;
		this.dateDispo = dateDispo;
		this.revenueCadastre = revenueCadastre;
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

	public int getSurface() {
		return surface;
	}

	public void setSurface(int surface) {
		this.surface = surface;
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


	// ************************************************************
	/** Getters et setters pour la transformation de l'asso UML en JAVA */

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}
	
	

}
