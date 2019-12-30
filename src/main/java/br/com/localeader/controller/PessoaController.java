/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Leandro Laurindo
 */
@Controller
@RequestMapping("/pessoas")
public class PessoaController {
    
    @GetMapping("/cadastrar")
    public String cadastrar(){
        return "/pessoa/cadastrar";
    }
    
    @GetMapping("/listar")
    public String listar(){
        return "/pessoa/listar";
    }
    
}
