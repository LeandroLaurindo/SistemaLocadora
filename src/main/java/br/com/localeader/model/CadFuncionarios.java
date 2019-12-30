/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.model;

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
@Table(name = "cad_funcionarios", catalog = "localeader", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CadFuncionarios.findAll", query = "SELECT c FROM CadFuncionarios c")
    , @NamedQuery(name = "CadFuncionarios.findByIdFuncionario", query = "SELECT c FROM CadFuncionarios c WHERE c.idFuncionario = :idFuncionario")
    , @NamedQuery(name = "CadFuncionarios.findByAtivo", query = "SELECT c FROM CadFuncionarios c WHERE c.ativo = :ativo")
    , @NamedQuery(name = "CadFuncionarios.findByCargo", query = "SELECT c FROM CadFuncionarios c WHERE c.cargo = :cargo")
    , @NamedQuery(name = "CadFuncionarios.findByCodigo", query = "SELECT c FROM CadFuncionarios c WHERE c.codigo = :codigo")
    , @NamedQuery(name = "CadFuncionarios.findByDataAdmissao", query = "SELECT c FROM CadFuncionarios c WHERE c.dataAdmissao = :dataAdmissao")
    , @NamedQuery(name = "CadFuncionarios.findByDataAlteracao", query = "SELECT c FROM CadFuncionarios c WHERE c.dataAlteracao = :dataAlteracao")
    , @NamedQuery(name = "CadFuncionarios.findByDataDemissao", query = "SELECT c FROM CadFuncionarios c WHERE c.dataDemissao = :dataDemissao")
    , @NamedQuery(name = "CadFuncionarios.findByDataInsercao", query = "SELECT c FROM CadFuncionarios c WHERE c.dataInsercao = :dataInsercao")
    , @NamedQuery(name = "CadFuncionarios.findByGratificacao", query = "SELECT c FROM CadFuncionarios c WHERE c.gratificacao = :gratificacao")
    , @NamedQuery(name = "CadFuncionarios.findByQtdeDependentes", query = "SELECT c FROM CadFuncionarios c WHERE c.qtdeDependentes = :qtdeDependentes")
    , @NamedQuery(name = "CadFuncionarios.findBySalario", query = "SELECT c FROM CadFuncionarios c WHERE c.salario = :salario")
    , @NamedQuery(name = "CadFuncionarios.findBySetor", query = "SELECT c FROM CadFuncionarios c WHERE c.setor = :setor")
    , @NamedQuery(name = "CadFuncionarios.findBySindicato", query = "SELECT c FROM CadFuncionarios c WHERE c.sindicato = :sindicato")
    , @NamedQuery(name = "CadFuncionarios.findByTipoFuncionario", query = "SELECT c FROM CadFuncionarios c WHERE c.tipoFuncionario = :tipoFuncionario")
    , @NamedQuery(name = "CadFuncionarios.findByValeTransporte", query = "SELECT c FROM CadFuncionarios c WHERE c.valeTransporte = :valeTransporte")})
public class CadFuncionarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_funcionario")
    private Integer idFuncionario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ativo")
    private boolean ativo;
    @Size(max = 255)
    @Column(name = "cargo")
    private String cargo;
    @Size(max = 25)
    @Column(name = "codigo")
    private String codigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_admissao")
    @Temporal(TemporalType.DATE)
    private Date dataAdmissao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_alteracao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAlteracao;
    @Column(name = "data_demissao")
    @Temporal(TemporalType.DATE)
    private Date dataDemissao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_insercao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataInsercao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "gratificacao")
    private BigDecimal gratificacao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "qtde_dependentes")
    private int qtdeDependentes;
    @Basic(optional = false)
    @NotNull
    @Column(name = "salario")
    private BigDecimal salario;
    @Size(max = 255)
    @Column(name = "setor")
    private String setor;
    @Size(max = 255)
    @Column(name = "sindicato")
    private String sindicato;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "tipo_funcionario")
    private String tipoFuncionario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vale_transporte")
    private boolean valeTransporte;
    @JoinColumn(name = "documento_fk", referencedColumnName = "id_documentos")
    @ManyToOne(optional = false)
    private CadDocumentos documentoFk;
    @JoinColumn(name = "usuario_fk", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario usuarioFk;

    public CadFuncionarios() {
    }

    public CadFuncionarios(Integer idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public CadFuncionarios(Integer idFuncionario, boolean ativo, Date dataAdmissao, Date dataAlteracao, Date dataInsercao, BigDecimal gratificacao, int qtdeDependentes, BigDecimal salario, String tipoFuncionario, boolean valeTransporte) {
        this.idFuncionario = idFuncionario;
        this.ativo = ativo;
        this.dataAdmissao = dataAdmissao;
        this.dataAlteracao = dataAlteracao;
        this.dataInsercao = dataInsercao;
        this.gratificacao = gratificacao;
        this.qtdeDependentes = qtdeDependentes;
        this.salario = salario;
        this.tipoFuncionario = tipoFuncionario;
        this.valeTransporte = valeTransporte;
    }

    public Integer getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Integer idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Date getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(Date dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public Date getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(Date dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }

    public Date getDataDemissao() {
        return dataDemissao;
    }

    public void setDataDemissao(Date dataDemissao) {
        this.dataDemissao = dataDemissao;
    }

    public Date getDataInsercao() {
        return dataInsercao;
    }

    public void setDataInsercao(Date dataInsercao) {
        this.dataInsercao = dataInsercao;
    }

    public BigDecimal getGratificacao() {
        return gratificacao;
    }

    public void setGratificacao(BigDecimal gratificacao) {
        this.gratificacao = gratificacao;
    }

    public int getQtdeDependentes() {
        return qtdeDependentes;
    }

    public void setQtdeDependentes(int qtdeDependentes) {
        this.qtdeDependentes = qtdeDependentes;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public String getSindicato() {
        return sindicato;
    }

    public void setSindicato(String sindicato) {
        this.sindicato = sindicato;
    }

    public String getTipoFuncionario() {
        return tipoFuncionario;
    }

    public void setTipoFuncionario(String tipoFuncionario) {
        this.tipoFuncionario = tipoFuncionario;
    }

    public boolean getValeTransporte() {
        return valeTransporte;
    }

    public void setValeTransporte(boolean valeTransporte) {
        this.valeTransporte = valeTransporte;
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
        hash += (idFuncionario != null ? idFuncionario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CadFuncionarios)) {
            return false;
        }
        CadFuncionarios other = (CadFuncionarios) object;
        if ((this.idFuncionario == null && other.idFuncionario != null) || (this.idFuncionario != null && !this.idFuncionario.equals(other.idFuncionario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.localeader.model.CadFuncionarios[ idFuncionario=" + idFuncionario + " ]";
    }
    
}
