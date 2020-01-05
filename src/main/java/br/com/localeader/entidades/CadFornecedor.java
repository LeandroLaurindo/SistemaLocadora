/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.entidades;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Leandro Laurindo
 */
@Entity
@Table(name = "cad_fornecedor", catalog = "localeader", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CadFornecedor.findAll", query = "SELECT c FROM CadFornecedor c")
    , @NamedQuery(name = "CadFornecedor.findByIdFornecedor", query = "SELECT c FROM CadFornecedor c WHERE c.idFornecedor = :idFornecedor")
    , @NamedQuery(name = "CadFornecedor.findByAgencia", query = "SELECT c FROM CadFornecedor c WHERE c.agencia = :agencia")
    , @NamedQuery(name = "CadFornecedor.findByBanco", query = "SELECT c FROM CadFornecedor c WHERE c.banco = :banco")
    , @NamedQuery(name = "CadFornecedor.findByConta", query = "SELECT c FROM CadFornecedor c WHERE c.conta = :conta")
    , @NamedQuery(name = "CadFornecedor.findByDataAlteracao", query = "SELECT c FROM CadFornecedor c WHERE c.dataAlteracao = :dataAlteracao")
    , @NamedQuery(name = "CadFornecedor.findByDataInsercao", query = "SELECT c FROM CadFornecedor c WHERE c.dataInsercao = :dataInsercao")
    , @NamedQuery(name = "CadFornecedor.findBySegmentoFk", query = "SELECT c FROM CadFornecedor c WHERE c.segmentoFk = :segmentoFk")})
public class CadFornecedor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_fornecedor")
    private Integer idFornecedor;
    @Size(max = 5)
    @Column(name = "agencia")
    private String agencia;
    @Column(name = "banco")
    private Integer banco;
    @Size(max = 15)
    @Column(name = "conta")
    private String conta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_alteracao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAlteracao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_insercao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataInsercao;
    @Column(name = "segmento_fk")
    private Integer segmentoFk;
    @JoinColumn(name = "documento_fk", referencedColumnName = "id_documentos")
    @ManyToOne(optional = false)
    private CadDocumentos documentoFk;
    @JoinColumn(name = "usuario_fk", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario usuarioFk;

    public CadFornecedor() {
    }

    public CadFornecedor(Integer idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public CadFornecedor(Integer idFornecedor, Date dataAlteracao, Date dataInsercao) {
        this.idFornecedor = idFornecedor;
        this.dataAlteracao = dataAlteracao;
        this.dataInsercao = dataInsercao;
    }

    public Integer getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(Integer idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public Integer getBanco() {
        return banco;
    }

    public void setBanco(Integer banco) {
        this.banco = banco;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public Date getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(Date dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }

    public Date getDataInsercao() {
        return dataInsercao;
    }

    public void setDataInsercao(Date dataInsercao) {
        this.dataInsercao = dataInsercao;
    }

    public Integer getSegmentoFk() {
        return segmentoFk;
    }

    public void setSegmentoFk(Integer segmentoFk) {
        this.segmentoFk = segmentoFk;
    }

    public CadDocumentos getDocumentoFk() {
        return documentoFk;
    }

    public void setDocumentoFk(CadDocumentos documentoFk) {
        this.documentoFk = documentoFk;
    }

    public Usuario getUsuarioFk() {
        return usuarioFk;
    }

    public void setUsuarioFk(Usuario usuarioFk) {
        this.usuarioFk = usuarioFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFornecedor != null ? idFornecedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CadFornecedor)) {
            return false;
        }
        CadFornecedor other = (CadFornecedor) object;
        if ((this.idFornecedor == null && other.idFornecedor != null) || (this.idFornecedor != null && !this.idFornecedor.equals(other.idFornecedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.localeader.model.CadFornecedor[ idFornecedor=" + idFornecedor + " ]";
    }
    
}
