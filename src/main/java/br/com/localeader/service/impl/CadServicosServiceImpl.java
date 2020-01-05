/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.service.impl;

import br.com.localeader.dao.CadServicosDao;
import br.com.localeader.entidades.CadServicos;
import br.com.localeader.service.CadServicosService;
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
public class CadServicosServiceImpl implements CadServicosService{
    
    @Autowired
    private CadServicosDao dao;

    @Override
    public void salvar(CadServicos servicos) {
        dao.save(servicos);
    }

    @Override
    public void editar(CadServicos servicos) {
        dao.update(servicos);
    }

    @Override
    public void excluir(Integer id) {
        dao.delete(id);
    }

    @Override
    @Transactional(readOnly = true)
    public CadServicos buscarPorId(Integer id) {
        return dao.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public CadServicos buscarPorCodigoServico(Integer codigoServico) {
         String jpql = "SELECT c FROM CadServicos c WHERE c.codigoServico ='" + codigoServico + "'";
        return dao.buscarEntity(jpql);
    }

    @Override
    @Transactional(readOnly = true)
    public CadServicos buscarPorNomeServico(String nomeServico) {
         String jpql = "SELECT c FROM CadServicos c WHERE c.nomeServico ='" + nomeServico + "'";
        return dao.buscarEntity(jpql);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CadServicos> buscarTodos() {
        return dao.findAll();
    }
    
    
}
