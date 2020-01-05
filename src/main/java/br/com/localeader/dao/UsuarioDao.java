/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.dao;

import br.com.localeader.entidades.Usuario;
import java.util.List;

/**
 *
 * @author Leandro Laurindo
 */
public interface UsuarioDao {

    void save(Usuario usuario);

    void update(Usuario usuario);

    void delete(Integer id);

    Usuario findById(Integer id);

    Usuario findByLogin(String login);

    List<Usuario> findAll();

    Usuario buscarEntity(String jpql);

}
