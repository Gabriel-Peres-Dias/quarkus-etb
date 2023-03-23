package br.com.oficina.dto;

import br.com.oficina.enuns.Servicos;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public record CadastroPedidoDTO(
        @NotNull
        Long idCliente,
        @NotNull
        Long idFuncionario,
        @NotNull
        Servicos servicos,
        @NotNull
        @JsonbDateFormat("dd-MM-yyyy HH:mm:ss")
        LocalDateTime data,
        @NotNull
        Double valor
) {
}
