/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.service.impl;

import br.com.localeader.dao.CadHabilitacaoDao;
import br.com.localeader.model.CadHabilitacao;
import br.com.localeader.service.CadHabilitacaoService;
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
public class CadHabilitacaoServiceImpl implements CadHabilitacaoService {
    
    @Autowired
    private CadHabilitacaoDao dao;
    
    @Override
    public void salvar(CadHabilitacao habilitacao) {
        dao.save(habilitacao);
    }
    
    @Override
    public void editar(CadHabilitacao habilitacao) {
        dao.update(habilitacao);
    }
    
    @Override
    public void excluir(Integer id) {
        dao.delete(id);
    }
    
    @Override
    @Transactional(readOnly = true)
    public CadHabilitacao buscarPorId(Integer id) {
        return dao.findById(id);
    }
    
    @Override
    @Transactional(readOnly = true)
    public CadHabilitacao buscarPorCnh(String cnh) {
        String jpql = "SELECT c FROM CadHabilitacao c WHERE c.cnh ='" + cnh + "'";
        return dao.buscarEntity(jpql);
    }
    
    @Override
    @Transactional(readOnly = true)
    public CadHabilitacao buscarPorNumRegistro(String numRegistro) {
        String jpql = "SELECT c FROM CadHabilitacao c WHERE c.numRegistro ='" + numRegistro + "'";
        return dao.buscarEntity(jpql);
    }
    
    @Override
    @Transactional(readOnly = true)
    public CadHabilitacao buscarPorCnpj(String cnpj) {
        String jpql = "SELECT c FROM CadHabilitacao c WHERE c.documentoFk.cnpj ='" + cnpj + "'";
        return dao.buscarEntity(jpql);
    }
    
    @Override
    @Transactional(readOnly = true)
    public CadHabilitacao buscarPorCpf(Integer cpf) {
        String jpql = "SELECT c FROM CadHabilitacao c WHERE c.documentoFk.cpf ='" + cpf + "'";
        return dao.buscarEntity(jpql);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<CadHabilitacao> buscarTodos() {
        return dao.findAll();
    }
    
}
