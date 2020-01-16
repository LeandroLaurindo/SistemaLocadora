/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.service;

import br.com.localeader.dao.UsuarioDao;
import br.com.localeader.entidades.Perfis;
import br.com.localeader.entidades.Usuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Leandro Laurindo
 */
@Service
public class LoginService implements UserDetailsService {

    @Autowired
    private UsuarioDao usuarioDao;

    @Transactional(readOnly = true)
    public Usuario buscarPeloLogin(String login) {
        return usuarioDao.findByLogin(login);
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = buscarPeloLogin(username);
        return new User(
                usuario.getLogin(),
                usuario.getSenha(),
                AuthorityUtils.createAuthorityList(getAuthorities(usuario.getPerfil()))
        );
    }

    private String[] getAuthorities(List<Perfis> listaDePerfils) {
        String[] authorities = new String[listaDePerfils.size()];
        for (int i = 0; i < listaDePerfils.size(); i++) {
            authorities[i] = listaDePerfils.get(i).getNomePerfil().trim();
        }
        return authorities;
    }

}
