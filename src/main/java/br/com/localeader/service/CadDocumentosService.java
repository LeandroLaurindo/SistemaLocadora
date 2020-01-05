/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.service;

import br.com.localeader.entidades.CadDocumentos;
import java.util.List;

/**
 *
 * @author Leandro Laurindo
 */
public interface CadDocumentosService {

    void salvar(CadDocumentos documentos);

    void editar(CadDocumentos documentos);

    void excluir(Integer id);

    CadDocumentos buscarPorId(Integer id);

    CadDocumentos buscarPorCpf(String cpf);

    CadDocumentos buscarPorDoCnpj(String cnpj);

    List<CadDocumentos> buscarTodos();
}
