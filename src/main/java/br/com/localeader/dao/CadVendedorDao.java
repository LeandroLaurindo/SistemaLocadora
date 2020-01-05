/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.dao;

import br.com.localeader.entidades.CadVendedor;
import java.util.List;

/**
 *
 * @author Leandro Laurindo
 */
public interface CadVendedorDao {

    void save(CadVendedor vendedor);

    void update(CadVendedor vendedor);

    void delete(Integer id);

    CadVendedor findById(Integer id);

    List<CadVendedor> findAll();
    
    CadVendedor buscarEntity(String jpql);
}
