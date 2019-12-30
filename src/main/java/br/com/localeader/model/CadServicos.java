/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Leandro Laurindo
 */
@Entity
@Table(name = "cad_servicos", catalog = "localeader", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CadServicos.findAll", query = "SELECT c FROM CadServicos c")
    , @NamedQuery(name = "CadServicos.findByIdServico", query = "SELECT c FROM CadServicos c WHERE c.idServico = :idServico")
    , @NamedQuery(name = "CadServicos.findByCodigoServico", query = "SELECT c FROM CadServicos c WHERE c.codigoServico = :codigoServico")
    , @NamedQuery(name = "CadServicos.findByDescricao", query = "SELECT c FROM CadServicos c WHERE c.descricao = :descricao")
    , @NamedQuery(name = "CadServicos.findByNomeServico", query = "SELECT c FROM CadServicos c WHERE c.nomeServico = :nomeServico")
    , @NamedQuery(name = "CadServicos.findByTipoServico", query = "SELECT c FROM CadServicos c WHERE c.tipoServico = :tipoServico")})
public class CadServicos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_servico")
    private Integer idServico;
    @Column(name = "codigo_servico")
    private Integer codigoServico;
    @Size(max = 150)
    @Column(name = "descricao")
    private String descricao;
    @Size(max = 30)
    @Column(name = "nome_servico")
    private String nomeServico;
    @Size(max = 255)
    @Column(name = "tipo_servico")
    private String tipoServico;

    public CadServicos() {
    }

    public CadServicos(Integer idServico) {
        this.idServico = idServico;
    }

    public Integer getIdServico() {
        return idServico;
    }

    public void setIdServico(Integer idServico) {
        this.idServico = idServico;
    }

    public Integer getCodigoServico() {
        return codigoServico;
    }

    public void setCodigoServico(Integer codigoServico) {
        this.codigoServico = codigoServico;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNomeServico() {
        return nomeServico;
    }

    public void setNomeServico(String nomeServico) {
        this.nomeServico = nomeServico;
    }

    public String getTipoServico() {
        return tipoServico;
    }

    public void setTipoServico(String tipoServico) {
        this.tipoServico = tipoServico;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idServico != null ? idServico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CadServicos)) {
            return false;
        }
        CadServicos other = (CadServicos) object;
        if ((this.idServico == null && other.idServico != null) || (this.idServico != null && !this.idServico.equals(other.idServico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.localeader.model.CadServicos[ idServico=" + idServico + " ]";
    }
    
}
