package br.com.oficina.resource;

import br.com.oficina.dto.CadastroPedidoDTO;
import br.com.oficina.service.PedidoService;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("/pedido")
public class PedidoResource {

    final PedidoService pedidoService;

    public PedidoResource(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @GET
    @Path("/{id}")
    public Response buscarPedidoPorId(@PathParam("id") Long id) {
        return Response.ok(pedidoService.buscarPedidoPorId(id)).build();
    }

    @GET
    public Response buscarPedidoPorId() {
        return Response.ok(pedidoService.buscarTodos()).build();
    }

    @POST
    public Response cadastrarPedido(CadastroPedidoDTO pedidoDTO, @Context UriInfo uriInfo) {
        var pedido = pedidoService.efetuarPedido(pedidoDTO);
        var uri = uriInfo.getAbsolutePathBuilder().path(Long.toString(pedido.id()));
        return Response.created(uri.build()).entity(pedido).build();
    }
}
