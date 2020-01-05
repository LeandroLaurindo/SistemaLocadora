/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.service;

import br.com.localeader.entidades.CadFuncionarios;
import java.util.List;

/**
 *
 * @author Leandro Laurindo
 */
public interface CadFuncionariosService {
    
    void salvar(CadFuncionarios funcionarios);

    void editar(CadFuncionarios funcionarios);

    void excluir(Integer id);

    CadFuncionarios buscarPorId(Integer id);
    
    CadFuncionarios buscarPorIdUsuario(Integer id);

    CadFuncionarios buscarPorCnpj(String cnpj);

    CadFuncionarios buscarPorCpf(Integer cpf);

    List<CadFuncionarios> buscarTodos();
}
