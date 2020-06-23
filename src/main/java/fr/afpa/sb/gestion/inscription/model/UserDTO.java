package fr.afpa.sb.gestion.inscription.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class UserDTO implements Serializable {
	
	private Integer idutilisateur;

	private String adresse;

	private String codepersonnelcentre;

	private LocalDate datenaissance;

	@NotNull
	@Size(min=5,max=30)
	
	private String email;

	private Integer etat;
	
	@NotNull
	@Size(min=1,max=30)
	private String nom;
	
	@NotNull
	@Size(min=6,max=15)
	private String password;
	
	private String prenom;

	private Integer tel;
	
	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return "UserDto [idutilisateur=" + idutilisateur + ", adresse=" + adresse + ", codepersonnelcentre="
				+ codepersonnelcentre + ", datenaissance=" + datenaissance + ", email=" + email + ", etat=" + etat
				+ ", nom=" + nom + ", password=" + password + ", prenom=" + prenom + ", tel=" + tel + "]";
	}

	public Integer getIdutilisateur() {
		return idutilisateur;
	}

	public void setIdutilisateur(Integer idutilisateur) {
		this.idutilisateur = idutilisateur;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getCodepersonnelcentre() {
		return codepersonnelcentre;
	}

	public void setCodepersonnelcentre(String codepersonnelcentre) {
		this.codepersonnelcentre = codepersonnelcentre;
	}

	public LocalDate getDatenaissance() {
		return datenaissance;
	}

	public void setDatenaissance(LocalDate datenaissance) {
		this.datenaissance = datenaissance;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getEtat() {
		return etat;
	}

	public void setEtat(Integer etat) {
		this.etat = etat;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Integer getTel() {
		return tel;
	}

	public void setTel(Integer tel) {
		this.tel = tel;
	}

	

}
