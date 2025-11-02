package com.bruno.pedidosplusapi.service;

import com.bruno.pedidosplusapi.model.Cliente;
import com.bruno.pedidosplusapi.model.Pedido;
import com.bruno.pedidosplusapi.model.StatusPedido;
import com.bruno.pedidosplusapi.repository.ClienteRepository;
import com.bruno.pedidosplusapi.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final ClienteRepository clienteRepository;

    public PedidoService(PedidoRepository pedidoRepository, ClienteRepository clienteRepository) {
        this.pedidoRepository = pedidoRepository;
        this.clienteRepository = clienteRepository;
    }

    public Pedido criarComDto(java.math.BigDecimal valorTotal, Long clienteId) {
        var cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        var pedido = new Pedido();
        pedido.setValorTotal(valorTotal);
        pedido.setCliente(cliente);
        pedido.setStatus(com.bruno.pedidosplusapi.model.StatusPedido.NOVO);

        return pedidoRepository.save(pedido);
    }

    public Pedido criar(Pedido pedido) {
        // valida se o cliente existe
        Long idCliente = pedido.getCliente().getId();
        Cliente cliente = clienteRepository.findById(idCliente)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        pedido.setCliente(cliente);
        pedido.setStatus(StatusPedido.NOVO);

        return pedidoRepository.save(pedido);
    }

    public List<Pedido> listar() {
        return pedidoRepository.findAll();
    }

    public  java.util.List<Pedido> listarPorCliente(long clienteId) {
        return pedidoRepository.findByClienteId(clienteId);
    }

    public Pedido buscarPorId(Long id) {
        return pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
    }

    public Pedido atualizarStatus(Long id, StatusPedido novoStatus) {
        Pedido pedido = buscarPorId(id);
        pedido.setStatus(novoStatus);
        return pedidoRepository.save(pedido);
    }

    public void deletar(Long id) {
        pedidoRepository.deleteById(id);
    }
}
