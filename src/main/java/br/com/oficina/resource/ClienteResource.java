package br.com.oficina.resource;

import br.com.oficina.dto.AlterarClienteDTO;
import br.com.oficina.dto.CadastroClienteDTO;
import br.com.oficina.service.ClienteService;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/cliente")
public class ClienteResource {

    ClienteService clienteService;

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
    public Response criarCliente(@Valid CadastroClienteDTO clienteDTO) {
        //TODO: aprender sobre a URI no POST, de acordo com os verbos http de retornar o id onde encontro o registro criado
        return Response.status(Response.Status.CREATED).entity(clienteService.cadastrarCliente(clienteDTO)).build();
    }

    @PUT
    public Response alterarCliente(@Valid  AlterarClienteDTO clienteDTO) {
        return Response.ok(clienteService.alterarCliente(clienteDTO)).build();
    }

    @DELETE
    @Path("{id}")
    public Response desativarCliente(@PathParam("id") Long id) {
        clienteService.desativarCliente(id);
        return Response.noContent().build();
    }
}
