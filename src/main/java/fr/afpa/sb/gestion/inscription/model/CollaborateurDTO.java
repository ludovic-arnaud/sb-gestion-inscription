package fr.afpa.sb.gestion.inscription.model;

public class CollaborateurDTO extends UserDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer idsession;
	

	public CollaborateurDTO() {
		super();
	}

	public Integer getIdsession() {
		return idsession;
	}

	public void setIdsession(Integer idsession) {
		this.idsession = idsession;
	}

	@Override
	public String toString() {
		return "CollaborateurDTO [idsession=" + idsession + ", toString()=" + super.toString() + "]";
	}

}
