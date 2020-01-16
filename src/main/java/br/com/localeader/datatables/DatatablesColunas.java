package br.com.localeader.datatables;

public class DatatablesColunas {

	public static final String[] CADPESSOAS = {"idPessoa", "conjuge","dataAlteracao", "dataInsercao", "dataNascimento", 
        "estadoCivil", "estrangeiro", "nacionalidade","nome", "pais", "profissao", "razaoSocial", "sexo","situacao",
        "tipoPessoa", "usuarioFk.idUsuario"};

	public static final String[] MEDICOS = {"id", "nome", "crm", "dtInscricao", "especialidades"};
	
	public static final String[] AGENDAMENTOS = {"id", "paciente.nome", "dataConsulta", "medico.nome", "especialidade.titulo"};

	public static final String[] USUARIOS = {"idU   suario", "login", "ativo", "perfis"};	
}
