
package com.gestion.pagos.model;

import com.gestion.pagos.model.Productos;
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
@Table(name = "promociones")
public class Promociones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idpromociones;
    
    @Column(name = "descripcion")
    private String descripcion;
    
    @Column(name = "descuento")
    private int descuento;
    
    @Column(name = "fechaInicio")
    private String fechaInicio;
    
     @Column(name = "fechaFin")
    private String fechaFin;
     
      @ManyToOne
    @JoinColumn(name = "idproductos")
    private Productos productos;
    
    
}
