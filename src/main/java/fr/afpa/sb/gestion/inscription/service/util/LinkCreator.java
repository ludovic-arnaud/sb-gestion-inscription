package fr.afpa.sb.gestion.inscription.service.util;

import org.springframework.hateoas.Link;

import fr.afpa.sb.gestion.inscription.exception.ResourceNotFoundException;

public interface LinkCreator<T> {
     Link getSelfLink(T t) throws ResourceNotFoundException;
     Link getLinks();

}