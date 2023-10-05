package br.com.fiap.startup_one.escola;

import br.com.fiap.startup_one.endereco.Endereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "escolas")
@Entity(name = "Escola")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Escola {


    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String registro;
    @Enumerated(EnumType.STRING)

    private TipoEscola tipoescola;
    @Embedded
    private Endereco endereco;

    private Boolean ativo;

    public Escola(DadosCadastroEscola dados) {
        this.ativo = true;
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.registro = dados.registro();
        this.tipoescola = dados.tipoescola();
        this.endereco = new Endereco(dados.endereco());
    }

    public void atualizarInformacoes(DadosAtualizacaoEscola dados) {
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
