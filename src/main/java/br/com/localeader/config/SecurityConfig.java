/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.config;

import br.com.localeader.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author Leandro Laurindo
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig  extends WebSecurityConfigurerAdapter{
    
    @Autowired
    private LoginService loginService;

    @Override
    protected void configure(HttpSecurity http){
        try{
        http.authorizeRequests()
                //acessos publicos liberados
                .antMatchers("/webjars/**","/css/**","/js/**", "/img/**").permitAll()
                .antMatchers("/","/entrar","/entrar-error").permitAll()
                //acessos privados master
                .antMatchers("/usuarios/**").hasAuthority("MASTER")
                .anyRequest().authenticated()
                .and().formLogin()
                .loginPage("/entrar")
                .defaultSuccessUrl("/home", true)
                .failureUrl("/entrar-error")
                .permitAll()
                .and()
                .logout()
                .logoutSuccessUrl("/entrar")
                .and()
                .exceptionHandling()
                .accessDeniedPage("/acesso-negado");
        }catch(Exception e){
            e.printStackTrace();
        }
                
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       
        auth.userDetailsService(loginService).passwordEncoder(new BCryptPasswordEncoder());
    }
    
    
}
