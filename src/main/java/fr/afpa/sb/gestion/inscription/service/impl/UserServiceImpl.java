package fr.afpa.sb.gestion.inscription.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.afpa.sb.gestion.inscription.constantes.Constantes;
import fr.afpa.sb.gestion.inscription.entity.Collaborateur;
import fr.afpa.sb.gestion.inscription.entity.Role;
import fr.afpa.sb.gestion.inscription.entity.Session;
import fr.afpa.sb.gestion.inscription.entity.Utilisateur;
import fr.afpa.sb.gestion.inscription.exception.BadRequestException;
import fr.afpa.sb.gestion.inscription.exception.ResourceNotFoundException;
import fr.afpa.sb.gestion.inscription.model.CollaborateurDTO;
import fr.afpa.sb.gestion.inscription.model.UserDTO;
import fr.afpa.sb.gestion.inscription.repository.CollaborateurDAO;
import fr.afpa.sb.gestion.inscription.repository.RoleDAO;
import fr.afpa.sb.gestion.inscription.repository.SessionDAO;
import fr.afpa.sb.gestion.inscription.repository.UserDAO;
import fr.afpa.sb.gestion.inscription.service.UserService;
import fr.afpa.sb.gestion.inscription.service.util.Mapper;

@Transactional(readOnly = true)
@Service
public class UserServiceImpl implements UserService {

	private UserDAO userDAO;

	private RoleDAO roleDAO;

	private CollaborateurDAO collaborateurDAO;

	private SessionDAO sessionDAO;

	@Autowired
	public UserServiceImpl(UserDAO userDAO, RoleDAO roleDAO, CollaborateurDAO collaborateurDAO, SessionDAO sessionDAO) {
		super();
		this.userDAO = userDAO;
		this.roleDAO = roleDAO;
		this.collaborateurDAO = collaborateurDAO;
		this.sessionDAO = sessionDAO;
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

	@Override
	@Transactional
	public CollaborateurDTO createCollaborateur(CollaborateurDTO collaborateurDTO) {

		Optional<Utilisateur> optUser = userDAO.findByEmail(collaborateurDTO.getEmail());

		if (optUser.isPresent()) {
			throw new BadRequestException("user with " + collaborateurDTO.getEmail() + " already exists");
		} else {
			Optional<Role> optRole = roleDAO.findByCode(Constantes.ROLE_COLLABORATEUR);
			if (!optRole.isPresent()) {
				throw new ResourceNotFoundException("role with " + Constantes.ROLE_COLLABORATEUR + " doesn't exist");
			} else {
				Optional<Session> optSession = sessionDAO.findById(collaborateurDTO.getIdsession());
				if (!optSession.isPresent()) {
					throw new ResourceNotFoundException(
							"session with " + collaborateurDTO.getIdsession() + " doesn't exist");
				}
				Role role = optRole.get();
				Collaborateur collaborateur = Mapper.map(collaborateurDTO, Collaborateur.class);
				collaborateur.getRoles().add(role);
				collaborateur.setSession(optSession.get());
				collaborateur = collaborateurDAO.save(collaborateur);
				collaborateurDTO = Mapper.map(collaborateur, CollaborateurDTO.class);
				collaborateurDTO.setIdsession(collaborateur.getSession().getIdSession());
				return collaborateurDTO;
			}
		}
	}
}
