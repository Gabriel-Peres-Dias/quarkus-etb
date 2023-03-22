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
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_funcionaro")
    private Funcionario funcionario;

    @Enumerated(EnumType.STRING)
    private Servicos servicos;

    private double valor;
    private LocalDateTime data;
    Boolean ativo;

    public Pedido(Long id, Cliente cliente, Funcionario funcionario, Servicos servicos, Double valor, LocalDateTime data, Boolean ativo) {
        this.id = id;
        this.cliente = cliente;
        this.funcionario = funcionario;
        this.servicos = servicos;
        this.valor = valor;
        this.data = data;
        this.ativo = true;
    }
}
