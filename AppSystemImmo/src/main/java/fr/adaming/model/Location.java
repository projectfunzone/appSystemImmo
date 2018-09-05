package fr.adaming.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/*
 * Amandine
 * Classe modele Location
 */

@Entity
@Table(name = "locations")
public class Location extends BienImmo implements Serializable {

	/*
	 * Attributs
	 */
	private double caution;
	private double loyer;
	private double charge;
	private String bail;
	private String garniture;

	@OneToMany(mappedBy = "location")
	private List<Visite> listeVisiteLocation;

	@ManyToOne
	@JoinColumn(name = "proprietaire_id", referencedColumnName = "id")
	private Proprietaire proprietaire;

	@ManyToOne
	@JoinColumn(name = "classeStandard_id", referencedColumnName = "id", nullable = true)
	private ClasseStandard classeStandard;

	/*
	 * constructeur
	 */
	public Location() {
		super();
	}

	public Location(double caution, double loyer, double charge, String bail, String garniture) {
		super();
		this.caution = caution;
		this.loyer = loyer;
		this.charge = charge;
		this.bail = bail;
		this.garniture = garniture;
	}

	public Location(String categorie, String type, int noChambre, String statut, Date dateSoumis, Date dateDispo,
			double revenueCadastre, Byte[] photo, Adresse adresse, double caution, double loyer, double charge,
			String bail, String garniture) {
		super(categorie, type, noChambre, statut, dateSoumis, dateDispo, revenueCadastre, photo, adresse);
		this.caution = caution;
		this.loyer = loyer;
		this.charge = charge;
		this.bail = bail;
		this.garniture = garniture;
	}

	public Location(int id, String categorie, String type, int noChambre, String statut, Date dateSoumis,
			Date dateDispo, double revenueCadastre, Byte[] photo, Adresse adresse, double caution, double loyer,
			double charge, String bail, String garniture) {
		super(id, categorie, type, noChambre, statut, dateSoumis, dateDispo, revenueCadastre, photo, adresse);
		this.caution = caution;
		this.loyer = loyer;
		this.charge = charge;
		this.bail = bail;
		this.garniture = garniture;
	}

	/*
	 * getters et setters
	 */
	public double getCaution() {
		return caution;
	}

	public void setCaution(double caution) {
		this.caution = caution;
	}

	public double getLoyer() {
		return loyer;
	}

	public void setLoyer(double loyer) {
		this.loyer = loyer;
	}

	public double getCharge() {
		return charge;
	}

	public void setCharge(double charge) {
		this.charge = charge;
	}

	public String getBail() {
		return bail;
	}

	public void setBail(String bail) {
		this.bail = bail;
	}

	public String getGarniture() {
		return garniture;
	}

	public void setGarniture(String garniture) {
		this.garniture = garniture;
	}

	public List<Visite> getListeVisiteLocation() {
		return listeVisiteLocation;
	}

	public void setListeVisiteLocation(List<Visite> listeVisiteLocation) {
		this.listeVisiteLocation = listeVisiteLocation;
	}

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
