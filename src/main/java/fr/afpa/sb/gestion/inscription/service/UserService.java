package fr.afpa.sb.gestion.inscription.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import fr.afpa.sb.gestion.inscription.model.CollaborateurDTO;
import fr.afpa.sb.gestion.inscription.model.UserDTO;

public interface UserService {
	
	public UserDTO findUserByID(Integer id);
	public UserDTO createUser(UserDTO userDTO);
	public UserDTO updateUser(Integer id, UserDTO userDTO);
	public void deleteUser(UserDTO userDTO);
	public void deleteUserById(Integer id);
	public List<UserDTO> findAllUser ();
	
	public Page<UserDTO> findPaginated(int page, int size, Sort sort);
	
	public CollaborateurDTO createCollaborateur(CollaborateurDTO collaborateurDTO);
	public CollaborateurDTO updateCollaborateur(Integer id, CollaborateurDTO collaborateurDTO);
	public List<CollaborateurDTO> findAllCollaborateur();
}
