/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.dao;

import br.com.localeader.entidades.CadEndereco;
import java.util.List;

/**
 *
 * @author Leandro Laurindo
 */
public interface CadEnderecoDao {

    void save(CadEndereco endereco);

    void update(CadEndereco endereco);

    void delete(Integer id);

    CadEndereco findById(Integer id);

    CadEndereco buscarEntity(String jpql);
    
    
    List<CadEndereco> findAll();
    
    
}
