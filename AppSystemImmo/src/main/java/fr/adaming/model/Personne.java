package fr.adaming.model;

import java.io.Serializable;

import javax.persistence.Embedded;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Personne implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nom;
	private String prenom;
	private String telPrive;

	// assocition UML en java
	@Embedded
	private Adresse adresse;

	public Personne() {
		super();
	}

	public Personne(String nom, String prenom, String telPrive, Adresse adresse) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.telPrive = telPrive;
		this.adresse = adresse;
	}

	public Personne(int id, String nom, String prenom, String telPrive, Adresse adresse) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.telPrive = telPrive;
		this.adresse = adresse;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getTelPrive() {
		return telPrive;
	}

	public void setTelPrive(String telPrive) {
		this.telPrive = telPrive;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

}
