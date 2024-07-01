package com.gestion.pagos.controller;

import com.gestion.pagos.repository.CategoriasRepository;

import com.gestion.pagos.model.Categorias;
import com.gestion.pagos.exception.ResourceNotFoundException;

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

public class CategoriasController {
    
       @Autowired
    private CategoriasRepository categoriasRepository;

    // Listar Productos
    @GetMapping("/categorias")
    public List<Categorias> listarProductos() {
        return categoriasRepository.findAll();
    }

    // Guardar Productos
    @PostMapping("/categorias")
    public Categorias guardarCategorias(@RequestBody Categorias categorias) {
        return categoriasRepository.save(categorias);
    }

    // Listar un producto por id
    @GetMapping("/categorias/{id}")
    public ResponseEntity<Categorias> listarProductoPorId(@PathVariable long id) {
        Categorias categorias = categoriasRepository.findById(id)
 .orElseThrow(() -> new ResourceNotFoundException("el usuario con ese ID  no existe : " + id));        return ResponseEntity.ok(categorias);
    }
    
    
     // Actualizar Productos
    @PutMapping("/categorias/{id}")
    public ResponseEntity<Categorias> actualizarProductos(@PathVariable Long id, @RequestBody Categorias categoriasRequest) {
        Categorias categorias = categoriasRepository.findById(id)
 .orElseThrow(() -> new ResourceNotFoundException("el usuario con ese ID  no existe : " + id));
        categorias.setNombre(categoriasRequest.getNombre());
        categorias.setDescripcion(categoriasRequest.getDescripcion());
        
        Categorias categoriaActualizado = categoriasRepository.save(categorias);
        return ResponseEntity.ok(categoriaActualizado);
    }

    // Eliminar Productos
    @DeleteMapping("/categoria/{id}")
    public ResponseEntity<Map<String, Boolean>> eliminarProductos(@PathVariable Long id) {
        Categorias categorias = categoriasRepository.findById(id)
 .orElseThrow(() -> new ResourceNotFoundException("el usuario con ese ID  no existe : " + id));
        categoriasRepository.delete(categorias);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
    
}
