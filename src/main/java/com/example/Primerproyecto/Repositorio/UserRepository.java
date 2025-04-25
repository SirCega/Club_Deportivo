package com.example.Primerproyecto.Repositorio;

import com.example.Primerproyecto.entidad.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User,String> {

    Optional<User> findByUserName(String nombreUsuario	);
    boolean existsByUserName(String nombreUsuario);
}

