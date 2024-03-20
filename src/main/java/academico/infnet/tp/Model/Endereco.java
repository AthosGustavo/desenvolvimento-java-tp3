package academico.infnet.tp.Model;

import academico.infnet.tp.Record.EscolaRecord.DadosCadastroEscolaRecord;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "enderecos")
public class Endereco {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String rua;
  private String cidade;
  private String estado;
  private String cep;

  @OneToOne(mappedBy = "endereco")
  private Escola escola;
  public Endereco() {}
  public Endereco(DadosCadastroEscolaRecord dados){
    this.rua = dados.endereco().rua;
    this.cidade = dados.endereco().cidade;
    this.estado = dados.endereco().estado;
    this.cep = dados.endereco().cep;
  }

}
