package br.com.oficina.resource;

import br.com.oficina.dto.AlterarFuncionarioDTO;
import br.com.oficina.dto.DadosFuncionarioDTO;
import br.com.oficina.service.FuncionarioService;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/funcionario")
public class FuncionarioResource {

    final FuncionarioService funcionarioService;

    public FuncionarioResource(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @GET
    @Path("{id}")
    public Response buscarFuncionarioPorId(@PathParam("id") Long id) {
        return Response.status(Response.Status.OK).entity(funcionarioService.buscarFuncionarioPorId(id)).build();
    }

    @GET
    public Response buscarTodosFuncionarios() {
        return Response.status(Response.Status.OK).entity(funcionarioService.listarFuncionarios()).build();
    }

    @POST
    public Response criarFuncionario(DadosFuncionarioDTO funcionarioDTO) {
        return Response.status(Response.Status.CREATED).entity(funcionarioService.cadastrarFuncionario(funcionarioDTO)).build();
    }

    @PUT
    public Response atualizarFuncionario(AlterarFuncionarioDTO funcionarioDTO) {
        return Response.status(Response.Status.OK).entity(funcionarioService.atualizarFuncionario(funcionarioDTO)).build();
    }

    @DELETE
    @Path("{id}")
    public Response desativarFuncionario(@PathParam("id")Long id) {
        funcionarioService.desativarFuncionario(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
