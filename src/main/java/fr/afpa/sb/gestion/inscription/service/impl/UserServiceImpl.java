package fr.afpa.sb.gestion.inscription.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.afpa.sb.gestion.inscription.entity.Utilisateur;
import fr.afpa.sb.gestion.inscription.exception.BadRequestException;
import fr.afpa.sb.gestion.inscription.exception.ResourceNotFoundException;
import fr.afpa.sb.gestion.inscription.model.UserDTO;
import fr.afpa.sb.gestion.inscription.repository.UserDAO;
import fr.afpa.sb.gestion.inscription.service.UserService;
import fr.afpa.sb.gestion.inscription.service.util.Mapper;

@Transactional(readOnly = true)
@Service
public class UserServiceImpl implements UserService {

	private UserDAO userDAO;

	@Autowired
	public UserServiceImpl(UserDAO userDAO) {
		super();
		this.userDAO = userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public UserDTO findUserByID(Integer id) {

		Optional<Utilisateur> optUser = userDAO.findById(id);

		if (!optUser.isPresent()) {
			throw new ResourceNotFoundException("user with " + id + " not found");
		} else {
			Utilisateur user = optUser.get();
			return Mapper.map(user, UserDTO.class);
		}
	}

	@Override
	@Transactional
	public UserDTO createUser(UserDTO userDTO) {

		Optional<Utilisateur> optUser = userDAO.findByEmail(userDTO.getEmail());

		if (optUser.isPresent()) {
			throw new BadRequestException("user with " + userDTO.getEmail() + " already exists");
		} else {
			Utilisateur user = userDAO.save(Mapper.map(userDTO, Utilisateur.class));
			return Mapper.map(user, UserDTO.class);
		}
	}

	@Override
	@Transactional
	public UserDTO updateUser(Integer id, UserDTO userDTO) {

		userDTO.setIdutilisateur(id);

		Optional<Utilisateur> optUser = userDAO.findById(userDTO.getIdutilisateur());

		if (!optUser.isPresent()) {
			throw new ResourceNotFoundException("user with " + userDTO.getIdutilisateur() + " not found");
		} else {
			
			Optional<Utilisateur> optUserByMail = userDAO.findByEmail(userDTO.getEmail());

			if (optUserByMail.isPresent() && id != optUserByMail.get().getIdutilisateur()) {
				throw new BadRequestException("user with " + userDTO.getEmail() + " already exists");
			}
			Utilisateur user = userDAO.save(Mapper.map(userDTO, Utilisateur.class));
			return Mapper.map(user, UserDTO.class);
		}
	}

	@Override
	@Transactional
	public void deleteUser(UserDTO userDTO) {

		Optional<Utilisateur> optUser = userDAO.findById(userDTO.getIdutilisateur());

		if (!optUser.isPresent()) {
			throw new ResourceNotFoundException("user with " + userDTO.getIdutilisateur() + " not found");
		} else {
			userDAO.delete(Mapper.map(userDTO, Utilisateur.class));
		}
	}

	@Override
	public List<UserDTO> findAllUser() {
		List<Utilisateur> list = userDAO.findAll();
		return Mapper.map(list, UserDTO.class);
	}

	@Override
	@Transactional
	public void deleteUserById(Integer id) {
		Optional<Utilisateur> optUser = userDAO.findById(id);

		if (!optUser.isPresent()) {
			throw new ResourceNotFoundException("user with " + id + " not found");
		} else {
			userDAO.deleteById(id);
		}

	}

}
