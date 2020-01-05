/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.dao;

import br.com.localeader.entidades.CadHabilitacao;
import java.util.List;

/**
 *
 * @author Leandro Laurindo
 */
public interface CadHabilitacaoDao {

    void save(CadHabilitacao habilitacao);

    void update(CadHabilitacao habilitacao);

    void delete(Integer id);

    CadHabilitacao findById(Integer id);

    CadHabilitacao buscarEntity(String jql);
    
    List<CadHabilitacao> findAll();
    
    
}
