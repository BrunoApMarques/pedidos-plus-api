package com.bruno.pedidosplusapi.service;

import com.bruno.pedidosplusapi.model.Cliente;
import com.bruno.pedidosplusapi.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente criar(Cliente cliente) {
        // regra simples para exemplo: não deixar documento duplicado
        clienteRepository.findByDocumento(cliente.getDocumento())
                .ifPresent(c -> {
                    throw new RuntimeException("Já existe cliente com esse documento");
                });

        return clienteRepository.save(cliente);
    }

    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }

    public Cliente buscarPorId(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }

    public Cliente atualizar(Long id, Cliente clienteAtualizado) {
        Cliente existente = buscarPorId(id);
        existente.setNome(clienteAtualizado.getNome());
        existente.setEmail(clienteAtualizado.getEmail());
        existente.setDocumento(clienteAtualizado.getDocumento());
        return clienteRepository.save(existente);
    }

    public void deletar(Long id) {
        Cliente existente = buscarPorId(id);
        clienteRepository.delete(existente);
    }
}
