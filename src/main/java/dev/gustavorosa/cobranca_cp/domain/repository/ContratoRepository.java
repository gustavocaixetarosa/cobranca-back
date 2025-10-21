package dev.gustavorosa.cobranca_cp.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.gustavorosa.cobranca_cp.domain.model.Contrato;

@Repository
public interface ContratoRepository extends JpaRepository<Contrato, Long> {
}
