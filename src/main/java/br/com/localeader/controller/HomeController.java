/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.controller;

import br.com.localeader.dao.UsuarioDao;
import br.com.localeader.model.Usuario;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Leandro Laurindo
 */
@Controller
public class HomeController {
   @Autowired
   private UsuarioDao dao;
    @GetMapping("/")
    public String index() {

        return "/home";
    }
    @GetMapping("/logar")
    public String logar(Usuario usuario, HttpSession session) {
        
        return "/index";
    }
    @GetMapping("/layout")
    public String home() {
        
        return "/layout";
    }

}
