/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.gestion.pagos.repository;


import com.gestion.pagos.model.Usuarios;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author illim
 */
@Repository

public interface UsuarioRepository extends JpaRepository<Usuarios, Long>{
     Optional<Usuarios> findByEmail(String email);
}



