package br.com.fiap.startup_one.centrodesaude;
public record DadosListagemCentroDeSaude(Long id, String nome, String cnpj, String email, Especialidade especialidade) {
    public DadosListagemCentroDeSaude(CentroDeSaude clinica) {
        this(clinica.getId(), clinica.getNome(), clinica.getEmail(), clinica.getCnpj(), clinica.getEspecialidade());
}
}