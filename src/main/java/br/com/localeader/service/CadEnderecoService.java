/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.service;

import br.com.localeader.entidades.CadEndereco;
import java.util.List;

/**
 *
 * @author Leandro Laurindo
 */
public interface CadEnderecoService {
     
    void salvar(CadEndereco endereco);

    void editar(CadEndereco endereco);

    void excluir(Integer id);

    CadEndereco buscarPorId(Integer id);

    CadEndereco buscarPorEndereco(String endereco);

    CadEndereco buscarPorIdUsuario(Integer id);

    List<CadEndereco> buscarTodos();
}
