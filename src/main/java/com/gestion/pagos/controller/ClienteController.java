/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gestion.pagos.controller;

import com.gestion.pagos.exception.ResourceNotFoundException;
import com.gestion.pagos.model.Usuarios;
import com.gestion.pagos.repository.UsuarioRepository;



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



/**
 *
 * @author illim
 */
@CrossOrigin(origins = "http://localhost:5173/")
@RestController
@RequestMapping("/api/v1")
public class ClienteController {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/usuarios")
    public List<Usuarios> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    @PostMapping("/usuarios")
    public Usuarios guardarUsuarios(@RequestBody Usuarios usuario) {
        return usuarioRepository.save(usuario);
    }

    @GetMapping("/usuarios/{id}")
    public ResponseEntity<Usuarios> listarClientePorId(@PathVariable Long id) {
        
        Usuarios usuario = usuarioRepository.findById(id)
                 .orElseThrow(() -> new ResourceNotFoundException("el usuario con ese ID  no existe : " + id));
        return ResponseEntity.ok(usuario);
    }
    
    @PutMapping("/usuarios/{id}")
    
    public ResponseEntity<Usuarios> actualizarUsuario(@PathVariable Long id,@RequestBody Usuarios usuarioRequest){
        Usuarios usuario = usuarioRepository.findById(id)
                 .orElseThrow(() -> new ResourceNotFoundException("el cliente con ese ID  no existe : " + id));
        
        usuario.setNombre(usuarioRequest.getNombre());
        usuario.setApellidos(usuarioRequest.getApellidos());
        usuario.setEmail(usuarioRequest.getEmail());
        usuario.setPassword(usuarioRequest.getPassword());
        usuario.setDireccion(usuarioRequest.getDireccion());
        usuario.setTelefono(usuarioRequest.getTelefono());
        usuario.setSaldo(usuarioRequest.getSaldo());
        
        Usuarios usuarioActualizado = usuarioRepository.save(usuario);
        return ResponseEntity.ok(usuarioActualizado);
    
    }
    
@PutMapping("/usuarios/{id}/descontarSaldo")
public ResponseEntity<Usuarios> descontarSaldo(@PathVariable Long id, @RequestBody Map<String, Float> payload) {
    Float totalPedido = payload.get("totalPedido");
    Usuarios usuario = usuarioRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado con ID: " + id));
    
    usuario.setSaldo(usuario.getSaldo() - totalPedido);
    Usuarios usuarioActualizado = usuarioRepository.save(usuario);
    return ResponseEntity.ok(usuarioActualizado);
}

        
    @DeleteMapping("/usuarios/{id}")
    public ResponseEntity<Map<String,Boolean>> eliminarUsuarios(@PathVariable Long id){
        Usuarios usuario = usuarioRepository.findById(id)
                 .orElseThrow(() -> new ResourceNotFoundException("el usuario con ese ID  no existe : " + id));
        
        usuarioRepository.delete(usuario);
        Map<String,Boolean> response = new HashMap<>();
        response.put("deleted",Boolean.TRUE);
        return ResponseEntity.ok(response);
    
    }

}