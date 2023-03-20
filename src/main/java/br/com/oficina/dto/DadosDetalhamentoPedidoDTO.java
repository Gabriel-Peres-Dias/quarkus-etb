package br.com.oficina.dto;

import br.com.oficina.model.Cliente;
import br.com.oficina.model.Pedido;
import br.com.oficina.model.Servico;

import javax.json.bind.annotation.JsonbDateFormat;
import java.time.LocalDateTime;

public record DadosDetalhamentoPedidoDTO(
        Long id,
        Cliente cliente,
        Servico servico,
        Double valor,
        @JsonbDateFormat("dd-MM-yyyy HH:mm:ss")
        LocalDateTime data
) {
    public DadosDetalhamentoPedidoDTO(Pedido pedido){
        this(pedido.getId(), pedido.getCliente(), pedido.getServico(), pedido.getValor(), pedido.getData());
    }
}
