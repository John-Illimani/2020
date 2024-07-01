package com.gestion.pagos.model;

import com.gestion.pagos.model.Categorias;
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
@Table(name = "productos")

public class Productos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idproductos;
    
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "descripcion")
    private String descripcion;
    
    @Column(name = "precio")
    private double precio;
    
    @Column(name = "imagen")
    private String imagen; 
    
     @ManyToOne
    @JoinColumn(name = "idcategoria")
    private Categorias categorias;
    
}

