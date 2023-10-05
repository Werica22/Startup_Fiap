package br.com.fiap.startup_one.profissional;

import br.com.fiap.startup_one.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoProfissional(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco) {
}
