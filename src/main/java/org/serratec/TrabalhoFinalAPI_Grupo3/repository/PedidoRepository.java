package org.serratec.TrabalhoFinalAPI_Grupo3.repository;

import org.serratec.TrabalhoFinalAPI_Grupo3.entity.Pedidos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedidos, Long>{

}
