/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.service.impl;

import br.com.localeader.dao.CadTelefoneDao;
import br.com.localeader.model.CadTelefone;
import br.com.localeader.service.CadTelefoneService;
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
public class CadTelefoneServiceImpl implements CadTelefoneService {

    @Autowired
    private CadTelefoneDao dao;

    @Override
    public void salvar(CadTelefone telefone) {
        dao.save(telefone);
    }

    @Override
    public void editar(CadTelefone telefone) {
        dao.update(telefone);
    }

    @Override
    public void excluir(Integer id) {
        dao.delete(id);
    }

    @Override
    @Transactional(readOnly = true)
    public CadTelefone buscarPorId(Integer id) {
        return dao.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public CadTelefone buscarPorTelefone(String telefone) {
        String jpql = "SELECT c FROM CadTelefone c WHERE c.email ='" + telefone + "'";
        return dao.buscarEntity(jpql);
    }

    @Override
    @Transactional(readOnly = true)
    public CadTelefone buscarPorCpf(String cpf) {
        String jpql = "SELECT c FROM CadTelefone c WHERE c.documentoFk.cpf ='" + cpf + "'";
        return dao.buscarEntity(jpql);
    }

    @Override
    @Transactional(readOnly = true)
    public CadTelefone buscarPorCnpj(String cnpj) {
        String jpql = "SELECT c FROM CadTelefone c WHERE c.documentoFk.cnpj ='" + cnpj + "'";
        return dao.buscarEntity(jpql);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CadTelefone> buscarTodos() {
        return dao.findAll();
    }

}
