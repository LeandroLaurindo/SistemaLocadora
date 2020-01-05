/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.dao;

import br.com.localeader.entidades.CadCliente;
import java.util.List;

/**
 *
 * @author Leandro Laurindo
 */
public interface CadClienteDao {

    void save(CadCliente cliente);

    void update(CadCliente cliente);

    void delete(Integer id);

    CadCliente findById(Integer id);

    CadCliente buscarEntity(String jpql);
    
    List<CadCliente> findAll();
    
    
}
