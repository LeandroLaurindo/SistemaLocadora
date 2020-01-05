/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.service.impl;

import br.com.localeader.dao.CadPessoaDao;
import br.com.localeader.entidades.CadPessoa;
import br.com.localeader.service.CadPessoaService;
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
public class CadPessoaServiceImpl implements CadPessoaService{
    
    @Autowired
    private CadPessoaDao dao;

    @Override
    public void salvar(CadPessoa pessoa) {
       dao.save(pessoa);
    }

    @Override
    public void editar(CadPessoa pessoa) {
        dao.update(pessoa);
    }

    @Override
    public void excluir(Integer id) {
        dao.delete(id);
    }

    @Override
    @Transactional(readOnly = true)
    public CadPessoa buscarPorId(Integer id) {
        return dao.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public CadPessoa buscarPorIdUsuario(Integer id) {
        String jpql = "SELECT c FROM CadPessoa c WHERE c.usuarioFk.idUsuario ='" + id + "'";
        return dao.buscarEntity(jpql);
    }

    @Override
    @Transactional(readOnly = true)
    public CadPessoa buscarPorProfissao(String profissao) {
        String jpql = "SELECT c FROM CadPessoa c WHERE c.profissao ='" + profissao + "'";
        return dao.buscarEntity(jpql);
    }

    @Override
    @Transactional(readOnly = true)
    public CadPessoa buscarPorRazaoSocial(String razaoSocial) {
        String jpql = "SELECT c FROM CadPessoa c WHERE c.razaoSocial ='" + razaoSocial + "'";
        return dao.buscarEntity(jpql);
    }

    @Override
    @Transactional(readOnly = true)
    public CadPessoa buscarPorNome(String nome) {
        String jpql = "SELECT c FROM CadPessoa c WHERE c.nome ='" + nome + "'";
        return dao.buscarEntity(jpql);
    }

    @Override
    @Transactional(readOnly = true)
    public CadPessoa buscarPorNumRegistro(String numRegistro) {
        String jpql = "SELECT c FROM CadPessoa c WHERE c.numRegistro ='" + numRegistro + "'";
        return dao.buscarEntity(jpql);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CadPessoa> buscarTodos() {
        return dao.findAll();
    }
    
    
}
