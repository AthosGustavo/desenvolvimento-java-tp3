package academico.infnet.tp.Controller;

import academico.infnet.tp.Model.Escola;
import academico.infnet.tp.Record.EscolaRecord.DadosCadastroEscolaRecord;
import academico.infnet.tp.Service.EscolaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("escolas")
public class EscolaController {
  @Autowired
  private EscolaService escolaService;

  @GetMapping
  public void getAllEscolas(){
    System.out.println("deu certo");
  }

  @PostMapping
  public void criarCadastroCompletoEscolaController(@RequestBody DadosCadastroEscolaRecord dados){
    escolaService.cadastroCompletoEscolaService(dados);
  }
}

