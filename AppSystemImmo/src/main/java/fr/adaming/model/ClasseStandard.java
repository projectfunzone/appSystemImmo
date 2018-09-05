package fr.adaming.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="classeStandard")
public class ClasseStandard {


	/*
	 * Attributs
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String codeClasse;
	private String modeOffre;
	private double prixMax;
	private int surfaceMin;
	private String typeImmo;
	
	
	

	/*
	 * association
	 */
	@OneToMany(mappedBy="classeStandard")
	private List<BienImmo> listeIm;
	
	@ManyToMany(mappedBy="listeClasseStandard")
	private List<Client> listeClient;
	
	
	
	/*
	 * constructeur
	 */
	public ClasseStandard() {
		super();
	}




	public ClasseStandard(int id, String codeClasse, String modeOffre, double prixMax, int surfaceMin,
			String typeImmo) {
		super();
		this.id = id;
		this.codeClasse = codeClasse;
		this.modeOffre = modeOffre;
		this.prixMax = prixMax;
		this.surfaceMin = surfaceMin;
		this.typeImmo = typeImmo;
	}




	public ClasseStandard(String codeClasse, String modeOffre, double prixMax, int surfaceMin, String typeImmo) {
		super();
		this.codeClasse = codeClasse;
		this.modeOffre = modeOffre;
		this.prixMax = prixMax;
		this.surfaceMin = surfaceMin;
		this.typeImmo = typeImmo;
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




	public String getCodeClasse() {
		return codeClasse;
	}




	public void setCodeClasse(String codeClasse) {
		this.codeClasse = codeClasse;
	}




	public String getModeOffre() {
		return modeOffre;
	}




	public void setModeOffre(String modeOffre) {
		this.modeOffre = modeOffre;
	}




	public double getPrixMax() {
		return prixMax;
	}




	public void setPrixMax(double prixMax) {
		this.prixMax = prixMax;
	}




	public int getSurfaceMin() {
		return surfaceMin;
	}




	public void setSurfaceMin(int surfaceMin) {
		this.surfaceMin = surfaceMin;
	}




	public String getTypeImmo() {
		return typeImmo;
	}




	public void setTypeImmo(String typeImmo) {
		this.typeImmo = typeImmo;
	}




	public List<BienImmo> getListeIm() {
		return listeIm;
	}




	public void setListeIm(List<BienImmo> listeIm) {
		this.listeIm = listeIm;
	}




	public List<Client> getListeClient() {
		return listeClient;
	}




	public void setListeClient(List<Client> listeClient) {
		this.listeClient = listeClient;
	}
	
	
	
	
}
