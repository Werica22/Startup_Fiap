package br.com.fiap.startup_one.escola;

import br.com.fiap.startup_one.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoEscola(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco) {
}
