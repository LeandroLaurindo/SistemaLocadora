/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.service.impl;

import br.com.localeader.dao.CadVendedorDao;
import br.com.localeader.entidades.CadVendedor;
import br.com.localeader.service.CadVendedorService;
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
public class CadVendedorServiceImpl implements CadVendedorService {

    @Autowired
    private CadVendedorDao dao;

    @Override
    public void salvar(CadVendedor vendedor) {
        dao.save(vendedor);
    }

    @Override
    public void editar(CadVendedor vendedor) {
        dao.update(vendedor);
    }

    @Override
    public void excluir(Integer id) {
        dao.delete(id);
    }

    @Override
    @Transactional(readOnly = true)
    public CadVendedor buscarPorId(Integer id) {
        return dao.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public CadVendedor buscarPorIdUsuario(Integer isUsuario) {
        String jpql = "SELECT c FROM CadVendedor c WHERE c.usuarioFk.idUsuario ='" + isUsuario + "'";
        return dao.buscarEntity(jpql);
    }

    @Override
    @Transactional(readOnly = true)
    public CadVendedor buscarPorCpf(String cpf) {
        String jpql = "SELECT c FROM CadVendedor c WHERE c.documentoFk.cpf ='" + cpf + "'";
        return dao.buscarEntity(jpql);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CadVendedor> buscarTodos() {
        return dao.findAll();
    }

    @Override
    public boolean existeVendedor(String cpf, String cnpj) {
        boolean retorno = false;
        if (!cnpj.isEmpty()) {
            String jpql = "SELECT c FROM CadVendedor c WHERE c.documentoFk.cnpj ='" + cnpj + "'";
            retorno = dao.buscarEntity(jpql).getIdVendedor()!= null;
        }
        if (!cpf.isEmpty()) {
            String jpql = "SELECT c FROM CadVendedor c WHERE c.documentoFk.cpf ='" + cpf + "'";
            retorno = dao.buscarEntity(jpql).getIdVendedor()!= null;
        }
        return retorno;
    }
}