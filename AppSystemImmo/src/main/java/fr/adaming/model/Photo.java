package fr.adaming.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;


@Entity /**
 * Cette annaotation permet de rendre cette classe persitante(prise en
 * compte par l'ORM)
 */
@Table(name = "photos") /** Spécifier la table correspondante à cette classe */
public class Photo implements Serializable{
	
	//***********************************************************************
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;	
	@Lob
	private byte[] image;

	//***********************************************************************
	//Constructeurs
	public Photo() {
		super();
	}
	
	public Photo(byte[] image) {
		super();
		this.image = image;
	}

	public Photo(int id, byte[] image) {
		super();
		this.id = id;
		this.image = image;
	}
	
	//***********************************************************************
	//Les getters et setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}
	
	
	
	
}
