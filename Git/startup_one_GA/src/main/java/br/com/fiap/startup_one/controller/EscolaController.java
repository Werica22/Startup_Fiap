package br.com.fiap.startup_one.controller;

import br.com.fiap.startup_one.escola.*;
import br.com.fiap.startup_one.profissional.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("escolas")
public class


EscolaController {

    @Autowired
    private EscolaRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroEscola dados) {
        repository.save(new Escola(dados));
    }

    @GetMapping
    public Page<DadosListagemEscola> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemEscola::new);

    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoEscola dados) {
        var escola = repository.getReferenceById(dados.id());
        escola.atualizarInformacoes(dados);

    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id) {
        var escola = repository.getReferenceById((id));
        escola.excluir();

    }

}




