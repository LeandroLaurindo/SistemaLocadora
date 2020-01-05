/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.controller;

import br.com.localeader.utils.PasswordUtils;
import br.com.localeader.entidades.Usuario;
import br.com.localeader.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Leandro Laurindo
 */
@Controller
//@PreAuthorize("hasAuthority('MASTER')")
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/listar")
    public String listar(ModelMap model) {
        model.addAttribute("usuarios", usuarioService.buscarTodos());
        return "/usuario/listar";
    }

    @GetMapping("/cadastro")
    public String cadastrarUsuario(Usuario usuario) {
        return "/usuario/cadastrar";
    }

    @PostMapping("/salvar")
    public String salvar(Usuario usuario, RedirectAttributes attr) {

        if (usuarioService.usuarioExiste(usuario.getLogin())) {
            attr.addFlashAttribute("fail", "Já existe um usuário cadastrado para o login informado.");
        } else {
            usuario.setSenha(PasswordUtils.gerarBCrypt(usuario.getSenha()));
            usuario.setAtivo(true);
            usuarioService.salvar(usuario);

            attr.addFlashAttribute("success", "Usuário inserido com sucesso.");
        }

        return "redirect:/usuarios/cadastro";
    }

    @GetMapping("/editar/{id}")
    public String preEditar(@PathVariable("id") Integer id, ModelMap model) {
        model.addAttribute("usuario", usuarioService.buscarPorId(id));
        return "usuario/cadastrar";
    }

    @PostMapping("/editar")
    public String editar(Usuario usuario, RedirectAttributes attr) {
        usuarioService.editar(usuario);
        attr.addFlashAttribute("success", "Usuário editado com sucesso.");
        return "redirect:/usuarios/cadastro";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Integer id, ModelMap model) {
        usuarioService.excluir(id);
        model.addAttribute("success", "Usuário excluído com sucesso.");
        return listar(model);
    }

    @GetMapping("/buscar/login")
    public String getPorNome(@RequestParam("login") String login, ModelMap model) {
        model.addAttribute("usuarios", usuarioService.buscarPorLogin(login));
        return "/usuario/listar";
    }


}
