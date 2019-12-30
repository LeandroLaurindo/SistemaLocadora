/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.dao;

import br.com.localeader.model.CadFuncionarios;
import java.util.List;

/**
 *
 * @author Leandro Laurindo
 */
public interface CadFuncionariosDao {

    void save(CadFuncionarios funcionario);

    void update(CadFuncionarios funcionario);

    void delete(Integer id);

    CadFuncionarios findById(Integer id);

    CadFuncionarios buscarEntity(String jpql);
    
    List<CadFuncionarios> findAll();
    
    
}
