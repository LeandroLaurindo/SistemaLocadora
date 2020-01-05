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
@Table(name = "cad_telefone", catalog = "localeader", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CadTelefone.findAll", query = "SELECT c FROM CadTelefone c")
    , @NamedQuery(name = "CadTelefone.findByIdTelefone", query = "SELECT c FROM CadTelefone c WHERE c.idTelefone = :idTelefone")
    , @NamedQuery(name = "CadTelefone.findByDataAlteracao", query = "SELECT c FROM CadTelefone c WHERE c.dataAlteracao = :dataAlteracao")
    , @NamedQuery(name = "CadTelefone.findByDataInsercao", query = "SELECT c FROM CadTelefone c WHERE c.dataInsercao = :dataInsercao")
    , @NamedQuery(name = "CadTelefone.findByDdd", query = "SELECT c FROM CadTelefone c WHERE c.ddd = :ddd")
    , @NamedQuery(name = "CadTelefone.findByTelefone", query = "SELECT c FROM CadTelefone c WHERE c.telefone = :telefone")
    , @NamedQuery(name = "CadTelefone.findByWhatsapp", query = "SELECT c FROM CadTelefone c WHERE c.whatsapp = :whatsapp")})
public class CadTelefone implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_telefone")
    private Integer idTelefone;
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "ddd")
    private int ddd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "telefone")
    private String telefone;
    @Column(name = "whatsapp")
    private Boolean whatsapp;
    @JoinColumn(name = "documento_fk", referencedColumnName = "id_documentos")
    @ManyToOne(optional = false)
    private CadDocumentos documentoFk;
    @JoinColumn(name = "usuario_fk", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario usuarioFk;

    public CadTelefone() {
    }

    public CadTelefone(Integer idTelefone) {
        this.idTelefone = idTelefone;
    }

    public CadTelefone(Integer idTelefone, Date dataAlteracao, Date dataInsercao, int ddd, String telefone) {
        this.idTelefone = idTelefone;
        this.dataAlteracao = dataAlteracao;
        this.dataInsercao = dataInsercao;
        this.ddd = ddd;
        this.telefone = telefone;
    }

    public Integer getIdTelefone() {
        return idTelefone;
    }

    public void setIdTelefone(Integer idTelefone) {
        this.idTelefone = idTelefone;
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

    public int getDdd() {
        return ddd;
    }

    public void setDdd(int ddd) {
        this.ddd = ddd;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Boolean getWhatsapp() {
        return whatsapp;
    }

    public void setWhatsapp(Boolean whatsapp) {
        this.whatsapp = whatsapp;
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
        hash += (idTelefone != null ? idTelefone.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CadTelefone)) {
            return false;
        }
        CadTelefone other = (CadTelefone) object;
        if ((this.idTelefone == null && other.idTelefone != null) || (this.idTelefone != null && !this.idTelefone.equals(other.idTelefone))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.localeader.model.CadTelefone[ idTelefone=" + idTelefone + " ]";
    }
    
}
