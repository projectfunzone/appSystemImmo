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
	private List<Location> listeBienLocation;
	
	
	@OneToMany(mappedBy="proprietaire")
	private List<Achat> listeBienAchat;

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

	public List<Location> getListeBienLocation() {
		return listeBienLocation;
	}

	public void setListeBienLocation(List<Location> listeBienLocation) {
		this.listeBienLocation = listeBienLocation;
	}

	public List<Achat> getListeBienAchat() {
		return listeBienAchat;
	}

	public void setListeBienAchat(List<Achat> listeBienAchat) {
		this.listeBienAchat = listeBienAchat;
	}



	
}
