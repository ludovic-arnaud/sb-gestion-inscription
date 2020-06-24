package fr.afpa.sb.gestion.inscription.service.util;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.Link;
import org.springframework.stereotype.Component;

import fr.afpa.sb.gestion.inscription.controller.UserController;
import fr.afpa.sb.gestion.inscription.exception.ResourceNotFoundException;
import fr.afpa.sb.gestion.inscription.model.UserDTO;

@Component
public class UserDTOLinkCreator implements LinkCreator<UserDTO> {

	@Override
	public Link getLinks() {
		return linkTo(methodOn(UserController.class).retrieveAllUsers()).withRel("/userManagment");
	}

	@Override
	public Link getSelfLink(UserDTO userDTO) throws ResourceNotFoundException {
		return linkTo(methodOn(UserController.class).retrieveUser(((UserDTO) userDTO).getIdutilisateur()))
				.withSelfRel();
	}

}
