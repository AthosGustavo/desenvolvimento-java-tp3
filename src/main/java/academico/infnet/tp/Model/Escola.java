package academico.infnet.tp.Model;

import academico.infnet.tp.Record.EscolaRecord.DadosCadastroEscolaRecord;
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
  private Professor professor;
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "endereco_id", referencedColumnName = "id")
  private Endereco endereco;

  public Escola(DadosCadastroEscolaRecord escola, Endereco endereco, Professor professor, String nomeProfessor){
    this.nome = escola.nome();
    this.email = escola.email();
    this.nomeProfessor = nomeProfessor;
    this.endereco = endereco;
    this.professor = professor;
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
