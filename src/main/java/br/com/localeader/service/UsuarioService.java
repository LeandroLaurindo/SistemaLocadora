/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.service;

import br.com.localeader.entidades.Usuario;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

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
    
    Page<Usuario> getPaginatedUsuarios(Pageable pageable);
    
    boolean usuarioExiste(String login);
    
    public Map<String , Object> buscarUsuarios(HttpServletRequest request);

}
