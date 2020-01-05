/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 *
 * @author Leandro Laurindo
 */
@EnableWebSecurity
public class SecurityConfig  extends WebSecurityConfigurerAdapter{

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/webjars/**","/css/**","/js/**", "/img/**").permitAll()
                .antMatchers("/","/entrar","/entrar-error").permitAll()
                .anyRequest().authenticated()
                .and().formLogin()
                .loginPage("/entrar")
                .defaultSuccessUrl("/home", true)
                .failureUrl("/entrar-error")
                .permitAll()
                .and()
                .logout()
                .logoutSuccessUrl("/entrar");
                
    }
    
    
}
