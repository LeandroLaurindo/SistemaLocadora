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
@Table(name = "cad_email", catalog = "localeader", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CadEmail.findAll", query = "SELECT c FROM CadEmail c")
    , @NamedQuery(name = "CadEmail.findByIdEmail", query = "SELECT c FROM CadEmail c WHERE c.idEmail = :idEmail")
    , @NamedQuery(name = "CadEmail.findByDataAlteracao", query = "SELECT c FROM CadEmail c WHERE c.dataAlteracao = :dataAlteracao")
    , @NamedQuery(name = "CadEmail.findByDataInsercao", query = "SELECT c FROM CadEmail c WHERE c.dataInsercao = :dataInsercao")
    , @NamedQuery(name = "CadEmail.findByEmail", query = "SELECT c FROM CadEmail c WHERE c.email = :email")
    , @NamedQuery(name = "CadEmail.findByObservacao", query = "SELECT c FROM CadEmail c WHERE c.observacao = :observacao")
    , @NamedQuery(name = "CadEmail.findBySite", query = "SELECT c FROM CadEmail c WHERE c.site = :site")})
public class CadEmail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_email")
    private Integer idEmail;
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
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="E-mail inválido")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "email", unique = true)
    private String email;
    @Size(max = 200)
    @Column(name = "observacao")
    private String observacao;
    @Size(max = 100)
    @Column(name = "site")
    private String site;
    @JoinColumn(name = "documento_fk", referencedColumnName = "id_documentos")
    @ManyToOne(optional = false)
    private CadDocumentos documentoFk;
    @JoinColumn(name = "usuario_fk", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario usuarioFk;

    public CadEmail() {
    }

    public CadEmail(Integer idEmail) {
        this.idEmail = idEmail;
    }

    public CadEmail(Integer idEmail, Date dataAlteracao, Date dataInsercao, String email) {
        this.idEmail = idEmail;
        this.dataAlteracao = dataAlteracao;
        this.dataInsercao = dataInsercao;
        this.email = email;
    }

    public Integer getIdEmail() {
        return idEmail;
    }

    public void setIdEmail(Integer idEmail) {
        this.idEmail = idEmail;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
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
        hash += (idEmail != null ? idEmail.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CadEmail)) {
            return false;
        }
        CadEmail other = (CadEmail) object;
        if ((this.idEmail == null && other.idEmail != null) || (this.idEmail != null && !this.idEmail.equals(other.idEmail))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.localeader.model.CadEmail[ idEmail=" + idEmail + " ]";
    }
    
}
