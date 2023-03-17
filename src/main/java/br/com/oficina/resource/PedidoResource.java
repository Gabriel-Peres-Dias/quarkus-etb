package br.com.oficina.resource;

import br.com.oficina.model.Pedido;
import br.com.oficina.repository.PedidoRepository;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/pedido")
public class PedidoResource {

    final PedidoRepository pedidoRepository;

    public PedidoResource(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @POST
    public Response cadastrarPedido(CadastroPedidoDTO pedidoDTO) {
        var pedido = pedidoRepository.persist(new Pedido(pedidoDTO));
        return Response.status(Response.Status.CREATED).entity(new DadosPedidoDTO(pedido)).build();
    }
}
