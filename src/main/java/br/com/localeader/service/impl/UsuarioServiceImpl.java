/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.service.impl;

import br.com.localeader.dao.UsuarioDao;
import br.com.localeader.datatables.Datatables;
import br.com.localeader.datatables.DatatablesColunas;
import br.com.localeader.entidades.Usuario;
import br.com.localeader.repositories.UsuarioRepository;
import br.com.localeader.service.UsuarioService;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Leandro Laurindo
 */
@Service
@Transactional(readOnly = false)
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioDao dao;

    
    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private Datatables datatables;

    @Override
    public void salvar(Usuario usuario) {
        dao.save(usuario);
    }

    @Override
    public void editar(Usuario usuario) {
        dao.update(usuario);
    }

    @Override
    public void excluir(Integer id) {
        dao.delete(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario buscarPorId(Integer id) {
        return dao.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario buscarPorLogin(String login) {
        return dao.findByLogin(login);
    }

    /**
     *
     * @return
     */
    @Override
    @Transactional(readOnly = true)
    public List<Usuario> buscarTodos() {
        return dao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public boolean usuarioExiste(String login) {
        Usuario usu = dao.findByLogin(login);
        return usu.getIdUsuario() != null;
    }

    @Override
    @Transactional(readOnly = true)
    public Map<String, Object> buscarUsuarios(HttpServletRequest request) {
        datatables.setRequest(request);
        datatables.setColunas(DatatablesColunas.USUARIOS);
        Page<?> page = datatables.getSearch().isEmpty() ? repository.findAll(datatables.getPageable())
                : repository.findByLogin(datatables.getSearch(), datatables.getPageable());
        return datatables.getResponse(page);
    }

    @Override
    public Page<Usuario> getPaginatedUsuarios(Pageable pageable) {
        return repository.findAll(pageable);
    }

}
