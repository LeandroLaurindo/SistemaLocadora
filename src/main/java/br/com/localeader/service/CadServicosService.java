/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.service;

import br.com.localeader.model.CadServicos;
import java.util.List;

/**
 *
 * @author Leandro Laurindo
 */
public interface CadServicosService {
    
    void salvar(CadServicos servicos);

    void editar(CadServicos servicos);

    void excluir(Integer id);

    CadServicos buscarPorId(Integer id);
    
    CadServicos buscarPorCodigoServico(Integer codigoServico);
            
    CadServicos buscarPorNomeServico(String nomeServico);
    
    List<CadServicos> buscarTodos();
}
