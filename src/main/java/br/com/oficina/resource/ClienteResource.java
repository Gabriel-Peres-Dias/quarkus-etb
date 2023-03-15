package br.com.oficina.resource;

import br.com.oficina.model.Cliente;
import br.com.oficina.service.ClienteService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/cliente")
public class ClienteResource{

    @Inject
    ClienteService clienteService;

    @GET
    @Path("{id}")
    public Response buscarPorId(@PathParam("id") Long id) {
        return Response.status(Response.Status.OK).entity(clienteService.buscarClientePorId(id)).build();
    }

    @GET
    public Response buscarTodos() {
        return Response.status(Response.Status.OK).entity(clienteService.buscarTodosClientes()).build();
    }

    @POST
    public Response criarCliente(Cliente cliente) {
        var novoCliente = clienteService.cadastrarCliente(cliente);
        return Response.status(Response.Status.CREATED).entity(novoCliente).build();
    }

    @PUT
    public Response alterarCliente(Cliente cliente) {
        var clienteTmp = clienteService.buscarClientePorId(cliente.getId());
        cliente.atualizarCliente(clienteTmp);
        return Response.status(Response.Status.OK).entity(new Cliente(clienteTmp)).build();
    }

    @DELETE
    @Path("{id}")
    public Response desativarCliente(@PathParam("id") Long id) {
        var cliente = clienteService.buscarClientePorId(id);
        cliente.desativar();
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
