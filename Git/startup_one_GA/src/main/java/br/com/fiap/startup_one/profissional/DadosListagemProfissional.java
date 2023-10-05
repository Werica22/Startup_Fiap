package br.com.fiap.startup_one.profissional;

public record DadosListagemProfissional(Long id, String nome, String email, String registro, Especialidade especialidade){
    public DadosListagemProfissional(Profissional profissional) {
        this(profissional.getId(), profissional.getNome(), profissional.getEmail(), profissional.getRegistro(), profissional.getEspecialidade());
    }
}
