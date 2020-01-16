/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.service;

import br.com.localeader.entidades.Usuario;
import br.com.localeader.repositories.UsuarioRepository;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 *
 * @author Leandro Laurindo
 */
@Service
public class UsuarioServicePage {

    @Autowired
    private UsuarioRepository repository;
    
     private List<Usuario> usuarios = new ArrayList<>();
     
    public Page<Usuario> findPaginated(Pageable pageable) {
        usuarios = repository.findAll();
        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        List<Usuario> lista;
        if (usuarios.size() < startItem) {
            lista = Collections.emptyList();
        } else {
            int toIndex = Math.min(startItem + pageSize, usuarios.size());
            lista = usuarios.subList(startItem, toIndex);
        }
        Page<Usuario> usuarioPage
                = new PageImpl<>(lista, PageRequest.of(currentPage, pageSize), usuarios.size());
        return usuarioPage;
    }
}
