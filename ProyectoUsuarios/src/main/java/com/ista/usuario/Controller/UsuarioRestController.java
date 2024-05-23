package com.ista.usuario.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ista.usuario.models.Entity.Usuario;
import com.ista.usuario.models.Service.IUsuarioService;


@RestController
@RequestMapping("/api")
public class UsuarioRestController {

	@Autowired
	private IUsuarioService usuarioservice;

	@GetMapping("/usuario")
	public List<Usuario> indext() {
		return usuarioservice.findAll();

	}
	
    @GetMapping("/usuario/{id}")
    public Usuario show(@PathVariable Long id) {
    	return usuarioservice.findById(id);
    }
    
    @PostMapping("/usuario")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario create(@RequestBody Usuario id) {
    	return usuarioservice.save(id);
    }
    
    @PutMapping("/usuario/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario update(@RequestBody Usuario usuario, @PathVariable Long id) {
    	Usuario usuarioactual = usuarioservice.findById(id);
    	usuarioactual.setNombre(usuario.getNombre());
    	usuarioactual.setClave(usuario.getClave());
    	usuarioactual.setEmail(usuario.getEmail());
    	usuarioactual.setEstado(usuario.getEstado());
    	return usuarioservice.save(usuarioactual);
    }
    
    @DeleteMapping("/usuario/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
    	usuarioservice.delete(id);
    }
    
    
    
}
