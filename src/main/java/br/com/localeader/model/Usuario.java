/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.model;

import br.com.localeader.enums.PerfilEnum;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Leandro Laurindo
 */
@Entity
@Table(name = "usuario", catalog = "localeader", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
    , @NamedQuery(name = "Usuario.findByIdUsuario", query = "SELECT u FROM Usuario u WHERE u.idUsuario = :idUsuario")
    , @NamedQuery(name = "Usuario.findByAtivo", query = "SELECT u FROM Usuario u WHERE u.ativo = :ativo")
    , @NamedQuery(name = "Usuario.findByLogin", query = "SELECT u FROM Usuario u WHERE u.login = :login")
    , @NamedQuery(name = "Usuario.findBySenha", query = "SELECT u FROM Usuario u WHERE u.senha = :senha")
    , @NamedQuery(name = "Usuario.findByPerfil", query = "SELECT u FROM Usuario u WHERE u.perfil = :perfil")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_usuario")
    private Integer idUsuario;
    @Size(max = 3)
    @Column(name = "ativo")
    private String ativo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "login", nullable = false, unique = true)
    private String login;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "senha")
    private String senha;
    @Enumerated(EnumType.STRING)
    @Column(name = "perfil" , nullable = false)
    private PerfilEnum perfil;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioFk")
    private List<CadFuncionarios> cadFuncionariosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioFk")
    private List<CadEmail> cadEmailList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioFk")
    private List<CadFornecedor> cadFornecedorList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioFk")
    private List<CadVendedor> cadVendedorList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioFk")
    private List<CadTelefone> cadTelefoneList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioFk")
    private List<CadOcorrencias> cadOcorrenciasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioFk")
    private List<CadPessoa> cadPessoaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioFk")
    private List<CadEndereco> cadEnderecoList;

    public Usuario() {
    }

    public Usuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuario(Integer idUsuario, String ativo, String login, String senha, PerfilEnum perfil) {
        this.idUsuario = idUsuario;
        this.ativo = ativo;
        this.login = login;
        this.senha = senha;
        this.perfil = perfil;
    }

    

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getAtivo() {
        return ativo;
    }

    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public PerfilEnum getPerfil() {
        return perfil;
    }

    public void setPerfil(PerfilEnum perfil) {
        this.perfil = perfil;
    }

   

    @XmlTransient
    public List<CadFuncionarios> getCadFuncionariosList() {
        return cadFuncionariosList;
    }

    public void setCadFuncionariosList(List<CadFuncionarios> cadFuncionariosList) {
        this.cadFuncionariosList = cadFuncionariosList;
    }

    @XmlTransient
    public List<CadEmail> getCadEmailList() {
        return cadEmailList;
    }

    public void setCadEmailList(List<CadEmail> cadEmailList) {
        this.cadEmailList = cadEmailList;
    }

    @XmlTransient
    public List<CadFornecedor> getCadFornecedorList() {
        return cadFornecedorList;
    }

    public void setCadFornecedorList(List<CadFornecedor> cadFornecedorList) {
        this.cadFornecedorList = cadFornecedorList;
    }

    @XmlTransient
    public List<CadVendedor> getCadVendedorList() {
        return cadVendedorList;
    }

    public void setCadVendedorList(List<CadVendedor> cadVendedorList) {
        this.cadVendedorList = cadVendedorList;
    }

    @XmlTransient
    public List<CadTelefone> getCadTelefoneList() {
        return cadTelefoneList;
    }

    public void setCadTelefoneList(List<CadTelefone> cadTelefoneList) {
        this.cadTelefoneList = cadTelefoneList;
    }

    @XmlTransient
    public List<CadOcorrencias> getCadOcorrenciasList() {
        return cadOcorrenciasList;
    }

    public void setCadOcorrenciasList(List<CadOcorrencias> cadOcorrenciasList) {
        this.cadOcorrenciasList = cadOcorrenciasList;
    }

    @XmlTransient
    public List<CadPessoa> getCadPessoaList() {
        return cadPessoaList;
    }

    public void setCadPessoaList(List<CadPessoa> cadPessoaList) {
        this.cadPessoaList = cadPessoaList;
    }

    @XmlTransient
    public List<CadEndereco> getCadEnderecoList() {
        return cadEnderecoList;
    }

    public void setCadEnderecoList(List<CadEndereco> cadEnderecoList) {
        this.cadEnderecoList = cadEnderecoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.localeader.model.Usuario[ idUsuario=" + idUsuario + " ]";
    }
    
}
