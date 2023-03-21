package br.com.oficina.dto;

import br.com.oficina.enuns.Servicos;

import javax.json.bind.annotation.JsonbDateFormat;
import java.time.LocalDateTime;

public record DadosPedidoDTO(
        Long idCliente,
        Servicos servicos,
        @JsonbDateFormat("dd-MM-yyyy HH:mm:ss")
        LocalDateTime data,
        Double valor
) {
}
