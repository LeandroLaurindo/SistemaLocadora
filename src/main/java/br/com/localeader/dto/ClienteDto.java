/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.dto;

import br.com.localeader.entidades.CadDocumentos;
import br.com.localeader.entidades.Usuario;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

/**
 *
 * @author Leandro Laurindo
 */
public class ClienteDto {

    private Integer idUsuario;

    private Integer idEmail;

    private Integer idTelefone;

    private Integer idDucumento;

    private Integer idPessoa;

    private Integer idHabilitacao;

    private Integer idCliente;

    //campos classe cliente
    private Integer ClassificacaoFk;

    private String valorCretido;

    private String obsCliente;

    private String origemCliente;

    private String planoPgto;

    private Integer representanteLegalFk;

    private Integer segmentoFk;

    private Integer tabelaPreocoFk;

    private Integer vendedorFk;

    private Integer documentoFk;

    //campos classe cadDocumentos
    @CNPJ(message = "Cnpj inválido.")
    private String cnpj;
    @CPF(message = "cpf inválido")
    private String cpf;
    private String inscricaoEstudal;
    private String inscricaoMunicipal;
    private String passaporte;
    private String rg;
    private String suframa;
    private Date validadePassaporte;
    private int usuarioFk;
    private Integer pessoaFk;

    //campos cademail
    @NotEmpty(message = "O email não pode ser vazio.")
    @Email(message = "Email inválido.")
    private String email;
    private String observacaoEmail;
    private String site;

    //campos cadendereco  private String bairro;
    @NotEmpty(message = "Bairro não pode ser vazio.")
    private String bairro;
    @NotEmpty(message = "Cep não pode ser vazio.")
    private String cep;
    @NotEmpty(message = "Cidade não pode ser vazio.")
    private String cidade;
    private String complemento;
    @NotEmpty(message = "Endereço não pode ser vazio.")
    private String logradouro;
    private String numero;
    private String uf;

    //campos cadhabilitacao
    private String categoria;
    private String cnh;
    private Date emissao;
    private String numRegistro;
    private String numSeguranca;
    private String orgao;
    private Date validade;

    //campos pessoa
    private String conjuge;
    @NotEmpty(message = "Data de nascimento não pode ser vazio.")
    private Date dataNascimento;
    private String estadoCivil;
    private Boolean estrangeiro;
    private String nacionalidade;
    @Size(min = 1, max = 150)
    @NotEmpty(message = "Nome não pode ser vazio.")
    private String nome;
    @NotEmpty(message = "Pais não pode ser vazio.")
    private String pais;
    private String profissao;
    @Size(max = 150)
    @Column(name = "razao_social")
    private String razaoSocial;
    @NotEmpty(message = "O campo sexo não pode ser vazio.")
    private String sexo;
    private String situacao;
    @NotEmpty(message = "Tipo pessoa não pode ser vazio.")
    private String tipoPessoa;

    //campos cadtelefone;
    @NotEmpty(message = "DDD não pode ser vazio.")
    private int ddd;
    @Size(min = 1, max = 10)
    @NotEmpty(message = "Telefone não pode ser vazio.")
    private String telefone;
    private Boolean whatsapp;

    public ClienteDto() {
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdEmail() {
        return idEmail;
    }

    public void setIdEmail(Integer idEmail) {
        this.idEmail = idEmail;
    }

    public Integer getIdTelefone() {
        return idTelefone;
    }

    public void setIdTelefone(Integer idTelefone) {
        this.idTelefone = idTelefone;
    }

    public Integer getIdDucumento() {
        return idDucumento;
    }

    public void setIdDucumento(Integer idDucumento) {
        this.idDucumento = idDucumento;
    }

    public Integer getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }

    public Integer getIdHabilitacao() {
        return idHabilitacao;
    }

    public void setIdHabilitacao(Integer idHabilitacao) {
        this.idHabilitacao = idHabilitacao;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getClassificacaoFk() {
        return ClassificacaoFk;
    }

    public void setClassificacaoFk(Integer ClassificacaoFk) {
        this.ClassificacaoFk = ClassificacaoFk;
    }

    public String getValorCretido() {
        return valorCretido;
    }

    public void setValorCretido(String valorCretido) {
        this.valorCretido = valorCretido;
    }

    public String getObsCliente() {
        return obsCliente;
    }

    public void setObsCliente(String obsCliente) {
        this.obsCliente = obsCliente;
    }

    public String getOrigemCliente() {
        return origemCliente;
    }

    public void setOrigemCliente(String origemCliente) {
        this.origemCliente = origemCliente;
    }

    public String getPlanoPgto() {
        return planoPgto;
    }

    public void setPlanoPgto(String planoPgto) {
        this.planoPgto = planoPgto;
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

    public Integer getTabelaPreocoFk() {
        return tabelaPreocoFk;
    }

    public void setTabelaPreocoFk(Integer tabelaPreocoFk) {
        this.tabelaPreocoFk = tabelaPreocoFk;
    }

    public Integer getVendedorFk() {
        return vendedorFk;
    }

    public void setVendedorFk(Integer vendedorFk) {
        this.vendedorFk = vendedorFk;
    }

    public Integer getDocumentoFk() {
        return documentoFk;
    }

    public void setDocumentoFk(Integer documentoFk) {
        this.documentoFk = documentoFk;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getInscricaoEstudal() {
        return inscricaoEstudal;
    }

    public void setInscricaoEstudal(String inscricaoEstudal) {
        this.inscricaoEstudal = inscricaoEstudal;
    }

    public String getInscricaoMunicipal() {
        return inscricaoMunicipal;
    }

    public void setInscricaoMunicipal(String inscricaoMunicipal) {
        this.inscricaoMunicipal = inscricaoMunicipal;
    }

    public String getPassaporte() {
        return passaporte;
    }

    public void setPassaporte(String passaporte) {
        this.passaporte = passaporte;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getSuframa() {
        return suframa;
    }

    public void setSuframa(String suframa) {
        this.suframa = suframa;
    }

    public int getUsuarioFk() {
        return usuarioFk;
    }

    public void setUsuarioFk(int usuarioFk) {
        this.usuarioFk = usuarioFk;
    }

    public Integer getPessoaFk() {
        return pessoaFk;
    }

    public void setPessoaFk(Integer pessoaFk) {
        this.pessoaFk = pessoaFk;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getObservacaoEmail() {
        return observacaoEmail;
    }

    public void setObservacaoEmail(String observacaoEmail) {
        this.observacaoEmail = observacaoEmail;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
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

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public Date getEmissao() {
        return emissao;
    }

    public void setEmissao(Date emissao) {
        this.emissao = emissao;
    }

    public String getNumRegistro() {
        return numRegistro;
    }

    public void setNumRegistro(String numRegistro) {
        this.numRegistro = numRegistro;
    }

    public String getNumSeguranca() {
        return numSeguranca;
    }

    public void setNumSeguranca(String numSeguranca) {
        this.numSeguranca = numSeguranca;
    }

    public String getOrgao() {
        return orgao;
    }

    public void setOrgao(String orgao) {
        this.orgao = orgao;
    }

    public Date getValidade() {
        return validade;
    }

    public void setValidade(Date validade) {
        this.validade = validade;
    }

    public String getConjuge() {
        return conjuge;
    }

    public void setConjuge(String conjuge) {
        this.conjuge = conjuge;
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

    public Date getValidadePassaporte() {
        return validadePassaporte;
    }

    public void setValidadePassaporte(Date validadePassaporte) {
        this.validadePassaporte = validadePassaporte;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
   
}
