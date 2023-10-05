package br.com.fiap.startup_one.centrodesaude;


import br.com.fiap.startup_one.endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroCentroDeSaude(
        @NotBlank
        String nome,
        @NotBlank
        String cnpj,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String telefone,
        @NotNull
        Especialidade especialidade,

        @NotNull
        @Valid
        DadosEndereco endereco


)
{
}
        
