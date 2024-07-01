package com.gestion.pagos.controller;

import com.gestion.pagos.exception.ResourceNotFoundException;

import com.gestion.pagos.model.Inventario;
import com.gestion.pagos.repository.InventarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:5173/")
@RestController
@RequestMapping("/api/v1")
public class InventarioController {
        
    @Autowired
    private InventarioRepository inventarioRepository;

    // Listar Inventarios
    @GetMapping("/inventario")
    public List<Inventario> listarInventario() {
        return inventarioRepository.findAll();
    }

    // Guardar Inventario
    @PostMapping("/inventario")
    public Inventario guardarInventario(@RequestBody Inventario inventario) {
        return inventarioRepository.save(inventario);
    }

    // Listar un inventario por id
    @GetMapping("/inventario/{id}")
    public ResponseEntity<Inventario> listarInventarioPorId(@PathVariable long id) {
        Inventario inventario = inventarioRepository.findById(id)
                 .orElseThrow(() -> new ResourceNotFoundException("el usuario con ese ID  no existe : " + id));
        return ResponseEntity.ok(inventario);
    }
    
    // Actualizar Inventario
    @PutMapping("/inventario/{id}")
    public ResponseEntity<Inventario> actualizarInventario(@PathVariable Long id, @RequestBody Inventario inventarioRequest) {
        Inventario inventario = inventarioRepository.findById(id)
                 .orElseThrow(() -> new ResourceNotFoundException("el usuario con ese ID  no existe : " + id));

        inventario.setCantidadDisponible(inventarioRequest.getCantidadDisponible());
        inventario.setUltimaActualizacion(inventarioRequest.getUltimaActualizacion());

        Inventario inventarioActualizado = inventarioRepository.save(inventario);
        return ResponseEntity.ok(inventarioActualizado);
    }

    // Eliminar Inventario
    @DeleteMapping("/inventario/{id}")
    public ResponseEntity<Map<String, Boolean>> eliminarInventario(@PathVariable Long id) {
        Inventario inventario = inventarioRepository.findById(id)
                 .orElseThrow(() -> new ResourceNotFoundException("el usuario con ese ID  no existe : " + id));

        inventarioRepository.delete(inventario);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
