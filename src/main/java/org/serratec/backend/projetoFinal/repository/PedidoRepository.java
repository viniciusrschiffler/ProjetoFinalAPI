package org.serratec.backend.projetoFinal.repository;

import org.serratec.backend.projetoFinal.domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
