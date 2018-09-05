package fr.adaming.model;

import javax.persistence.Embeddable;

@Embeddable
public class Adresse {

	private String rue;
	private String cp;
	private String ville;
	private String pays;

	public Adresse() {
		super();
	}

	public Adresse(String rue, String cp, String ville, String pays) {
		super();
		this.rue = rue;
		this.cp = cp;
		this.ville = ville;
		this.pays = pays;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

}
