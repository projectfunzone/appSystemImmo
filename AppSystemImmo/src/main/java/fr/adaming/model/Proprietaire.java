package fr.adaming.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "proprietaires")
public class Proprietaire extends Personne implements Serializable {

	private String telPro;
	
	@OneToMany(mappedBy="proprietaire")
	private List<BienImmo> listeBienImmo;

	public Proprietaire() {
		super();
	}

	public Proprietaire(String nom, String prenom, String telPrive, Adresse adresse, String telPro) {
		super(nom, prenom, telPrive, adresse);
		this.telPro = telPro;
	}

	public Proprietaire(int id, String nom, String prenom, String telPrive, Adresse adresse, String telPro) {
		super(id, nom, prenom, telPrive, adresse);
		this.telPro = telPro;
	}

	public String getTelPro() {
		return telPro;
	}

	public void setTelPro(String telPro) {
		this.telPro = telPro;
	}

	public List<BienImmo> getListeBienImmo() {
		return listeBienImmo;
	}

	public void setListeBienImmo(List<BienImmo> listeBienImmo) {
		this.listeBienImmo = listeBienImmo;
	}

	
}
