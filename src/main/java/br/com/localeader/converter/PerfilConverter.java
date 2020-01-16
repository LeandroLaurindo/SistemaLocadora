/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.converter;

import br.com.localeader.entidades.Perfis;
import java.util.ArrayList;
import java.util.List;
import org.springframework.core.convert.converter.Converter;

/**
 *
 * @author Leandro Laurindo
 */
public class PerfilConverter implements Converter<String[], List<Perfis>> {

    @Override
    public List<Perfis> convert(String[] source) {
        List<Perfis> perfis = new ArrayList<>();
        for (String id : source) {
            perfis.add(new Perfis(Integer.valueOf(id)));
        }
        return perfis;
    }

}
