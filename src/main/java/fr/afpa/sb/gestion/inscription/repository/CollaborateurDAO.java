package fr.afpa.sb.gestion.inscription.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.afpa.sb.gestion.inscription.entity.Collaborateur;

@Repository
public interface CollaborateurDAO extends JpaRepository<Collaborateur, Integer> {

}
