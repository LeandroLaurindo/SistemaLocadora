/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.service;

import br.com.localeader.entidades.CadPessoa;
import java.util.List;

/**
 *
 * @author Leandro Laurindo
 */
public interface CadPessoaService {

    void salvar(CadPessoa pessoa);

    void editar(CadPessoa pessoa);

    void excluir(Integer id);

    CadPessoa buscarPorId(Integer id);

    CadPessoa buscarPorIdUsuario(Integer id);

    CadPessoa buscarPorProfissao(String profissao);

    CadPessoa buscarPorRazaoSocial(String razaoSocial);

    CadPessoa buscarPorNome(String nome);

    CadPessoa buscarPorNumRegistro(String numRegistro);

    List<CadPessoa> buscarTodos();
}
