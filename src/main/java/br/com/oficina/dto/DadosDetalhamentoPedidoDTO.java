package br.com.oficina.dto;

import br.com.oficina.enuns.Servicos;
import br.com.oficina.model.Cliente;
import br.com.oficina.model.Funcionario;
import br.com.oficina.model.Pedido;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record DadosDetalhamentoPedidoDTO(
        Long id,
        Cliente cliente,
        Funcionario Funcionario,
        Servicos servico,
        Double valor,
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
        LocalDateTime data
) {
    public DadosDetalhamentoPedidoDTO(Pedido pedido) {
        this(pedido.getId(), pedido.getCliente(), pedido.getFuncionario(), pedido.getServicos(), pedido.getValor(), pedido.getData());
    }
}
