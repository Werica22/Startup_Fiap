package br.com.fiap.startup_one.centrodesaude;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CentroDeSaudeRepository extends JpaRepository<CentroDeSaude,Long> {
    Page<CentroDeSaude> findAllByAtivoTrue(Pageable paginacao);
}