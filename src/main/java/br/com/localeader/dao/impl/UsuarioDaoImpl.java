/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.dao.impl;

import br.com.localeader.dao.AbstractDao;
import br.com.localeader.dao.UsuarioDao;
import br.com.localeader.entidades.Usuario;
import javax.persistence.NoResultException;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Leandro Laurindo
 */
@Repository
public class UsuarioDaoImpl extends AbstractDao<Usuario, Integer> implements UsuarioDao {

    @Override
    public Usuario findByLogin(String login) {
        String jqql = "SELECT u FROM Usuario u WHERE u.login ='" + login + "'";
        try {
            return buscarEntity(jqql);
        } catch (NoResultException e) {
            return new Usuario();
        }
    }

}
