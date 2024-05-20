package com.tendencias.demo.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tendencias.demo.Entity1.Usuario;
import com.tendencias.demo.Services1.IUsuarioService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;


@RestController
@RequestMapping("/api")
public class UsuarioRestController {

	@Autowired
	private IUsuarioService usuarioService;
	
	//LISTAR
	@GetMapping("/usuario")
	@Transactional(readOnly = true)
	public List<Usuario> mostrar(){
		
		return usuarioService.mostrarUsuarios();
	}
	
	//CREAAR
	@PostMapping("/usuario")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario crear(@RequestBody Usuario usuario) {
		
		return usuarioService.guardar(usuario);
	}
	
	//BUSCARID
	@GetMapping("/usuario/{idusuario}")
	public Usuario buscar(@PathVariable Long idusuario) {
		
		return usuarioService.buscarPorId(idusuario);
	}
	
	//MODIFICAR
	@PutMapping("/usuario/{idusuario}")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario modificar(@RequestBody Usuario usuario, @PathVariable Long idusuario) {
		
		Usuario usuarioActual = usuarioService.buscarPorId(idusuario);
		usuarioActual.setNombre(usuario.getNombre());
		usuarioActual.setClave(usuario.getClave());
		usuarioActual.setEmail(usuario.getEmail());
		usuarioActual.setEstado(usuario.isEstado());
		
		return usuarioService.guardar(usuario);
	}
	
	//ELIMINAR
	@DeleteMapping("/usaurio/{idusuario}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long idusuario) {
		
		usuarioService.eliminar(idusuario);
	}
}
