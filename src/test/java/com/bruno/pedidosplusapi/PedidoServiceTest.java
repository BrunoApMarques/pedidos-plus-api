package com.bruno.pedidosplusapi;

import com.bruno.pedidosplusapi.dto.PedidoResponseDTO;
import com.bruno.pedidosplusapi.model.Cliente;
import com.bruno.pedidosplusapi.model.Pedido;
import com.bruno.pedidosplusapi.model.StatusPedido;
import com.bruno.pedidosplusapi.repository.ClienteRepository;
import com.bruno.pedidosplusapi.repository.PedidoRepository;
import com.bruno.pedidosplusapi.service.PedidoService;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PedidoServiceTest {

    @Test
    void deveCriarPedidoComSucessoUsandoDto() {
        // arrange
        var pedidoRepository = mock(PedidoRepository.class);
        var clienteRepository = mock(ClienteRepository.class);

        var service = new PedidoService(pedidoRepository, clienteRepository);

        var cliente = new Cliente();
        cliente.setId(1L);
        cliente.setNome("Bruno");

        when(clienteRepository.findById(1L)).thenReturn(Optional.of(cliente));

        when(pedidoRepository.save(any(Pedido.class))).thenAnswer(invocation -> {
            Pedido p = invocation.getArgument(0);
            p.setId(10L);
            return p;
        });

        // act
        PedidoResponseDTO dto = service.criarComDto(new BigDecimal("100.00"), 1L);

        // assert
        assertNotNull(dto);
        assertEquals(10L, dto.getId());
        assertEquals(new BigDecimal("100.00"), dto.getValorTotal());
        assertEquals("NOVO", dto.getStatus());
        assertEquals(1L, dto.getClienteId());
        assertEquals("Bruno", dto.getClienteNome());


        ArgumentCaptor<Pedido> captor = ArgumentCaptor.forClass(Pedido.class);
        verify(pedidoRepository, times(1)).save(captor.capture());
        Pedido salvo = captor.getValue();

        assertEquals(new BigDecimal("100.00"), salvo.getValorTotal());
        assertEquals(StatusPedido.NOVO, salvo.getStatus());
        assertEquals(1L, salvo.getCliente().getId());
    }

    @Test
    void deveLancarExcecaoQuandoClienteNaoExiste() {
        var pedidoRepository = mock(PedidoRepository.class);
        var clienteRepository = mock(ClienteRepository.class);

        var service = new PedidoService(pedidoRepository, clienteRepository);

        when(clienteRepository.findById(99L)).thenReturn(Optional.empty());

        RuntimeException ex = assertThrows(RuntimeException.class,
                () -> service.criarComDto(new BigDecimal("50.00"), 99L));

        assertEquals("Cliente não encontrado", ex.getMessage());
        verify(pedidoRepository, never()).save(any());
    }
}

