/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gestion.pagos.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

/**
 *
 * @author illim
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pago")

public class Pago {

    @Id  //indica que un campo es la clave primaria de la tabla

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idPago;

    
    //foranea pedidos
    @Column(name = "pedido")
    private String pedido;
    
    @Column(name = "monto")
    private float monto;
    
    @Column(name = "fecha")
    private String fecha;
    
    
    
   
    @ManyToOne
    @JoinColumn(name = "idmetodo")
    private MetodoPago metodo;
     
    
}
