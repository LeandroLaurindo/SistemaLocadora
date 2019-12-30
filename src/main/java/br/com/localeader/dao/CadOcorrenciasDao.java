/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.dao;

import br.com.localeader.model.CadOcorrencias;
import java.util.List;

/**
 *
 * @author Leandro Laurindo
 */
public interface CadOcorrenciasDao {

    void save(CadOcorrencias ocorrencias);

    void update(CadOcorrencias ocorrencias);

    void delete(Integer id);

    CadOcorrencias findById(Integer id);
    
    CadOcorrencias buscarEntity(String jpql);
    
    List<CadOcorrencias> findAll();
    
    
}
