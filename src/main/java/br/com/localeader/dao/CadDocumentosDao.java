/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.dao;

import br.com.localeader.model.CadDocumentos;
import java.util.List;

/**
 *
 * @author Leandro Laurindo
 */
public interface CadDocumentosDao {

    void save(CadDocumentos pessoa);

    void update(CadDocumentos pessoa);

    void delete(Integer id);

    CadDocumentos findById(Integer id);

    CadDocumentos buscarEntity(String jpql);
    
    List<CadDocumentos> findAll();
    
    
}
