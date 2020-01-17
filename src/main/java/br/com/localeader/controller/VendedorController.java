/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.controller;

import br.com.localeader.dto.VendedorDto;
import br.com.localeader.entidades.CadDocumentos;
import br.com.localeader.entidades.CadEmail;
import br.com.localeader.entidades.CadEndereco;
import br.com.localeader.entidades.CadPessoa;
import br.com.localeader.entidades.CadTelefone;
import br.com.localeader.entidades.CadVendedor;
import br.com.localeader.enums.UF;
import br.com.localeader.service.CadDocumentosService;
import br.com.localeader.service.CadEmailService;
import br.com.localeader.service.CadEnderecoService;
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
@RequestMapping("/vendedor")
public class VendedorController {
    
    @Autowired
    private CadVendedorService vendedorService;

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
        model.addAttribute("vendedor", vendedorService.buscarTodos());
        return "/vendedor/listar";
    }
 
    @GetMapping("/cadastro")
    public String cadastrarVendedor(CadVendedor vendedor) {
        return "/vendedor/cadastrar";
    }

    @PostMapping("/salvar")
    public String salvar(VendedorDto vendedorDto, RedirectAttributes attr) {

        if (vendedorService.existeVendedor(vendedorDto.getCpf(), vendedorDto.getCnpj()) == false) {
            attr.addFlashAttribute("fail", "Já existe um vendedor cadastrado para o documento informado.");
        } else {
            CadPessoa pessoa = this.converterDtoEmPessoa(vendedorDto);
            pessoaService.salvar(pessoa);
            CadDocumentos documentos = this.converterEmCadDocumentos(vendedorDto);
            //documentos.setPessoaFk(pessoaService.buscarPorId(pessoa.getIdPessoa()));
            documentos.setPessoaFk(pessoa);
            documentosService.salvar(documentos);
            documentos = documentosService.buscarPorId(documentos.getIdDocumentos());
            CadVendedor vendedor = this.converterEmCadVendedor(vendedorDto);
            //fornecedor.setDocumentoFk(documentos);
            vendedor.setDocumentoFk(documentos);
            vendedorService.salvar(vendedor);
            CadEndereco endereco = this.converterEmCadEndereco(vendedorDto);
            endereco.setDocumentoFk(documentos);
            // endereco.setUsuarioFk(usuarioFk);
            enderecoService.salvar(endereco);
            CadTelefone telefone = this.converterEmCadTelefone(vendedorDto);
            telefone.setDocumentoFk(documentos);
            telefoneService.salvar(telefone);
            CadEmail email = this.converterEmCadEmail(vendedorDto);
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
        model.addAttribute("vendedor", vendedorService.buscarPorId(id));
        return "/vendedor/cadastrar";
    }

    @PostMapping("/editar")
    public String editar(CadVendedor vendedor, RedirectAttributes attr) {
        vendedorService.editar(vendedor);
        attr.addFlashAttribute("success", "Vendedor editado com sucesso.");
        return "redirect:/vendedor/cadastrar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Integer id, ModelMap model) {
        CadVendedor vendedor = vendedorService.buscarPorId(id);
        CadDocumentos documentos = documentosService.buscarPorId(vendedor.getDocumentoFk().getIdDocumentos());
        CadPessoa pessoa = pessoaService.buscarPorId(documentos.getPessoaFk().getIdPessoa());
        pessoa.setSituacao("NAO");
        pessoaService.editar(pessoa);
        model.addAttribute("success", "Vendedor excluído com sucesso.");
        return listar(model);
    }
    
    private CadVendedor converterEmCadVendedor(VendedorDto dto) {
        CadVendedor vendedor = new CadVendedor();
        vendedor.setDataAlteracao(new Date());
        vendedor.setDataInsercao(new Date());
        return vendedor;
    }

    private CadPessoa converterDtoEmPessoa(VendedorDto dto) {
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

    private CadEmail converterEmCadEmail(VendedorDto dto) {
        CadEmail cadEmail = new CadEmail();
        cadEmail.setDataAlteracao(new Date());
        cadEmail.setDataInsercao(new Date());
        cadEmail.setEmail(dto.getEmail());
        cadEmail.setObservacao(dto.getObservacaoEmail());
        cadEmail.setSite(dto.getSite());
        return cadEmail;
    }

    private CadTelefone converterEmCadTelefone(VendedorDto dto) {
        CadTelefone cadTelefone = new CadTelefone();
        cadTelefone.setDataAlteracao(new Date());
        cadTelefone.setDataInsercao(new Date());
        cadTelefone.setDdd(dto.getDdd());
        cadTelefone.setTelefone(dto.getTelefone());
        cadTelefone.setWhatsapp(dto.getWhatsapp());
        return cadTelefone;
    }

    private CadDocumentos converterEmCadDocumentos(VendedorDto dto) {
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

    private CadEndereco converterEmCadEndereco(VendedorDto dto) {
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
