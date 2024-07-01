package com.gestion.pagos.controller;

import com.gestion.pagos.model.Usuarios;
import com.gestion.pagos.repository.UsuarioRepository;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import org.springframework.http.HttpStatus;

@CrossOrigin(origins = "http://localhost:5173/")
@RestController
@RequestMapping("/api/v1")
public class AuthController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/login")
public ResponseEntity<?> login(@RequestBody Usuarios loginRequest) {
    Optional<Usuarios> usuarioOptional = usuarioRepository.findByEmail(loginRequest.getEmail());

    if (usuarioOptional.isPresent()) {
        Usuarios usuario = usuarioOptional.get();
        if (usuario.getPassword().equals(loginRequest.getPassword())) {
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Login successful");
            response.put("userId", usuario.getId());
            response.put("nombre", usuario.getNombre());
            return ResponseEntity.ok(response);
        }
    }
    
    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized");
}
}