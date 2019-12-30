/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.enums;

/**
 *
 * @author Leandro Laurindo
 */
public enum UF {
    RO("RO", "Rondônia"),
    AC("AC", "Acre"),
    AM("AM", "Amazonas"),
    RR("RR", "Roraima"),
    PA("PA", "Pará"),
    AP("AP", "Amapá"),
    TO("TO", "Tocantins"),
    MA("MA", "Maranhão"),
    PI("PI", "Piauí"),
    CE("CE", "Ceará"),
    RN("RN", "Rio Grande do Norte"),
    PB("PB", "Paraíba"),
    PE("PE", "Pernambuco"),
    AL("AL", "Alagoas"),
    SE("SE", "Sergipe"),
    BA("BA", "Bahia"),
    MG("MG", "Minas Gerais"),
    ES("ES", "Espírito Santo"),
    RJ("RJ", "Rio de Janeiro"),
    SP("SP", "São Paulo"),
    PR("PR", "Paraná"),
    SC("SC", "Santa Catarina"),
    RS("RS", "Rio Grande do Sul"),
    MS("MS", "Mato Grosso do Sul"),
    MT("MT", "Mato Grosso"),
    GO("GO", "Goiás"),
    DF("DF", "Distrito Federal");

    private final String sigla;
    private final String nome;

   UF(String sigla, String nome) {
        this.sigla = sigla;
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public String getNome() {
        return nome;
    }
  
    
}
