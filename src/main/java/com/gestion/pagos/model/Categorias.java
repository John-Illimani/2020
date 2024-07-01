
package com.gestion.pagos.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "categorias")

public class Categorias {
    
    @Id  
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idcategoria;

    
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "descripcion")
    private String descripcion;
   
}
