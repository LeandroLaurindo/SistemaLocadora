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
public enum PerfilTipo {
   MASTER(1, "MASTER"), ADMIN(2, "ADMIN"), VENDEDOR(3, "VENDEDOR"),FUNCIONARIO(4,"FUNCIONARIO"),CLIENTE(4,"CLIENTE");
	
	private Integer cod;
	private String desc;

	private PerfilTipo(Integer cod, String desc) {
		this.cod = cod;
		this.desc = desc;
	}

	public Integer getCod() {
		return cod;
	}

	public String getDesc() {
		return desc;
	}
}
