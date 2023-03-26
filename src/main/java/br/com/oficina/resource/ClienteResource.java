package br.com.oficina.resource;

import br.com.oficina.dto.AlterarClienteDTO;
import br.com.oficina.dto.CadastroClienteDTO;
import br.com.oficina.service.ClienteService;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("/cliente")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ClienteResource {

    final ClienteService clienteService;

    @Inject
    public ClienteResource(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GET
    @Path("{id}")
    public Response buscarPorId(@PathParam("id") Long id) {
        return Response.ok(clienteService.buscarClientePorId(id)).build();
    }

    @GET
    public Response buscarTodos() {
        return Response.ok(clienteService.buscarTodosClientes()).build();
    }

    @POST
    public Response criarCliente(@Valid CadastroClienteDTO clienteDTO, @Context UriInfo uriInfo) {
        var cliente = clienteService.cadastrarCliente(clienteDTO);
        var uri = uriInfo.getAbsolutePathBuilder().path(Long.toString(cliente.id()));
        return Response.created(uri.build()).entity(cliente).build();
    }

    @PUT
    public Response alterarCliente(@Valid AlterarClienteDTO clienteDTO) {
        return Response.ok(clienteService.alterarCliente(clienteDTO)).build();
    }

    @DELETE
    @Path("{id}")
    public Response desativarCliente(@PathParam("id") Long id) {
        clienteService.desativarCliente(id);
        return Response.noContent().build();
    }
}
