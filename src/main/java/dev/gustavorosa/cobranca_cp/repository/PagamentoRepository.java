package dev.gustavorosa.cobranca_cp.repository;

import dev.gustavorosa.cobranca_cp.model.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
}
