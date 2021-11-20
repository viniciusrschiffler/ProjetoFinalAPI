package org.serratec.backend.projetoFinal.Repository;

import org.serratec.backend.projetoFinal.domain.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long> {
	
}
