/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.service.impl;

import br.com.localeader.dao.CadClienteDao;
import br.com.localeader.model.CadCliente;
import br.com.localeader.service.CadClienteService;
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
public class CadClienteServiceImpl implements CadClienteService {

    @Autowired
    CadClienteDao dao;

    @Override
    public void salvar(CadCliente cliente) {
        dao.save(cliente);
    }

    @Override
    public void editar(CadCliente cliente) {
        dao.update(cliente);
    }

    @Override
    public void excluir(Integer id) {
        dao.delete(id);
    }

    @Override
    @Transactional(readOnly = true)
    public CadCliente buscarPorId(Integer id) {
        return dao.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public CadCliente buscarPorDoCpf(String cpf) {
        String jpql = "SELECT c FROM CadCliente c WHERE c.documentoFk.cpf ='" + cpf + "'";
        return dao.buscarEntity(jpql);
    }

    @Override
    @Transactional(readOnly = true)
    public CadCliente buscarPorDoCnpj(String cnpj) {
        String jpql = "SELECT c FROM CadCliente c WHERE c.documentoFk.cnpj ='" + cnpj + "'";
        return dao.buscarEntity(jpql);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CadCliente> buscarTodos() {
      return dao.findAll();
    }

}
