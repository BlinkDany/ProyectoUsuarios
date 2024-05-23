package com.ista.usuario.models.Service;

import java.util.List;

import com.ista.usuario.models.Entity.Usuario;



public interface IUsuarioService {
	
	public List<Usuario> findAll();

	public Usuario save(Usuario id);
	
	public Usuario findById(Long id);

	public void delete (Long id);

}
