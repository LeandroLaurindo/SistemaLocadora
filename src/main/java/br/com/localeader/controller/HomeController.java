/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Leandro Laurindo
 */
@Controller
public class HomeController {

    @GetMapping({"/", "/entrar"})
    public String inicio() {
        return "/entrar";
    }

    @GetMapping("/home")
    public String entrar() {
        return "/home";
    }

    @GetMapping("/entrar-error")
    public String entrarError(ModelMap model) {
        model.addAttribute("alerta", "erro");
        model.addAttribute("titulo  ", "Credenciais inválidas!");
        model.addAttribute("texto", "Login ou senha incorretos tente novamente!");
        model.addAttribute("subTexto", "Acesso permitidos somente para cadastros ativados!");
        return "/entrar";
    }

    @GetMapping("/404")
    public String retornarPaginaErro(){
        return "/error";
    }
}
