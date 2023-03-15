package br.com.oficina.model;

import br.com.oficina.dto.AlterarClienteDTO;
import br.com.oficina.dto.CadastroClienteDTO;
import br.com.oficina.dto.ListaClienteDTO;
import br.com.oficina.endereco.Endereco;
import br.com.oficina.enuns.Perfil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "TB_CLIENTE")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String senha;
    private String cpf;
    @Embedded
    private Endereco endereco;
    @Enumerated(EnumType.STRING)
    private Perfil perfil;
    private boolean ativo;

    public Cliente(ListaClienteDTO cliente) {
        this.ativo = true;
        this.nome = cliente.nome();
        this.email = cliente.email();
        this.telefone = cliente.telefone();
        this.cpf = cliente.cpf();
        this.endereco = cliente.endereco();
    }

    public Cliente(CadastroClienteDTO cliente) {
        this.ativo = true;
        this.nome = cliente.nome();
        this.email = cliente.email();
        this.telefone = cliente.telefone();
        this.senha = cliente.senha();
        this.cpf = cliente.cpf();
        this.endereco = cliente.endereco();
        this.perfil = cliente.perfil();
    }

    public void atualizarCliente(AlterarClienteDTO cliente) {
        this.nome = cliente.nome();
        this.email = cliente.email();
        this.telefone = cliente.telefone();
        this.senha = cliente.senha();
        this.cpf = cliente.cpf();
        this.endereco = cliente.endereco();
        this.perfil = cliente.perfil();
    }

    public void desativar() {
        this.ativo = false;
    }

}
