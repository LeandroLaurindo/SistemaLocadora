/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.service.impl;

import br.com.localeader.dao.UsuarioDao;
import br.com.localeader.model.Usuario;
import br.com.localeader.service.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Leandro Laurindo
 */
@Service
@Transactional(readOnly = false)
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    private UsuarioDao dao;
    
    @Override
    public void salvar(Usuario usuario) {
      dao.save(usuario);
    }

    @Override
    public void editar(Usuario usuario) {
        dao.update(usuario);
    }

    @Override
    public void excluir(Integer id) {
        dao.delete(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario buscarPorId(Integer id) {
      return dao.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario buscarPorLogin(String login) {
        String jqql = "SELECT u FROM Usuario u WHERE u.login ='"+login+"'";
     return dao.buscarEntity(jqql);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Usuario> buscarTodos() {
        return dao.findAll();
    }
    
}
