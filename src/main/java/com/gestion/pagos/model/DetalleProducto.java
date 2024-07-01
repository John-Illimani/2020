
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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "detalleProducto")
public class DetalleProducto {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idDetallePedido;
    
    @Column(name = "cantidad")
    private int cantidad;
    
    @Column(name = "precioUnitario")
    private int precioUnitario;
    
    @ManyToOne
    @JoinColumn(name = "idproductos")
    private Productos productos;
   
}
