/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.service;

import br.com.localeader.entidades.CadCliente;
import java.util.List;

/**
 *
 * @author Leandro Laurindo
 */
public interface CadClienteService {

    void salvar(CadCliente cliente);

    void editar(CadCliente cliente);

    void excluir(Integer id);

    CadCliente buscarPorId(Integer id);

    CadCliente buscarPorDoCpf(String cpf);

    CadCliente buscarPorDoCnpj(String cpf);

    List<CadCliente> buscarTodos();

    public boolean existeCliente(String cpf, String cnpj);

}
