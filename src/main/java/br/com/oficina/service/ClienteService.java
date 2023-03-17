package br.com.oficina.service;

import br.com.oficina.dto.AlterarClienteDTO;
import br.com.oficina.dto.CadastroClienteDTO;
import br.com.oficina.model.Cliente;
import br.com.oficina.repository.ClienteRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class ClienteService {

    final ClienteRepository clienteRepository;

    @Inject
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente buscarClientePorId(Long id) {
        return clienteRepository.findById(id);
    }

    public List<Cliente> buscarTodosClientes() {
        return clienteRepository.listAll();
    }

    @Transactional
    public Cliente cadastrarCliente(CadastroClienteDTO clienteDTO) {
        var cliente = new Cliente(clienteDTO);
        clienteRepository.persist(cliente);
        return cliente;
    }

    @Transactional
    public Cliente alterarCliente(AlterarClienteDTO clienteDTO) {
        var cliente = new Cliente(clienteDTO);
       clienteRepository.atualizar(cliente);
        return cliente;
    }

    @Transactional
    public void desativarCliente(Long id) {
        var cliente = clienteRepository.findById(id);
        cliente.desativar();
    }
}
