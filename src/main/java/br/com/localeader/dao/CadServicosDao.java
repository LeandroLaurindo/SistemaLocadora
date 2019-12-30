/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.dao;

import br.com.localeader.model.CadServicos;
import java.util.List;

/**
 *
 * @author Leandro Laurindo
 */
public interface CadServicosDao {

    void save(CadServicos servicos);

    void update(CadServicos servicos);

    void delete(Integer id);

    CadServicos findById(Integer id);

    List<CadServicos> findAll();
    
    CadServicos buscarEntity(String jpql);
}
