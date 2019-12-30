/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.service;

import br.com.localeader.model.Usuario;
import java.util.List;

/**
 *
 * @author Leandro Laurindo
 */
public interface UsuarioService {
     
    void salvar(Usuario usuario);

    void editar(Usuario usuario);

    void excluir(Integer id);

    Usuario buscarPorId(Integer id);

    Usuario buscarPorLogin(String login);

    List<Usuario> buscarTodos();
}
