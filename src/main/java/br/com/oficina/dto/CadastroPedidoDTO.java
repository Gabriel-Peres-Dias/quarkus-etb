package br.com.oficina.dto;

import br.com.oficina.enuns.Servicos;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public record CadastroPedidoDTO(
        @NotNull(message = "ID do Cliente não pode ser nulo")
        Long idCliente,
        @NotNull(message = "ID do Funcionário não pode ser nulo")
        Long idFuncionario,
        @NotNull(message = "O Serviço não pode ser nulo")
        Servicos servicos,
        @NotNull(message = "A Data não pode ser nula")
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
        LocalDateTime data,
        @NotNull(message = "O valor do serviço não pode ser nulo")
        Double valor
) {
}
