/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.service.impl;

import br.com.localeader.dao.CadFornecedorDao;
import br.com.localeader.entidades.CadFornecedor;
import br.com.localeader.service.CadFornecedorService;
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
public class CadFornecedorServiceImpl implements  CadFornecedorService{
    
    @Autowired
    private CadFornecedorDao dao;

    @Override
    public void salvar(CadFornecedor fornecedor) {
        dao.save(fornecedor);
    }

    @Override
    public void editar(CadFornecedor fornecedor) {
        dao.update(fornecedor);
    }

    @Override
    public void excluir(Integer id) {
        dao.delete(id);
    }

    @Override
    @Transactional(readOnly = true)
    public CadFornecedor buscarPorId(Integer id) {
       return dao.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public CadFornecedor buscarPorCnpj(String cnpj) {
        String jpql = "SELECT c FROM CadFornecedor c WHERE c.documentoFk.cnpj ='" + cnpj + "'";
        return dao.buscarEntity(jpql);
    }

    @Override
    @Transactional(readOnly = true)
    public CadFornecedor buscarPorCpf(Integer cpf) {
        String jpql = "SELECT c FROM CadFornecedor c WHERE c.documentoFk.cpf ='" + cpf + "'";
        return dao.buscarEntity(jpql);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CadFornecedor> buscarTodos() {
        return dao.findAll();
    }
    
    
}
