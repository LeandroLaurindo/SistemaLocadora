/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.controller;

import br.com.localeader.model.CadCliente;
import br.com.localeader.service.CadClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Leandro Laurindo
 */
@Controller
@RequestMapping("/clientes")
public class ClienteController {
    
    @Autowired
    CadClienteService service;
    
    @GetMapping("/listar")
    public String listar(){
        return "/cliente/listar";
    }
    
    @PostMapping("/salvar")
    public String salvar(CadCliente cliente){
        service.salvar(cliente);
        return "/cliente/cadastrar";
    }
    
    
}
