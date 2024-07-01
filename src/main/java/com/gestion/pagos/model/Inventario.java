
package com.gestion.pagos.model;

import com.gestion.pagos.model.Inventario;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "inventario")

public class Inventario {
       @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idinventario;
    
    @Column(name = "cantidadDisponible")
    private int cantidadDisponible;
    
   @Column(name = "ultimaActualizacion")
    private String ultimaActualizacion;
   
     @ManyToOne
    @JoinColumn(name = "idproductos")
    private Productos productos;
    
}
