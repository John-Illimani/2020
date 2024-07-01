
package com.gestion.pagos.repository;

import com.gestion.pagos.model.DetalleProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetallesProductoRepository extends JpaRepository<DetalleProducto, Long> {
    
}
