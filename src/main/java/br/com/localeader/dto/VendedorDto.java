/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.dto;

import java.util.Date;
import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

/**
 *
 * @author Filip
 */
public class VendedorDto {
    
    private Integer idUsuario;

    private Integer idEmail;

    private Integer idTelefone;

    private Integer idDucumento;

    private Integer idPessoa;

    private Integer idVendedor;

    //campos classe fornecedor

    private Integer segmentoFk;

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
    
    /**
     * @return the idUsuario
     */
    public Integer getIdUsuario() {
        return idUsuario;
    }

    /**
     * @param idUsuario the idUsuario to set
     */
    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * @return the idEmail
     */
    public Integer getIdEmail() {
        return idEmail;
    }

    /**
     * @param idEmail the idEmail to set
     */
    public void setIdEmail(Integer idEmail) {
        this.idEmail = idEmail;
    }

    /**
     * @return the idTelefone
     */
    public Integer getIdTelefone() {
        return idTelefone;
    }

    /**
     * @param idTelefone the idTelefone to set
     */
    public void setIdTelefone(Integer idTelefone) {
        this.idTelefone = idTelefone;
    }

    /**
     * @return the idDucumento
     */
    public Integer getIdDucumento() {
        return idDucumento;
    }

    /**
     * @param idDucumento the idDucumento to set
     */
    public void setIdDucumento(Integer idDucumento) {
        this.idDucumento = idDucumento;
    }

    /**
     * @return the idPessoa
     */
    public Integer getIdPessoa() {
        return idPessoa;
    }

