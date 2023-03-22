package br.com.oficina.resource;

import br.com.oficina.dto.CadastroPedidoDTO;
import br.com.oficina.service.PedidoService;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

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
    public Response cadastrarPedido(CadastroPedidoDTO pedidoDTO) {
        //TODO: aprender sobre a URI no POST, de acordo com os verbos http de retornar o id onde encontro o registro criado
        return Response.status(Response.Status.CREATED).entity(pedidoService.efetuarPedido(pedidoDTO)).build();
    }
}
