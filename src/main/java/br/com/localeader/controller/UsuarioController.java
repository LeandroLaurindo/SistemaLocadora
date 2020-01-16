/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.controller;

import br.com.localeader.datatables.Datatables;
import br.com.localeader.entidades.Perfis;
import br.com.localeader.utils.PasswordUtils;
import br.com.localeader.entidades.Usuario;
import br.com.localeader.repositories.PerfisRepository;
import br.com.localeader.repositories.UsuarioRepository;
import br.com.localeader.service.UsuarioService;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.jaxb.SpringDataJaxb;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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

    @Autowired
    private PerfisRepository perfisRepository;

    @Autowired
    private UsuarioRepository repository;

    /* @GetMapping("/listar")
    public String listar(ModelMap model) {
       // model.addAttribute("usuarios", usuarioService.buscarTodos());
        return "/usuario/listar";
    }*/
    @GetMapping("/cadastro")
    public String cadastrarUsuario(Usuario usuario) {
        return "/usuario/cadastrar";
    }

    @PostMapping("/salvar")
    public String salvar(Usuario usuario, @RequestParam("perfil") Integer perfil, RedirectAttributes attr) {

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

    /* @GetMapping("/listar")
    public ResponseEntity<?> getUsuarios(Pageable pageable) {
        return new  ResponseEntity<>(repository.findAll(pageable), HttpStatus.OK);
    }*/
    @GetMapping("/editar/{id}")
    public String preEditar(@PathVariable("id") Integer id, ModelMap model) {
        model.addAttribute("usuario", usuarioService.buscarPorId(id));
        return "usuario/cadastrar";
    }

    @PostMapping("/editar")
    public String editar(Usuario usuario, @RequestParam("perfil") Integer perfil, RedirectAttributes attr) {
        
        usuarioService.editar(usuario);
        attr.addFlashAttribute("success", "Usuário editado com sucesso.");
        return "redirect:/usuarios/cadastro";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Integer id, ModelMap model) {
        usuarioService.excluir(id);
        model.addAttribute("success", "Usuário excluído com sucesso.");
        return "redirect:/usuarios/listar/page/0";
    }

    @PostMapping("/buscar/login")
    public String getPorNome(@RequestParam("login") String login, ModelMap model) {
        System.out.println("login :" + login);
        model.addAttribute("usuarios", repository.findByLogin(login, PageRequest.of(0, 5)));
        model.addAttribute("pageNumbers", 0);
        return "/usuario/listar";
    }

    /**
     *
     * @param page
     * @param v
     * @param model
     * @return
     */
    @RequestMapping(value = "/listar/{page}/{v}")
    public String listar(@PathVariable("page") String page, @PathVariable("v") String v, ModelMap model) {
        int p = Integer.parseInt(v);
        System.out.println("page : " + page);
        List<Usuario> lista = repository.findAll();
        List<Integer> paginas = IntStream.rangeClosed(0, lista.size() / 3).boxed().collect(Collectors.toList());
        /*  for (int i = 0; i < (lista.size() * 2); i++) {
            paginas.add(i);
        }*/
        model.addAttribute("usuarios", repository.findAll(PageRequest.of(p, 3)));
        model.addAttribute("pageNumbers", paginas);
        return "/usuario/listar";
    }

    @ModelAttribute("perfis")
    public List<Perfis> getPerfil() {
        return perfisRepository.buscarTodos();
    }

}
