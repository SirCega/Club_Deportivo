	package com.example.Primerproyecto.Repositorio;
	
	import java.util.Optional;
	
	import org.springframework.data.jpa.repository.JpaRepository;
	import org.springframework.stereotype.Repository;
	
	import com.example.Primerproyecto.entidad.Role;
	import com.example.Primerproyecto.enums.RoleList;
	
	@Repository
	public interface RoleRepository extends JpaRepository<Role, Integer> {
	
	    Optional<Role> findByName(RoleList name);
	}