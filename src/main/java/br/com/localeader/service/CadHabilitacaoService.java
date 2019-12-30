/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.service;

import br.com.localeader.model.CadHabilitacao;
import java.util.List;

/**
 *
 * @author Leandro Laurindo
 */
public interface CadHabilitacaoService {
    
    void salvar(CadHabilitacao habilitacao);

    void editar(CadHabilitacao habilitacao);

    void excluir(Integer id);

    CadHabilitacao buscarPorId(Integer id);

    CadHabilitacao buscarPorCnh(String cnh);
    
    CadHabilitacao buscarPorNumRegistro(String numRegistro);

    CadHabilitacao buscarPorCnpj(String cnpj);

    CadHabilitacao buscarPorCpf(Integer cpf);
  
    List<CadHabilitacao> buscarTodos();
}
