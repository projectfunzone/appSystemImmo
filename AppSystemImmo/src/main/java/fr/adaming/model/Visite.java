package fr.adaming.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*
 * Amandine
 * Classe modele Visite 
 */


@Entity
@Table(name="visites")
public class Visite {

	/*
	 * Attributs
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	
	/*
	 * association
	 */
	@JsonIgnore
	@OneToOne
	@JoinColumn(name="acquisition_id", referencedColumnName="id")
	private Acquisition acquisition;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="conseiller_id", referencedColumnName="id")
	private Conseiller conseiller;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="client_id", referencedColumnName="id")
	private Client client;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="location_id", referencedColumnName="id")
	private Location location;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="achat_id", referencedColumnName="id")
	private Achat achat;
	
	/*
	 * constructeur
	 */
	public Visite() {
		super();
	}

	public Visite(int id, Date date) {
		super();
		this.id = id;
		this.date = date;
	}

	public Visite(Date date) {
		super();
		this.date = date;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Acquisition getAcquisition() {
		return acquisition;
	}

	public void setAcquisition(Acquisition acquisition) {
		this.acquisition = acquisition;
	}

	@JsonIgnoreProperties("listeVisiteConseiller")
	public Conseiller getConseiller() {
		return conseiller;
	}

	public void setConseiller(Conseiller conseiller) {
		this.conseiller = conseiller;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	@JsonIgnoreProperties("listeVisiteLocation")
	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
	@JsonIgnoreProperties("listeVisiteAchat")
	public Achat getAchat() {
		return achat;
	}

	public void setAchat(Achat achat) {
		this.achat = achat;
	}



	
	
}
