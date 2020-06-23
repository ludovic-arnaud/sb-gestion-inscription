package fr.afpa.sb.gestion.inscription.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.afpa.sb.gestion.inscription.entity.Utilisateur;

@Repository
public interface UserDAO extends JpaRepository<Utilisateur, Integer> {

	
	public Optional<Utilisateur> findByEmail(String email);
	
	public Optional<Utilisateur> findByEmailAndPassword(String email, String password);
	

}
