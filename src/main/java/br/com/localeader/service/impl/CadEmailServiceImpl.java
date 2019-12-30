/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.service.impl;

import br.com.localeader.dao.CadEmailDao;
import br.com.localeader.model.CadEmail;
import br.com.localeader.service.CadEmailService;
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
public class CadEmailServiceImpl implements CadEmailService{

    @Autowired
    private CadEmailDao dao;
    
    @Override
    public void salvar(CadEmail email) {
        dao.save(email);
                }

    @Override
    public void editar(CadEmail email) {
        dao.update(email);
    }

    @Override
    public void excluir(Integer id) {
        dao.delete(id);
    }

    @Override
    @Transactional(readOnly = true)
    public CadEmail buscarPorId(Integer id) {
        return dao.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public CadEmail buscarPorEmail(String email) {
      String jpql = "SELECT c FROM CadEmail c WHERE c.email ='" + email + "'";
        return dao.buscarEntity(jpql);  
    }

    @Override
    @Transactional(readOnly = true)
    public CadEmail buscarPorIdUsuario(Integer id) {
        String jpql = "SELECT c FROM CadEmail c WHERE c.usuarioFk.idUsuario ='" + id + "'";
        return dao.buscarEntity(jpql);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CadEmail> buscarTodos() {
       return dao.findAll();
    }
    
}
