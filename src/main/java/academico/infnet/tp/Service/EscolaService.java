package academico.infnet.tp.Service;

import academico.infnet.tp.Model.Endereco;
import academico.infnet.tp.Model.Escola;
import academico.infnet.tp.Model.Professor;
import academico.infnet.tp.Record.EscolaRecord.DadosCadastroEscolaRecord;
import academico.infnet.tp.Repository.EscolaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EscolaService {

  @Autowired
  private EscolaRepository repository;
  public void cadastroCompletoEscolaService(DadosCadastroEscolaRecord dados){
    Endereco endereco = new Endereco(dados);
    Professor professor = new Professor(dados);
    String nomeProfessor = dados.professor().getNome();
    this.repository.save(new Escola(dados, endereco, professor, nomeProfessor));
  }
}
