package br.com.oficina.exception;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.ArrayList;
import java.util.stream.Collectors;

@Provider
public class ValidationException implements ExceptionMapper<ConstraintViolationException> {

    @Override
    public Response toResponse(ConstraintViolationException e) {
        var violacoes = new ArrayList<>(e.getConstraintViolations());
        var codigo = Response.Status.BAD_REQUEST.getStatusCode();
        var mensagem = violacoes.stream().map(ConstraintViolation::getMessage).collect(Collectors.toList());
        return Response.status(Response.Status.BAD_REQUEST).entity(mensagem.stream().map(m -> new MessageError(codigo, m)).collect(Collectors.toList())).build();
    }
}
