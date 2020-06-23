package fr.afpa.sb.gestion.inscription.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.afpa.sb.gestion.inscription.model.CollaborateurDTO;
import fr.afpa.sb.gestion.inscription.model.UserDTO;
import fr.afpa.sb.gestion.inscription.service.UserService;

@RestController
@RequestMapping("/userManagment")
public class UserController {
	
	private UserService userService;

	@Autowired
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@GetMapping("/utilisateurs")
	public List<UserDTO> retrieveAllUsers(){
		return userService.findAllUser();
	}
	
	@GetMapping("/colls")
	public List<CollaborateurDTO> retrieveAllCollaborateurs(){
		return userService.findAllCollaborateur();
	}
	
	@GetMapping("/utilisateur/{id}")
	public ResponseEntity<UserDTO> retrieveUser(@PathVariable(value = "id") Integer id) {
		return ResponseEntity.ok().body(userService.findUserByID(id));
	}
	
	@PostMapping("/utilisateur")
	public ResponseEntity<UserDTO> addUser(@Valid @RequestBody UserDTO userDTO) {
		return ResponseEntity.ok().body(userService.createUser(userDTO));
	}
	
	@PutMapping("/utilisateur/{id}")
	public ResponseEntity<UserDTO> updateUser(@PathVariable(value = "id") Integer id, @Valid @RequestBody UserDTO userDTO)  {
		return ResponseEntity.ok().body(userService.updateUser(id, userDTO));
	}
	
	@DeleteMapping("/utilisateur/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable(value = "id") Integer id) {
		userService.deleteUserById(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@PostMapping("/coll")
	public ResponseEntity<CollaborateurDTO> addCollaborateur(@Valid @RequestBody CollaborateurDTO collaborateurDTO){
		return ResponseEntity.ok().body(userService.createCollaborateur(collaborateurDTO));
	}
	
	@PutMapping("/coll/{id}")
	public ResponseEntity<CollaborateurDTO> updateCollaborateur(@PathVariable(value = "id") Integer id, @Valid @RequestBody CollaborateurDTO collaborateurDTO)  {
		return ResponseEntity.ok().body(userService.updateCollaborateur(id, collaborateurDTO));
	}

}
