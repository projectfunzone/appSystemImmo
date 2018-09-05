package fr.adaming.model;

import java.util.Date;

public class BienImmo {
	
	/**Les attributs de BienImmo*/
	private int id;
	private String categorie;
	private String type;
	private int noChambre;
	private String statut;
	private Date dateSoumis;
	private Date dateDispo;
	private double revenueCadastre;
	private Byte photo;

	//************************************************************
	/**Construsteur vide*/
	public BienImmo() {
		super();
	}


	public BienImmo(String categorie, String type, int noChambre, String statut, Date dateSoumis, Date dateDispo,
			double revenueCadastre, Byte photo) {
		super();
		this.categorie = categorie;
		this.type = type;
		this.noChambre = noChambre;
		this.statut = statut;
		this.dateSoumis = dateSoumis;
		this.dateDispo = dateDispo;
		this.revenueCadastre = revenueCadastre;
		this.photo = photo;
	}


	public BienImmo(int id, String categorie, String type, int noChambre, String statut, Date dateSoumis,
			Date dateDispo, double revenueCadastre, Byte photo) {
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
	}
	//************************************************************
	/**Getters et setters*/


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


	public Byte getPhoto() {
		return photo;
	}


	public void setPhoto(Byte photo) {
		this.photo = photo;
	}
	
	

}
