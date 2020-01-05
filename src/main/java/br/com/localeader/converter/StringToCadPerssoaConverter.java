/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.converter;

import br.com.localeader.entidades.CadPessoa;
import br.com.localeader.service.CadPessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 *
 * @author Leandro Laurindo
 */
@Component
public class StringToCadPerssoaConverter implements Converter<String, CadPessoa>{

    @Autowired
    private CadPessoaService service;
    
    @Override
    public CadPessoa convert(String text) {
        if(text.isEmpty()){
            return null;
        }
        Integer id = Integer.valueOf(text);
        return service.buscarPorId(id);
    }
    
}
