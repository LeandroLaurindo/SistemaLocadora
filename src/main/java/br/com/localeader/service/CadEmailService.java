/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.service;

import br.com.localeader.entidades.CadEmail;
import java.util.List;

/**
 *
 * @author Leandro Laurindo
 */
public interface CadEmailService {
    
    void salvar(CadEmail email);

    void editar(CadEmail email);

    void excluir(Integer id);

    CadEmail buscarPorId(Integer id);

    CadEmail buscarPorEmail(String email);

    CadEmail buscarPorIdUsuario(Integer id);

    List<CadEmail> buscarTodos();
}
