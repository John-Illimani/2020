
package com.gestion.pagos.controller;


import com.gestion.pagos.exception.ResourceNotFoundException;
import com.gestion.pagos.model.DetalleProducto;
import com.gestion.pagos.repository.DetallesProductoRepository;

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

public class DetalleProductoController {
    @Autowired
    private DetallesProductoRepository detallesProductoRepository;

    // Listar Productos
    @GetMapping("/detalleProducto")
    public List<DetalleProducto> listarDetalleProducto() {
        return detallesProductoRepository.findAll();
    }

    // Guardar Productos
    @PostMapping("/detalleProducto")
    public DetalleProducto guardarDetalleProducto(@RequestBody DetalleProducto detalleProducto) {
        return detallesProductoRepository.save(detalleProducto);
    }

    // Listar un producto por id
    @GetMapping("/detalleProducto/{id}")
    public ResponseEntity<DetalleProducto> listarDetalleProductoPorId(@PathVariable long id) {
        DetalleProducto detalleProducto = detallesProductoRepository.findById(id)
                 .orElseThrow(() -> new ResourceNotFoundException("el usuario con ese ID  no existe : " + id));
        return ResponseEntity.ok(detalleProducto);
    }
    
    
     // Actualizar Productos
    @PutMapping("/detalleProducto/{id}")
    public ResponseEntity<DetalleProducto> actualizarDetalle(@PathVariable Long id, @RequestBody DetalleProducto detalleProductoRequest) {
        DetalleProducto detalleProducto = detallesProductoRepository.findById(id)
                 .orElseThrow(() -> new ResourceNotFoundException("el usuario con ese ID  no existe : " + id));

        detalleProducto.setCantidad(detalleProductoRequest.getCantidad());
        detalleProducto.setPrecioUnitario(detalleProductoRequest.getPrecioUnitario());

        DetalleProducto detalleActualizado = detallesProductoRepository.save(detalleProducto);
        return ResponseEntity.ok(detalleActualizado);
    }

    // Eliminar Productos
    @DeleteMapping("/detalleProducto/{id}")
    public ResponseEntity<Map<String, Boolean>> eliminarDetalle(@PathVariable Long id) {
        DetalleProducto detalleProducto = detallesProductoRepository.findById(id)
                 .orElseThrow(() -> new ResourceNotFoundException("el usuario con ese ID  no existe : " + id));

        detallesProductoRepository.delete(detalleProducto);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
