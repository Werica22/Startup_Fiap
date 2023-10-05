package br.com.fiap.startup_one.escola;

public record DadosListagemEscola(Long id, String nome, String email, String registro, TipoEscola tipoescola){
    public DadosListagemEscola(Escola escola) {
        this(escola.getId(), escola.getNome(), escola.getEmail(), escola.getRegistro(), escola.getTipoescola());
    }
}
