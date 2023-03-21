package br.com.oficina.service;

import br.com.oficina.dto.AlterarClienteDTO;
import br.com.oficina.dto.CadastroClienteDTO;
import br.com.oficina.dto.DadosDetalhamentoClienteDTO;
import br.com.oficina.model.Cliente;
import br.com.oficina.repository.ClienteRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class ClienteService {

    final ClienteRepository clienteRepository;

    @Inject
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public DadosDetalhamentoClienteDTO buscarClientePorId(Long id) {
        return new DadosDetalhamentoClienteDTO(clienteRepository.findById(id));
    }

    public List<DadosDetalhamentoClienteDTO> buscarTodosClientes() {
        var lista = clienteRepository.listAll();
        return lista.stream().map(DadosDetalhamentoClienteDTO::new).collect(Collectors.toList());
    }

    @Transactional
    public DadosDetalhamentoClienteDTO cadastrarCliente(CadastroClienteDTO clienteDTO) {
        var cliente = new Cliente(clienteDTO);
        clienteRepository.persist(cliente);
        return new DadosDetalhamentoClienteDTO(cliente);
    }

    @Transactional
    public DadosDetalhamentoClienteDTO alterarCliente(AlterarClienteDTO clienteDTO) {
        var cliente = new Cliente(clienteDTO);
       clienteRepository.atualizar(cliente);
        return new DadosDetalhamentoClienteDTO(cliente);
    }

    @Transactional
    public void desativarCliente(Long id) {
        var cliente = clienteRepository.findById(id);
        cliente.desativar();
    }
}
