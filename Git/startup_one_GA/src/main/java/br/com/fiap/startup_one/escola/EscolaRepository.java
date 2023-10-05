package br.com.fiap.startup_one.escola;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EscolaRepository extends JpaRepository<Escola, Long> {
    Page<Escola> findAllByAtivoTrue(Pageable paginacao);
}
