/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gestion.pagos.controller;

import com.gestion.pagos.model.MetodoPago;
import com.gestion.pagos.repository.MetodoPagoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author illim
 */
@CrossOrigin(origins = "http://localhost:5173/")
@RestController
@RequestMapping("/api/v1")
public class MetodoPagoController {
    
         @Autowired
    private MetodoPagoRepository clienteRepository;

    @GetMapping("/metodopago")
    public List<MetodoPago> listarClientes() {
        return clienteRepository.findAll();
    }

    @PostMapping("/metodopago")
    public MetodoPago guardarCliente(@RequestBody MetodoPago cliente) {
        return clienteRepository.save(cliente);
    }
    
}
