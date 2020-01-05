/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.dao;

import br.com.localeader.entidades.CadEmail;
import java.util.List;

/**
 *
 * @author Leandro Laurindo
 */
public interface CadEmailDao {

    void save(CadEmail cliente);

    void update(CadEmail cliente);

    void delete(Integer id);

    CadEmail findById(Integer id);

    CadEmail buscarEntity(String jpql);
    
    List<CadEmail> findAll();
    
    
}
