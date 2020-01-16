/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.controller;

import br.com.localeader.dto.FuncionarioDto;
import br.com.localeader.dto.VendedorDto;
import br.com.localeader.entidades.CadDocumentos;
import br.com.localeader.entidades.CadEmail;
import br.com.localeader.entidades.CadEndereco;
import br.com.localeader.entidades.CadFuncionarios;
import br.com.localeader.entidades.CadPessoa;
import br.com.localeader.entidades.CadTelefone;
import br.com.localeader.entidades.CadVendedor;
import br.com.localeader.enums.UF;
import br.com.localeader.service.CadDocumentosService;
import br.com.localeader.service.CadEmailService;
import br.com.localeader.service.CadEnderecoService;
import br.com.localeader.service.CadFuncionariosService;
import br.com.localeader.service.CadPessoaService;
import br.com.localeader.service.CadTelefoneService;
import br.com.localeader.service.CadVendedorService;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Leandro Laurindo
 */
@Controller
@RequestMapping("/funcionario")
public class FuncionariosController {
    
    @Autowired
    private CadFuncionariosService funcionarioService;

    @Autowired
    CadPessoaService pessoaService;

    @Autowired
    CadDocumentosService documentosService;

    @Autowired
    CadEmailService emailService;

    @Autowired
    CadEnderecoService enderecoService;

    @Autowired
    CadTelefoneService telefoneService;

    @GetMapping("/listar")
    public String listar(ModelMap model) {
        model.addAttribute("funcionario", funcionarioService.buscarTodos());
        return "/funcionario/listar";
    }

    @GetMapping("/cadastro")
    public String cadastrarFuncionario(CadFuncionarios funcionario) {
        return "/funcionario/cadastrar";
    }

    @PostMapping("/salvar")
    public String salvar(FuncionarioDto funcionarioDto, RedirectAttributes attr) {

        if (funcionarioService.existeFuncionario(funcionarioDto.getCpf(), funcionarioDto.getCnpj()) == false) {
            attr.addFlashAttribute("fail", "Já existe um funcionário cadastrado para o documento informado.");
        } else {
            CadPessoa pessoa = this.converterDtoEmPessoa(funcionarioDto);
            pessoaService.salvar(pessoa);
            CadDocumentos documentos = this.converterEmCadDocumentos(funcionarioDto);
            //documentos.setPessoaFk(pessoaService.buscarPorId(pessoa.getIdPessoa()));
            documentos.setPessoaFk(pessoa);
            documentosService.salvar(documentos);
            documentos = documentosService.buscarPorId(documentos.getIdDocumentos());
            CadFuncionarios funcionario = this.converterEmCadFuncionario(funcionarioDto);
            //fornecedor.setDocumentoFk(documentos);
            funcionario.setDocumentoFk(documentos);
            funcionarioService.salvar(funcionario);
            CadEndereco endereco = this.converterEmCadEndereco(funcionarioDto);
            endereco.setDocumentoFk(documentos);
            // endereco.setUsuarioFk(usuarioFk);
            enderecoService.salvar(endereco);
            CadTelefone telefone = this.converterEmCadTelefone(funcionarioDto);
            telefone.setDocumentoFk(documentos);
            telefoneService.salvar(telefone);
            CadEmail email = this.converterEmCadEmail(funcionarioDto);
            email.setDocumentoFk(documentos);
            /*if (clienteDto.getCnh() != null) {
                CadHabilitacao habilitacao = this.converterEmCadHabilitacao(fornecedorDto);
                habilitacao.setDocumentoFk(documentos);
                habilitacaoService.salvar(habilitacao);
            }*/

            attr.addFlashAttribute("success", "Vendedor inserido com sucesso.");
        }
        return "redirect:/vendedor/cadastrar";
    }
    
    @GetMapping("/editar/{id}")
    public String preEditar(@PathVariable("id") Integer id, ModelMap model) {
        model.addAttribute("funcionario", funcionarioService.buscarPorId(id));
        return "/funcionario/cadastrar";
    }

