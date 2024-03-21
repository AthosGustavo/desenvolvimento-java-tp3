package academico.infnet.tp.Service;

import academico.infnet.tp.Model.Endereco;
import academico.infnet.tp.Model.Escola;
import academico.infnet.tp.Model.Professor;
import academico.infnet.tp.Record.EscolaRecord.DadosCadastroEscolaRecord;
import academico.infnet.tp.Repository.EscolaRepository;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EscolaService {

  @Autowired
  private EscolaRepository repository;
  public void cadastroCompletoEscolaService(DadosCadastroEscolaRecord dados){
    String responseJson = ViaCepService.buscaCep(dados.endereco().getCep());
    String rua = "";
    String cidade = "";
    String estado = "";
    String bairro = "";
    String cep = dados.endereco().getCep();

    try{
      JSONObject responseObject = new JSONObject(responseJson);
      rua = responseObject.getString("logradouro");
      bairro = responseObject.getString("bairro");
      cidade = responseObject.getString("localidade");
      estado = responseObject.getString("uf");

    }catch(JSONException ex){
      System.out.println(ex.getMessage());
    }


    Endereco endereco = new Endereco(rua,bairro,cidade, estado, cep);
    Professor professor = new Professor(dados);
    String nomeProfessor = dados.professor().getNome();
    this.repository.save(new Escola(dados, endereco, professor, nomeProfessor));
  }

  public List<DadosCadastroEscolaRecord> buscaTodasEscolasService(){
    return repository.findAll().stream()
      .map(escola -> new DadosCadastroEscolaRecord(escola))
      .collect(Collectors.toList());
  }

  public void removeEscolaService(Long id){
    this.repository.deleteById(id);
  }
}
