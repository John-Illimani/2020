/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gestion.pagos.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
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
@Table(name = "metodopago")
public class MetodoPago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idmetodo;

    @Column(name = "metodo")
    private String metodoP;

    @Column(name = "descripcion")
    private String descripcion;

    @OneToMany(mappedBy = "metodo")
    @JsonBackReference
    private List<Pago> pagos;
}
