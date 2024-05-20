package com.tendencias.demo.Dao1;

import org.springframework.data.repository.CrudRepository;

import com.tendencias.demo.Entity1.Usuario;

public interface IUsuarioDao extends CrudRepository<Usuario, Long>{

}
