
package com.gestion.pagos.repository;

import com.gestion.pagos.model.Promociones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PromocionesRepository extends JpaRepository<Promociones, Long>{
    
}
