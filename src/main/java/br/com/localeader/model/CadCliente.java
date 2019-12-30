/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Leandro Laurindo
 */
@Entity
@Table(name = "cad_cliente", catalog = "localeader", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CadCliente.findAll", query = "SELECT c FROM CadCliente c")
    , @NamedQuery(name = "CadCliente.findByIdCliente", query = "SELECT c FROM CadCliente c WHERE c.idCliente = :idCliente")
    , @NamedQuery(name = "CadCliente.findByClassificacaoFk", query = "SELECT c FROM CadCliente c WHERE c.classificacaoFk = :classificacaoFk")
    , @NamedQuery(name = "CadCliente.findByLimiteCredito", query = "SELECT c FROM CadCliente c WHERE c.limiteCredito = :limiteCredito")
    , @NamedQuery(name = "CadCliente.findByObservacao", query = "SELECT c FROM CadCliente c WHERE c.observacao = :observacao")
    , @NamedQuery(name = "CadCliente.findByOrigemCliente", query = "SELECT c FROM CadCliente c WHERE c.origemCliente = :origemCliente")
    , @NamedQuery(name = "CadCliente.findByPlanoPagto", query = "SELECT c FROM CadCliente c WHERE c.planoPagto = :planoPagto")
    , @NamedQuery(name = "CadCliente.findByRepresentanteLegalFk", query = "SELECT c FROM CadCliente c WHERE c.representanteLegalFk = :representanteLegalFk")
    , @NamedQuery(name = "CadCliente.findBySegmentoFk", query = "SELECT c FROM CadCliente c WHERE c.segmentoFk = :segmentoFk")
    , @NamedQuery(name = "CadCliente.findByTabelaPrecoFk", query = "SELECT c FROM CadCliente c WHERE c.tabelaPrecoFk = :tabelaPrecoFk")
    , @NamedQuery(name = "CadCliente.findByVendedorFk", query = "SELECT c FROM CadCliente c WHERE c.vendedorFk = :vendedorFk")})
public class CadCliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cliente")
    private Integer idCliente;
    @Column(name = "classificacao_fk")
    private Integer classificacaoFk;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "limite_credito")
    private BigDecimal limiteCredito;
    @Size(max = 250)
    @Column(name = "observacao")
    private String observacao;
    @Size(max = 50)
    @Column(name = "origem_cliente")
    private String origemCliente;
    @Size(max = 30)
    @Column(name = "plano_pagto")
    private String planoPagto;
    @Column(name = "representante_legal_fk")
    private Integer representanteLegalFk;
    @Column(name = "segmento_fk")
    private Integer segmentoFk;
    @Column(name = "tabela_preco_fk")
    private Integer tabelaPrecoFk;
    @Column(name = "vendedor_fk")
    private Integer vendedorFk;
    @JoinColumn(name = "documento_fk", referencedColumnName = "id_documentos")
    @ManyToOne(optional = false)
    private CadDocumentos documentoFk;

    public CadCliente() {
    }

    public CadCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getClassificacaoFk() {
        return classificacaoFk;
    }

    public void setClassificacaoFk(Integer classificacaoFk) {
        this.classificacaoFk = classificacaoFk;
    }

    public BigDecimal getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(BigDecimal limiteCredito) {
        this.limiteCredito = limiteCredito;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getOrigemCliente() {
        return origemCliente;
    }

    public void setOrigemCliente(String origemCliente) {
        this.origemCliente = origemCliente;
    }

    public String getPlanoPagto() {
        return planoPagto;
    }

    public void setPlanoPagto(String planoPagto) {
        this.planoPagto = planoPagto;
    }

    public Integer getRepresentanteLegalFk() {
        return representanteLegalFk;
    }

    public void setRepresentanteLegalFk(Integer representanteLegalFk) {
        this.representanteLegalFk = representanteLegalFk;
    }

    public Integer getSegmentoFk() {
        return segmentoFk;
    }

    public void setSegmentoFk(Integer segmentoFk) {
        this.segmentoFk = segmentoFk;
    }

    public Integer getTabelaPrecoFk() {
        return tabelaPrecoFk;
    }

    public void setTabelaPrecoFk(Integer tabelaPrecoFk) {
        this.tabelaPrecoFk = tabelaPrecoFk;
    }

    public Integer getVendedorFk() {
        return vendedorFk;
    }

    public void setVendedorFk(Integer vendedorFk) {
        this.vendedorFk = vendedorFk;
    }

    public CadDocumentos getDocumentoFk() {
        return documentoFk;
    }

    public void setDocumentoFk(CadDocumentos documentoFk) {
        this.documentoFk = documentoFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCliente != null ? idCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CadCliente)) {
            return false;
        }
        CadCliente other = (CadCliente) object;
        if ((this.idCliente == null && other.idCliente != null) || (this.idCliente != null && !this.idCliente.equals(other.idCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.localeader.model.CadCliente[ idCliente=" + idCliente + " ]";
    }
    
}
