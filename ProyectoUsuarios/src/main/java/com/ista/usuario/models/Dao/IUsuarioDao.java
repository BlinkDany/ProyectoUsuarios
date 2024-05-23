package com.ista.usuario.models.Dao;

import org.springframework.data.repository.CrudRepository;

import com.ista.usuario.models.Entity.Usuario;



public interface IUsuarioDao extends CrudRepository<Usuario,Long> {

}