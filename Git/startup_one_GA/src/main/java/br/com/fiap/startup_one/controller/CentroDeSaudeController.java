package br.com.fiap.startup_one.controller;


import br.com.fiap.startup_one.centrodesaude.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("centrosdesaude")
public class CentroDeSaudeController {

    @Autowired
    private CentroDeSaudeRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroCentroDeSaude dados) {
        repository.save(new CentroDeSaude(dados));
    }

    @GetMapping
    public Page<DadosListagemCentroDeSaude> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemCentroDeSaude::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoCentroDeSaude dados) {
        var clinica = repository.getReferenceById(dados.id());
        clinica.atualizarInformacoes(dados);

    }
    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id) {
        var clinica  = repository.getReferenceById(id);
        clinica.excluir();
}

}