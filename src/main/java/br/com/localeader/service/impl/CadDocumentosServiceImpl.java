/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.service.impl;

import br.com.localeader.dao.CadDocumentosDao;
import br.com.localeader.model.CadDocumentos;
import br.com.localeader.service.CadDocumentosService;
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
public class CadDocumentosServiceImpl implements CadDocumentosService {

    @Autowired
    private CadDocumentosDao dao;

    @Override
    public void salvar(CadDocumentos documentos) {
        dao.save(documentos);
    }

    @Override
    public void editar(CadDocumentos documentos) {
        dao.save(documentos);
    }

    @Override
    public void excluir(Integer id) {
        dao.delete(id);
    }

    @Override
    @Transactional(readOnly = true)
    public CadDocumentos buscarPorId(Integer id) {
        return dao.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public CadDocumentos buscarPorCpf(String cpf) {
        String jpql = "SELECT c from CadDocumentos c WHERE c.cpf ='" + cpf + "'";
        return dao.buscarEntity(jpql);
    }

    @Override
    @Transactional(readOnly = true)
    public CadDocumentos buscarPorDoCnpj(String cnpj) {
        String jpql = "SELECT c from CadDocumentos c WHERE c.cpf ='" + cnpj + "'";
        return dao.buscarEntity(jpql);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CadDocumentos> buscarTodos() {
        return dao.findAll();
    }

}
