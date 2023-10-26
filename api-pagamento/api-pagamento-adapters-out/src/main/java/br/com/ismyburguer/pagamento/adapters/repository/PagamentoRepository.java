package br.com.ismyburguer.pagamento.adapters.repository;

import br.com.ismyburguer.pagamento.adapters.entity.PagamentoEntity;
import br.com.ismyburguer.core.adapter.out.PersistenceDriver;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

@PersistenceDriver
public interface PagamentoRepository extends JpaRepository<PagamentoEntity, UUID> {
}
