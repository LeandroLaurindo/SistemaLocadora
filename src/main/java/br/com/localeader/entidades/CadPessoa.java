/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Leandro Laurindo
 */
@Entity
@Table(name = "cad_pessoa", catalog = "localeader", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CadPessoa.findAll", query = "SELECT c FROM CadPessoa c")
    , @NamedQuery(name = "CadPessoa.findByIdPessoa", query = "SELECT c FROM CadPessoa c WHERE c.idPessoa = :idPessoa")
    , @NamedQuery(name = "CadPessoa.findByConjuge", query = "SELECT c FROM CadPessoa c WHERE c.conjuge = :conjuge")
    , @NamedQuery(name = "CadPessoa.findByDataAlteracao", query = "SELECT c FROM CadPessoa c WHERE c.dataAlteracao = :dataAlteracao")
    , @NamedQuery(name = "CadPessoa.findByDataInsercao", query = "SELECT c FROM CadPessoa c WHERE c.dataInsercao = :dataInsercao")
    , @NamedQuery(name = "CadPessoa.findByDataNascimento", query = "SELECT c FROM CadPessoa c WHERE c.dataNascimento = :dataNascimento")
    , @NamedQuery(name = "CadPessoa.findByEstadoCivil", query = "SELECT c FROM CadPessoa c WHERE c.estadoCivil = :estadoCivil")
    , @NamedQuery(name = "CadPessoa.findByEstrangeiro", query = "SELECT c FROM CadPessoa c WHERE c.estrangeiro = :estrangeiro")
    , @NamedQuery(name = "CadPessoa.findByNacionalidade", query = "SELECT c FROM CadPessoa c WHERE c.nacionalidade = :nacionalidade")
    , @NamedQuery(name = "CadPessoa.findByNome", query = "SELECT c FROM CadPessoa c WHERE c.nome = :nome")
    , @NamedQuery(name = "CadPessoa.findByPais", query = "SELECT c FROM CadPessoa c WHERE c.pais = :pais")
    , @NamedQuery(name = "CadPessoa.findByProfissao", query = "SELECT c FROM CadPessoa c WHERE c.profissao = :profissao")
    , @NamedQuery(name = "CadPessoa.findByRazaoSocial", query = "SELECT c FROM CadPessoa c WHERE c.razaoSocial = :razaoSocial")
    , @NamedQuery(name = "CadPessoa.findBySexo", query = "SELECT c FROM CadPessoa c WHERE c.sexo = :sexo")
    , @NamedQuery(name = "CadPessoa.findBySituacao", query = "SELECT c FROM CadPessoa c WHERE c.situacao = :situacao")
    , @NamedQuery(name = "CadPessoa.findByTipoPessoa", query = "SELECT c FROM CadPessoa c WHERE c.tipoPessoa = :tipoPessoa")})
public class CadPessoa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_pessoa")
    private Integer idPessoa;
    @Size(max = 150)
    @Column(name = "conjuge")
    private String conjuge;
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
    @Column(name = "data_nascimento")
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;
    @Size(max = 50)
    @Column(name = "estado_civil")
    private String estadoCivil;
    @Column(name = "estrangeiro")
    private Boolean estrangeiro;
    @Size(max = 100)
    @Column(name = "nacionalidade")
    private String nacionalidade;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "nome")
    private String nome;
    @Size(max = 100)
    @Column(name = "pais")
    private String pais;
    @Size(max = 100)
    @Column(name = "profissao")
    private String profissao;
    @Size(max = 150)
    @Column(name = "razao_social")
    private String razaoSocial;
    @Size(max = 255)
    @Column(name = "sexo")
    private String sexo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "situacao")
    private String situacao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "tipo_pessoa")
    private String tipoPessoa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pessoaFk")
    private List<CadDocumentos> cadDocumentosList;
    @JoinColumn(name = "usuario_fk", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario usuarioFk;

    public CadPessoa() {
    }

    public CadPessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }

    public CadPessoa(Integer idPessoa, Date dataAlteracao, Date dataInsercao, String nome, String situacao, String tipoPessoa) {
        this.idPessoa = idPessoa;
        this.dataAlteracao = dataAlteracao;
        this.dataInsercao = dataInsercao;
        this.nome = nome;
        this.situacao = situacao;
        this.tipoPessoa = tipoPessoa;
    }

    public Integer getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getConjuge() {
        return conjuge;
    }

    public void setConjuge(String conjuge) {
        this.conjuge = conjuge;
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

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public Boolean getEstrangeiro() {
        return estrangeiro;
    }

    public void setEstrangeiro(Boolean estrangeiro) {
        this.estrangeiro = estrangeiro;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(String tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    @XmlTransient
    public List<CadDocumentos> getCadDocumentosList() {
        return cadDocumentosList;
    }

    public void setCadDocumentosList(List<CadDocumentos> cadDocumentosList) {
        this.cadDocumentosList = cadDocumentosList;
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
        hash += (idPessoa != null ? idPessoa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CadPessoa)) {
            return false;
        }
        CadPessoa other = (CadPessoa) object;
        if ((this.idPessoa == null && other.idPessoa != null) || (this.idPessoa != null && !this.idPessoa.equals(other.idPessoa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.localeader.model.CadPessoa[ idPessoa=" + idPessoa + " ]";
    }
    
}
