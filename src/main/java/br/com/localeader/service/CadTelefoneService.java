/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.service;

import br.com.localeader.model.CadTelefone;
import java.util.List;

/**
 *
 * @author Leandro Laurindo
 */
public interface CadTelefoneService {

    void salvar(CadTelefone telefone);

    void editar(CadTelefone telefone);

    void excluir(Integer id);

    CadTelefone buscarPorId(Integer id);

    CadTelefone buscarPorTelefone(String login);

    CadTelefone buscarPorCpf(String cpf);
    
    CadTelefone buscarPorCnpj(String cnpj);
    
    List<CadTelefone> buscarTodos();

}