    /**
     * @param idPessoa the idPessoa to set
     */
    public void setIdPessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }

    /**
     * @return the idVendedor
     */
    public Integer getIdVendedor() {
        return idVendedor;
    }

    /**
     * @param idVendedor the idVendedor to set
     */
    public void setIdVendedor(Integer idVendedor) {
        this.idVendedor = idVendedor;
    }

    /**
     * @return the segmentoFk
     */
    public Integer getSegmentoFk() {
        return segmentoFk;
    }

    /**
     * @param segmentoFk the segmentoFk to set
     */
    public void setSegmentoFk(Integer segmentoFk) {
        this.segmentoFk = segmentoFk;
    }

    /**
     * @return the documentoFk
     */
    public Integer getDocumentoFk() {
        return documentoFk;
    }

    /**
     * @param documentoFk the documentoFk to set
     */
    public void setDocumentoFk(Integer documentoFk) {
        this.documentoFk = documentoFk;
    }

    /**
     * @return the cnpj
     */
    public String getCnpj() {
        return cnpj;
    }

    /**
     * @param cnpj the cnpj to set
     */
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the inscricaoEstudal
     */
    public String getInscricaoEstudal() {
        return inscricaoEstudal;
    }

    /**
     * @param inscricaoEstudal the inscricaoEstudal to set
     */
    public void setInscricaoEstudal(String inscricaoEstudal) {
        this.inscricaoEstudal = inscricaoEstudal;
    }

    /**
     * @return the inscricaoMunicipal
     */
    public String getInscricaoMunicipal() {
        return inscricaoMunicipal;
    }

    /**
     * @param inscricaoMunicipal the inscricaoMunicipal to set
     */
    public void setInscricaoMunicipal(String inscricaoMunicipal) {
        this.inscricaoMunicipal = inscricaoMunicipal;
    }

    /**
     * @return the passaporte
     */
    public String getPassaporte() {
        return passaporte;
    }

    /**
     * @param passaporte the passaporte to set
     */
    public void setPassaporte(String passaporte) {
        this.passaporte = passaporte;
    }

    /**
     * @return the rg
     */
    public String getRg() {
        return rg;
    }

    /**
     * @param rg the rg to set
     */
    public void setRg(String rg) {
        this.rg = rg;
    }

    /**
     * @return the suframa
     */
    public String getSuframa() {
        return suframa;
    }

    /**
     * @param suframa the suframa to set
     */
    public void setSuframa(String suframa) {
        this.suframa = suframa;
    }

    /**
     * @return the validadePassaporte
     */
    public Date getValidadePassaporte() {
        return validadePassaporte;
    }

    /**
     * @param validadePassaporte the validadePassaporte to set
     */
    public void setValidadePassaporte(Date validadePassaporte) {
        this.validadePassaporte = validadePassaporte;
    }

    /**
     * @return the usuarioFk
     */
    public int getUsuarioFk() {
        return usuarioFk;
    }

    /**
     * @param usuarioFk the usuarioFk to set
     */
    public void setUsuarioFk(int usuarioFk) {
        this.usuarioFk = usuarioFk;
    }

    /**
     * @return the pessoaFk
     */
    public Integer getPessoaFk() {
        return pessoaFk;
    }

    /**
     * @param pessoaFk the pessoaFk to set
     */
    public void setPessoaFk(Integer pessoaFk) {
        this.pessoaFk = pessoaFk;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the observacaoEmail
     */
    public String getObservacaoEmail() {
        return observacaoEmail;
    }

    /**
     * @param observacaoEmail the observacaoEmail to set
     */
    public void setObservacaoEmail(String observacaoEmail) {
        this.observacaoEmail = observacaoEmail;
    }

    /**
     * @return the site
     */
    public String getSite() {
        return site;
    }

    /**
     * @param site the site to set
     */
    public void setSite(String site) {
        this.site = site;
    }

    /**
     * @return the bairro
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * @param bairro the bairro to set
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    /**
     * @return the cep
     */
    public String getCep() {
        return cep;
    }

    /**
     * @param cep the cep to set
     */
    public void setCep(String cep) {
        this.cep = cep;
    }

    /**
     * @return the cidade
     */
    public String getCidade() {
        return cidade;
    }

    /**
     * @param cidade the cidade to set
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    /**
     * @return the complemento
     */
    public String getComplemento() {
        return complemento;
    }

    /**
     * @param complemento the complemento to set
     */
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    /**
     * @return the logradouro
     */
    public String getLogradouro() {
        return logradouro;
    }

    /**
     * @param logradouro the logradouro to set
     */
    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    /**
     * @return the numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * @return the uf
     */
    public String getUf() {
        return uf;
    }

    /**
     * @param uf the uf to set
     */
    public void setUf(String uf) {
        this.uf = uf;
    }

    /**
     * @return the conjuge
     */
    public String getConjuge() {
        return conjuge;
    }

    /**
     * @param conjuge the conjuge to set
     */
    public void setConjuge(String conjuge) {
        this.conjuge = conjuge;
    }

    /**
     * @return the dataNascimento
     */
    public Date getDataNascimento() {
        return dataNascimento;
    }

    /**
     * @param dataNascimento the dataNascimento to set
     */
    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    /**
     * @return the estadoCivil
     */
    public String getEstadoCivil() {
        return estadoCivil;
    }

    /**
     * @param estadoCivil the estadoCivil to set
     */
    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    /**
     * @return the estrangeiro
     */
    public Boolean getEstrangeiro() {
        return estrangeiro;
    }

    /**
     * @param estrangeiro the estrangeiro to set
     */
    public void setEstrangeiro(Boolean estrangeiro) {
        this.estrangeiro = estrangeiro;
    }

    /**
     * @return the nacionalidade
     */
    public String getNacionalidade() {
        return nacionalidade;
    }

    /**
     * @param nacionalidade the nacionalidade to set
     */
    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the pais
     */
    public String getPais() {
        return pais;
    }

    /**
     * @param pais the pais to set
     */
    public void setPais(String pais) {
        this.pais = pais;
    }

    /**
     * @return the profissao
     */
    public String getProfissao() {
        return profissao;
    }

    /**
     * @param profissao the profissao to set
     */
    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    /**
     * @return the razaoSocial
     */
    public String getRazaoSocial() {
        return razaoSocial;
    }

    /**
     * @param razaoSocial the razaoSocial to set
     */
    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    /**
     * @return the sexo
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /**
     * @return the situacao
     */
    public String getSituacao() {
        return situacao;
    }

    /**
     * @param situacao the situacao to set
     */
    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    /**
     * @return the tipoPessoa
     */
    public String getTipoPessoa() {
        return tipoPessoa;
    }

    /**
     * @param tipoPessoa the tipoPessoa to set
     */
    public void setTipoPessoa(String tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    /**
     * @return the ddd
     */
    public int getDdd() {
        return ddd;
    }

    /**
     * @param ddd the ddd to set
     */
    public void setDdd(int ddd) {
        this.ddd = ddd;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the whatsapp
     */
    public Boolean getWhatsapp() {
        return whatsapp;
    }

    /**
     * @param whatsapp the whatsapp to set
     */
    public void setWhatsapp(Boolean whatsapp) {
        this.whatsapp = whatsapp;
    }
}
