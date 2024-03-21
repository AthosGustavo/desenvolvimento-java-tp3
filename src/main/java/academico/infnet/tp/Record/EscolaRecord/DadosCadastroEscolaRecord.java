package academico.infnet.tp.Record.EscolaRecord;

import academico.infnet.tp.Model.Endereco;
import academico.infnet.tp.Model.Escola;
import academico.infnet.tp.Model.Professor;

public record DadosCadastroEscolaRecord(String nome, String email, String nomeProfessor, Endereco endereco, Professor professor) {

  public DadosCadastroEscolaRecord(Escola escola){
    this(escola.getNome(), escola.getEmail(), escola.getNomeProfessor(), escola.getEndereco(), escola.getProfessor());
  }
}
