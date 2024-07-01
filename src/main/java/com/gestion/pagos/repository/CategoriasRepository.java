
package com.gestion.pagos.repository;

import com.gestion.pagos.model.Categorias;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriasRepository  extends JpaRepository<Categorias, Long>{
    
}
