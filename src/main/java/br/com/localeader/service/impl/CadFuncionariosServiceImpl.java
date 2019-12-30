/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.service.impl;

import br.com.localeader.dao.CadFuncionariosDao;
import br.com.localeader.model.CadFuncionarios;
import br.com.localeader.service.CadFuncionariosService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Leandro Laurindo
 */
@Service
@Transactional(readOnly = true)
public class CadFuncionariosServiceImpl implements CadFuncionariosService{
    
    @Autowired
    private CadFuncionariosDao dao;

    @Override
    public void salvar(CadFuncionarios funcionarios) {
        salvar(funcionarios);
    }

    @Override
    public void editar(CadFuncionarios funcionarios) {
        dao.update(funcionarios);
    }

    @Override
    public void excluir(Integer id) {
        dao.delete(id);
    }

    @Override
    @Transactional(readOnly = true)
    public CadFuncionarios buscarPorId(Integer id) {
      return dao.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public CadFuncionarios buscarPorIdUsuario(Integer id) {
        String jpql = "SELECT c FROM CadFuncionarios c WHERE c.usuarioFk.idUsuario ='" + id + "'";
        return dao.buscarEntity(jpql);
    }

    @Override
    @Transactional(readOnly = true)
    public CadFuncionarios buscarPorCnpj(String cnpj) {
        String jpql = "SELECT c FROM CadFuncionarios c WHERE c.documentoFk.cnpj ='" + cnpj + "'";
        return dao.buscarEntity(jpql);
    }

    @Override
    @Transactional(readOnly = true)
    public CadFuncionarios buscarPorCpf(Integer cpf) {
        String jpql = "SELECT c FROM CadFuncionarios c WHERE c.documentoFk.cpf ='" + cpf + "'";
        return dao.buscarEntity(jpql);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CadFuncionarios> buscarTodos() {
        return dao.findAll();
    }
}