    @PostMapping("/editar")
    public String editar(CadFuncionarios funcionario, RedirectAttributes attr) {
        funcionarioService.editar(funcionario);
        attr.addFlashAttribute("success", "Funcionário editado com sucesso.");
        return "redirect:/funcionario/cadastrar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Integer id, ModelMap model) {
        CadFuncionarios funcionario = funcionarioService.buscarPorId(id);
        CadDocumentos documentos = documentosService.buscarPorId(funcionario.getDocumentoFk().getIdDocumentos());
        CadPessoa pessoa = pessoaService.buscarPorId(documentos.getPessoaFk().getIdPessoa());
        pessoa.setSituacao("NAO");
        pessoaService.editar(pessoa);
        model.addAttribute("success", "Funcionário excluído com sucesso.");
        return listar(model);
    }
    
    private CadFuncionarios converterEmCadFuncionario(FuncionarioDto dto) {
        CadFuncionarios funcionario = new CadFuncionarios();
        funcionario.setDataAlteracao(new Date());
        funcionario.setDataInsercao(new Date());
        return funcionario;
    }

    private CadPessoa converterDtoEmPessoa(FuncionarioDto dto) {
        CadPessoa cadPessoa = new CadPessoa();
        cadPessoa.setConjuge(dto.getConjuge());
        cadPessoa.setDataAlteracao(new Date());
        cadPessoa.setDataInsercao(new Date());
        cadPessoa.setDataNascimento(dto.getDataNascimento());
        cadPessoa.setEstadoCivil(dto.getEstadoCivil());
        cadPessoa.setEstrangeiro(dto.getEstrangeiro());
        cadPessoa.setNacionalidade(dto.getNacionalidade());
        cadPessoa.setNome(dto.getNome());
        cadPessoa.setPais(dto.getPais());
        cadPessoa.setProfissao(dto.getProfissao());
        cadPessoa.setRazaoSocial(dto.getRazaoSocial());
        cadPessoa.setSexo(dto.getSexo());
        cadPessoa.setSituacao(dto.getSituacao());
        cadPessoa.setTipoPessoa(dto.getTipoPessoa());
        return cadPessoa;
    }

    private CadEmail converterEmCadEmail(FuncionarioDto dto) {
        CadEmail cadEmail = new CadEmail();
        cadEmail.setDataAlteracao(new Date());
        cadEmail.setDataInsercao(new Date());
        cadEmail.setEmail(dto.getEmail());
        cadEmail.setObservacao(dto.getObservacaoEmail());
        cadEmail.setSite(dto.getSite());
        return cadEmail;
    }

    private CadTelefone converterEmCadTelefone(FuncionarioDto dto) {
        CadTelefone cadTelefone = new CadTelefone();
        cadTelefone.setDataAlteracao(new Date());
        cadTelefone.setDataInsercao(new Date());
        cadTelefone.setDdd(dto.getDdd());
        cadTelefone.setTelefone(dto.getTelefone());
        cadTelefone.setWhatsapp(dto.getWhatsapp());
        return cadTelefone;
    }

    private CadDocumentos converterEmCadDocumentos(FuncionarioDto dto) {
        CadDocumentos documentos = new CadDocumentos();
        documentos.setCnpj(dto.getCnpj());
        documentos.setCpf(dto.getCpf());
        documentos.setDataAlteracao(new Date());
        documentos.setDataInsercao(new Date());
        documentos.setInscricaoEstudal(dto.getInscricaoEstudal());
        documentos.setInscricaoMunicipal(dto.getInscricaoMunicipal());
        documentos.setPassaporte(dto.getPassaporte());
        documentos.setRg(dto.getRg());
        documentos.setSuframa(dto.getSuframa());
        documentos.setValidadePassaporte(dto.getValidadePassaporte());
        return documentos;
    }

    private CadEndereco converterEmCadEndereco(FuncionarioDto dto) {
        CadEndereco cadEndereco = new CadEndereco();
        cadEndereco.setBairro(dto.getBairro());
        cadEndereco.setCep(dto.getCep());
        cadEndereco.setCidade(dto.getCidade());
        cadEndereco.setLogradouro(dto.getLogradouro());
        cadEndereco.setComplemento(dto.getComplemento());
        cadEndereco.setDataAlteracao(new Date());
        cadEndereco.setDataInsercao(new Date());
        cadEndereco.setNumero(dto.getNumero());
        cadEndereco.setUf(UF.MG);
        return cadEndereco;
    }
}
