package br.com.oficina.service;

import br.com.oficina.dto.DadosDetalhamentoPedidoDTO;
import br.com.oficina.dto.DadosPedidoDTO;
import br.com.oficina.model.Pedido;
import br.com.oficina.repository.ClienteRepository;
import br.com.oficina.repository.PedidoRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class PedidoService {

    final PedidoRepository pedidoRepository;
    final ClienteRepository clienteRepository;

    @Inject
    public PedidoService(PedidoRepository pedidoRepository, ClienteRepository clienteRepository) {
        this.pedidoRepository = pedidoRepository;
        this.clienteRepository = clienteRepository;
    }

    public Pedido buscarPedidoPorId(Long id) {
        return pedidoRepository.findById(id);
    }

    public List<Pedido> buscarTodos() {
        return pedidoRepository.listAll();
    }

    @Transactional
    public DadosDetalhamentoPedidoDTO efetuarPedido(DadosPedidoDTO pedidoDTO) {
        var cliente = clienteRepository.findById(pedidoDTO.idCliente());
        var pedido = new Pedido(null, cliente, pedidoDTO.servicos(), pedidoDTO.valor(), pedidoDTO.data(), null);
        pedidoRepository.persist(pedido);
        return new DadosDetalhamentoPedidoDTO(pedido);
    }
}
