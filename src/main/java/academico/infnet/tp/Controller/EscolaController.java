package academico.infnet.tp.Controller;

import academico.infnet.tp.Model.Escola;
import academico.infnet.tp.Record.EscolaRecord.DadosCadastroEscolaRecord;
import academico.infnet.tp.Service.EscolaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("escolas")
public class EscolaController {
  @Autowired
  private EscolaService escolaService;

  @GetMapping
  public List<DadosCadastroEscolaRecord> buscarTodasEscolas(){
    return escolaService.buscaTodasEscolasService();
  }

  @PostMapping
  public void criarCadastroCompletoEscolaController(@RequestBody DadosCadastroEscolaRecord dados){
    escolaService.cadastroCompletoEscolaService(dados);
  }

  @DeleteMapping("/{id}")
  public void removeEscolaController(@PathVariable Long id){
    escolaService.removeEscolaService(id);
  }
}

