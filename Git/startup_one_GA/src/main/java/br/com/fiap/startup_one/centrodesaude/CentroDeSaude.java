package br.com.fiap.startup_one.centrodesaude;


import br.com.fiap.startup_one.endereco.Endereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "centrosdesaude")
@Entity(name = "CentroDeSaude")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class CentroDeSaude {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cnpj;
    private String email;
    private String telefone;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private Endereco endereco;

    private Boolean ativo;


    public CentroDeSaude(DadosCadastroCentroDeSaude dados) {
        this.ativo = true;
        this.nome = dados.nome();
        this.cnpj = dados.cnpj();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.especialidade = dados.especialidade();
        this.endereco = new Endereco(dados.endereco());

    }

    public void atualizarInformacoes(DadosAtualizacaoCentroDeSaude dados) {
        if (dados.nome() != null) {
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