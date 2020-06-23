package fr.afpa.sb.gestion.inscription.service;

import java.util.List;

import fr.afpa.sb.gestion.inscription.model.UserDTO;

public interface UserService {
	
	public UserDTO findUserByID(Integer id);
	public UserDTO createUser (UserDTO userDTO);
	public UserDTO updateUser (Integer id, UserDTO userDTO);
	public void deleteUser (UserDTO userDTO);
	public void deleteUserById(Integer id);
	public List<UserDTO> findAllUser ();
}
