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
	private Date date;

	
	/*
	 * association
	 */
	@OneToOne
	@JoinColumn(name="id", referencedColumnName="id")
	private Acquisition acquisition;
	
	@ManyToOne
	@JoinColumn(name="id", referencedColumnName="id")
	private Conseiller conseiller;
	
	@ManyToOne
	@JoinColumn(name="id", referencedColumnName="id")
	private Client client;
	
	@ManyToOne
	@JoinColumn(name="id", referencedColumnName="id")
	private BienImmo bienImmo;
	
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

	public BienImmo getBienImmo() {
		return bienImmo;
	}

	public void setBienImmo(BienImmo bienImmo) {
		this.bienImmo = bienImmo;
	}
	

	
	
}
