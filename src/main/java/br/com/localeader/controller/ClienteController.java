/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.controller;

import br.com.localeader.dao.CadClienteDao;
import br.com.localeader.dto.ClienteDto;
import br.com.localeader.enums.UF;
import br.com.localeader.entidades.CadCliente;
import br.com.localeader.entidades.CadDocumentos;
import br.com.localeader.entidades.CadEmail;
import br.com.localeader.entidades.CadEndereco;
import br.com.localeader.entidades.CadHabilitacao;
import br.com.localeader.entidades.CadPessoa;
import br.com.localeader.entidades.CadTelefone;
import br.com.localeader.service.CadClienteService;
import br.com.localeader.service.CadDocumentosService;
import br.com.localeader.service.CadEmailService;
import br.com.localeader.service.CadEnderecoService;
import br.com.localeader.service.CadHabilitacaoService;
import br.com.localeader.service.CadPessoaService;
import br.com.localeader.service.CadTelefoneService;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    CadClienteService serviceCliente;

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

    @Autowired
    CadHabilitacaoService habilitacaoService;

    @GetMapping("/cadastrar")
    public String cadastrar(CadClienteDao cliente) {
        return "/cliente/cadastrar";
    }

    @GetMapping("/listar")
    public String listar(ModelMap model) {
        List<CadCliente> cli = serviceCliente.buscarTodos();
        List<CadCliente> lista = new ArrayList<>();
        for (CadCliente cadCliente : cli) {
            if (!cadCliente.getDocumentoFk().getPessoaFk().getSituacao().equalsIgnoreCase("NAO")) {
                lista.add(cadCliente);
            }
        }
        model.addAttribute("clientes", lista);
        return "/cliente/listar";
    }

    @PostMapping("/salvar")
    public String salvar(ClienteDto clienteDto, RedirectAttributes attr) {

        if (serviceCliente.existeCliente(clienteDto.getCpf(), clienteDto.getCnpj()) == false) {
            attr.addFlashAttribute("fail", "Já existe um cliente cadastrado para o documento informado.");
        } else {
            CadPessoa  pessoa = this.converterDtoEmPessoa(clienteDto);
            pessoaService.salvar(pessoa);
            CadDocumentos documentos = this.converterEmCadDocumentos(clienteDto);
            documentos.setPessoaFk(pessoaService.buscarPorId(pessoa.getIdPessoa()));
            documentos.setPessoaFk(pessoa);
            documentosService.salvar(documentos);
            documentos = documentosService.buscarPorId(documentos.getIdDocumentos());
            CadCliente cliente = this.converterDtoEmCadCliente(clienteDto);
            cliente.setDocumentoFk(documentos);
            cliente.setDocumentoFk(documentos);
            serviceCliente.salvar(cliente);
            CadEndereco endereco = this.converterEmCadEndereco(clienteDto);
            endereco.setDocumentoFk(documentos);
           // endereco.setUsuarioFk(usuarioFk);
            enderecoService.salvar(endereco);
            CadTelefone telefone = this.converterEmCadTelefone(clienteDto);
            telefone.setDocumentoFk(documentos);
            telefoneService.salvar(telefone);
             CadEmail email = this.converterEmCadEmail(clienteDto);
            email.setDocumentoFk(documentos);
            if (clienteDto.getCnh() != null) {
                CadHabilitacao habilitacao = this.converterEmCadHabilitacao(clienteDto);
                habilitacao.setDocumentoFk(documentos);
                habilitacaoService.salvar(habilitacao);
            }

            attr.addFlashAttribute("success", "Cliente inserido com sucesso.");
        }
        return "redirect:/cliente/cadastrar";
    }

    @GetMapping("/editar/{id}")
    public String preEditar(@PathVariable("id") Integer id, ModelMap model) {
        model.addAttribute("cliente", serviceCliente.buscarPorId(id));
        return "/cliente/cadastrar";
    }

    @PostMapping("/editar")
    public String editar(CadCliente departamento, RedirectAttributes attr) {
        serviceCliente.editar(departamento);
        attr.addFlashAttribute("success", "Cliente editado com sucesso.");
        return "redirect:/cliente/cadastrar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Integer id, ModelMap model) {
        CadCliente cliente = serviceCliente.buscarPorId(id);
        CadDocumentos documentos = documentosService.buscarPorId(cliente.getDocumentoFk().getIdDocumentos());
        CadPessoa pessoa = pessoaService.buscarPorId(documentos.getPessoaFk().getIdPessoa());
        pessoa.setSituacao("NAO");
        pessoaService.editar(pessoa);
        model.addAttribute("success", "Cliente excluído com sucesso.");
        return listar(model);
    }

    private CadPessoa converterDtoEmPessoa(ClienteDto dto) {
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

    private CadCliente converterDtoEmCadCliente(ClienteDto dto) {
        CadCliente cadCliente = new CadCliente();
        cadCliente.setClassificacaoFk(dto.getClassificacaoFk());
        cadCliente.setLimiteCredito(formatarValor(dto.getValorCretido()));
        cadCliente.setObservacao(dto.getObsCliente());
        cadCliente.setOrigemCliente(dto.getOrigemCliente());
        cadCliente.setPlanoPagto(dto.getPlanoPgto());
        cadCliente.setRepresentanteLegalFk(dto.getRepresentanteLegalFk());
        cadCliente.setSegmentoFk(dto.getSegmentoFk());
        cadCliente.setTabelaPrecoFk(dto.getTabelaPreocoFk());
        cadCliente.setVendedorFk(dto.getVendedorFk());
        return cadCliente;
    }

    private CadEmail converterEmCadEmail(ClienteDto dto) {
        CadEmail cadEmail = new CadEmail();
        cadEmail.setDataAlteracao(new Date());
        cadEmail.setDataInsercao(new Date());
        cadEmail.setEmail(dto.getEmail());
        cadEmail.setObservacao(dto.getObservacaoEmail());
        cadEmail.setSite(dto.getSite());
        return cadEmail;
    }

    private CadTelefone converterEmCadTelefone(ClienteDto dto) {
        CadTelefone cadTelefone = new CadTelefone();
        cadTelefone.setDataAlteracao(new Date());
        cadTelefone.setDataInsercao(new Date());
        cadTelefone.setDdd(dto.getDdd());
        cadTelefone.setTelefone(dto.getTelefone());
        cadTelefone.setWhatsapp(dto.getWhatsapp());
        return cadTelefone;
    }
    
    private CadDocumentos converterEmCadDocumentos(ClienteDto dto) {
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
    
    private CadHabilitacao converterEmCadHabilitacao(ClienteDto dto) {
        CadHabilitacao habilitacao = new CadHabilitacao();
        habilitacao.setCategoria(dto.getCategoria());
        habilitacao.setCnh(dto.getCnh());
        habilitacao.setEmissao(dto.getEmissao());
        habilitacao.setNumRegistro(dto.getNumRegistro());
        habilitacao.setNumSeguranca(dto.getNumSeguranca());
        habilitacao.setOrgao(dto.getOrgao());
        habilitacao.setValidade(dto.getValidade());
        return habilitacao;
    }
   

  private CadEndereco converterEmCadEndereco(ClienteDto dto) {
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
     

    private BigDecimal formatarValor(String v) {
        v = v.replaceAll(".", "");
        v = v.replaceAll(",", ".");
        return new BigDecimal(v);
    }
}
