/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.dao;

import br.com.localeader.model.CadPessoa;
import java.util.List;

/**
 *
 * @author Leandro Laurindo
 */
public interface CadPessoaDao {

    void save(CadPessoa cliente);

    void update(CadPessoa cliente);

    void delete(Integer id);

    CadPessoa findById(Integer id);

    List<CadPessoa> findAll();
    
   CadPessoa buscarEntity(String jpql);
}
