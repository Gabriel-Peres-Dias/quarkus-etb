package br.com.oficina.resource;

import br.com.oficina.dto.AlterarFuncionarioDTO;
import br.com.oficina.dto.CadastroFuncionarioDTO;
import br.com.oficina.service.FuncionarioService;

import javax.validation.Valid;
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
        return Response.ok(funcionarioService.buscarFuncionarioPorId(id)).build();
    }

    @GET
    public Response buscarTodosFuncionarios() {
        return Response.ok(funcionarioService.listarFuncionarios()).build();
    }

    @POST
    public Response criarFuncionario(@Valid CadastroFuncionarioDTO funcionarioDTO) {
        //TODO: aprender sobre a URI no POST, de acordo com os verbos http de retornar o id onde encontro o registro criado
        return Response.status(Response.Status.CREATED).entity(funcionarioService.cadastrarFuncionario(funcionarioDTO)).build();
    }

    @PUT
    public Response atualizarFuncionario(@Valid AlterarFuncionarioDTO funcionarioDTO) {
        return Response.ok(funcionarioService.atualizarFuncionario(funcionarioDTO)).build();
    }

    @DELETE
    @Path("{id}")
    public Response desativarFuncionario(@PathParam("id")Long id) {
        funcionarioService.desativarFuncionario(id);
        return Response.noContent().build();
    }
}
