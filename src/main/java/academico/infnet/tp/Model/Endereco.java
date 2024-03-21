package academico.infnet.tp.Model;

import academico.infnet.tp.Record.EscolaRecord.DadosCadastroEscolaRecord;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "enderecos")
public class Endereco {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String rua;

  private String bairro;
  private String cidade;
  private String estado;
  private String cep;

  @OneToOne(mappedBy = "endereco")
  @JsonBackReference
  private Escola escola;
  public Endereco(String rua,String bairro, String cidade, String estado, String cep) {
    this.rua = rua;
    this.bairro = bairro;
    this.cidade = cidade;
    this.estado = estado;
    this.cep = cep;
  }
//  public Endereco(DadosCadastroEscolaRecord dados){
//    this.rua = dados.endereco().rua;
//    this.cidade = dados.endereco().cidade;
//    this.estado = dados.endereco().estado;
//    this.cep = dados.endereco().cep;
//  }
  public Endereco(){}
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getRua() {
    return rua;
  }

  public void setRua(String rua) {
    this.rua = rua;
  }

  public String getCidade() {
    return cidade;
  }

  public void setCidade(String cidade) {
    this.cidade = cidade;
  }

  public String getEstado() {
    return estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }

  public String getCep() {
    return cep;
  }

  public void setCep(String cep) {
    this.cep = cep;
  }

  public Escola getEscola() {
    return escola;
  }

  public void setEscola(Escola escola) {
    this.escola = escola;
  }
}
