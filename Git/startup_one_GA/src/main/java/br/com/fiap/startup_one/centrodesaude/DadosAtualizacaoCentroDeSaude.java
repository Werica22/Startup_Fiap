package br.com.fiap.startup_one.centrodesaude;

import br.com.fiap.startup_one.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoCentroDeSaude(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco){

        }