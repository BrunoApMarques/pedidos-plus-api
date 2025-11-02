package com.bruno.pedidosplusapi.repository;

import com.bruno.pedidosplusapi.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    //busca todos os pedidos de um cilente
    List<Pedido> findByClienteId(Long clienteId);
}
