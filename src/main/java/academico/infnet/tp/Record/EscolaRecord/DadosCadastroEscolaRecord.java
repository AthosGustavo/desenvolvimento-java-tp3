package academico.infnet.tp.Record.EscolaRecord;

import academico.infnet.tp.Model.Endereco;
import academico.infnet.tp.Model.Professor;

public record DadosCadastroEscolaRecord(String nome, String email, String nomeProfessor, Endereco endereco, Professor professor) {}
