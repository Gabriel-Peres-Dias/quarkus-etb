package br.com.oficina.resource;

import br.com.oficina.dto.AlterarClienteDTO;
import br.com.oficina.dto.CadastroClienteDTO;
import br.com.oficina.service.ClienteService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/cliente")
public class ClienteResource{

    ClienteService clienteService;

    @Inject
    public ClienteResource(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

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
    public Response criarCliente(CadastroClienteDTO clienteDTO) {
        return Response.status(Response.Status.CREATED).entity(clienteService.cadastrarCliente(clienteDTO)).build();
    }

    @PUT
    public Response alterarCliente(AlterarClienteDTO clienteDTO) {
        return Response.status(Response.Status.OK).entity(clienteService.alterarCliente(clienteDTO)).build();
    }

    @DELETE
    @Path("{id}")
    public Response desativarCliente(@PathParam("id") Long id) {
        clienteService.desativarCliente(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
