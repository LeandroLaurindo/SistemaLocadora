/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author Leandro Laurindo
 */
public class PasswordUtils {

    private static final Logger LOG = LoggerFactory.getLogger(PasswordUtils.class);

   

    
    /**
     * 
     * Gera o hash utilizando o BCRypt.
     *
     * @param senha
     * @return
     */
    public static String gerarBCrypt(String senha) {
        if (senha == null) {
            return senha;
        }
        LOG.info("gerando o hash com o BCRypt.");
        BCryptPasswordEncoder bCryptEncoder = new BCryptPasswordEncoder();
        return bCryptEncoder.encode(senha);
    }

    /**
     * Valida a senha
     *
     * @param senha
     * @param senhaEncoded
     * @return
     */
    public static boolean senhaValida(String senha, String senhaEncoded) {
        BCryptPasswordEncoder bCryptEncoder = new BCryptPasswordEncoder();
        return bCryptEncoder.matches(senha, senhaEncoded);
    }
    

}
