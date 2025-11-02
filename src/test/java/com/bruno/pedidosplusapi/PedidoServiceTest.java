package com.bruno.pedidosplusapi;

import com.bruno.pedidosplusapi.model.Cliente;
import com.bruno.pedidosplusapi.model.Pedido;
import com.bruno.pedidosplusapi.model.StatusPedido;
import com.bruno.pedidosplusapi.repository.ClienteRepository;
import com.bruno.pedidosplusapi.repository.PedidoRepository;
import com.bruno.pedidosplusapi.service.PedidoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PedidoServiceTest {

    private PedidoRepository pedidoRepository;
    private ClienteRepository clienteRepository;
    private PedidoService pedidoService;

    @BeforeEach
    void setUp() {
        pedidoRepository = mock(PedidoRepository.class);
        clienteRepository = mock(ClienteRepository.class);
        pedidoService = new PedidoService(pedidoRepository, clienteRepository);
    }

    @Test
    void deveCriarPedidoQuandoClienteExiste() {
        // arrange
        Cliente cliente = new Cliente();
        cliente.setId(1L);
        when(clienteRepository.findById(1L)).thenReturn(Optional.of(cliente));

        // act
        Pedido pedidoSalvo = new Pedido();
        pedidoSalvo.setId(10L);
        when(pedidoRepository.save(any(Pedido.class))).thenReturn(pedidoSalvo);

        Pedido pedido = pedidoService.criarComDto(new BigDecimal("100.00"), 1L);

        // assert
        assertNotNull(pedido);
        assertEquals(10L, pedido.getId());

        ArgumentCaptor<Pedido> captor = ArgumentCaptor.forClass(Pedido.class);
        verify(pedidoRepository, times(1)).save(captor.capture());
        Pedido salvo = captor.getValue();
        assertEquals(new BigDecimal("100.00"), salvo.getValorTotal());
        assertEquals(StatusPedido.NOVO, salvo.getStatus());
        assertEquals(1L, salvo.getCliente().getId());
    }

    @Test
    void deveLancarExcecaoQuandoClienteNaoExiste() {
        when(clienteRepository.findById(99L)).thenReturn(Optional.empty());

        RuntimeException ex = assertThrows(RuntimeException.class,
                () -> pedidoService.criarComDto(new BigDecimal("50.00"), 99L));

        assertEquals("Cliente não encontrado", ex.getMessage());
    }
}
