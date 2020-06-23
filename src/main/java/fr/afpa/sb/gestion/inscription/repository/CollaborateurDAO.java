package fr.afpa.sb.gestion.inscription.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.afpa.sb.gestion.inscription.entity.Collaborateur;
import fr.afpa.sb.gestion.inscription.entity.Utilisateur;

@Repository
public interface CollaborateurDAO extends JpaRepository<Collaborateur, Integer> {

	public Optional<Collaborateur> findByEmail(String email);

	public Optional<Collaborateur> findByEmailAndPassword(String email, String password);

}
