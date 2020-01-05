/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.dao;

import br.com.localeader.entidades.CadFornecedor;
import java.util.List;

/**
 *
 * @author Leandro Laurindo
 */
public interface CadFornecedorDao {

    void save(CadFornecedor cliente);

    void update(CadFornecedor cliente);

    void delete(Integer id);

    CadFornecedor findById(Integer id);

    List<CadFornecedor> findAll();
    
    CadFornecedor buscarEntity(String jpql);
    
}
