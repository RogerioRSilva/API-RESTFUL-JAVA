package med.voll.api.domain.paciente;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.domain.endereco.Endereco;

@Getter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Paciente")
@Table(name = "pacientes")
public class Paciente {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String cpf;
    private String telefone;
    private Boolean ativo;

    @Embedded
    private Endereco endereco;

    public Paciente(DadosCadastroPaciente dados){
        this.ativo = true;
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.cpf = dados.cpf();
        this.endereco = new Endereco(dados.endereco());
    }

    public void atualizarInformacoes(DadosAtualizacaoPaciente dadosPaciente) {
        if(dadosPaciente.nome() != null){
            this.nome = dadosPaciente.nome();
        }
        if(dadosPaciente.telefone() != null){
            this.telefone = dadosPaciente.telefone();
        }
        if(dadosPaciente.endereco() != null){
            this.endereco.atualizarInformacoes(dadosPaciente.endereco());
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}