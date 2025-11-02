package com.bruno.pedidosplusapi.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PedidoResponseDTO {

    private Long id;
    private BigDecimal valorTotal;
    private LocalDateTime dataCriacao;
    private String status;
    private Long clienteId;
    private String clienteNome;

    public PedidoResponseDTO() {
    }

    public PedidoResponseDTO(Long id, BigDecimal valorTotal, LocalDateTime dataCriacao,
                             String status, Long clienteId, String clienteNome) {

        this.id = id;
        this.valorTotal = valorTotal;
        this.dataCriacao = dataCriacao;
        this.status = status;
        this.clienteId = clienteId;
        this.clienteNome = clienteNome;
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public String getStatus() {
        return status;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public String getClienteNome() {
        return clienteNome;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public void setClienteNome(String clienteNome) {
        this.clienteNome = clienteNome;
    }
}