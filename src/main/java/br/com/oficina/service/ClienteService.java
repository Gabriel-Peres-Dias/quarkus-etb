package br.com.oficina.service;

import br.com.oficina.model.Cliente;
import br.com.oficina.repository.ClienteRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class ClienteService {

    @Inject
    ClienteRepository clienteRepository;

    public Cliente buscarClientePorId(Long id) {
        return clienteRepository.findById(id);
    }

    public List<Cliente>buscarTodosClientes() {
        return clienteRepository.listAll();
    }

    @Transactional
    public Cliente cadastrarCliente(Cliente cliente) {
        var novoCliente = new Cliente(cliente);
        clienteRepository.persist(cliente);
        return novoCliente;
    }

    @Transactional
    public Cliente alterarCliente(Long id) {
        var cliente = clienteRepository.findById(id);
        cliente.atualizarCliente(cliente);
        return cliente;
    }

    @Transactional
    public void desativarCliente(Long id) {
        var cliente = clienteRepository.findById(id);
        cliente.desativar();
    }
}
