/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "cad_ocorrencias", catalog = "localeader", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CadOcorrencias.findAll", query = "SELECT c FROM CadOcorrencias c")
    , @NamedQuery(name = "CadOcorrencias.findByIdOcorrencia", query = "SELECT c FROM CadOcorrencias c WHERE c.idOcorrencia = :idOcorrencia")
    , @NamedQuery(name = "CadOcorrencias.findByData", query = "SELECT c FROM CadOcorrencias c WHERE c.data = :data")
    , @NamedQuery(name = "CadOcorrencias.findByDataAlteracao", query = "SELECT c FROM CadOcorrencias c WHERE c.dataAlteracao = :dataAlteracao")
    , @NamedQuery(name = "CadOcorrencias.findByDataInsercao", query = "SELECT c FROM CadOcorrencias c WHERE c.dataInsercao = :dataInsercao")
    , @NamedQuery(name = "CadOcorrencias.findByDescricao", query = "SELECT c FROM CadOcorrencias c WHERE c.descricao = :descricao")
    , @NamedQuery(name = "CadOcorrencias.findByPrevisao", query = "SELECT c FROM CadOcorrencias c WHERE c.previsao = :previsao")
    , @NamedQuery(name = "CadOcorrencias.findByValor", query = "SELECT c FROM CadOcorrencias c WHERE c.valor = :valor")
    , @NamedQuery(name = "CadOcorrencias.findByVendedorFk", query = "SELECT c FROM CadOcorrencias c WHERE c.vendedorFk = :vendedorFk")})
public class CadOcorrencias implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_ocorrencia")
    private Integer idOcorrencia;
    @Column(name = "data")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;
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
    @Size(max = 255)
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "previsao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date previsao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor")
    private BigDecimal valor;
    @Column(name = "vendedor_fk")
    private Integer vendedorFk;
    @JoinColumn(name = "documento_fk", referencedColumnName = "id_documentos")
    @ManyToOne(optional = false)
    private CadDocumentos documentoFk;
    @JoinColumn(name = "usuario_fk", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario usuarioFk;

    public CadOcorrencias() {
    }

    public CadOcorrencias(Integer idOcorrencia) {
        this.idOcorrencia = idOcorrencia;
    }

    public CadOcorrencias(Integer idOcorrencia, Date dataAlteracao, Date dataInsercao) {
        this.idOcorrencia = idOcorrencia;
        this.dataAlteracao = dataAlteracao;
        this.dataInsercao = dataInsercao;
    }

    public Integer getIdOcorrencia() {
        return idOcorrencia;
    }

    public void setIdOcorrencia(Integer idOcorrencia) {
        this.idOcorrencia = idOcorrencia;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getPrevisao() {
        return previsao;
    }

    public void setPrevisao(Date previsao) {
        this.previsao = previsao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
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

    public Usuario getUsuarioFk() {
        return usuarioFk;
    }

    public void setUsuarioFk(Usuario usuarioFk) {
        this.usuarioFk = usuarioFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOcorrencia != null ? idOcorrencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CadOcorrencias)) {
            return false;
        }
        CadOcorrencias other = (CadOcorrencias) object;
        if ((this.idOcorrencia == null && other.idOcorrencia != null) || (this.idOcorrencia != null && !this.idOcorrencia.equals(other.idOcorrencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.localeader.model.CadOcorrencias[ idOcorrencia=" + idOcorrencia + " ]";
    }
    
}
