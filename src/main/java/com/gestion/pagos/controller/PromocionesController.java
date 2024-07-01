
package com.gestion.pagos.controller;


import com.gestion.pagos.exception.ResourceNotFoundException;
import com.gestion.pagos.model.Promociones;
import com.gestion.pagos.repository.PromocionesRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:5173/")
@RestController
@RequestMapping("/api/v1")

public class PromocionesController {
        
    @Autowired
    private PromocionesRepository promocionesRepository;

    // Listar Productos
    @GetMapping("/promociones")
    public List<Promociones> listarPromociones() {
        return promocionesRepository.findAll();
    }

    // Guardar Productos
    @PostMapping("/promociones")
    public Promociones guardarPromociones(@RequestBody Promociones promociones) {
        return promocionesRepository.save(promociones);
    }

    // Listar un producto por id
    @GetMapping("/promociones/{id}")
    public ResponseEntity<Promociones> listarProductoPorId(@PathVariable long id) {
        Promociones promociones = promocionesRepository.findById(id)
                 .orElseThrow(() -> new ResourceNotFoundException("el usuario con ese ID  no existe : " + id));
        return ResponseEntity.ok(promociones);
    }
    
     // Actualizar Productos
    @PutMapping("/promociones/{id}")
    public ResponseEntity<Promociones> actualizarPromociones(@PathVariable Long id, @RequestBody Promociones promocionesRequest) {
        Promociones promociones = promocionesRepository.findById(id)
                 .orElseThrow(() -> new ResourceNotFoundException("el usuario con ese ID  no existe : " + id));

        promociones.setDescripcion(promocionesRequest.getDescripcion());
        promociones.setDescuento(promocionesRequest.getDescuento());
        promociones.setFechaInicio(promocionesRequest.getFechaInicio());
        promociones.setFechaFin(promocionesRequest.getFechaFin());

        Promociones promocionesActualizado = promocionesRepository.save(promociones);
        return ResponseEntity.ok(promocionesActualizado);
    }

    // Eliminar Productos
    @DeleteMapping("/promociones/{id}")
    public ResponseEntity<Map<String, Boolean>> eliminarPromociones(@PathVariable Long id) {
        Promociones promociones = promocionesRepository.findById(id)
                 .orElseThrow(() -> new ResourceNotFoundException("el usuario con ese ID  no existe : " + id));

        promocionesRepository.delete(promociones);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
    // Copiar Promoción
    @PostMapping("/promociones/copiar/{id}")
    public ResponseEntity<Promociones> copiarPromocion(@PathVariable Long id) {
        Promociones promocionOriginal = promocionesRepository.findById(id)
                 .orElseThrow(() -> new ResourceNotFoundException("el usuario con ese ID  no existe : " + id));

        Promociones promocionCopiada = new Promociones();
        promocionCopiada.setDescripcion(promocionOriginal.getDescripcion());
        promocionCopiada.setDescuento(promocionOriginal.getDescuento());
        promocionCopiada.setFechaInicio(promocionOriginal.getFechaInicio());
        promocionCopiada.setFechaFin(promocionOriginal.getFechaFin());

        Promociones nuevaPromocion = promocionesRepository.save(promocionCopiada);
        return ResponseEntity.ok(nuevaPromocion);
    }

    // Eliminar Promoción Copiada
    @DeleteMapping("/promociones/copiar/{id}")
    public ResponseEntity<Map<String, Boolean>> eliminarPromocionCopiada(@PathVariable Long id) {
        Promociones promocionCopiada = promocionesRepository.findById(id)
                 .orElseThrow(() -> new ResourceNotFoundException("el usuario con ese ID  no existe : " + id));

        promocionesRepository.delete(promocionCopiada);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
