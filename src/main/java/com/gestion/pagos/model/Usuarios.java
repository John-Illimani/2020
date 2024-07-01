
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

/**
 *
 * @author Limber
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "usuarios")
public class Usuarios {
    @Id
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "apellidos")
    private String apellidos;
    

    
    @Column(name = "email")
    private String email;
    
    
    @Column(name = "password")
    private String password;
        
     @Column(name = "direccion")
    private String direccion;
            
            
    @Column(name = "telefono")
    private String telefono;
                
                
    @Column(name = "saldo")
    private float  saldo;    
          
}