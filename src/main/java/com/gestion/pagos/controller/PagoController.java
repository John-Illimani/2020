/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gestion.pagos.controller;

import com.gestion.pagos.model.Pago;
import com.gestion.pagos.repository.PagoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

public class PagoController {
        @Autowired
    private PagoRepository pagoRepository;

   /* @GetMapping("/pago")
    public List<Pago> listarClientes() {
        return pagoRepository.findAll();
    }*/

    @PostMapping("/pago")
    public Pago guardarCliente(@RequestBody Pago cliente) {
        return pagoRepository.save(cliente);
    }
   

    @GetMapping("/pago")
    public ResponseEntity<List<Pago>> getAllPagos() {
        List<Pago> pagos = pagoRepository.findAll();
        return ResponseEntity.ok(pagos);
    }
  
}