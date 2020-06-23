package fr.afpa.sb.gestion.inscription.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.afpa.sb.gestion.inscription.entity.Role;

@Repository
public interface RoleDAO extends JpaRepository<Role, Integer> {

	public List<Role> findByCode(String code);

}
