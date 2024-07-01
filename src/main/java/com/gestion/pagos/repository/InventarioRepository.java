
package com.gestion.pagos.repository;

import com.gestion.pagos.model.Inventario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface InventarioRepository extends JpaRepository<Inventario, Long>{
    
}
