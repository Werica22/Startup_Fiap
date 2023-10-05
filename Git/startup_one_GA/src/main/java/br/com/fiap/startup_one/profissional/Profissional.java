package br.com.fiap.startup_one.profissional;

import br.com.fiap.startup_one.endereco.Endereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "profissionais")
@Entity(name = "Profissional")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Profissional {


    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String registro;
    @Enumerated(EnumType.STRING)

    private Especialidade especialidade;
    @Embedded
    private Endereco endereco;

    private Boolean ativo;

    public Profissional(DadosCadastroProfissional dados) {
        this.ativo = true;
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.registro = dados.registro();
        this.especialidade = dados.especialidade();
        this.endereco = new Endereco(dados.endereco());
    }

    public void atualizarInformacoes(DadosAtualizacaoProfissional dados) {
        if (dados.nome()!= null) {
        this.nome = dados.nome();
    }
        if (dados.telefone() != null) {
            this.telefone = dados.telefone();
        }
        if (dados.endereco() != null) {
            this.endereco.atualizarInformacoes(dados.endereco());
        }
        }

    public void excluir() {
        this.ativo = false;
    }
}
