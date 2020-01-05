/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.service.impl;

import br.com.localeader.dao.CadEmailDao;
import br.com.localeader.dao.CadEnderecoDao;
import br.com.localeader.entidades.CadEndereco;
import br.com.localeader.service.CadEnderecoService;
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
public class CadEnderecoServiceImpl implements CadEnderecoService {

    @Autowired
    private CadEnderecoDao dao;

    @Override
    public void salvar(CadEndereco endereco) {
        dao.save(endereco);
    }

    @Override
    public void editar(CadEndereco endereco) {
        dao.update(endereco);
    }

    @Override
    public void excluir(Integer id) {
        dao.delete(id);
    }

    @Override
    @Transactional(readOnly = true)
    public CadEndereco buscarPorId(Integer id) {
        return dao.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public CadEndereco buscarPorEndereco(String endereco) {
        String jpql = "SELECT c FROM CadEndereco c WHERE c.logradouro ='" + endereco + "'";
        return dao.buscarEntity(jpql);
    }

    @Override
    @Transactional(readOnly = true)
    public CadEndereco buscarPorIdUsuario(Integer id) {
        String jpql = "SELECT c FROM CadEndereco c WHERE c.usuarioFk.idUsuario ='" + id + "'";
        return dao.buscarEntity(jpql);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CadEndereco> buscarTodos() {
        return dao.findAll();
    }

}
