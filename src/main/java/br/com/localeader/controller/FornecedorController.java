/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.controller;

import br.com.localeader.dto.FornecedorDto;
import br.com.localeader.entidades.CadDocumentos;
import br.com.localeader.entidades.CadEmail;
import br.com.localeader.entidades.CadEndereco;
import br.com.localeader.entidades.CadFornecedor;
import br.com.localeader.entidades.CadPessoa;
import br.com.localeader.entidades.CadTelefone;
import br.com.localeader.enums.UF;
import br.com.localeader.service.CadDocumentosService;
import br.com.localeader.service.CadEmailService;
import br.com.localeader.service.CadEnderecoService;
import br.com.localeader.service.CadFornecedorService;
import br.com.localeader.service.CadPessoaService;
import br.com.localeader.service.CadTelefoneService;
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
@RequestMapping("/fornecedor")
public class FornecedorController {

    @Autowired
    private CadFornecedorService fornecedorService;

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
        model.addAttribute("fornecedor", fornecedorService.buscarTodos());
        return "/fornecedor/listar";
    }

    @GetMapping("/cadastro")
    public String cadastrarFornecedor(CadFornecedor fornecedor) {
        return "/fornecedor/cadastrar";
    }

    @PostMapping("/salvar")
    public String salvar(FornecedorDto fornecedorDto, RedirectAttributes attr) {

        if (fornecedorService.existeFornecedor(fornecedorDto.getCpf(), fornecedorDto.getCnpj()) == false) {
            attr.addFlashAttribute("fail", "Já existe um fornecedor cadastrado para o documento informado.");
        } else {
            CadPessoa pessoa = this.converterDtoEmPessoa(fornecedorDto);
            pessoaService.salvar(pessoa);
            CadDocumentos documentos = this.converterEmCadDocumentos(fornecedorDto);
            //documentos.setPessoaFk(pessoaService.buscarPorId(pessoa.getIdPessoa()));
            documentos.setPessoaFk(pessoa);
            documentosService.salvar(documentos);
            documentos = documentosService.buscarPorId(documentos.getIdDocumentos());
            CadFornecedor fornecedor = this.converterEmCadFornecedor(fornecedorDto);
            //fornecedor.setDocumentoFk(documentos);
            fornecedor.setDocumentoFk(documentos);
            fornecedorService.salvar(fornecedor);
            CadEndereco endereco = this.converterEmCadEndereco(fornecedorDto);
            endereco.setDocumentoFk(documentos);
            // endereco.setUsuarioFk(usuarioFk);
            enderecoService.salvar(endereco);
            CadTelefone telefone = this.converterEmCadTelefone(fornecedorDto);
            telefone.setDocumentoFk(documentos);
            telefoneService.salvar(telefone);
            CadEmail email = this.converterEmCadEmail(fornecedorDto);
            email.setDocumentoFk(documentos);
            /*if (clienteDto.getCnh() != null) {
                CadHabilitacao habilitacao = this.converterEmCadHabilitacao(fornecedorDto);
                habilitacao.setDocumentoFk(documentos);
                habilitacaoService.salvar(habilitacao);
            }*/

            attr.addFlashAttribute("success", "Fornecedor inserido com sucesso.");
        }
        return "redirect:/fornecedor/cadastrar";
    }
    
    @GetMapping("/editar/{id}")
    public String preEditar(@PathVariable("id") Integer id, ModelMap model) {
        model.addAttribute("fornecedor", fornecedorService.buscarPorId(id));
        return "/fornecedor/cadastrar";
    }

    @PostMapping("/editar")
    public String editar(CadFornecedor fornecedor, RedirectAttributes attr) {
        fornecedorService.editar(fornecedor);
        attr.addFlashAttribute("success", "Fornecedor editado com sucesso.");
        return "redirect:/fornecedor/cadastrar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Integer id, ModelMap model) {
        CadFornecedor fornecedor = fornecedorService.buscarPorId(id);
        CadDocumentos documentos = documentosService.buscarPorId(fornecedor.getDocumentoFk().getIdDocumentos());
        CadPessoa pessoa = pessoaService.buscarPorId(documentos.getPessoaFk().getIdPessoa());
        pessoa.setSituacao("NAO");
        pessoaService.editar(pessoa);
        model.addAttribute("success", "Fornecedor excluído com sucesso.");
        return listar(model);
    }
    
    private CadFornecedor converterEmCadFornecedor(FornecedorDto dto) {
        CadFornecedor fornecedor = new CadFornecedor();
        fornecedor.setAgencia(dto.getAgencia());
        fornecedor.setBanco(dto.getBanco());
        fornecedor.setConta(dto.getConta());
        fornecedor.setDataAlteracao(new Date());
        fornecedor.setDataInsercao(new Date());
        fornecedor.setSegmentoFk(dto.getSegmentoFk());
        return fornecedor;
    }

    private CadPessoa converterDtoEmPessoa(FornecedorDto dto) {
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

    private CadEmail converterEmCadEmail(FornecedorDto dto) {
        CadEmail cadEmail = new CadEmail();
        cadEmail.setDataAlteracao(new Date());
        cadEmail.setDataInsercao(new Date());
        cadEmail.setEmail(dto.getEmail());
        cadEmail.setObservacao(dto.getObservacaoEmail());
        cadEmail.setSite(dto.getSite());
        return cadEmail;
    }

    private CadTelefone converterEmCadTelefone(FornecedorDto dto) {
        CadTelefone cadTelefone = new CadTelefone();
        cadTelefone.setDataAlteracao(new Date());
        cadTelefone.setDataInsercao(new Date());
        cadTelefone.setDdd(dto.getDdd());
        cadTelefone.setTelefone(dto.getTelefone());
        cadTelefone.setWhatsapp(dto.getWhatsapp());
        return cadTelefone;
    }

    private CadDocumentos converterEmCadDocumentos(FornecedorDto dto) {
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

    private CadEndereco converterEmCadEndereco(FornecedorDto dto) {
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
