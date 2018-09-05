package fr.adaming.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;

@MappedSuperclass
public class BienImmo implements Serializable{
	//************************************************************
	/**Les attributs de BienImmo*/
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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
	//************************************************************
	/**Transformation de l'association UML en JAVA*/
	@ManyToOne
	@JoinColumn(name="proprietaire_id", referencedColumnName="id")
	private Proprietaire proprietaire;
	
	private Adresse adresse;
	@ManyToOne
	@JoinColumn(name="classeStandard_id", referencedColumnName="id", nullable=true)
	private ClasseStandard classeStandard;
	@OneToMany(mappedBy="bienImmo")
	private List<Visite> listeVisiteImmo;

	//************************************************************
	/**Construsteur vide*/
	public BienImmo() {
		super();
	}
	
	public BienImmo(String categorie, String type, int noChambre, String statut, Date dateSoumis, Date dateDispo,
			double revenueCadastre, Byte[] photo, Proprietaire proprietaire, Adresse adresse,
			ClasseStandard classeStandard, List<Visite> listeVisiteImmo) {
		super();
		this.categorie = categorie;
		this.type = type;
		this.noChambre = noChambre;
		this.statut = statut;
		this.dateSoumis = dateSoumis;
		this.dateDispo = dateDispo;
		this.revenueCadastre = revenueCadastre;
		this.photo = photo;
		this.proprietaire = proprietaire;
		this.adresse = adresse;
		this.classeStandard = classeStandard;
		this.listeVisiteImmo = listeVisiteImmo;
	}
	

	public BienImmo(int id, String categorie, String type, int noChambre, String statut, Date dateSoumis,
			Date dateDispo, double revenueCadastre, Byte[] photo, Proprietaire proprietaire, Adresse adresse,
			ClasseStandard classeStandard, List<Visite> listeVisiteImmo) {
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
		this.proprietaire = proprietaire;
		this.adresse = adresse;
		this.classeStandard = classeStandard;
		this.listeVisiteImmo = listeVisiteImmo;
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

	public Byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(Byte[] photo) {
		this.photo = photo;
	}
	//************************************************************
	/**Getters et setters pour la transformation de l'asso UML en JAVA*/

	public Proprietaire getProprietaire() {
		return proprietaire;
	}

	public void setProprietaire(Proprietaire proprietaire) {
		this.proprietaire = proprietaire;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public ClasseStandard getClasseStandard() {
		return classeStandard;
	}

	public void setClasseStandard(ClasseStandard classeStandard) {
		this.classeStandard = classeStandard;
	}

	public List<Visite> getListeVisiteImmo() {
		return listeVisiteImmo;
	}

	public void setListeVisiteImmo(List<Visite> listeVisiteImmo) {
		this.listeVisiteImmo = listeVisiteImmo;
	}
	
	
	

}
