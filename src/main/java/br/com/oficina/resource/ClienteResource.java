package br.com.oficina.resource;

import br.com.oficina.dto.AlterarClienteDTO;
import br.com.oficina.dto.CadastroClienteDTO;
import br.com.oficina.dto.ListaClienteDTO;
import br.com.oficina.service.ClienteService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.stream.Collectors;

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
        var cliente = clienteService.buscarClientePorId(id);
        return Response.status(Response.Status.OK).entity(new ListaClienteDTO(cliente)).build();
    }

    @GET
    public Response buscarTodos() {
        var clientes = clienteService.buscarTodosClientes();
        return Response.status(Response.Status.OK).entity(clientes.stream().map(ListaClienteDTO::new).collect(Collectors.toList())).build();
    }

    @POST
    public Response criarCliente(CadastroClienteDTO clienteDTO) {
        var cliente = clienteService.cadastrarCliente(clienteDTO);
        return Response.status(Response.Status.CREATED).entity(new ListaClienteDTO(cliente)).build();
    }

    @PUT
    public Response alterarCliente(AlterarClienteDTO clienteDTO) {
        var cliente = clienteService.alterarCliente(clienteDTO);
        return Response.status(Response.Status.OK).entity(new ListaClienteDTO(cliente)).build();
    }

    @DELETE
    @Path("{id}")
    public Response desativarCliente(@PathParam("id") Long id) {
        clienteService.desativarCliente(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
