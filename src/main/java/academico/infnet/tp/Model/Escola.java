package academico.infnet.tp.Model;

import academico.infnet.tp.Record.EscolaRecord.DadosCadastroEscolaRecord;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "escolas")
public class Escola {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String nome;
  private String email;
  private String nomeProfessor;
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "professor_id", referencedColumnName = "id")
  @JsonManagedReference
  private Professor professor;
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "endereco_id", referencedColumnName = "id")
  @JsonManagedReference
  private Endereco endereco;

  public Escola(){}

  public Escola(DadosCadastroEscolaRecord escola, Endereco endereco, Professor professor, String nomeProfessor){
    this.nome = escola.nome();
    this.email = escola.email();
    this.nomeProfessor = nomeProfessor;
    this.endereco = endereco;
    this.professor = professor;
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

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getNomeProfessor() {
    return nomeProfessor;
  }

  public void setNomeProfessor(String nomeProfessor) {
    this.nomeProfessor = nomeProfessor;
  }

  public Professor getProfessor() {
    return professor;
  }

  public void setProfessor(Professor professor) {
    this.professor = professor;
  }

  public Endereco getEndereco() {
    return endereco;
  }

  public void setEndereco(Endereco endereco) {
    this.endereco = endereco;
  }

  @Override
  public String toString() {
    return "Escola{" +
      "id=" + id +
      ", nome='" + nome + '\'' +
      ", email='" + email + '\'' +
      ", professores=" + professor+
      ", endereco=" + endereco +
      '}';
  }
}
