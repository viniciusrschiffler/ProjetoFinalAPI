package org.serratec.backend.projetoFinal.Repository;

import org.serratec.backend.projetoFinal.domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
