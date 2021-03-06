/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.entidades;

import br.com.localeader.enums.UF;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
@Table(name = "cad_endereco", catalog = "localeader", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CadEndereco.findAll", query = "SELECT c FROM CadEndereco c")
    , @NamedQuery(name = "CadEndereco.findByIdEndereco", query = "SELECT c FROM CadEndereco c WHERE c.idEndereco = :idEndereco")
    , @NamedQuery(name = "CadEndereco.findByBairro", query = "SELECT c FROM CadEndereco c WHERE c.bairro = :bairro")
    , @NamedQuery(name = "CadEndereco.findByCep", query = "SELECT c FROM CadEndereco c WHERE c.cep = :cep")
    , @NamedQuery(name = "CadEndereco.findByCidade", query = "SELECT c FROM CadEndereco c WHERE c.cidade = :cidade")
    , @NamedQuery(name = "CadEndereco.findByComplemento", query = "SELECT c FROM CadEndereco c WHERE c.complemento = :complemento")
    , @NamedQuery(name = "CadEndereco.findByDataAlteracao", query = "SELECT c FROM CadEndereco c WHERE c.dataAlteracao = :dataAlteracao")
    , @NamedQuery(name = "CadEndereco.findByDataInsercao", query = "SELECT c FROM CadEndereco c WHERE c.dataInsercao = :dataInsercao")
    , @NamedQuery(name = "CadEndereco.findByLogradouro", query = "SELECT c FROM CadEndereco c WHERE c.logradouro = :logradouro")
    , @NamedQuery(name = "CadEndereco.findByNumero", query = "SELECT c FROM CadEndereco c WHERE c.numero = :numero")
    , @NamedQuery(name = "CadEndereco.findByUf", query = "SELECT c FROM CadEndereco c WHERE c.uf = :uf")})
public class CadEndereco implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_endereco")
    private Integer idEndereco;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "bairro")
    private String bairro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cep")
    private String cep;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "cidade")
    private String cidade;
    @Size(max = 25)
    @Column(name = "complemento")
    private String complemento;
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
    @Size(min = 1, max = 50)
    @Column(name = "logradouro")
    private String logradouro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "numero")
    private String numero;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "uf")
    @Enumerated(EnumType.STRING)
    private UF uf;
    @JoinColumn(name = "documento_fk", referencedColumnName = "id_documentos")
    @ManyToOne(optional = false)
    private CadDocumentos documentoFk;
    @JoinColumn(name = "usuario_fk", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario usuarioFk;

    public CadEndereco() {
    }

    public CadEndereco(Integer idEndereco) {
        this.idEndereco = idEndereco;
    }

    public CadEndereco(Integer idEndereco, String bairro, String cep, String cidade, Date dataAlteracao, Date dataInsercao, String logradouro, String numero, UF uf) {
        this.idEndereco = idEndereco;
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
        this.dataAlteracao = dataAlteracao;
        this.dataInsercao = dataInsercao;
        this.logradouro = logradouro;
        this.numero = numero;
        this.uf = uf;
    }

    public Integer getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Integer idEndereco) {
        this.idEndereco = idEndereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
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

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public UF getUf() {
        return uf;
    }

    public void setUf(UF uf) {
        this.uf = uf;
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
        hash += (idEndereco != null ? idEndereco.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CadEndereco)) {
            return false;
        }
        CadEndereco other = (CadEndereco) object;
        if ((this.idEndereco == null && other.idEndereco != null) || (this.idEndereco != null && !this.idEndereco.equals(other.idEndereco))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.localeader.model.CadEndereco[ idEndereco=" + idEndereco + " ]";
    }
    
}
