/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.gestion.pagos.repository;

import com.gestion.pagos.model.MetodoPago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author illim
 */
@Repository
public interface MetodoPagoRepository extends JpaRepository<MetodoPago, Long> {
    
}
