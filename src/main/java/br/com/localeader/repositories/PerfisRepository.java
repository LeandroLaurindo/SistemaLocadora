/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.repositories;

import br.com.localeader.entidades.Perfis;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Leandro Laurindo
 */
@Repository
public interface PerfisRepository extends CrudRepository<Perfis, Integer> {
    
    @Query("SELECT p FROM Perfis p")
    List<Perfis> buscarTodos();
}
