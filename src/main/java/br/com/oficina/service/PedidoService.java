package br.com.oficina.service;

import br.com.oficina.dto.DadosDetalhamentoPedidoDTO;
import br.com.oficina.dto.CadastroPedidoDTO;
import br.com.oficina.model.Pedido;
import br.com.oficina.repository.ClienteRepository;
import br.com.oficina.repository.FuncionarioRepository;
import br.com.oficina.repository.PedidoRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class PedidoService {

    final PedidoRepository pedidoRepository;
    final ClienteRepository clienteRepository;
    final FuncionarioRepository funcionarioRepository;

    @Inject
    public PedidoService(PedidoRepository pedidoRepository, ClienteRepository clienteRepository, FuncionarioRepository funcionarioRepository) {
        this.pedidoRepository = pedidoRepository;
        this.clienteRepository = clienteRepository;
        this.funcionarioRepository = funcionarioRepository;
    }

    public DadosDetalhamentoPedidoDTO buscarPedidoPorId(Long id) {
        var pedido = pedidoRepository.findById(id);
        return new DadosDetalhamentoPedidoDTO(pedido);
    }

    public List<DadosDetalhamentoPedidoDTO> buscarTodos() {
        var lista = pedidoRepository.listAll();
        return lista.stream().map(DadosDetalhamentoPedidoDTO::new).collect(Collectors.toList());
    }

    @Transactional
    public DadosDetalhamentoPedidoDTO efetuarPedido(CadastroPedidoDTO pedidoDTO) {
        var cliente = clienteRepository.findById(pedidoDTO.idCliente());
        var funcionario = funcionarioRepository.findById(pedidoDTO.idFuncionario());
        var pedido = new Pedido(null, cliente, funcionario, pedidoDTO.servicos(), pedidoDTO.valor(), pedidoDTO.data(), null);
        pedidoRepository.persist(pedido);
        return new DadosDetalhamentoPedidoDTO(pedido);
    }
}
