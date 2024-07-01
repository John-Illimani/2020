
package com.gestion.pagos.controller;


import com.gestion.pagos.exception.ResourceNotFoundException;
import com.gestion.pagos.model.Productos;
import com.gestion.pagos.repository.productoRepositorio;

import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;


@CrossOrigin(origins = "http://localhost:5173/")
@RestController
@RequestMapping("/api/v1")

public class productoController {

    @Autowired
    private productoRepositorio productoRepositorio;

    // Listar Productos
    @GetMapping("/productos")
    public List<Productos> listarProductos() {
        return productoRepositorio.findAll();
    }

    // Guardar Productos
    @PostMapping("/productos")
    public Productos guardarProductos(@RequestBody Productos productos) {
        return productoRepositorio.save(productos);
    }

    // Listar un producto por id
    @GetMapping("/productos/{id}")
    public ResponseEntity<Productos> listarProductoPorId(@PathVariable long id) {
        Productos productos = productoRepositorio.findById(id)
                 .orElseThrow(() -> new ResourceNotFoundException("el usuario con ese ID  no existe : " + id));
        return ResponseEntity.ok(productos);
    }

    // Actualizar Productos
    @PutMapping("/productos/{id}")
    public ResponseEntity<Productos> actualizarProductos(@PathVariable Long id, @RequestBody Productos productosRequest) {
        Productos productos = productoRepositorio.findById(id)
                 .orElseThrow(() -> new ResourceNotFoundException("el usuario con ese ID  no existe : " + id));

        productos.setNombre(productosRequest.getNombre());
        productos.setDescripcion(productosRequest.getDescripcion());
        productos.setPrecio(productosRequest.getPrecio());
        productos.setImagen(productosRequest.getImagen());

        Productos productosActualizado = productoRepositorio.save(productos);
        return ResponseEntity.ok(productosActualizado);
    }

    // Eliminar Productos
    @DeleteMapping("/productos/{id}")
    public ResponseEntity<Map<String, Boolean>> eliminarProductos(@PathVariable Long id) {
        Productos productos = productoRepositorio.findById(id)
                 .orElseThrow(() -> new ResourceNotFoundException("el usuario con ese ID  no existe : " + id));

        productoRepositorio.delete(productos);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
    // Copiar Producto
    @PostMapping("/productos/copiar/{id}")
    public ResponseEntity<Productos> copiarProducto(@PathVariable Long id) {
        Productos productoOriginal = productoRepositorio.findById(id)
                 .orElseThrow(() -> new ResourceNotFoundException("el usuario con ese ID  no existe : " + id));

        Productos productoCopiado = new Productos();
        productoCopiado.setNombre(productoOriginal.getNombre());
        productoCopiado.setDescripcion(productoOriginal.getDescripcion());
        productoCopiado.setPrecio(productoOriginal.getPrecio());
        productoCopiado.setImagen(productoOriginal.getImagen());

        Productos nuevoProducto = productoRepositorio.save(productoCopiado);
        return ResponseEntity.ok(nuevoProducto);
    }

    // Eliminar Producto Copiado
    @DeleteMapping("/productos/copiar/{id}")
    public ResponseEntity<Map<String, Boolean>> eliminarProductoCopiado(@PathVariable Long id) {
        Productos productoCopiado = productoRepositorio.findById(id)
                 .orElseThrow(() -> new ResourceNotFoundException("el usuario con ese ID  no existe : " + id));

        productoRepositorio.delete(productoCopiado);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
