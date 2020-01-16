/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.repositories;

import br.com.localeader.entidades.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Leandro Laurindo
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
   
    @Query("SELECT u FROM Usuario u WHERE u.login like ?1%")
    public Page<Usuario> findByLogin(String login, Pageable pageable);
    
    /**
     *
     * @param pageable
     * @return
     */
    @Override
    Page<Usuario> findAll(Pageable pageable);
    
    
}
