package fr.adaming.model;

import java.io.File;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/*
 * Amandine
 * Classe modele Acquisition
 */


@Entity
@Table(name="acuqisitions")
public class Acquisition implements Serializable {

	/*
	 * Attributs
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private double prixAchat;
	private Date date;
	private String ref;
	private File contrat;
	
	
	/*
	 * association
	 */
	@OneToOne
	@JoinColumn(name="visite_id", referencedColumnName="id")
	private Visite visiteAcqui;
	
	/*
	 * constructeur
	 */
	public Acquisition() {
		super();
	}



	public Acquisition(int id, double prixAchat, Date date, String ref, File contrat) {
		super();
		this.id = id;
		this.prixAchat = prixAchat;
		this.date = date;
		this.ref = ref;
		this.contrat = contrat;
	}



	public Acquisition(double prixAchat, Date date, String ref, File contrat) {
		super();
		this.prixAchat = prixAchat;
		this.date = date;
		this.ref = ref;
		this.contrat = contrat;
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



	public double getPrixAchat() {
		return prixAchat;
	}



	public void setPrixAchat(double prixAchat) {
		this.prixAchat = prixAchat;
	}



	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
	}



	public String getRef() {
		return ref;
	}



	public void setRef(String ref) {
		this.ref = ref;
	}



	public File getContrat() {
		return contrat;
	}



	public void setContrat(File contrat) {
		this.contrat = contrat;
	}



	public Visite getVisiteAcqui() {
		return visiteAcqui;
	}



	public void setVisiteAcqui(Visite visiteAcqui) {
		this.visiteAcqui = visiteAcqui;
	}
	

	
	
}
