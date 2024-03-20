package academico.infnet.tp.Model;

import java.util.List;

import academico.infnet.tp.Record.EscolaRecord.DadosCadastroEscolaRecord;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
public class Professor {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String nome;
  private float salario;
  private String titulo;
  @OneToOne(mappedBy = "professor")
  private Escola escola;

  public Professor() {}
  public Professor(DadosCadastroEscolaRecord dados){
    this.nome = dados.professor().nome;
    this.salario = dados.professor().salario;
    this.titulo = dados.professor().titulo;

  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public float getSalario() {
    return salario;
  }

  public void setSalario(float salario) {
    this.salario = salario;
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public Escola getEscola() {
    return escola;
  }

  public void setEscola(Escola escola) {
    this.escola = escola;
  }
}