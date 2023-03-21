package br.com.oficina.model;

import br.com.oficina.enuns.Servicos;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "TB_PEDIDOS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @Enumerated(EnumType.STRING)
    private Servicos servicos;

    private double valor;
    private LocalDateTime data;
    Boolean ativo;

    public Pedido(Long id, Cliente cliente, Servicos servicos, Double valor, LocalDateTime data, Boolean ativo) {
        this.id = id;
        this.cliente = cliente;
        this.servicos = servicos;
        this.valor = valor;
        this.data = data;
        this.ativo = true;
    }
}
