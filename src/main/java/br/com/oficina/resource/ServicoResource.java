package br.com.oficina.resource;

import br.com.oficina.model.Servico;
import br.com.oficina.repository.ServicoRepository;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/servico")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ServicoResource {

    ServicoRepository servicoRepository;

    @Inject
    public ServicoResource(ServicoRepository servicoRepository) {
        this.servicoRepository = servicoRepository;
    }

    @GET
    public List<Servico> listarAll() {
        return servicoRepository.listAll();
    }

    @GET
    @Path("{id}")
    public Response listarPorId(@PathParam("id") Long id) {
        return Response.status(Response.Status.OK).entity(servicoRepository.findById(id)).build();
    }
}
