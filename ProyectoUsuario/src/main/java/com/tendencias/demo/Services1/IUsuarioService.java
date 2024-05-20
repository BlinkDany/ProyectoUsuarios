package com.tendencias.demo.Services1;

import java.util.List;

import com.tendencias.demo.Entity1.Usuario;

public interface IUsuarioService {

	public List<Usuario> mostrarUsuarios();
	
	public Usuario guardar(Usuario usuario);
	
	public Usuario buscarPorId(Long idusuario);
	
	public void eliminar (Long idusuario);
}
