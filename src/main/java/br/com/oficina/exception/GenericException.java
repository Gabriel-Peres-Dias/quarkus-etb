package br.com.oficina.exception;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class GenericException implements ExceptionMapper<OficinaException> {

    @Override
    @Produces(MediaType.APPLICATION_JSON)
    public Response toResponse(OficinaException e) {
        var codigo = Response.Status.BAD_REQUEST.getStatusCode();
        var messageError = new MessageError(codigo, e.getMessage());
        return Response.status(Response.Status.BAD_REQUEST).entity(messageError).build();
    }

}
