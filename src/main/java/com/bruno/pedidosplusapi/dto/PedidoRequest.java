package com.bruno.pedidosplusapi.dto;

import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public class PedidoRequest {

    @NotNull(message = "Valor total é obrigatório")
    private BigDecimal valorTotal;

    @NotNull(message = "Id do cliente é obrigatório")
    private Long clienteId;

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }
}
