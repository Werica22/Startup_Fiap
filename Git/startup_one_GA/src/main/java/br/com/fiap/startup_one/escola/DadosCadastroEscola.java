package br.com.fiap.startup_one.escola;

import br.com.fiap.startup_one.endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroEscola(
        @NotBlank
        String nome,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String telefone,
        @NotBlank
        @Pattern(regexp = "\\d{4,6}")
        String registro,
        @NotNull
        TipoEscola tipoescola,
        @NotNull
        @Valid
        DadosEndereco endereco) {
}
