package com.tendencias.demo.Services1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tendencias.demo.Dao1.IUsuarioDao;
import com.tendencias.demo.Entity1.Usuario;

import jakarta.transaction.Transactional;

@Service
public class UsuarioServiceImpl implements IUsuarioService{

	@Autowired
	private IUsuarioDao usuarioDao;
	
	@Override
	public List<Usuario> mostrarUsuarios() {
		// TODO Auto-generated method stub
		return (List<Usuario>) usuarioDao.findAll();
	}

	@Override
	@Transactional
	public Usuario guardar(Usuario usuario) {
		// TODO Auto-generated method stub
		return usuarioDao.save(usuario);
	}

	@Override
	public Usuario buscarPorId(Long idusuario) {
		// TODO Auto-generated method stub
		return usuarioDao.findById(idusuario).orElse(null);
	}

	@Override
	public void eliminar(Long idusuario) {
		// TODO Auto-generated method stub
		usuarioDao.deleteById(idusuario);
	}

}
