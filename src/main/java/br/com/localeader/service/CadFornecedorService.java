/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.service;

import br.com.localeader.model.CadFornecedor;
import java.util.List;

/**
 *
 * @author Leandro Laurindo
 */
public interface CadFornecedorService {
     
    void salvar(CadFornecedor fornecedor);

    void editar(CadFornecedor fornecedor);

    void excluir(Integer id);

    CadFornecedor buscarPorId(Integer id);

    CadFornecedor buscarPorCnpj(String cnpj);

    CadFornecedor buscarPorCpf(Integer cpf);

    List<CadFornecedor> buscarTodos();
}
