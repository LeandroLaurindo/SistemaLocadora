/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.service;

import br.com.localeader.entidades.CadVendedor;
import java.util.List;

/**
 *
 * @author Leandro Laurindo
 */
public interface CadVendedorService {
    
    void salvar(CadVendedor vendedor);

    void editar(CadVendedor vendedor);

    void excluir(Integer id);

    CadVendedor buscarPorId(Integer id);

    CadVendedor buscarPorIdUsuario(Integer isUsuario);

    CadVendedor buscarPorCpf(String cpf);

    List<CadVendedor> buscarTodos();
    
    public boolean existeVendedor(String cpf, String cnpj);
}
