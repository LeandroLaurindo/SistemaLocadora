/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.dao;

import br.com.localeader.model.CadTelefone;
import java.util.List;

/**
 *
 * @author Leandro Laurindo
 */
public interface CadTelefoneDao {

    void save(CadTelefone telefone);

    void update(CadTelefone telefone);

    void delete(Integer id);

    CadTelefone findById(Integer id);

    List<CadTelefone> findAll();

    CadTelefone buscarEntity(String jpql);

}
