package br.com.oficina.dto;

import javax.json.bind.annotation.JsonbDateFormat;
import java.time.LocalDateTime;

public record DadosPedidoDTO(
        Long idServico,
        Long idCliente,
        @JsonbDateFormat("dd-MM-yyyy HH:mm:ss")
        LocalDateTime data,
        Double valor
) {
}
